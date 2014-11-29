package model;

import main.Main;
import net.sf.json.JSONObject;

public class UploadToken {
	public String _short = null;
	public String id = null;
	public String uploadUrl = null;
	public String uploadApkToken = null;
	public String uploadIconToken = null;
	public String uploadApkKey = null;
	public String uploadIconKey = null;
	public UploadToken(String ret){
		JSONObject jsonObject = JSONObject.fromString(ret);
		_short = jsonObject.getString("short");
		Main.app.appShort = _short;
		id = jsonObject.getString("id");
		JSONObject bundle =jsonObject.getJSONObject("bundle");
		JSONObject icon = bundle.getJSONObject("icon");
		uploadIconToken = icon.getString("token");
		uploadIconKey = icon.getString("key");
		JSONObject pkg = bundle.getJSONObject("pkg");
		uploadApkToken = pkg.getString("token");
		uploadApkKey = pkg.getString("key");	
		uploadUrl = pkg.getString("url");
	}
}
