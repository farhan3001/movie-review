package com.example.moviereviewv3;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Fragment_CastVerticalList extends Fragment {

    Toolbar toolbar;

    Adapter_CastVertical adapter;
    List<Model_Actor> actors;
    RecyclerView recyclerView;

    SQLiteHelper helper;
    Model_Movie recievedMovieItem;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cast_vertical_list, container, false);

        Bundle bundle = getArguments();
        recievedMovieItem= (Model_Movie) bundle.getSerializable("movie_object");

        toolbar= view.findViewById(R.id.cast_navbar);
        toolbar.setTitle("Cast");
        AppCompatActivity activity = (AppCompatActivity) getActivity();
        activity.setSupportActionBar(toolbar);

        actors= helper.readActorByMovie(recievedMovieItem.getName());
        recyclerView =view.findViewById(R.id.vertical_list_recycler_view);
        adapter = new Adapter_CastVertical(actors);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
        recyclerView.setAdapter(adapter);

        return view;
    }
    @Override
    public void onAttach(@NonNull Activity activity) {
        super.onAttach(activity);
        helper=new SQLiteHelper(activity);
    }

}
