package com.imagepicker.ui.grid.view;

import com.imagepicker.base.activity.IImageBaseView;
import com.imagepicker.data.ImageBean;
import com.imagepicker.data.ImageFloderBean;
import com.imagepicker.data.ImagePickerOptions;

import java.util.List;

/**
 * Created by LWK
 * TODO ImageDataActivity的View层接口
 */

public interface IImageDataView extends IImageBaseView
{
    ImagePickerOptions getOptions();

    void startTakePhoto();

    void showLoading();

    void hideLoading();

    void onDataChanged(List<ImageBean> dataList);

    void onFloderChanged(ImageFloderBean floderBean);

    void onImageClicked(ImageBean imageBean, int position);

    void onSelectNumChanged(int curNum);

    void warningMaxNum();
}
