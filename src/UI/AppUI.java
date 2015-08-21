package UI;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import net.sf.json.JSONObject;
import main.Main;
import model.UploadToken;
import Util.ParseApp;
import Util.UploadFile;
import java.awt.FlowLayout;
import java.awt.CardLayout;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JRadioButton;

/**
 * 显示APP的Panel
 * @author will
 *
 */
public class AppUI extends JPanel implements ActionListener{
	private JLabel appNameK = null;
	private JLabel appNameV = null;
	private JLabel appIdK = null;
	private JLabel appIdV = null;
	private JLabel oneKeyUploadLabel = null;
	private JButton oneKeyUploadBtn = null;//一键上传
	
	private JLabel appVersionK = null;
	private JLabel appVersionV = null;
	
	private JLabel appIconK = null;
	private ImageIcon appIcon = null;
	
	private JPanel appNamePanel = null;
	private JPanel appIdPanel = null;
	private JPanel uploadPanel = null;
	private JPanel appVersionPanel = null;
	private JPanel appIconPanel = null;
	private JLabel imageLabel = null;
	
	private JPanel userJPanel = null;
	private JPanel appJPanel = null;
	private JPanel appJPanel_1;
	
	ParseApp parseApp = null;
	private JTextField appChangeLog;
	
	public AppUI(){
	    parseApp = new ParseApp("/Users/will/job/runtime-EclipseApplication/ApiDemos");
	    
		init();
	}
	
	public AppUI(String path){
	    parseApp = new ParseApp(path);
	    Main.app = parseApp;
		init();
	}
	
	private void init(){
		initPanel();
		appNamePanel = new JPanel();
		appNamePanel.setBounds(0, 0, 400, 250);
		appIdPanel = new JPanel();
		appIdPanel.setBounds(-1257, -801, 400, 235);
		uploadPanel = new JPanel();
		uploadPanel.setBounds(-1257, -801, 400, 235);
		appVersionPanel = new JPanel();
		appVersionPanel.setBounds(-1257, -801, 400, 235);
		appIconPanel = new JPanel();
		appIconPanel.setBounds(-1257, -801, 400, 235);
		appJPanel_1.setLayout(null);
		
		appNamePanel.setPreferredSize(new Dimension(300,50));
		
		appJPanel_1.add(appNamePanel);
		appJPanel_1.add(appIdPanel);
		appJPanel_1.add(uploadPanel);
		appJPanel_1.add(this.appVersionPanel);
		appJPanel_1.add(this.appIconPanel);
		
		appNameK = new JLabel("应用名：");
		appNameK.setBounds(92, 25, 52, 16);
		appNameV = new JLabel(parseApp.getAppName());
		appNameV.setBounds(249, 25, 36, 16);
		appNamePanel.setLayout(null);
		this.appNamePanel.add(appNameK);
		this.appNamePanel.add(appNameV);
		
		JLabel lblNewLabel = new JLabel("应用信息");
		lblNewLabel.setForeground(new Color(72, 61, 139));
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		lblNewLabel.setBounds(163, 6, 61, 16);
		appNamePanel.add(lblNewLabel);
		
		JLabel label = new JLabel("应用包名：");
		label.setBounds(92, 53, 73, 16);
		appNamePanel.add(label);
		
		JLabel appIdLable = new JLabel(parseApp.getAppid());
		appIdLable.setBounds(234, 53, 61, 16);
		appNamePanel.add(appIdLable);
		
		JLabel label_1 = new JLabel("应用图片：");
		label_1.setBounds(92, 81, 73, 16);
		appNamePanel.add(label_1);
		
		JLabel appIconLabel = new JLabel();
		appIconLabel.setBounds(234, 81, 61, 61);
		appIcon = new ImageIcon(parseApp.getAppIcon());
		appIconLabel.setIcon(this.appIcon);
		this.appIcon.setImage(this.appIcon.getImage().getScaledInstance(50, 50,
    		    Image.SCALE_DEFAULT));
		appNamePanel.add(appIconLabel);
		
		JLabel lblNewLabel_1 = new JLabel("更新日志:");
		lblNewLabel_1.setBounds(92, 152, 61, 16);
		appNamePanel.add(lblNewLabel_1);
		
		appChangeLog = new JTextField("");
		appChangeLog.setBounds(234, 152, 134, 50);
		appNamePanel.add(appChangeLog);
		appChangeLog.setColumns(10);
		
		oneKeyUploadBtn = new JButton("一键上传");
		oneKeyUploadBtn.setBackground(new Color(0, 128, 128));
		oneKeyUploadBtn.setBounds(163, 215, 117, 29);
		appNamePanel.add(oneKeyUploadBtn);
		
//		appIdK = new JLabel("应用ID：");
//		appIdK.setBounds(10, 5, 53, 16);
//		appIdV = new JLabel(parseApp.getAppid());
//		appIdV.setBounds(130, 5, 166, 16);
//		appIdPanel.setLayout(null);
//		this.appIdPanel.add(appIdK);
//		this.appIdPanel.add(appIdV);
//		
//		appVersionK = new JLabel("版本号：");
//		appVersionK.setBounds(10, 5, 52, 16);
//		appVersionV = new JLabel(parseApp.getAppVersion());
//		appVersionV.setBounds(130, 5, 27, 16);
//		appVersionPanel.setLayout(null);
//		this.appVersionPanel.add(appVersionK);
//		this.appVersionPanel.add(appVersionV);
//		
//		this.appIconK = new JLabel("Icon：");
//		appIconK.setBounds(10, 5, 40, 16);
//		appIcon = new ImageIcon(parseApp.getAppIcon());
//    	this.imageLabel = new JLabel();
//    	this.imageLabel.setSize(30, 30);
//    	this.imageLabel.setBounds(222,13,0,0);
//    	this.imageLabel.setIcon(this.appIcon);
//    	this.appIcon.setImage(this.appIcon.getImage().getScaledInstance(50, 50,
//    		    Image.SCALE_DEFAULT));
//    	appIconPanel.setLayout(null);
//    	
//    	this.appIconPanel.add(appIconK);
//    	this.appIconPanel.add(imageLabel);
//		
//		oneKeyUploadLabel = new JLabel("一键上传操作：");
//		oneKeyUploadLabel.setBounds(10, 12, 91, 16);
//		oneKeyUploadBtn = new JButton("上传");
//		oneKeyUploadBtn.setBounds(130, 5, 100, 30);
//		oneKeyUploadBtn.setPreferredSize(new Dimension(50, 30));
//		uploadPanel.setLayout(null);
//		this.uploadPanel.add(oneKeyUploadLabel);
//		this.uploadPanel.add(oneKeyUploadBtn);
		oneKeyUploadBtn.addActionListener(this);
	}
	
	public void initPanel(){
		userJPanel = new JPanel();
		appJPanel_1 = new JPanel();
		appJPanel_1.setPreferredSize(new Dimension(400, 240));
		this.add(appJPanel_1);
		this.add(userJPanel);
		userJPanel.add(Main.userUI);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == oneKeyUploadBtn){
			String ret = UploadFile.getUpLoadToken(parseApp.getAppid());
			UploadToken uploadToken = new UploadToken(ret);
			File apkFile = parseApp.getApk();
			if(apkFile != null){
				System.out.print(apkFile.getAbsolutePath());
				UploadFile.uploadFile(apkFile, uploadToken);
			}else{
				System.out.print("抱歉没有找到apk");
			}
			
		}
	}
}
