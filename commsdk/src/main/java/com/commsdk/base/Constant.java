package com.commsdk.base;

import com.commsdk.common.FileUtils;

public class Constant {

	//网络返回码
	public static final int CODE_AUTH=201;//权限相关(未登录)
	public static final int CODE_504=504;
	public static final int CODE_502=502;
	public static final int CODE_404=404;


	/**商品详情页面传递WebView数据*/
	public static final String TAG_GOODS_DESC="goodsDesc";


	/**
	 * 图片目录
	 */
	public static final String FILE_PATH = FileUtils.getSavePath();
	public static final String TEMPORARY_FILE_PATH = FileUtils.getTemporarySavePath();

	/** 照相请求码 */
	public static final int CAMERA_REQUESTCODE = 100;
	/** 照片图片编辑请求码 */
	public static final int CAMERA_ET_REQUESTCODE = 101;
	/** 选择联系人请求码 */
	public static final int CONTACTS_ET_REQUESTCODE = 102;
	/** 相册请求的编码 */
	public static final int PHOTO_REQUESTCODE = 200;
	/** 发布编辑请求码 */
	public static final int PHBLISH_ET_REQUESTCODE = 301;


	/**轮播测试数据*/
	public static final String[] IMAGES = new String[] {
		"http://b.hiphotos.baidu.com/image/pic/item/023b5bb5c9ea15cec72cb6d6b2003af33b87b22b.jpg",
		"http://b.hiphotos.baidu.com/image/pic/item/023b5bb5c9ea15cec72cb6d6b2003af33b87b22b.jpg",
		"http://f.hiphotos.baidu.com/image/pic/item/b2de9c82d158ccbf79a00f8c1cd8bc3eb1354163.jpg",
		"http://f.hiphotos.baidu.com/image/pic/item/b2de9c82d158ccbf79a00f8c1cd8bc3eb1354163.jpg",
		"http://b.hiphotos.baidu.com/image/pic/item/023b5bb5c9ea15cec72cb6d6b2003af33b87b22b.jpg",
		"http://e.hiphotos.baidu.com/image/pic/item/14ce36d3d539b600be63e95eed50352ac75cb7ae.jpg",
		"http://e.hiphotos.baidu.com/image/pic/item/14ce36d3d539b600be63e95eed50352ac75cb7ae.jpg",
		"http://weloveicons.s3.amazonaws.com/icons/100929_applications.png",
		"http://112.74.18.34:12002/2016/01/14/8c8312316c3398147d62a49c6c294bca_yckx_temp.png",
		"http://f.hiphotos.baidu.com/image/pic/item/b2de9c82d158ccbf79a00f8c1cd8bc3eb1354163.jpg",
		"http://e.hiphotos.baidu.com/image/pic/item/14ce36d3d539b600be63e95eed50352ac75cb7ae.jpg",
		"http://3.bp.blogspot.com/-ka5MiRGJ_S4/TdD9OoF6bmI/AAAAAAAAE8k/7ydKtptUtSg/s1600/Google_Sky%2BMaps_Android.png",
		"http://112.74.18.34:12002/2016/01/14/8c8312316c3398147d62a49c6c294bca_yckx_temp.png",
		"http://112.74.18.34:12002/2016/01/14/8c8312316c3398147d62a49c6c294bca_yckx_temp.png", 
		"", 
		"http://wrong.site.com/corruptedLink", 
	};
	
	
	public static final String REGIST="http://test.youchekuaixi.com/auth/phone-captcha?phone=11";



	/**==============环信================*/

	public static final String MESSAGE_ATTR_IS_VOICE_CALL = "is_voice_call";
	public static final String MESSAGE_ATTR_IS_VIDEO_CALL = "is_video_call";

	public static final String MESSAGE_TYPE_RECALL = "message_recall";

	public static final String MESSAGE_ATTR_IS_BIG_EXPRESSION = "em_is_big_expression";
	public static final String MESSAGE_ATTR_EXPRESSION_ID = "em_expression_id";

	public static final String MESSAGE_ATTR_AT_MSG = "em_at_list";
	public static final String MESSAGE_ATTR_VALUE_AT_MSG_ALL = "ALL";



	public static final int CHATTYPE_SINGLE = 1;
	public static final int CHATTYPE_GROUP = 2;
	public static final int CHATTYPE_CHATROOM = 3;

	public static final String EXTRA_CHAT_TYPE = "chatType";
	public static final String EXTRA_USER_ID = "userId";

	public static final String NEW_FRIENDS_USERNAME = "item_new_friends";
	public static final String GROUP_USERNAME = "item_groups";
	public static final String CHAT_ROOM = "item_chatroom";
	public static final String ACCOUNT_REMOVED = "account_removed";
	public static final String ACCOUNT_CONFLICT = "conflict";
	public static final String ACCOUNT_FORBIDDEN = "user_forbidden";
	public static final String ACCOUNT_KICKED_BY_CHANGE_PASSWORD = "kicked_by_change_password";
	public static final String ACCOUNT_KICKED_BY_OTHER_DEVICE = "kicked_by_another_device";
	public static final String CHAT_ROBOT = "item_robots";
	public static final String MESSAGE_ATTR_ROBOT_MSGTYPE = "msgtype";
	public static final String ACTION_GROUP_CHANAGED = "action_group_changed";
	public static final String ACTION_CONTACT_CHANAGED = "action_contact_changed";
}
