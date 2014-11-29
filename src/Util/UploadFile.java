package Util;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONObject;
import main.Main;
import model.UploadToken;

public class UploadFile {
	public static String tokenUrl = " http://fir.im/api/v2/app/info/";
	public static String appInfoUrl = "http://fir.im/api/v2/app/";
	public static String infoUrl = "";
	public static String versionUrl = "http://fir.im/api/v2/appVersion/:versionOid/complete";
	public static String getUpLoadToken(String appid){
		String token = Main.user.token;
		String _tokenUrl = tokenUrl + appid + "?token="+token+"&type=android";
		String ret =  HttpRequest.sendGet(_tokenUrl);
		System.out.print(ret);
		return ret;
	}
	public static String uploadFile(File apkFile,UploadToken ut){
		String token = Main.user.token;
		Map<String, String> textMap = new HashMap<String, String>();
		textMap.put("token", ut.uploadApkToken);
		textMap.put("key", ut.uploadApkKey);
		Map<String, String> fileMap = new HashMap<String, String>();
		fileMap.put("file",apkFile.getAbsolutePath());
	    String ret = HttpRequest.formUpload(ut.uploadUrl, textMap,fileMap);
	    JSONObject jsonObject = JSONObject.fromString(ret);
	    putFileInfo(jsonObject);
		return ret;
	}
	public static String putFileInfo(JSONObject json){
		String ret = "";
		String appid = json.getString("appOid");
		String url = appInfoUrl + appid + "?token="+Main.user.token;
		String paramStr = "name="+Main.app.getAppName();
		url = url + "&" + paramStr + "&source=eclipse";
		try {
			ret = HttpRequest.sendPut(url, paramStr);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ret = putVersion(json);
		return ret;
	}
	
	public static String putVersion(JSONObject json){
		String ret = "";
		String versionId = json.getString("versionOid");
		String _versionUrl = versionUrl.replace(":versionOid", versionId);
		String paramStr = "version="+Main.app.getAppVersion()+"&versionShort="+Main.app.getAppVersion()
				+ "&release_type=inhouse&token="+Main.user.token;
		_versionUrl = _versionUrl + "?" + paramStr;
		try {
			ret = HttpRequest.sendPut(_versionUrl, paramStr);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return ret;
	}
}
