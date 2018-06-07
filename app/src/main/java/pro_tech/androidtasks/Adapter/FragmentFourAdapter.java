package pro_tech.androidtasks.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import pro_tech.androidtasks.Models.FragmentFourModel;
import pro_tech.androidtasks.R;

public class FragmentFourAdapter extends RecyclerView.Adapter<FragmentFourAdapter.ViewHolder> {
    private String ChannelName , ImageUrl;
    private List<FragmentFourModel> modelList;
    private Context context;

    public FragmentFourAdapter(List<FragmentFourModel> modelList, Context context) {
        this.modelList = modelList;
        this.context = context;
    }

    @NonNull
    @Override

    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rowlistitemfour ,parent , false);
        ViewHolder viewHolder =  new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ViewHolder viewHolder = holder;

        ImageUrl = modelList.get(position).getImageUrl();
        ChannelName = modelList.get(position).getChannelName();
        if(position%2!=0){
            viewHolder.channelname.setText(ChannelName);
            holder.imageView.setVisibility(View.GONE);

        }
        else{
            viewHolder.channelname.setText(ChannelName);
            Picasso.with(context).load(ImageUrl).into(holder.imageView);
        }


    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }



    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView channelname;
        private ImageView imageView;
        public ViewHolder(View itemView) {
            super(itemView);
            channelname = itemView.findViewById(R.id.channelname);
            imageView = itemView.findViewById(R.id.imageview);
        }
    }
}
