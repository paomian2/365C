package com.a365vintagewine.widget;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;

import com.bartoszlipinski.recyclerviewheader.RecyclerViewHeader;

/**
 * Created by Administrator on 2017/8/29 0029.
 *
 * recycleView的外层需要使用FrameLayout,如：
 *
 <android.support.v4.widget.SwipeRefreshLayout
 android:id="@+id/refrenshLayout"
 android:layout_width="match_parent"
 android:layout_height="match_parent">
 <FrameLayout
 android:layout_width="match_parent"
 android:layout_height="wrap_content">
 <android.support.v7.widget.RecyclerView
 android:id="@+id/recycler_goodsList"
 android:layout_width="match_parent"
 android:layout_height="wrap_content"
 />
 <com.a365vintagewine.widget.MyRecyclerViewHeader
 android:id="@+id/header_igoodsList"
 android:layout_width="match_parent"
 android:layout_height="wrap_content">
 <include layout="@layout/item_business_home_header" />
 </com.a365vintagewine.widget.MyRecyclerViewHeader>
 </FrameLayout>
 </android.support.v4.widget.SwipeRefreshLayout>

 */

public class MyRecyclerViewHeader extends RecyclerViewHeader {

    private int mCurrentScroll;

    public MyRecyclerViewHeader(Context context) {
        super(context);
    }

    public MyRecyclerViewHeader(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyRecyclerViewHeader(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }
    public interface OnScrollTopListener {
        void onTop(boolean isTop);
    }

    public OnScrollTopListener mOnScrollTopListener;

    public void setOnScrollTopListener(OnScrollTopListener onScrollTopListener) {
        mOnScrollTopListener = onScrollTopListener;
    }
    private void setupHeader(final RecyclerView recycler) {
        recycler.setOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                mCurrentScroll = mCurrentScroll;
                mCurrentScroll += dy;
                MyRecyclerViewHeader.this.setTranslationY(-mCurrentScroll);

                // 增加时候滚动的顶部回调
                if (mOnScrollTopListener != null) {
                    if (mCurrentScroll > 0) {
                        mOnScrollTopListener.onTop(false);
                    } else {
                        mOnScrollTopListener.onTop(true);
                    }
                }
            }
        });
    }
}
