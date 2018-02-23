package com.example.android.materialdesigncodelab;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
  }

  public void persistentBottomSheetBtnClick(View view) {
    startActivity(new Intent(this, PersistentBottomSheetActivity.class));
  }

  public void modelBottomSheetBtnClick(View view) {
    startActivity(new Intent(this, ModalBottomSheetActivity.class));
  }
}
