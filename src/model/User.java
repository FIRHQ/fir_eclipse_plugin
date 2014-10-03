package model;

import net.sf.json.JSONObject;
import Util.Constant;
import Util.HttpRequest;

/**
 * 用户信息
 * @author will
 *
 */
public class User {
	
	//头像
	public String avatar ;
	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Boolean getIsLogin() {
		return isLogin;
	}

	public void setIsLogin(Boolean isLogin) {
		this.isLogin = isLogin;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	//用户名
	public String name ;
	//用户的token
	public String token;
	//用户的ID
	public String userId;
	//是否登录
	public Boolean isLogin = false;
	//用户的邮箱
	public String email;
	
	/**
	 * 使用token登录
	 * @param token
	 */
	public void login(String token){
		try{
			String loginUrl = Constant.userInfoUrl.replace("[token]", token);
			System.out.println("loginUrl"+loginUrl);
			String sr=HttpRequest.sendGet(loginUrl);
			System.out.println(sr);
			JSONObject jsonObject = JSONObject.fromString(sr);
			this.avatar = jsonObject.getString("avatar");
			this.name = jsonObject.getString("name");
			this.token = token;
			this.userId = jsonObject.getString("id");
			this.email = jsonObject.getString("email");
			this.isLogin = true;
		}catch(Exception e){
			this.isLogin = false;
		}
	}
	
	/**
	 * 使用邮箱密码登录
	 * @param email
	 * @param password
	 */
	public void login(String email , String password){
		
	}
	
	/**
	 * 对出登录
	 * @return
	 */
	public Boolean loginOut(){
		this.userId = null;
		this.email = null;
		this.name = null;
		this.isLogin = false;
		this.token = null;
		this.avatar = null;
		return this.isLogin;
	}
}
