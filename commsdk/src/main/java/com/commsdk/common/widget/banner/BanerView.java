package com.commsdk.common.widget.banner;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Handler;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.commsdk.R;
import com.commsdk.common.AdjustImageView;
import com.commsdk.common.UIHelper;

import java.util.ArrayList;

/**
 * 广告轮播图片
 */
public class BanerView extends LinearLayout {
    /**
     * 上下文
     */
    private Context mContext;
    /**
     * 图片轮播视图
     */
    private ViewPager mAdvPager = null;
    /**
     * 滚动图片视图适配
     */
    private ImageCycleAdapter mAdvAdapter;
    /**
     * 图片轮播指示器控件
     */
    private ViewGroup mGroup;

    /**
     * 图片轮播指示个图
     */
    private ImageView mImageView = null;

    /**
     * 轮播图实体列表
     */
    private ArrayList<BannerBean> imageUrlList;

    /**
     * 滚动图片指示视图列表
     */
    private ImageView[] mImageViews = null;

    /**
     * 图片滚动当前图片下标
     */
    private int mImageIndex = 0;
    /**
     * 手机密度
     */
    private float mScale;
    private boolean isStop;
    private TextView imageName;

    /**
     * 是否正在滚动
     */
    private boolean isScrolling;

    /**
     * 广告图是否自适应
     */
    private boolean isADfixXY;
    /**
     * 是否使用750px的高度
     */
    private boolean is_750;


    /**
     * 轮播时间
     */
    private int recycleTime = 3000;

    /**
     * @param context
     */
    public BanerView(Context context) {
        super(context);
        init(context);
    }

