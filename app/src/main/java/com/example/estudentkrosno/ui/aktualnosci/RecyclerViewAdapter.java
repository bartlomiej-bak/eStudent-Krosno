package com.example.estudentkrosno.ui.aktualnosci;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.example.estudentkrosno.R;

import java.util.List;

import static android.view.View.GONE;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    ConstraintLayout expandableLayout;
    Context mContext;
    List<Post> mData;

    public RecyclerViewAdapter(Context mContext, List<Post> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        v = LayoutInflater.from(mContext).inflate(R.layout.post, parent, false);
        final MyViewHolder viewHolder = new MyViewHolder(v);

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expandableLayout = v.findViewById(R.id.expandableView);
                if(expandableLayout.getVisibility()==View.GONE){
                    expandableLayout.setVisibility(View.VISIBLE);
                }else{
                    expandableLayout.setVisibility(View.GONE);
                }

            }
        });
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.title.setText(mData.get(position).getTitle());
        holder.desc.setText(mData.get(position).getDesc());
        holder.img.setImageResource(mData.get(position).getPhoto());

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder{

        private TextView title;
        private TextView desc;
        private ImageView img;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.name);
            desc = itemView.findViewById(R.id.desc);
            img = itemView.findViewById(R.id.imageView);
        }
    }

}
