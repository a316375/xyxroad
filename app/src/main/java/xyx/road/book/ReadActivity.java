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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read);
        string=getIntent().getStringExtra("title");

         ActionBar ab = getSupportActionBar();
        ab.setTitle(string);


        List<String> listDate = new ArrayList<>();
        listDate.add("1");
        listDate.add("2");
        listDate.add("3");
        listDate.add("4");
        listDate.add("5");

        ViewPager viewPager = findViewById(R.id.viewPager);
        viewPager.setAdapter(new ViewPagerAdapter(this, listDate));

    }
}
