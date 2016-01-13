package com.example.master.customadapter.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import com.example.master.customadapter.R;
import com.example.master.customadapter.adapter.Multi_Item_Adapter;
import com.example.master.customadapter.model.Student;
import java.util.ArrayList;

public class MultItemActivity extends AppCompatActivity {



  public static void actionStart(Context context){
    Intent intent=new Intent(context,MultItemActivity.class);
    context.startActivity(intent);
  }

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_mult_item);
    Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);

    FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
    fab.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View view) {
        Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
            .setAction("Action", null)
            .show();
      }
    });

    RecyclerView rvMult = (RecyclerView) findViewById(R.id.rv_mult);
    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);

    linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
    rvMult.setLayoutManager(linearLayoutManager);
    ArrayList<Student> students = new ArrayList<>();
    for (int i=0 ;i<30;i++){

      Student student = new Student();

      String text="我是一只小鸭子呀，咿呀咿呀呦，嘿嘿，嘿黝黑";

      int leng=3+(i%5);
      student.setName(text.substring(0, leng));

      student.setAge(i);
      students.add(student);

    }

    Multi_Item_Adapter multi_item_adapter = new Multi_Item_Adapter(students, this);


    rvMult.setAdapter(multi_item_adapter);
  }
}
