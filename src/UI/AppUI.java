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
	
	ParseApp parseApp = null;
	
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
		appIdPanel = new JPanel();
		uploadPanel = new JPanel();
		appVersionPanel = new JPanel();
		appIconPanel = new JPanel();
		
		appNamePanel.setPreferredSize(new Dimension(300,50));
		
		appJPanel.setLayout(new GridLayout(5,0)); 
		
		appJPanel.add(appNamePanel);
		appJPanel.add(appIdPanel);
		appJPanel.add(uploadPanel);
		appJPanel.add(this.appVersionPanel);
		appJPanel.add(this.appIconPanel);
		
		appNameK = new JLabel("应用名：");
		appNameV = new JLabel(parseApp.getAppName());
		this.appNamePanel.add(appNameK);
		this.appNamePanel.add(appNameV);
		
		appIdK = new JLabel("应用ID：");
		appIdV = new JLabel(parseApp.getAppid());
		this.appIdPanel.add(appIdK);
		this.appIdPanel.add(appIdV);
		
		appVersionK = new JLabel("版本号：");
		appVersionV = new JLabel(parseApp.getAppVersion());
		this.appVersionPanel.add(appVersionK);
		this.appVersionPanel.add(appVersionV);
		
		this.appIconK = new JLabel("Icon：");
		appIcon = new ImageIcon(parseApp.getAppIcon());
    	this.imageLabel = new JLabel();
    	this.imageLabel.setSize(30, 30);
    	this.imageLabel.setBounds(0,0,20,20);
    	this.imageLabel.setIcon(this.appIcon);
    	this.appIcon.setImage(this.appIcon.getImage().getScaledInstance(50, 50,
    		    Image.SCALE_DEFAULT));
    	
    	this.appIconPanel.add(appIconK);
    	this.appIconPanel.add(imageLabel);
		
		oneKeyUploadLabel = new JLabel("一键上传操作：");
		oneKeyUploadBtn = new JButton("上传");
		oneKeyUploadBtn.setPreferredSize(new Dimension(50, 30));
		this.uploadPanel.add(oneKeyUploadLabel);
		this.uploadPanel.add(oneKeyUploadBtn);
		oneKeyUploadBtn.addActionListener(this);
	}
	
	public void initPanel(){
		userJPanel = new JPanel();
		appJPanel = new JPanel();
		appJPanel.setPreferredSize(new Dimension(400, 235));
		this.add(appJPanel);
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
