package com.commsdk.common;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Environment;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.DecimalFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.GZIPInputStream;
public class FileUtils {
	private static String SDPATH = Environment.getExternalStorageDirectory() + "/";

	public static String getSDPATH() {
		return SDPATH;
	}

	/**
	 * 图片存储的路径
	 * */
	public static String FILEPAHT=SDPATH+"/365mjh/";
	/**
	 * yckx截屏临时文件
	 * */
	public static String SHARE_FILEName="yckx_screen_temp";

	/**图片存储的路径*/
	public static String getFileCache(Context context){
		return context.getExternalCacheDir().getPath();
	}
	/**
	 * 在SD卡上创建文件
	 */
	public File creatSDFile(String fileName) throws IOException {
		File file = new File(SDPATH + fileName);
		file.createNewFile();
		return file;
	}

	/**
	 * 在SD卡上创建目录
	 */
	public static File creatSDDir(String dirName) {
		File dir = new File(SDPATH + dirName);
		dir.mkdir();
		return dir;
	}

	/**
	 * 判断SD卡上的文件夹是否存在
	 */
	public static boolean isFileExist(String fileName) {
		File file = new File(fileName);
		return file.exists();
	}

	/** 删除目录 */
	public static boolean deleteDirectory(File dir) {
		File[] bookFiles = dir.listFiles();
		for (File bookFile : bookFiles) {
			if (bookFile.isDirectory())
				deleteDirectory(bookFile);
			bookFile.delete();
		}
		return dir.delete();
	}

	/** 删除文件 */
	public static boolean deleteFileByPath(String filePath) {
		if (!StringUtils.isEmpty(filePath)) {
			File delFile = new File(filePath);
			if (delFile.exists()) {
				return delFile.delete();
			}
		}

		return false;
	}

	/**
	 * 删除某一目录
	 * 
	 * @param path
	 *            路径
	 */
	public static boolean deleteFolder(String path) {
		File file = new File(path);
		return deleteFolder(file);
	}

	/**
	 * 删除某一目录
	 * 
	 * @param folder
	 *            删除的路径文件
	 */
	public static boolean deleteFolder(File folder) {
		boolean result = false;
		try {

			String childs[] = folder.list();
			if (childs == null || childs.length <= 0) {
				if (folder.delete()) {
					result = true;
				}
			} else {
				for (int i = 0; i < childs.length; i++) {
					String childName = childs[i];
					String childPath = folder.getPath() + File.separator + childName;
					File filePath = new File(childPath);
					if (filePath.exists() && filePath.isFile()) {
						if (filePath.delete()) {
							result = true;
						} else {
							result = false;
							break;
						}
					} else if (filePath.exists() && filePath.isDirectory()) {
						if (deleteFolder(filePath)) {
							result = true;
						} else {
							result = false;
							break;
						}
					}
				}
				folder.delete();
			}
		} catch (Exception e) {
			e.printStackTrace();
			result = false;
		}
		return result;
	}

