package com.example.android.materialdesigncodelab;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.example.android.materialdesigncodelab.R;

public class DetailActivity extends AppCompatActivity {

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_detail);
  }

  @Override protected void onDestroy() {
    super.onDestroy();
    supportFinishAfterTransition();
  }
}
