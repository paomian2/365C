package com.a365vintagewine.mvp.activity.setting;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.a365vintagewine.R;
import com.a365vintagewine.widget.ChoosePhotoPw;
import com.commsdk.base.BaseActivity;
import com.commsdk.common.UIHelper;
import com.imagepicker.ImagePicker;
import com.imagepicker.data.ImageBean;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FeedBackActivity extends BaseActivity {

    @Bind(R.id.img_text_title_back)
    RelativeLayout imgTextTitleBack;
    @Bind(R.id.tv_text_title)
    TextView tvTextTitle;
    @Bind(R.id.ll_text_title)
    RelativeLayout llTextTitle;
    @Bind(R.id.et_feedback_msg)
    EditText etFeedbackMsg;
    @Bind(R.id.et_feedback_phone)
    EditText etFeedbackPhone;
    @Bind(R.id.img_feedback_one)
    ImageView imgFeedbackOne;
    @Bind(R.id.img_feedback_two)
    ImageView imgFeedbackTwo;
    @Bind(R.id.img_feedback_there)
    ImageView imgFeedbackThere;
    @Bind(R.id.tv_feedback_msg_count)
    TextView tvFeedbackMsgCount;
    @Bind(R.id.btn_feedback_commit)
    Button btnFeedbackCommit;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void setActivityView(Bundle bundle) {
        setContentView(R.layout.act_feed_back);
        ButterKnife.bind(this);
    }

    @Override
    protected void initUI() {
        tvTextTitle.setText("意见反馈");
        llTextTitle.setBackgroundColor(Color.parseColor("#f2f2f2"));
        etFeedbackMsg.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                int lenght = etFeedbackMsg.getText().toString().trim().length();
                tvFeedbackMsgCount.setText((200-lenght) + "/200字");
                if (lenght > 0){
                    btnFeedbackCommit.setBackgroundResource(R.drawable.btn_background_black);
                    btnFeedbackCommit.setEnabled(true);
                    return;
                }
                btnFeedbackCommit.setBackgroundResource(R.drawable.btn_background_ddd);
                btnFeedbackCommit.setEnabled(false);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    @Override
    protected void initData() {

    }

    /**
     * 返回
     */
    @OnClick(R.id.img_text_title_back)
    public void back() {
        finish();
    }

    /**
     * 第一张图片
     */
    @OnClick(R.id.img_feedback_one)
    public void feecbackOneImg(){
        chooseTag = 1;
        choosePhotoPw = new ChoosePhotoPw(activity);
        choosePhotoPw.showPopupWindow(imgFeedbackOne);
    }

    /**
     * 第二张图片
     */
    @OnClick(R.id.img_feedback_two)
    public void feecbackTwoImg(){
        chooseTag = 2;
        choosePhotoPw = new ChoosePhotoPw(activity);
        choosePhotoPw.showPopupWindow(imgFeedbackOne);
    }

    /**
     * 第三张图片
     */
    @OnClick(R.id.img_feedback_there)
    public void feecbackThereImg(){
        chooseTag = 3;
        choosePhotoPw = new ChoosePhotoPw(activity);
        choosePhotoPw.showPopupWindow(imgFeedbackOne);
    }

    /**
     * 提交意见反馈
     */
    @OnClick(R.id.btn_feedback_commit)
    public void commitFeedback(){

    }

    private int chooseTag = 0;
    private ChoosePhotoPw choosePhotoPw;
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && data != null){
            if (requestCode == ChoosePhotoPw.REQUEST_CODE_ALBUM || requestCode == ChoosePhotoPw.REQUEST_CODE_PHOTOGRAPH)
            {
                //获取选择的图片数据
                List<ImageBean> resultList = data.getParcelableArrayListExtra(ImagePicker.INTENT_RESULT_DATA);
                switch(chooseTag){
                    case 1:
                        UIHelper.imageNet(activity,resultList.get(0).getImagePath(),imgFeedbackOne,true);
                        break;
                    case 2:
                        UIHelper.imageNet(activity,resultList.get(0).getImagePath(),imgFeedbackTwo,true);
                        break;
                    case 3:
                        UIHelper.imageNet(activity,resultList.get(0).getImagePath(),imgFeedbackThere,true);
                        break;
                    default :
                        break;
                }
            }
        }
    }
}
