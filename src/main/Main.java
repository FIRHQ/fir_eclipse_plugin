package main;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JPanel;

import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;

import org.eclipse.core.runtime.Platform;

import UI.AppUI;
import UI.LoginByToken;
import UI.WorkSpaceList;
import Util.FileOperate;
import Util.ParseApp;
import plug.InfoDialog;
import model.User;

/**
 * 整个程序的入口
 * @author will
 *
 */
public class Main implements FocusListener{
	public static User user = null;
	public static InfoDialog mainPanel = null;
	public static UI.User userUI = null;
	public static ParseApp app= null;
	//当前eclispe环境下的工程
	public static ArrayList<File> programList = new ArrayList();
	
	private LoginByToken loginByTokenPanel = null;
	
	public Boolean isShow = false;
	public Main(ArrayList<File> pl){
		this.programList = pl;
		init();
	}
	
	public void init(){
		user = new User();
		mainPanel = new InfoDialog();
		mainPanel.addFocusListener(this);
		String data = FileOperate.readFileByLines(Util.Util.getIconFilePath("/data/user.data"));
		if(!data.isEmpty()){
			JSONObject  jo = JSONObject.fromString(data);
			user = (User)JSONObject.toBean(jo,User.class);
		}
		
		if(user!=null && user.isLogin==true){
			userUI = new UI.User();
			//如果登录直接进入工程列表
			mainPanel.setContentPane(new WorkSpaceList());
		}else{
			loginByTokenPanel = new LoginByToken();
			//先进入LoginPanel页面
			Main.setCurrentPanel(loginByTokenPanel);
		}
		
		
		mainPanel.show();
	}
	
	/**
	 * 登录成功调用此方法
	 */
	public static void LoginSuccess(){
		System.out.println("------------------------");
		String strUser = JSONObject.fromObject(Main.user).toString();
		FileOperate.writeFile(Util.Util.getIconFilePath("/data/user.data"),strUser);
		userUI = new UI.User();
		mainPanel.setContentPane(new WorkSpaceList());
		
	}
	
	/**
	 * 显示Panel
	 * @param jp
	 */
	public  static void setCurrentPanel(JPanel jp){
		Main.mainPanel.setContentPane(jp);
		Main.mainPanel.show();
	}
	
	/**
	 * 选中APP时执行的操作
	 * @param path
	 */
	public static void selectApp(String path){
		Main.setCurrentPanel(new AppUI(path));
	}

	@Override
	public void focusGained(FocusEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void focusLost(FocusEvent e) {
		// TODO Auto-generated method stub
		System.out.println("...........失去焦点了");
	}
	
}
