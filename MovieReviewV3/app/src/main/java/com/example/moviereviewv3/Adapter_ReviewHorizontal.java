package com.example.moviereviewv3;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter_ReviewHorizontal extends RecyclerView.Adapter <Adapter_ReviewHorizontal.ReviewViewHolder>  {

    List<Model_Review> reviews;


    public Adapter_ReviewHorizontal(List<Model_Review> reviewList){
        this.reviews = reviewList;
    }

    @NonNull

    @Override
    public ReviewViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_review_horizontal, parent, false);
        ReviewViewHolder reviewViewHolder = new ReviewViewHolder(view);
        return reviewViewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull ReviewViewHolder holder, int position) {

        Model_Review review = reviews.get(position);

        holder.review_rating.setText(Float.toString(review.getRating()));
        holder.review_title.setText(review.getTitle());
        holder.review_desc.setText(review.getDescription());
        holder.reviewer_name.setText(review.getReviewer_name());
    }

    @Override
    public int getItemCount() {
        return reviews.size();
    }

    public class ReviewViewHolder extends RecyclerView.ViewHolder {

        TextView review_rating;
        TextView review_title;
        TextView review_desc;
        TextView reviewer_name;

        public ReviewViewHolder(@NonNull View itemView) {
            super(itemView);
            //hooks
            review_rating = itemView.findViewById(R.id.review_item_rating);
            review_title = itemView.findViewById(R.id.review_item_title);
            review_desc = itemView.findViewById(R.id.review_item_description);
            reviewer_name=itemView.findViewById(R.id.reviewer_name_tv);
        }


    }

}

