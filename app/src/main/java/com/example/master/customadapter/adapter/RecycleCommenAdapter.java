package com.example.master.customadapter.adapter;

import java.util.List;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * <p>
 * Title: TODO
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Copyright: Copyright (c) 2015
 * </p>
 * <p>
 * Company: 北京成嘉科技
 * </p>
 * 
 * @author 张元振
 * @date 2015年7月9日下午3:23:16
 */
public abstract class RecycleCommenAdapter<T> extends
		RecyclerView.Adapter<RecycleViewHolder> {

	Context context;
	private List<T> list;
	private int resourceID;

	/**
	 * @param context
	 * @param data
	 */
	public RecycleCommenAdapter(Context context, List<T> list, int resourceID) {
		super();
		this.context = context;
		this.list = list;
		this.resourceID = resourceID;
	}

	// RecyclerView显示的子View
	// 该方法返回是ViewHolder，当有可复用View时，就不再调用
	@Override
	public RecycleViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
		View v = LayoutInflater.from(context).inflate(resourceID, viewGroup,
				false);
		return RecycleViewHolder.get(v);
	}

	// 将数据绑定到子View
	@Override
	public void onBindViewHolder(RecycleViewHolder viewHolder, int i) {
		convert(viewHolder, list.get(i));

	}

	// RecyclerView显示数据条数
	@Override
	public int getItemCount() {
		return list.size();
	}

	public abstract void convert(RecycleViewHolder holder, T t);

}
