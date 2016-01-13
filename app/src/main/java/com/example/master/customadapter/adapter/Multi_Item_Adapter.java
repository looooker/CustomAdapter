package com.example.master.customadapter.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.master.customadapter.R;
import com.example.master.customadapter.model.Student;
import java.util.ArrayList;


public class Multi_Item_Adapter extends RecyclerView.Adapter<RecycleViewHolder> {

	private ArrayList<Student> students;
	private Context context;
	private static final int ITEM_VIEW_TYPE_HEADER = 0;
	private static final int ITEM_VIEW_TYPE_ITEM = 1;

	public Multi_Item_Adapter(ArrayList<Student> sutdents, Context context) {
		super();
		this.students = sutdents;
		this.context = context;
	}

	@Override
	public int getItemCount() {
		return students.size();
	}

	@Override
	public void onBindViewHolder(RecycleViewHolder arg0, int arg1) {
		int itemViewType = getItemViewType(arg1);
		if (itemViewType == ITEM_VIEW_TYPE_HEADER) {
			arg0.setText(R.id.tv_student_name,students.get(arg1).getName());
			
		} else if (itemViewType == ITEM_VIEW_TYPE_ITEM) {
			
		}

		arg0.setText(R.id.tv_student_age,String.valueOf(students.get(arg1).getAge()));

	}

	@Override
	public RecycleViewHolder onCreateViewHolder(ViewGroup arg0, int arg1) {
		View view = null;
		if (arg1 == ITEM_VIEW_TYPE_HEADER) {
			view = LayoutInflater.from(context).inflate(
					R.layout.item_student, arg0, false);
		} else if (arg1 == ITEM_VIEW_TYPE_ITEM) {
			view = LayoutInflater.from(context).inflate(
					R.layout.item_student_mult, arg0, false);
		}
		return RecycleViewHolder.get(view);
	}

	@Override
	public int getItemViewType(int position) {
		return students.get(position).getAge() %2==0? ITEM_VIEW_TYPE_HEADER
				: ITEM_VIEW_TYPE_ITEM;
	}

}
