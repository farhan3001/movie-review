package com.example.moviereviewv3;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter_Cast extends RecyclerView.Adapter <Adapter_Cast.CastViewHolder> implements ItemClickListener {

    List<Model_Actor> actors;
    private ItemClickListener clickListener;

    public Adapter_Cast(List<Model_Actor> actors){
        this.actors = actors;
    }

    @NonNull

    @Override
    public CastViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_cast_horizontal, parent, false);
        CastViewHolder castViewHolder = new CastViewHolder(view);
        return castViewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull CastViewHolder holder, int position) {

        Model_Actor actor = actors.get(position);
        holder.img.setImageResource(actor.getImage());
        holder.actor_name.setText(actor.getName());
        holder.actor_role.setText(actor.getRole());
    }

    @Override
    public int getItemCount() {
        return actors.size();

    }
    public void setClickListener(ItemClickListener itemClickListener) {
        this.clickListener = itemClickListener;
    }

    @Override
    public void onClick(View view, int position) {
    }

    public class CastViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{


        ImageView img;
        TextView actor_name;
        TextView actor_role;


        public CastViewHolder(@NonNull View itemView) {
            super(itemView);
            //hooks
            img = itemView.findViewById(R.id.image);
            actor_name = itemView.findViewById(R.id.wl_n_tv);
            actor_role = itemView.findViewById(R.id.wl_d_tv);
            itemView.setOnClickListener(this);
        }


        @Override
        public void onClick(View view) {
            if (clickListener != null) clickListener.onClick(view, getAdapterPosition());
        }
    }

}

