package pro_tech.androidtasks.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;
import pro_tech.androidtasks.Models.FragmentoneModel;
import pro_tech.androidtasks.R;
import pro_tech.androidtasks.VideoActivity;

public class FragmentoneAdapter extends RecyclerView.Adapter<FragmentoneAdapter.ViewHolder> {
    private String  Url, Title;
    private int Count;
    private DatabaseReference databaseReference;
    private List<FragmentoneModel> modelList;
    private Context context;

    public FragmentoneAdapter(List<FragmentoneModel> modelList, Context context) {
        this.modelList = modelList;
        this.context = context;
    }

    @NonNull
    @Override
    public FragmentoneAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rowlistitem ,parent , false);
        ViewHolder viewHolder =  new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull FragmentoneAdapter.ViewHolder holder, final int position) {
        ViewHolder viewHolder = holder;
        Url = modelList.get(position).getUrl();
        Title = modelList.get(position).getTitle();
        Count = modelList.get(position).getCount();
        viewHolder.Title.setText(Title);
        viewHolder.Remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "Removed Button Clicked!!", Toast.LENGTH_SHORT).show();
            }
        });
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Url = modelList.get(position).getUrl();
                Title = modelList.get(position).getTitle();
                Count = modelList.get(position).getCount();
                Senddata();
//                Toast.makeText(context, ""+Title, Toast.LENGTH_SHORT).show();

            }
        });
    }
    private void Senddata(){
        Count = Count+1;
        databaseReference = FirebaseDatabase.getInstance().getReference("Video");
        FragmentoneModel model =  new FragmentoneModel(Title,Url,Count);
        databaseReference.child(Url.substring(Url.lastIndexOf("=") + 1)).setValue(model);
//        Toast.makeText(context, "View Added", Toast.LENGTH_LONG).show();
        Intent intent =  new Intent(context, VideoActivity.class);
        intent.putExtra("url" ,(Url.substring(Url.lastIndexOf("=") + 1)));
        context.startActivity(intent);

    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView Title , Url;
        private Button Remove;
        private LinearLayout linearLayout;
        public ViewHolder(View itemView) {
            super(itemView);
            Title = itemView.findViewById(R.id.name);
            Remove = itemView.findViewById(R.id.removebtn);
            linearLayout = itemView.findViewById(R.id.linear);
//            Url =  itemView.findViewById(R.id.url);
        }
    }
}

