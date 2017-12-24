package com.a365vintagewine.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.a365vintagewine.R;
import com.a365vintagewine.mvp.activity.search.SearchShopGoodsActivity;
import com.a365vintagewine.mvp.model.bean.BranchBen;
import com.a365vintagewine.mvp.model.bean.CategoryBean;
import com.a365vintagewine.widget.NoScrollGridView;
import com.commsdk.base.BaseActivity;
import com.commsdk.base.BaseAdapter2;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 二级分类列表
 */

public class ClassificationTwoLevelAdapter extends BaseAdapter2<CategoryBean> {

    public ClassificationTwoLevelAdapter(Context context) {
        super(context);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.item_classification_twolevel, null);
            viewHolder = new ViewHolder(convertView, context);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        CategoryBean categoryBean = getItem(position);
        viewHolder.tvClassificationTwolevelname.setText(categoryBean.getName());
        List<BranchBen> brandList = categoryBean.getBrands();
        if (brandList != null) {
            viewHolder.adapter.setMlist(brandList);
            viewHolder.adapter.notifyDataSetChanged();
            viewHolder.rlClassificationShowbrand.setVisibility(View.VISIBLE);
            onclicks(viewHolder,categoryBean);
        }
        return convertView;
    }


    private int showTag = 0;

    private void onclicks(final ViewHolder viewHolder,final CategoryBean categoryBean) {
        RelativeLayout rlClassificationShowbrand = viewHolder.rlClassificationShowbrand;
        //查看更多
        rlClassificationShowbrand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (showTag == 0) {
                    showTag = 1;
                    viewHolder.imgClassificationShowbrand.setImageResource(R.mipmap.arrow_up);
                    viewHolder.adapter.setShowMoreTag(true);
                    viewHolder.adapter.notifyDataSetChanged();
                } else {
                    showTag = 0;
                    viewHolder.imgClassificationShowbrand.setImageResource(R.mipmap.arrow_dowm);
                    viewHolder.adapter.setShowMoreTag(false);
                    viewHolder.adapter.notifyDataSetChanged();
                }
            }
        });

        //查询门店商品
        viewHolder.tvClassificationTwolevelmore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchShopGoodsActivity.launch((BaseActivity)context,"","",categoryBean.getId()+"","");
            }
        });

        //点击品牌进入
        viewHolder.gvClassificationBrand.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                BranchBen branchBenTemp= (BranchBen) parent.getAdapter().getItem(position);
                SearchShopGoodsActivity.launch((BaseActivity)context,SearchShopGoodsActivity.SEARCH_ACTION_CODE_B,branchBenTemp);
            }
        });

    }

    static class ViewHolder {
        /**
         * 二级分类名称
         */
        @Bind(R.id.tv_classification_twolevelname)
        TextView tvClassificationTwolevelname;
        /**
         * 查看更多品牌
         */
        @Bind(R.id.tv_classification_twolevelmore)
        TextView tvClassificationTwolevelmore;
        /**
         * 品牌列表
         */
        @Bind(R.id.gv_classification_brand)
        NoScrollGridView gvClassificationBrand;
        @Bind(R.id.rl_classification_showbrand)
        RelativeLayout rlClassificationShowbrand;
        @Bind(R.id.img_classification_showbrand)
        ImageView imgClassificationShowbrand;
        /**
         * 品牌适配器
         */
        ClassificationBrandAdapter adapter;

        ViewHolder(View view, Context context) {
            adapter = new ClassificationBrandAdapter(context);
            ButterKnife.bind(this, view);
            gvClassificationBrand.setAdapter(adapter);
        }
    }
}
