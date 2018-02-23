package com.example.android.materialdesigncodelab;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

  private ImageView imgView;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    imgView = findViewById(R.id.img_main);

    imgView.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View view) {
        Intent intent = new Intent(MainActivity.this, DetailActivity.class);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
          ActivityOptionsCompat activityOptionsCompat =
              ActivityOptionsCompat.makeSceneTransitionAnimation(MainActivity.this, imgView,
                  getString(R.string.transition_image));
          startActivity(intent, activityOptionsCompat.toBundle());
        } else {
          startActivity(intent);
        }
      }
    });
  }
}
