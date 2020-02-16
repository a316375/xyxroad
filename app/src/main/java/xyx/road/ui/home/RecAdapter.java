package xyx.road.ui.home;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import xyx.road.R;
import xyx.road.book.ReadActivity;
import xyx.road.book.RootString;

public class RecAdapter extends RecyclerView.Adapter<RecAdapter.RecViewHolder> {

    private List<Movie> list;
    private Context context;
    private List<String[]> liststring;

    public RecAdapter(List<Movie> list, Context context) {
        this.list = list;
        this.context=context;
        liststring=new ArrayList<String[]>();
        liststring.add(RootString.A);
        liststring.add(RootString.B);
        liststring.add(RootString.C);
        liststring.add(RootString.D);
        liststring.add(RootString.E);
        liststring.add(RootString.F);
        liststring.add(RootString.G);

    }

    @Override
    public RecViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.item_movie, parent, false);
        return new RecViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecViewHolder holder, final int position) {
        final Movie movie = list.get(position);

        holder.bind(movie,position);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean expanded = movie.isExpanded();
                movie.setExpanded(!expanded);
                notifyItemChanged(position);


            }
        });

    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

    public class RecViewHolder extends RecyclerView.ViewHolder {

        private TextView title;
        private TextView genre;
        private TextView year;
        private View subItem;
        private RecyclerView root;

        public RecViewHolder(View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.item_title);
            genre = itemView.findViewById(R.id.sub_item_genre);
            year = itemView.findViewById(R.id.sub_item_year);
            subItem = itemView.findViewById(R.id.sub_item);
            root=itemView.findViewById(R.id.root);
        }

        private void bind(Movie movie,int point) {
            boolean expanded = movie.isExpanded();

            subItem.setVisibility(expanded ? View.VISIBLE : View.GONE);

            title.setText(movie.getTitle());
            genre.setText("Genre: " + movie.getGenre());
            year.setText("Year: " + movie.getYear());

            root.setLayoutManager(new LinearLayoutManager(context));

            root.setAdapter(new RootAdapter(Arrays.asList(liststring.get(point)),context));
            root.setVisibility(expanded ? View.VISIBLE : View.GONE);

//            subItem.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    context.startActivity(new Intent(context, ReadActivity.class));
//                }
//            });

        }
    }
}