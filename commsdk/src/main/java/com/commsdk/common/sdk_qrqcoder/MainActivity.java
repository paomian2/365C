package com.commsdk.common.sdk_qrqcoder;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.commsdk.R;
import com.commsdk.common.sdk_qrqcoder.utils.Constant;



public class MainActivity extends Activity {
    Button createCode;
    Button scan2code;
    Button scanBarCode;
    Button scanCode;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sdk_rqcode_main);
        int mode = getIntent().getIntExtra(Constant.REQUEST_SCAN_MODE, Constant.REQUEST_SCAN_MODE_ALL_MODE);
        createCode = (Button) findViewById(R.id.create_code);
        scan2code = (Button) findViewById(R.id.scan_2code);
        scanBarCode = (Button) findViewById(R.id.scan_bar_code);
        scanCode = (Button) findViewById(R.id.scan_code);
    }


    /**
     * 按钮监听事件，这里我使用Butterknife，不喜欢的也可以直接写监听
     * @param view
     */
    public void clickListener(View view){
        Intent intent;
        int i = view.getId();
        if (i == R.id.create_code) {
            intent = new Intent(this, CreateCodeActivity.class);
            startActivity(intent);

        } else if (i == R.id.scan_2code) {
            intent = new Intent(this, CommonScanActivity.class);
            intent.putExtra(Constant.REQUEST_SCAN_MODE, Constant.REQUEST_SCAN_MODE_QRCODE_MODE);
            startActivity(intent);

        } else if (i == R.id.scan_bar_code) {
            intent = new Intent(this, CommonScanActivity.class);
            intent.putExtra(Constant.REQUEST_SCAN_MODE, Constant.REQUEST_SCAN_MODE_BARCODE_MODE);
            startActivity(intent);

        } else if (i == R.id.scan_code) {
            intent = new Intent(this, CommonScanActivity.class);
            intent.putExtra(Constant.REQUEST_SCAN_MODE, Constant.REQUEST_SCAN_MODE_ALL_MODE);
            startActivity(intent);

        }
    }
}
