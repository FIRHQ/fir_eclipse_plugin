package main;

import java.io.File;
import java.util.ArrayList;

import UI.AppUI;
import UI.LoginByToken;
import UI.WorkSpaceList;
import Util.ParseApp;
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
	public static UI.User userUI = null;
	//当前eclispe环境下的工程
	public static ArrayList<File> programList = new ArrayList();
	
	private LoginByToken loginByTokenPanel = null;
	public Main(){
		init();
	}
	
	public void init(){
		user = new User();
		mainPanel = new InfoDialog();
		
		loginByTokenPanel = new LoginByToken();
		
		//先进入LoginPanel页面
		//mainPanel.setContentPane(loginByTokenPanel);
		
		//test
		mainPanel.setContentPane(new AppUI());
		ParseApp parseApp = new ParseApp("/Users/will/job/runtime-EclipseApplication/ApiDemos");
		mainPanel.show();
	}
	
	/**
	 * 登录成功调用此方法
	 */
	public static void LoginSuccess(){
		System.out.println("------------------------");
		userUI = new UI.User();
		mainPanel.setContentPane(new WorkSpaceList());
		
	}
	
}
