package com.example.moviereviewv3;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter_GenreHorizontalList extends RecyclerView.Adapter<Adapter_GenreHorizontalList.GenreHorizontalViewHolder> {

    private List<String> item_texts;

    public Adapter_GenreHorizontalList(List<String> item_texts) {
        this.item_texts = item_texts;
    }

    @NonNull
    @Override
    public GenreHorizontalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.list_item_genre_horizontal,parent,false);
        return new GenreHorizontalViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GenreHorizontalViewHolder holder, int position) {
        holder.horizontal_item_text.setText(item_texts.get(position));
    }

    @Override
    public int getItemCount() {
        return item_texts.size();
    }

    public class GenreHorizontalViewHolder extends RecyclerView.ViewHolder{

        TextView horizontal_item_text;

        public GenreHorizontalViewHolder(@NonNull View itemView) {
            super(itemView);
            horizontal_item_text=(TextView) itemView.findViewById(R.id.horizontal_item_text);
        }
    }
}