package com.commsdk.common;
import com.commsdk.base.Config;
import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.http.RequestParams;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest.HttpMethod;
import java.io.File;
public class XUtilsImgUp {
	public static void UpImg(File files,String type,RequestCallBack<String> requestCallBack){
		if (files!=null) {
			String url= "";
			RequestParams params = new RequestParams();
	//	    String token = SharedPreferenceUtil.getInstance(AppApplication.getInstance()).getString(SharedPreferenceUtil.TOKEN);
	//		params.setHeader("Authorization", "token " + token);
			url= Config.UPLOAD;
			params.addBodyParameter("uploadFile", files,"image/jpeg");
			params.addBodyParameter("type",type);
			/*if(files.size()==1&&isSingle){
				url= Config.UPLOAD;
				params.addBodyParameter("uploadFile", files.get(0),"image/jpeg");
			}else{
				url=Config.UPLOADS;
				for(int i= 0;i<files.size();i++){
					params.addBodyParameter("uploadFile["+i+"]",files.get(i),"image/jpeg");
				}
			}*/
			//params.addBodyParameter("relationType", relationType);
			LogUtil.d("uploadFile:",url+params.toString());
			HttpUtils http = new HttpUtils();
			http.send(HttpMethod.POST, url, params,requestCallBack);
								
		}
	}


}

