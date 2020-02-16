package xyx.road.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import xyx.road.R;
import xyx.road.book.RootString;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel = ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        final TextView textView = root.findViewById(R.id.text_home);
        homeViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });


        List<Movie> movieList = new ArrayList<>();

        movieList.add(new Movie(RootString.titles[0], "Biography, Drama, History", 1993));
        movieList.add(new Movie(RootString.titles[1], "Crime, Drama", 1994));
        movieList.add(new Movie(RootString.titles[2], "Crime, Drama, Thriller", 2007));
        movieList.add(new Movie(RootString.titles[3], "Crime, Drama, Thriller", 1994));
        movieList.add(new Movie(RootString.titles[4], "Drama", 1999));
        movieList.add(new Movie(RootString.titles[5], "Drama, Romance", 1994));
        movieList.add(new Movie(RootString.titles[6], "Crime, Drama", 1994));




        RecAdapter adapter = new RecAdapter(movieList,getContext());

        RecyclerView recyclerView = root.findViewById(R.id.recview);

        ((SimpleItemAnimator) recyclerView.getItemAnimator()).setSupportsChangeAnimations(false);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);










        return root;
    }
}