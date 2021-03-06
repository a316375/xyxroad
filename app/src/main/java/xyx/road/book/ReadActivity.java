package xyx.road.book;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;


import java.util.ArrayList;
import java.util.List;

import xyx.road.R;

public class ReadActivity extends AppCompatActivity {

    String  string;
    int [] pic;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read);
        string=getIntent().getStringExtra("title");

         ActionBar ab = getSupportActionBar();
        ab.setTitle(string);



        pic= new int[]{R.mipmap.ic_launcher};
        if (string.equals(RootString.A[0]))   pic= new int[]{R.mipmap.a01, R.mipmap.a02, R.mipmap.a03};

        ViewPager viewPager = findViewById(R.id.viewPager);
        viewPager.setAdapter(new ViewPagerAdapter(this,pic));
        viewPager.setCurrentItem(0);

    }
}
