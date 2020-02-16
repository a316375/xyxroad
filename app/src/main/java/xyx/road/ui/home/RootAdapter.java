package xyx.road.ui.home;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Arrays;
import java.util.List;

import xyx.road.R;
import xyx.road.book.ReadActivity;

public class RootAdapter extends RecyclerView.Adapter<RootAdapter.RecViewHolder>  {
    private List<String> strings;
    private Context context;

    public RootAdapter(List<String> strings, Context context) {
        this.strings = strings;
        this.context = context;
    }

    @NonNull
    @Override
    public RecViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.root_layout, parent, false);
        return new RootAdapter.RecViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecViewHolder holder, final int position) {
             final String root=strings.get(position);
             holder.bind(root,position);
             holder.itemView.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View v) {
                     notifyItemChanged(position);
                 }
             });

    }

    @Override
    public int getItemCount() {
        return strings.size();
    }

    public class RecViewHolder extends RecyclerView.ViewHolder {
        private TextView textView;

        public RecViewHolder(@NonNull View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.textView);

        }

        public void bind(final String root, int position) {
            textView.setText((position+1)+root);
            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(context, ReadActivity.class);
                    intent.putExtra("title",root);
                    context.startActivity(intent);
                }
            });

        }
    }
}
