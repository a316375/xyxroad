package xyx.road.book;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.viewpager.widget.PagerAdapter;

import java.util.List;

import xyx.road.R;

public class ViewPagerAdapter extends PagerAdapter {

    private Context mContext;

    private int[] mpics;

    public ViewPagerAdapter(Context mContext , int[] mpics) {
        this.mContext = mContext;

        this.mpics = mpics;
    }





    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public int getCount() {
        return mpics.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, final int position) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        ViewGroup view = (ViewGroup) inflater.inflate(R.layout.view_item, container, false);

        final TextView textView = view.findViewById(R.id.textView);
        textView.setText(position+"");

        ImageView imageView=view.findViewById(R.id.image);
        imageView.setImageResource(mpics[position]);


        container.addView(view);
        return view;
    }
}