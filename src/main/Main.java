package main;

import UI.LoginByToken;
import UI.WorkSpaceList;
import plug.InfoDialog;
import model.User;

/**
 * 整个程序的入口
 * @author will
 *
 */
public class Main {
	public static User user = null;
	public static InfoDialog mainPanel = null;
	
	private LoginByToken loginByTokenPanel = null;
	public Main(){
		init();
	}
	
	public void init(){
		user = new User();
		mainPanel = new InfoDialog();
		
		loginByTokenPanel = new LoginByToken();
		
		//先进入LoginPanel页面
		mainPanel.setContentPane(loginByTokenPanel);
		mainPanel.show();
	}
	
	/**
	 * 登录成功调用此方法
	 */
	public static void LoginSuccess(){
		System.out.println("------------------------");
		mainPanel.setContentPane(new WorkSpaceList());
	}
	
}
