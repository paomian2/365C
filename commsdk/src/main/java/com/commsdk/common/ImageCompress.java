package com.commsdk.common;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import com.commsdk.base.Constant;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
public class ImageCompress {

	public static File scal(String path) {
		File outputFile = new File(path);
		if (outputFile.exists()) {
			long fileSize = outputFile.length();
			final long fileMaxSize = 200 * 1024;
			if (fileSize >= fileMaxSize) {
				BitmapFactory.Options options = new BitmapFactory.Options();
				options.inJustDecodeBounds = true;
				BitmapFactory.decodeFile(path, options);
				int height = options.outHeight;
				int width = options.outWidth;

				double scale = Math.sqrt((float) fileSize / fileMaxSize);
				options.outHeight = (int) (height / scale);
				options.outWidth = (int) (width / scale);
				options.inSampleSize = (int) (scale + 0.5);
				options.inJustDecodeBounds = false;

				Bitmap bitmap = BitmapFactory.decodeFile(path, options);
				outputFile = new File(Constant.TEMPORARY_FILE_PATH + "/" + System.currentTimeMillis() + ".jpg");
				FileOutputStream fos = null;
				try {
					fos = new FileOutputStream(outputFile);
					bitmap.compress(Bitmap.CompressFormat.JPEG, 50, fos);
					fos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Log.d("", "sss ok " + outputFile.length());
				if (!bitmap.isRecycled()) {
					bitmap.recycle();
				}
			}
		}
		return outputFile;
	}
}
