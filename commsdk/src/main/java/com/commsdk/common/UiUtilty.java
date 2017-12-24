package com.commsdk.common;

import android.annotation.SuppressLint;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.ListView;

public class UiUtilty {
	/**
	 * ScrollView 中嵌套listview，listview设置了adapter并且设置了数据之后需要重新计算高度
	 * 
	 * */
	public static void setListViewHeightBasedOnChildren(ListView listView) {  
		ListAdapter listAdapter = listView.getAdapter();   
		if (listAdapter == null) {  
			// pre-condition  
			return;  
		}  

		int totalHeight = 0;  
		for (int i = 0; i < listAdapter.getCount(); i++) {  
			View listItem = listAdapter.getView(i, null, listView);  
			listItem.measure(0, 0);  
			totalHeight += listItem.getMeasuredHeight();  
		}  

		ViewGroup.LayoutParams params = listView.getLayoutParams();  
		params.height = totalHeight + (listView.getDividerHeight() * (listAdapter.getCount()-1))+15;  
		listView.setLayoutParams(params);  
	}  

	/**
	 * 
	 * ScrollView 中嵌套Gridview，Gridview设置了adapter并且设置了数据之后需要重新计算高度
	 * 2列
	 * 
	 * */
	@SuppressLint("NewApi")
	public static void setListViewHeightBasedOnChildren(GridView listView) {  
		ListAdapter listAdapter = listView.getAdapter();   
		if (listAdapter == null) {  
			// pre-condition  
			return;  
		}  

		int totalHeight = 0; 
		int totalLine=listAdapter.getCount();
		if(totalLine%2==1){
			totalLine=totalLine/2+1;
		}else{
			totalLine=totalLine/2;
		}
		for (int i = 0; i < totalLine; i++) {  
			View listItem = listAdapter.getView(i, null, listView);  
			listItem.measure(0, 0);  
			totalHeight += listItem.getMeasuredHeight();  
		}  

		ViewGroup.LayoutParams params = listView.getLayoutParams();  
		params.height = totalHeight + (listView.getVerticalSpacing() * (listAdapter.getCount() - 1));  
		listView.setLayoutParams(params);  
	}  


	@SuppressLint("NewApi")
	public static void setListViewHeightBasedOnChildren(GridView listView,int colums) {  
		ListAdapter listAdapter = listView.getAdapter();   
		if (listAdapter == null) {  
			// pre-condition  
			return;  
		}  

		int totalHeight = 0; 
		int totalLine=listAdapter.getCount();
		if(totalLine<colums){
			return;
		}
		if(totalLine%colums==1){
			totalLine=totalLine/colums+1;
		}else{
			totalLine=totalLine/colums;
		}
		for (int i = 0; i < totalLine; i++) {  
			View listItem = listAdapter.getView(i, null, listView);  
			listItem.measure(0, 0);  
			totalHeight += listItem.getMeasuredHeight();  
		}  

		ViewGroup.LayoutParams params = listView.getLayoutParams();  
		params.height = totalHeight + (listView.getVerticalSpacing() * (listAdapter.getCount() - 1));  
		listView.setLayoutParams(params);  
	}  

	public static void setListViewHeightBasedOnChildren2(GridView listView) {  
		// 获取listview的adapter  
		ListAdapter listAdapter = listView.getAdapter();  
		if (listAdapter == null) {  
			return;  
		}  
		// 固定列宽，有多少列  
		int col = 2;// listView.getNumColumns(); 
		col=listView.getNumColumns();
		int totalHeight = 0;  
		// i每次加4，相当于listAdapter.getCount()小于等于4时 循环一次，计算一次item的高度，  
		// listAdapter.getCount()小于等于8时计算两次高度相加  
		for (int i = 0; i < listAdapter.getCount(); i += col) {  
			// 获取listview的每一个item  
			View listItem = listAdapter.getView(i, null, listView);  
			listItem.measure(0, 0);  
			// 获取item的高度和  
			totalHeight += listItem.getMeasuredHeight();  
		}  

		// 获取listview的布局参数  
		ViewGroup.LayoutParams params = listView.getLayoutParams();  
		// 设置高度  
		params.height = totalHeight;  
		// 设置margin  
		((MarginLayoutParams) params).setMargins(10, 10, 10, 10);  
		// 设置参数  
		listView.setLayoutParams(params);  
	}  


	/**
	 * 计算gridview高度
	 * @param gridView
	 */
	public static void setGridViewHeightBasedOnChildren(GridView gridView) {
		// 获取GridView对应的Adapter
		ListAdapter listAdapter = gridView.getAdapter();
		if (listAdapter == null) {
			return;
		}
		int rows;
		int columns = 0;
		int horizontalBorderHeight = 0;
		Class<?> clazz = gridView.getClass();
		try {
			// 利用反射，取得每行显示的个数
			java.lang.reflect.Field column = clazz.getDeclaredField("mRequestedNumColumns");
			column.setAccessible(true);
			columns = (Integer) column.get(gridView);
			// 利用反射，取得横向分割线高度
			java.lang.reflect.Field horizontalSpacing = clazz
					.getDeclaredField("mRequestedHorizontalSpacing");
			horizontalSpacing.setAccessible(true);
			horizontalBorderHeight = (Integer) horizontalSpacing.get(gridView);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		// 判断数据总数除以每行个数是否整除。不能整除代表有多余，需要加一行
		if (listAdapter.getCount() % columns > 0) {
			rows = listAdapter.getCount() / columns + 1;
		} else {
			rows = listAdapter.getCount() / columns;
		}
		int totalHeight = 0;
		for (int i = 0; i < rows; i++) { // 只计算每项高度*行数
			View listItem = listAdapter.getView(i, null, gridView);
			listItem.measure(0, 0); // 计算子项View 的宽高
			totalHeight += listItem.getMeasuredHeight(); // 统计所有子项的总高度
		}
		ViewGroup.LayoutParams params = gridView.getLayoutParams();
		params.height = totalHeight + horizontalBorderHeight * (rows - 1);// 最后加上分割线总高度
		gridView.setLayoutParams(params);
	}


}

