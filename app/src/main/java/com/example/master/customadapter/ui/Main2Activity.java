package com.example.master.customadapter.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import com.example.master.customadapter.R;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener {

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main2);


    findViewById(R.id.tv_header).setOnClickListener(this);
    findViewById(R.id.tv_mult).setOnClickListener(this);
  }

  @Override public void onClick(View v) {
    switch (v.getId()){
      case R.id.tv_header:

        HeaderRecyclerViewActivity.actionStart(this);
        break;

      case R.id.tv_mult:
        MultItemActivity.actionStart(this);
        break;
      default:
        break;
    }
  }
}
