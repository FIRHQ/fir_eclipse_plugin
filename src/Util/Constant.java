package Util;

/**
 * 常量用来存放URL地址
 * @author will
 *
 */
public class Constant {
	//获取用户登录的地址
	public static String  userInfoUrl = "http://fir.im/api/v2/user/me?token=[token]";
	//获取app上传信息的接口
	public static String  appUploadUrl = "http://localhost:3000/api/v2/app/info/[appid]?type=ios&token=[token]";	
}