	/**
	 * 将一个InputStream里面的数据写入到SD卡中
	 */
	public File write2SDFromInput(String path, String fileName, InputStream input) {
		File file = null;
		OutputStream output = null;
		try// InputStream里面的数据写入到SD卡中的固定方法
		{
			creatSDDir(path);
			file = creatSDFile(path + fileName);
			output = new FileOutputStream(file);
			byte buffer[] = new byte[4 * 1024];
			while ((input.read(buffer)) != -1) {
				output.write(buffer);
			}
			output.flush();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				output.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return file;
	}

	public static String getSizeKBString(int f) {
		DecimalFormat fmt = new DecimalFormat("0.#");
		String s = fmt.format(f) + "KB";
		float f2 = f;
		if (f2 > 1024) {
			f2 = f / 1024.0f;
			s = fmt.format(f2) + "MB";
		}
		return s;
	}

	public static String getSizeString(long f) {
		DecimalFormat fmt = new DecimalFormat("0.#");
		float f1 = 1;
		if (f >= 1024) {
			f1 = f / 1024.0f;
		}
		String s = fmt.format(f1) + "KB";
		float f2 = 1;
		if (f1 >= 1024) {
			f2 = f1 / 1024.0f;
			s = fmt.format(f2) + "MB";
		}
		return s;
	}

	public static boolean untieGzip(String GzipPath, String filePath) {
		boolean mk = false;
		try {
			GZIPInputStream in = new GZIPInputStream(new FileInputStream(GzipPath));
			OutputStream out = new FileOutputStream(filePath);
			byte[] buf = new byte[1024];
			int len;
			while ((len = in.read(buf)) > 0) {
				out.write(buf, 0, len);
			}
			in.close();
			out.close();
			mk = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mk;
	}

	/**
	 * 获取常用文件储存路径
	 * 
	 * @return
	 */
	public static String getSavePath() {
		return getPath(false);
	}

	/**
	 * 获取临时储存路径
	 * 
	 * @return
	 */
	public static String getTemporarySavePath() {
		return getPath(true);
	}

	/**
	 * 获取储存路径
	 * 
	 * @param isTemporary
	 *            //是否是临时文件
	 * @return
	 */
	public static String getPath(boolean isTemporary) {
		String sdDir = "";
		String childDir = isTemporary == true ? "/yckx/pro/" : "/yckx/";
		boolean sdCardExist = Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED); // 判断sd卡是否存在
		if (sdCardExist) {
			sdDir = Environment.getExternalStorageDirectory() + childDir;// 获取跟目录
		} else {
			//sdDir = AppApplication.getInstance().getFilesDir().getAbsolutePath() + childDir;
		}
		File file = new File(sdDir);
		if (!file.exists()) {
			file.mkdir();
		}
		return sdDir;
	}

	/**
	 * 获取系统的总内存（单位Byte）
	 * 
	 * @return
	 */
	public static long getTotalMemory() {
		try {
			FileReader localFileReader = new FileReader("/proc/meminfo");
			BufferedReader localBufferedReader = new BufferedReader(localFileReader);
			String memTotal = localBufferedReader.readLine();
			localFileReader.close();

			String regEx = "\\d{1,}";
			Pattern p = Pattern.compile(regEx);
			Matcher m = p.matcher(memTotal);
			if (m.find()) {
				return (Long.parseLong(m.group(0)) * 1024);
			}
		} catch (Throwable e) {
			LogUtil.log(e);
		}
		return -1;
	}
	
	public static void writeFileToSD(InputStream is, String pathName, String fileName) {
		String sdStatus = Environment.getExternalStorageState();
		if (!sdStatus.equals(Environment.MEDIA_MOUNTED)) {
			LogUtil.d("XXTIMG", "SD card is not avaiable/writeable right now.");
			return;
		}
		try {
			File path = new File(pathName);
			File file = new File(pathName + fileName);
			if (!path.exists()) {
				LogUtil.d("XXTIMG", "Create the path:" + pathName);
				path.mkdir();
			}
			if (!file.exists()) {
				LogUtil.d("XXTIMG", "Create the file:" + fileName);
				file.createNewFile();
			}
		} catch (Exception e) {
			LogUtil.e("XXTIMG", "Error on writeFilToSD.");
			e.printStackTrace();
		}
	}


	/**
	 * 根据文件路径，将图片文件存储到sdcard中
	 *
	 * */
    public static void saveFileToSDcard(String filePath, Bitmap saveBitmap){
		try {
			FileOutputStream b = null;
			File yckx_tempFile = new File("/sdcard/yckx/");
			if (!yckx_tempFile.exists()) {
				yckx_tempFile.mkdirs();// 创建文件夹
			}
			File file = new File("/sdcard/yckx/" + filePath);
			b = new FileOutputStream(file);//写到存储卡
			saveBitmap.compress(Bitmap.CompressFormat.JPEG, 100, b);// 把数据写入文件
		}catch (FileNotFoundException e){
              e.printStackTrace();
		}

	}


	/*
  * 根据Uri获取图片绝对路径，解决Android4.4以上版本Uri转换
  * @param activity
  * @param imageUri
  * @author yaoxing
  * @date 2014-10-12
          */
	@TargetApi(19)
	public static String getImageAbsolutePath(Activity context, Uri imageUri) {
		if (context == null || imageUri == null)
			return null;
		if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.KITKAT && DocumentsContract.isDocumentUri(context, imageUri)) {
			if (isExternalStorageDocument(imageUri)) {
				String docId = DocumentsContract.getDocumentId(imageUri);
				String[] split = docId.split(":");
				String type = split[0];
				if ("primary".equalsIgnoreCase(type)) {
					return Environment.getExternalStorageDirectory() + "/" + split[1];
				}
			} else if (isDownloadsDocument(imageUri)) {
				String id = DocumentsContract.getDocumentId(imageUri);
				Uri contentUri = ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"), Long.valueOf(id));
				return getDataColumn(context,contentUri, null, null);
			} else if (isMediaDocument(imageUri)) {
				String docId = DocumentsContract.getDocumentId(imageUri);
				String[] split = docId.split(":");
				String type = split[0];
				Uri contentUri = null;
				if ("image".equals(type)) {
					contentUri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
				} else if ("video".equals(type)) {
					contentUri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
				} else if ("audio".equals(type)) {
					contentUri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
				}
				String selection = MediaStore.Images.Media._ID + "=?";
				String[] selectionArgs = new String[] { split[1] };
				return getDataColumn(context, contentUri, selection, selectionArgs);
			}
		} // MediaStore (and general)
		else if ("content".equalsIgnoreCase(imageUri.getScheme())) {
			// Return the remote address
			if (isGooglePhotosUri(imageUri))
				return imageUri.getLastPathSegment();
			return getDataColumn(context, imageUri, null, null);
		}
		// File
		else if ("file".equalsIgnoreCase(imageUri.getScheme())) {
			return imageUri.getPath();
		}
		return null;
	}

	public static String getDataColumn(Context context, Uri uri, String selection, String[] selectionArgs) {
		Cursor cursor = null;
		String column = MediaStore.Images.Media.DATA;
		String[] projection = { column };
		try {
			cursor = context.getContentResolver().query(uri, projection, selection, selectionArgs, null);
			if (cursor != null && cursor.moveToFirst()) {
				int index = cursor.getColumnIndexOrThrow(column);
				return cursor.getString(index);
			}
		} finally {
			if (cursor != null)
				cursor.close();
		}
		return null;
	}

	/**
	 * @param uri The Uri to check.
	 * @return Whether the Uri authority is ExternalStorageProvider.
	 */
	public static boolean isExternalStorageDocument(Uri uri) {
		return "com.android.externalstorage.documents".equals(uri.getAuthority());
	}

	/**
	 * @param uri The Uri to check.
	 * @return Whether the Uri authority is DownloadsProvider.
	 */
	public static boolean isDownloadsDocument(Uri uri) {
		return "com.android.providers.downloads.documents".equals(uri.getAuthority());
	}

	/**
	 * @param uri The Uri to check.
	 * @return Whether the Uri authority is MediaProvider.
	 */
	public static boolean isMediaDocument(Uri uri) {
		return "com.android.providers.media.documents".equals(uri.getAuthority());
	}

	/**
	 * @param uri The Uri to check.
	 * @return Whether the Uri authority is Google Photos.
	 */
	public static boolean isGooglePhotosUri(Uri uri) {
		return "com.google.android.apps.photos.content".equals(uri.getAuthority());
	}
	

}