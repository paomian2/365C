package com.a365vintagewine.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.a365vintagewine.R;
import com.a365vintagewine.mvp.model.bean.GoodsEvaluate;
import com.commsdk.base.BaseAdapter2;
import com.commsdk.common.StringUtils;
import com.commsdk.common.UIHelper;
import com.commsdk.common.widget.CircleImageView;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 商品评论适配
 */

public class GoodsEvaluateAdapter extends BaseAdapter2<GoodsEvaluate> {

    public GoodsEvaluateAdapter(Context context) {
        super(context);
    }


    @Override
    public int getCount() {
        return 50;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (null == convertView) {
            convertView = inflater.inflate(R.layout.item_goods_evaluate, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
      /*  GoodsEvaluate evaluate = getItem(position);
        viewHolder.tvGoodsEvaluateContent.setText(evaluate.getEvaluateContent());
        viewHolder.tvGoodsEvaluateName.setText(evaluate.getName());
        viewHolder.tvGoodsEvaluateTime.setText(evaluate.getEvaluateTime());
        switch(evaluate.getEvaluateType()){
            case 1:
                viewHolder.tvGoodsEvaluateComment.setText("好评");
                break;
            case 2:
                viewHolder.tvGoodsEvaluateComment.setText("中评");
                break;
            case 3:
                viewHolder.tvGoodsEvaluateComment.setText("差评");
                break;
            default :
                break;
        }
        if (!StringUtils.isEmpty(evaluate.getHeadImaUrl())){
            UIHelper.imageNet(context,evaluate.getHeadImaUrl(),viewHolder.imgGoodsEvaluateHead,true);
        }*/
        return convertView;
    }

    static class ViewHolder {
        @Bind(R.id.img_goods_evaluate_head)
        CircleImageView imgGoodsEvaluateHead;
        @Bind(R.id.tv_goods_evaluate_name)
        TextView tvGoodsEvaluateName;
        @Bind(R.id.tv_goods_evaluate_content)
        TextView tvGoodsEvaluateContent;
        @Bind(R.id.tv_goods_evaluate_time)
        TextView tvGoodsEvaluateTime;
        @Bind(R.id.tv_goods_evaluate_comment)
        TextView tvGoodsEvaluateComment;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
