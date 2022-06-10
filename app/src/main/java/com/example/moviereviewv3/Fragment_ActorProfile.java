package com.example.moviereviewv3;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class Fragment_ActorProfile extends Fragment {
    ImageView img;
    TextView age;
    TextView dob;
    TextView detail;
    TextView born;
    TextView movies;
    Toolbar toolbar;

    SQLiteHelper helper;
    Model_Actor recievedActorItem;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_actor_profile, container, false);

        Bundle bundle = getArguments();
        recievedActorItem= (Model_Actor) bundle.getSerializable("actor_object");

        toolbar=view.findViewById(R.id.actor_profile_navbar);
        toolbar.setTitle(recievedActorItem.getName());
        AppCompatActivity activity = (AppCompatActivity) getActivity();
        activity.setSupportActionBar(toolbar);

        img=view.findViewById(R.id.a_img);
        age=view.findViewById(R.id.a_age_data);
        dob=view.findViewById(R.id.a_dob_data);
        detail=view.findViewById(R.id.a_desc);
        born=view.findViewById(R.id.born_data);
        movies=view.findViewById(R.id.a_movies_data);

        img.setImageResource(recievedActorItem.getImage());
        age.setText(Integer.toString(recievedActorItem.getAge()));
        detail.setText(recievedActorItem.getDetail());
        dob.setText(recievedActorItem.getDateOfBirth());
        born.setText("Born: "+recievedActorItem.getDateOfBirth());
        movies.setText(recievedActorItem.getMovie());

        return view;
    }
    @Override
    public void onAttach(@NonNull Activity activity) {
        super.onAttach(activity);
        helper=new SQLiteHelper(activity);
    }

}
