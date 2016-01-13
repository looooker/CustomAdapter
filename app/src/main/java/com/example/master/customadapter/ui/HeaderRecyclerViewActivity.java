package com.example.master.customadapter.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import com.example.master.customadapter.R;
import com.example.master.customadapter.adapter.HeaderNumberAdapter;
import com.example.master.customadapter.adapter.RecycleAdapter;
import com.example.master.customadapter.adapter.StudentAdapter;
import com.example.master.customadapter.model.Student;
import java.util.ArrayList;

public class HeaderRecyclerViewActivity extends AppCompatActivity {

    private RecyclerView rvTest;
    private ArrayList<Student> students;
    private RecyclerView rvTest2;
    private RecyclerView rvTest1;


  public static void actionStart(Context context){
    Intent intent=new Intent(context,HeaderRecyclerViewActivity.class);
    context.startActivity(intent);
  }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvTest = ((RecyclerView) findViewById(R.id.app_recyclerview));
        rvTest1 = ((RecyclerView) findViewById(R.id.app_recyclerview1));
        rvTest2 = ((RecyclerView) findViewById(R.id.app_recyclerview2));

       final GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        LinearLayoutManager gridLayoutManager1 = new LinearLayoutManager(this);

        GridLayoutManager gridLayoutManager2 = new GridLayoutManager(this, 2);
        gridLayoutManager.setOrientation(GridLayoutManager.HORIZONTAL);
        gridLayoutManager1.setOrientation(LinearLayoutManager.HORIZONTAL);
        gridLayoutManager2.setOrientation(GridLayoutManager.HORIZONTAL);


        View header = LayoutInflater.from(this).inflate(R.layout.header_student, null);
        final HeaderNumberAdapter headerNumberAdapter = new HeaderNumberAdapter(header, 30);
        rvTest.setAdapter(headerNumberAdapter);
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                return headerNumberAdapter.isHeader(position) ? gridLayoutManager.getSpanCount() : 1;
            }
        });
        rvTest.setLayoutManager(gridLayoutManager);
        rvTest1.setLayoutManager(gridLayoutManager1);
        rvTest2.setLayoutManager(gridLayoutManager2);


//        SpacesItemDecoration decoration=new SpacesItemDecoration(36);
//        rvTest.addItemDecoration(decoration);
        students = new ArrayList<>();

        int i=0;
        for (;i<100;i++){

            Student student = new Student();

            String text="我是一只小鸭子呀，咿呀咿呀呦，嘿嘿，嘿黝黑";

            int leng=3+(i%10);
            student.setName(text.substring(0,leng));

            students.add(student);

            student.setAge(i);

        }

        StudentAdapter studentAdapter = new StudentAdapter(this, students);

        RecycleAdapter recycleAdapter = new RecycleAdapter(students);


        rvTest1.setAdapter(recycleAdapter);
        rvTest2.setAdapter(studentAdapter);
//        rvTest.scrollToPosition(5);

//        rvTest.scrollBy();

    }
}