    /**
     * @param context
     * @param attrs
     */
    public BanerView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BanerView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.Bannder, defStyleAttr, 0);
        isADfixXY = a.getBoolean(R.styleable.Bannder_isADfixXY, false);
        is_750 = a.getBoolean(R.styleable.Bannder_is_750, false);
        a.recycle();
        init(context);
    }

    private void init(Context context) {
        mContext = context;
        mScale = context.getResources().getDisplayMetrics().density;
        View contentView;
        if (is_750) {
            contentView=LayoutInflater.from(context).inflate(R.layout.ad_cycle_view_750, this);
            mAdvPager = (ViewPager) contentView.findViewById(R.id.adv_pager_750);
        } else {
            contentView=LayoutInflater.from(context).inflate(R.layout.ad_cycle_view, this);
            mAdvPager = (ViewPager) contentView.findViewById(R.id.adv_pager);
        }
        //start---设置一个ViewPager里面同时显示三个图片
        //设置Page间间距
        mAdvPager.setPageMargin(20);
        //设置缓存的页面数量
        mAdvPager.setOffscreenPageLimit(3);
        mAdvPager.setPageTransformer(false, new AlphaPageTransformer());
        //end----
        mAdvPager.addOnPageChangeListener(new GuidePageChangeListener());
        mAdvPager.setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_UP:
                        // 开始图片滚动
                        startImageTimerTask();
                        break;
                    default:
                        // 停止图片滚动
                        stopImageTimerTask();
                        break;
                }
                return false;
            }
        });
        // 滚动图片右下指示器视
        mGroup = (ViewGroup) findViewById(R.id.circles);
        if (is_750){
            mGroup.setVisibility(View.VISIBLE);
        }
        imageName = (TextView) findViewById(R.id.viewGroup2);
    }


    /**
     * 装填图片数据，
     *
     * @param :imageUrlList          圖片URL
     * @param :mBannerOnclickListner 轮播图点击事件
     */
    public void setImageResources(ArrayList<BannerBean> imageUrlList, BannerOnclickListner mBannerOnclickListner) {
        this.imageUrlList = imageUrlList;
        if (imageUrlList != null && imageUrlList.size() > 0) {
            this.setVisibility(View.VISIBLE);
        } else {
            this.setVisibility(View.GONE);
            return;
        }
        // 清除
        mGroup.removeAllViews();
        // 图片广告数量
        final int imageCount = imageUrlList.size();
        mImageViews = new ImageView[imageCount];
        for (int i = 0; i < imageCount; i++) {
            mImageView = new ImageView(mContext);
            int imageParams = (int) (mScale * 10 + 0.5f);// XP与DP转换，适应应不同分辨率
            int imagePadding = (int) (mScale * 5 + 0.5f);
            LayoutParams params = new LayoutParams(imageParams, imageParams);
            params.leftMargin = 10;
            if (isADfixXY){
                mImageView.setScaleType(ScaleType.FIT_XY);
            }else{
                mImageView.setScaleType(ScaleType.CENTER);
            }
            mImageView.setLayoutParams(params);
            mImageView.setPadding(imagePadding, imagePadding, imagePadding, imagePadding);

            mImageViews[i] = mImageView;
            if (i == 0) {
                mImageViews[i].setBackgroundResource(R.drawable.icon_point_select);
            } else {
                mImageViews[i].setBackgroundResource(R.drawable.icon_point_def);
            }
            mGroup.addView(mImageViews[i]);
        }

        //imageName.setText(imageDesList.get(0));
        imageName.setTextColor(getResources().getColor(R.color.blue));
        mAdvAdapter = new ImageCycleAdapter(mContext, mBannerOnclickListner);
        mAdvPager.setAdapter(mAdvAdapter);
        startImageTimerTask();
    }

    /**
     * s设置轮播时间
     */
    public void setRecycleTime(int recycleTime) {
        this.recycleTime = recycleTime;
    }

    /**
     * 设置广告图是否填充全部
     */
    public void setADfixXY(boolean isADfixXY) {
        this.isADfixXY = isADfixXY;
    }

    /**
     * 图片轮播(手动控制自动轮播与否，便于资源控件）
     */
    public void startImageCycle() {
        startImageTimerTask();
    }

    /**
     * 暂停轮播—用于节省资源
     */
    public void pushImageCycle() {
        stopImageTimerTask();
    }

    /**
     * 图片滚动任务
     */
    private void startImageTimerTask() {
        stopImageTimerTask();
        // 图片滚动
        mHandler.postDelayed(mImageTimerTask, recycleTime);
    }

    /**
     * 停止图片滚动任务
     */
    private void stopImageTimerTask() {
        isStop = true;
        mHandler.removeCallbacks(mImageTimerTask);
    }

    private Handler mHandler = new Handler();

    /**
     * 图片自动轮播Task
     */
    private Runnable mImageTimerTask = new Runnable() {
        @Override
        public void run() {
            if (mImageViews != null) {
                if (mAdvPager.getCurrentItem() >= imageUrlList.size() - 1) {
                    mAdvPager.setCurrentItem(0);
                } else {
                    mAdvPager.setCurrentItem(mAdvPager.getCurrentItem() + 1);
                }
                if (!isStop) {  //if  isStop=true   //当你退出后 要把这个给停下来 不然 这个一直存在 就一直在后台循环
                    mHandler.postDelayed(mImageTimerTask, recycleTime);
                }

            }
        }
    };

    /**
     * 轮播图片监听
     *
     * @author minking
     */
    private final class GuidePageChangeListener implements OnPageChangeListener {
        @Override
        public void onPageScrollStateChanged(int state) {
            if (state == ViewPager.SCROLL_STATE_IDLE) {//viewPager滚动结束
                startImageTimerTask();
            } else if (state == ViewPager.SCROLL_STATE_DRAGGING) {
                //viewPager在滚动
                isScrolling = true;
                return;
            }
            isScrolling = false;
        }

        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2) {
        }

        @Override
        public void onPageSelected(int index) {
            index = index % mImageViews.length;
            // 设置当前显示的图片
            mImageIndex = index;
            // 设置图片滚动指示器背
            mImageViews[index].setBackgroundResource(R.drawable.icon_point_select);
            for (int i = 0; i < mImageViews.length; i++) {
                if (index != i) {
                    mImageViews[i].setBackgroundResource(R.drawable.icon_point_def);
                }
            }
        }
    }

    private class ImageCycleAdapter extends PagerAdapter {

        /**
         * 图片视图缓存列表
         */
        private ArrayList<ImageView> mImageViewCacheList;

        /**
         * 图片资源列表
         */
        private ArrayList<String> nameList = new ArrayList<String>();

        /**
         * 广告图片点击监听
         */

        private BannerOnclickListner mBannerOnclickListner;


        private Context mContext;

        public ImageCycleAdapter(Context context, final BannerOnclickListner mBannerOnclickListner) {
            this.mContext = context;
            this.mBannerOnclickListner = mBannerOnclickListner;
            mImageViewCacheList = new ArrayList<>();
        }

        @Override
        public int getCount() {
            //  return Integer.MAX_VALUE;
            return imageUrlList == null ? 0 : imageUrlList.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        @Override
        public Object instantiateItem(ViewGroup container, final int position) {
            //  final int currenImagePosition=position % imageUrlList.size();
            final int currenImagePosition = position;
            String imageUrl = imageUrlList.get(currenImagePosition).getAdPic();
            final ImageView imageView;
            if (mImageViewCacheList.isEmpty()) {
                if (is_750){
                    imageView = new AdjustImageView(mContext);
                }else{
                    imageView = new ClickableImageView(mContext);
                }
                imageView.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
                if (isADfixXY) {
                    imageView.setScaleType(ScaleType.FIT_XY);
                } else {
                    imageView.setScaleType(ScaleType.CENTER);
                }
                UIHelper.imageNet(mContext, imageUrl+"", imageView, false,R.drawable.img_def_gray);
            } else {
                imageView = mImageViewCacheList.remove(0);
            }
            // 设置图片点击监听
            imageView.setTag(currenImagePosition);
            imageView.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    int mPosition = (int) imageView.getTag();
                    if (mBannerOnclickListner != null)
                        mBannerOnclickListner.onImageClick(mPosition, imageUrlList.get(mPosition), imageView);
                }
            });
            container.addView(imageView);
            return imageView;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            ImageView view;
            if (is_750){
                view = (AdjustImageView) object;
            }else{
                view = (ClickableImageView) object;
            }

            mAdvPager.removeView(view);
            mImageViewCacheList.add(view);
        }
    }

    /**
     * 轮播控件的监听事件
     *
     * @author minking
     */
    public interface BannerOnclickListner {
        /**
         * 单击图片事件
         *
         * @param position
         * @param imageView
         */
        void onImageClick(int position, BannerBean bannerBean, View imageView);
    }


}
