package com.example.moviereviewv3;

import android.app.Activity;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Fragment_MovieProfile extends Fragment {
    TextView director_name;
    TextView writer_name;
    TextView movie_rating;
    TextView movie_desc;
    ImageView movie_poster;
    Toolbar toolbar;
    VideoView videoView;
    TextView seeAll;
    RecyclerView castRecyclerView;
    RecyclerView reviewsRecyclerView;
    RecyclerView genreRecyclerView;
    RecyclerView moviesRecyclerView;

    SQLiteHelper helper;
    Model_Movie recievedMovieItem;

    Adapter_Cast castAdapter;
    List<Model_Actor> actors;

    Adapter_GenreHorizontalList genreAdapter;
    List<String> genres;

    Adapter_ReviewHorizontal reviewAdapter;
    List<Model_Review> reviews;

    Adapter_MovieHorizontal movieAdapter;
    List<Model_Movie> movies;


    @RequiresApi(api = Build.VERSION_CODES.N)
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_movie_profile, container, false);
        setHasOptionsMenu(true);

        Bundle bundle=this.getArguments();
        recievedMovieItem= (Model_Movie) bundle.getSerializable("movie_object");

        toolbar=view.findViewById(R.id.movie_profile_navbar);
        toolbar.setTitle(recievedMovieItem.getName());
        AppCompatActivity activity = (AppCompatActivity) getActivity();
        activity.setSupportActionBar(toolbar);

        director_name=view.findViewById(R.id.director_name_text_view1);
        writer_name=view.findViewById(R.id.writer_name_text_vieW);
        movie_rating=view.findViewById(R.id.mo_rat_tv);
        movie_poster=view.findViewById(R.id.movie_profile_poster);
        movie_desc=view.findViewById(R.id.movie_profile_description);
        seeAll = view.findViewById(R.id.seeAll);
        castRecyclerView =view.findViewById(R.id.cast_horizontal_list_recycler_view);
        reviewsRecyclerView =view.findViewById(R.id.horizontal_reviews_recycler_view);
        genreRecyclerView = view.findViewById(R.id.genre_horizontal_list);

        director_name.setText(recievedMovieItem.getDirector());
        writer_name.setText(recievedMovieItem.getWriter());
        movie_rating.setText(Float.toString(recievedMovieItem.getRating()));
        movie_poster.setImageResource(recievedMovieItem.getImage());
        movie_desc.setText(recievedMovieItem.getDescription());

        seeAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putSerializable("movie_object",recievedMovieItem);
                Fragment fragment = new Fragment_CastVerticalList();
                fragment.setArguments(bundle);
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.home_fragment_container,fragment).addToBackStack(null).commit();
            }
        });

        videoView=view.findViewById(R.id.video_player);
        String trailer_path=recievedMovieItem.getTrailer();
        Uri uri = Uri.parse(trailer_path);
        videoView.setVideoURI(uri);
        MediaController mediaController = new MediaController(getContext());
        videoView.setMediaController(mediaController);
        mediaController.setAnchorView(videoView);


        actors= helper.readActorByMovie(recievedMovieItem.getName());
        castAdapter = new Adapter_Cast(actors);
        castAdapter.setClickListener(new ItemClickListener() {
            @Override
            public void onClick(View view, int position) {
                Bundle bundle = new Bundle();
                bundle.putSerializable("actor_object",actors.get(position));
                Fragment fragment = new Fragment_ActorProfile();
                fragment.setArguments(bundle);
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.home_fragment_container,fragment).addToBackStack(null).commit();
            }
        });
        castRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));
        castRecyclerView.setAdapter(castAdapter);



        reviews=helper.readReviews(recievedMovieItem.getName());
        reviewAdapter = new Adapter_ReviewHorizontal(reviews);
        reviewsRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));
        reviewsRecyclerView.setAdapter(reviewAdapter);


        String genreString = recievedMovieItem.getGenre();
        String[] elements = genreString.split(",");
        List<String> fixedLenghtList = Arrays.asList(elements);
        genres = new ArrayList<String>(fixedLenghtList);
        genreAdapter = new Adapter_GenreHorizontalList(genres);
        genreRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));
        genreRecyclerView.setAdapter(genreAdapter);

        return view;
    }


    @Override
    public void onAttach(@NonNull Activity activity) {
        super.onAttach(activity);
        helper=new SQLiteHelper(activity);
    }
    @RequiresApi(api = Build.VERSION_CODES.N)
    public List<Model_Movie> filterListByGenre(List<Model_Movie> movieList)
    {
        List<Model_Movie> movies= new ArrayList<>();
        for(int i=0;i<5;i++){
            for (String genre:genres) {
                if(movieList.get(i).getGenre().contains(genre)){
                    if(!recievedMovieItem.getName().equals(movieList.get(i).getName())){
                        movies.add(movieList.get(i));
                    }
                }
            }
        }
        movies=movies.stream().distinct().collect(Collectors.toList());
        for (Model_Movie movie :
                movies) {
            System.out.println("Genre Movie: "+movie.getName());
        }
        return movies;
    }
}
