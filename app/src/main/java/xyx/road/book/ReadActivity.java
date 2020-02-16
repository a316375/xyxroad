package xyx.road.book;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;


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

    }
}
