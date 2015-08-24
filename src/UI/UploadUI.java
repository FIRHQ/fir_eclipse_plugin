package UI;

import java.awt.Graphics;
import java.awt.LayoutManager;
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
import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.UIManager;

import plug.InfoDialog;

public class UploadUI extends JPanel implements ActionListener{
	private JButton uploadBtn;
	private JButton settingBtn;
	private JButton closeBtn;
	public UploadUI() {
		setLayout(null);
		this.setSize(322, 518);
		initUI();
		initAction();
		// TODO Auto-generated constructor stub
	}
	public void initAction(){
		closeBtn.addActionListener(this);
		uploadBtn.addActionListener(this);
		settingBtn.addActionListener(this);
	}
	public void initUI(){
		JLabel lblNewLabel = new JLabel("fir.im upload");
		lblNewLabel.setForeground(UIManager.getColor("MenuBar.selectionForeground"));
		lblNewLabel.setBounds(113, 20, 125, 16);
		add(lblNewLabel);
		
		uploadBtn = new JButton();
		uploadBtn.setBounds(130, 126, 117, 29);
		ImageIcon uploadImg = new ImageIcon(Util.Util.getIconFilePath("/images/upload.png"));
		uploadBtn.setIcon(uploadImg);
		uploadBtn.setSize(uploadImg.getIconWidth(),uploadImg.getIconHeight());
		uploadBtn.setBorderPainted(false);
		add(uploadBtn);
		
		settingBtn = new JButton("");
		ImageIcon settingImg = new ImageIcon(Util.Util.getIconFilePath("/images/setting.png"));
		settingBtn.setBounds(10, 6, 117, 29);
		settingBtn.setIcon(settingImg);
		settingBtn.setSize(settingImg.getIconWidth(),settingImg.getIconHeight());
		settingBtn.setBorderPainted(false);
		
		add(settingBtn);
		
		closeBtn = new JButton("");
		ImageIcon closeImg = new ImageIcon(Util.Util.getIconFilePath("/images/close.png"));
		closeBtn.setIcon(closeImg);
		closeBtn.setBounds(280, 6, 117, 29);
		closeBtn.setSize(closeImg.getIconWidth(),closeImg.getIconHeight());
		closeBtn.setBorderPainted(false);
		add(closeBtn);		
	}
	public UploadUI(LayoutManager layout) {
		super(layout);
		// TODO Auto-generated constructor stub
	}

	public UploadUI(boolean isDoubleBuffered) {
		super(isDoubleBuffered);
		// TODO Auto-generated constructor stub
	}

	public UploadUI(LayoutManager layout, boolean isDoubleBuffered) {
		super(layout, isDoubleBuffered);
		// TODO Auto-generated constructor stub
	}
	
	protected void paintComponent(Graphics g) {  
        ImageIcon icon = new ImageIcon(Util.Util.getIconFilePath("/images/background.png")); 
        Image img = icon.getImage();  
        g.drawImage(img, 0, 0, icon.getIconWidth(),  
                icon.getIconHeight(), icon.getImageObserver());  
//        setSize(icon.getIconWidth(), icon.getIconHeight());  

    }
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == this.settingBtn){
			//TODO: 设置按钮
		}
		if(e.getSource() == this.closeBtn){
			//TODO: 关闭按钮
			System.out.print(".........");
			InfoDialog.getInstance().hide();
		}
		if(e.getSource() == this.uploadBtn){
			//TODO: 上传按钮
		}
	}
}
