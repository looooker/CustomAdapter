package com.example.master.customadapter.adapter;

import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.text.SpannableString;
import android.util.SparseArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

public class RecycleViewHolder extends RecyclerView.ViewHolder {

	private SparseArray<View> mViews;

	private View mConvertView;

	public RecycleViewHolder(View itemView) {
		super(itemView);
		this.mConvertView = itemView;
		mViews = new SparseArray<View>();
		// TODO Auto-generated constructor stub
	}

	public static RecycleViewHolder get(View itemView) {
		return new RecycleViewHolder(itemView);
	}

	public View getConvertView() {
		return mConvertView;
	}

	public <T extends View> T getView(int viewId) {
		View view = mViews.get(viewId);
		if (view == null) {
			view = mConvertView.findViewById(viewId);
			mViews.put(viewId, view);
		}
		return (T) view;
	}

	/**
	 * 设置textview的值
	 * 
	 * @param viewId
	 * @param text
	 * @return
	 */
	public RecycleViewHolder setText(int viewId, String text) {
		TextView tv = getView(viewId);
		tv.setText(text);
		return this;
	}

	/**
	 * 设置textview的值
	 * 
	 * @param viewId
	 * @param text
	 * @return
	 */
	public RecycleViewHolder setText(int viewId, SpannableString text) {
		TextView tv = getView(viewId);
		tv.setText(text);
		return this;
	}

	/**
	 * 设置图片
	 * 
	 * @param viewId
	 * @param resId
	 * @return
	 */
	public RecycleViewHolder setImageResource(int viewId, int resId) {
		ImageView view = getView(viewId);
		view.setImageResource(resId);
		return this;
	}

	/**
	 * 设置图片
	 * 
	 * @param viewId
	 * @return
	 */
	public RecycleViewHolder setImageBitmap(int viewId, Bitmap bitmap) {
		ImageView view = getView(viewId);
		view.setImageBitmap(bitmap);
		return this;
	}



	/**
	 * 设置图片
	 * 
	 * @param viewId
	 * @param resId
	 * @return
	 */
	// public ViewHolder setImageURI(int viewId, String url) {
	// ImageView view = getView(viewId);
	// // ImageLoader.getInstance.loadImg(view,url);
	// return this;
	// }

	/**
	 * 设置背景图片
	 * 
	 * @param viewId
	 * @param resId
	 * @return
	 */
	public RecycleViewHolder setBackgroundImage(int viewId, int resId) {
		View view = getView(viewId);
		view.setBackgroundResource(resId);
		return this;
	}

	/**
	 * 设置文字颜色
	 * 
	 * @param viewId
	 * @param resId
	 * @return
	 */
	public RecycleViewHolder setTextColor(int viewId, int resId) {
		TextView view = getView(viewId);
		view.setTextColor(resId);
		return this;
	}

	/**
	 * 设置点击事件
	 * 
	 * @param viewId
	 * @return
	 */
	public RecycleViewHolder setOnClickListener(int viewId,
			OnClickListener listener) {
		getView(viewId).setOnClickListener(listener);
		return this;
	}

}
