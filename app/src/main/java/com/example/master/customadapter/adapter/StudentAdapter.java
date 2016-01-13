package com.example.master.customadapter.adapter;

import android.content.Context;

import com.example.master.customadapter.R;
import com.example.master.customadapter.model.Student;

import java.util.List;

/**
 * Created by master on 2015/11/15.
 */
public class StudentAdapter extends RecycleCommenAdapter<Student> {
    /**
     * @param context
     * @param list
     */
    public StudentAdapter(Context context, List<Student> list) {
        super(context, list, R.layout.item_student);
    }




    @Override
    public void convert(RecycleViewHolder holder, Student student) {

        holder.setText(R.id.tv_student_age,String.valueOf(student.getAge())).setText(R.id.tv_student_name, student.getName());

    }
}
