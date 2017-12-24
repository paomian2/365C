package com.a365vintagewine.adapter;
import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.a365vintagewine.R;
import com.a365vintagewine.mvp.model.bean.CategorityBean;
import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 描述：商家首页商品分类横向列表适配器
 * 作者：Linxz
 * E-mail:lin_xiao_zhang@163.com
 * 时间:2017年09月08日  14:36
 * 版本：3.0
 */

public class GalleryGoodsClassAdapter extends BaseRecyViewAdapter<CategorityBean>{


    private OnCategoryItemClick onCategoryItemClick;


    public GalleryGoodsClassAdapter(Context context) {
        super(context);
    }


    public void setOnCategoryItemClick(OnCategoryItemClick onCategoryItemClick){
        this.onCategoryItemClick=onCategoryItemClick;
    }



    /**
     * 创建ViewHolder
     */
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i)
    {
        View view = inflater.inflate(R.layout.item_goods_class,
                viewGroup, false);
        return new ViewHolder(view);
    }


    /**
     * 设置值
     */
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        ViewHolder viewHolder= (ViewHolder) holder;
        final CategorityBean categorityBean=getItem(position);
        viewHolder.tvGoodsClass.setText(categorityBean.getName());
        if (categorityBean.isSelect()){
            viewHolder.tvGoodsClass.setTextColor(ContextCompat.getColor(context,R.color.black));
            viewHolder.tvGoodsClass.setTextSize(32);
        }else{
            viewHolder.tvGoodsClass.setTextColor(ContextCompat.getColor(context,R.color.backTextColor3));
            viewHolder.tvGoodsClass.setTextSize(30);
        }
        viewHolder.tvGoodsClass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onCategoryItemClick!=null){
                    onCategoryItemClick.onItemClick(categorityBean,position);
                }
            }
        });
    }




    public interface OnCategoryItemClick{
        void onItemClick(CategorityBean categorityBean,int position);
    }


    public class ViewHolder extends RecyclerView.ViewHolder{
        @Bind(R.id.tvGoodsClass)
        TextView tvGoodsClass;
        public ViewHolder(View view)
        {
            super(view);
            ButterKnife.bind(this, view);
        }

    }




}
