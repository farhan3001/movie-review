package com.example.moviereviewv3;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter_CastVertical extends RecyclerView.Adapter <Adapter_CastVertical.CastVerticalViewHolder>  {

    List<Model_Actor> actors;

    public Adapter_CastVertical(List<Model_Actor> actors){
        this.actors = actors;
    }
    @NonNull
    @Override
    public CastVerticalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_cast_vertical, parent, false);
        CastVerticalViewHolder castViewHolder = new CastVerticalViewHolder(view);
        return castViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CastVerticalViewHolder holder, int position) {

        Model_Actor actor = actors.get(position);
        holder.img.setImageResource(actor.getImage());
        holder.actor_name.setText(actor.getName());
        holder.actor_role.setText(actor.getRole());
    }

    @Override
    public int getItemCount() {
        return actors.size();
    }

    public class CastVerticalViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView actor_name;
        TextView actor_role;

        public CastVerticalViewHolder(@NonNull View itemView) {
            super(itemView);
            //hooks
            img = itemView.findViewById(R.id.actor_v_image);
            actor_name = itemView.findViewById(R.id.actor_v_n_tv);
            actor_role = itemView.findViewById(R.id.actor_v_d_tv);

        }
    }
}

