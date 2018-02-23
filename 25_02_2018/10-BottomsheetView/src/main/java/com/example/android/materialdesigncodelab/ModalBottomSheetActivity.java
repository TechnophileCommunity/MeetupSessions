package com.example.android.materialdesigncodelab;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetBehavior;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class ModalBottomSheetActivity extends AppCompatActivity {

  BottomSheetBehavior mBottomSheetBehavior;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_model_bottom_sheet);
    View bottomSheet = findViewById(R.id.bottom_sheet);
    mBottomSheetBehavior = BottomSheetBehavior.from(bottomSheet);
  }

  public void showBottomModel(View view) {
    mBottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
  }
}
