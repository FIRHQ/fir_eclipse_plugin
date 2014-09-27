package UI;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class AppUI extends JPanel {
	private JLabel appNameK = null;
	private JLabel appNameV = null;
	private JLabel appIdK = null;
	private JLabel appIdV = null;
	private JLabel oneKeyUploadLabel = null;
	private JButton oneKeyUploadBtn = null;
	
	private JPanel appNamePanel = null;
	private JPanel appIdPanel = null;
	private JPanel uploadPanel = null;
	
	public AppUI(){
		init();
	}
	
	private void init(){
		appNamePanel = new JPanel();
		appIdPanel = new JPanel();
		uploadPanel = new JPanel();
		
		appNamePanel.setPreferredSize(new Dimension(300,50));
		
		this.setLayout(new GridLayout(3,0)); 
		appNamePanel.setLayout(new GridLayout(0,2));
		appIdPanel.setLayout(new GridLayout(0,2));
		uploadPanel.setLayout(new GridLayout(0,2));
		
		this.add(appNamePanel);
		this.add(appIdPanel);
		this.add(uploadPanel);
		
		appNameK = new JLabel("应用名：");
		appNameV = new JLabel("测试应用");
		this.appNamePanel.add(appNameK);
		this.appNamePanel.add(appNameV);
		
		appIdK = new JLabel("应用ID：");
		appIdV = new JLabel("com.bjdxt.n");
		this.appIdPanel.add(appIdK);
		this.appIdPanel.add(appIdV);
		
		oneKeyUploadLabel = new JLabel("一键上传操作：");
		oneKeyUploadBtn = new JButton("上传");
		oneKeyUploadBtn.setPreferredSize(new Dimension(50, 30));
		this.uploadPanel.add(oneKeyUploadLabel);
		this.uploadPanel.add(oneKeyUploadBtn);
	}
}
