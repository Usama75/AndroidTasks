package pro_tech.androidtasks.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;

import java.util.List;

import pro_tech.androidtasks.Models.FragmentoneModel;
import pro_tech.androidtasks.R;

public class FragmenttwoAdapter extends RecyclerView.Adapter<FragmenttwoAdapter.ViewHolder> {
    private String  Url, Title;
    private int Count;
    private DatabaseReference databaseReference;
    private List<FragmentoneModel> modelList;
    private Context context;

    public FragmenttwoAdapter(List<FragmentoneModel> modelList, Context context) {
        this.modelList = modelList;
        this.context = context;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rowlistitemtwo ,parent , false);
        ViewHolder viewHolder =  new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ViewHolder viewHolder = holder;

        Url = modelList.get(position).getUrl();
        Title = modelList.get(position).getTitle();
        Count = modelList.get(position).getCount();
        viewHolder.Title.setText(Title);
        viewHolder.Views.setText("Views: "+Count);
    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView Title , Views;
        public ViewHolder(View itemView) {
            super(itemView);
            Title = itemView.findViewById(R.id.name);
            Views = itemView.findViewById(R.id.views);
        }
    }
}
