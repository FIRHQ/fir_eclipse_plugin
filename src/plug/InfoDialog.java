
package plug;

import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import javax.swing.*;

import Util.HttpRequest;
import Util.Util;
import model.User;
import net.sf.json.JSONObject;



/**
 * @author 
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

public class InfoDialog extends JDialog implements ActionListener
{
    
    String city="";
    String upLoad_url = "http://fir.im/api/v2/app/info/[appid]?type=android&token=[token]";
    private JPanel mainPanel = null;
    private JButton jbtn = null;
    private JTextArea jt = null;
    private JTextArea absolutPathJa = null;
    private JButton absouJbtn = null;
    
    private JPanel loginPanel = null;//登录panel
    private JPanel appInfoPanel = null;//APP信息panel
    private JPanel userInfoPanel = null;//用户信息panel
    
    private JLabel loginLabel = null;
    private JTextArea loginText = null;
    private JButton loginBtn = null;
    
    private JLabel  appLabel = null;
    private JButton choseFileBtn = null;
    private JFileChooser appFileChoser = null;
    private JTextArea appPathText = null;
    
    private ImageIcon userAvatarIcon = null;
    private JLabel userNameLabel = null;
    private JLabel imageLabel = null;
    private JLabel userEmailLabel = null;
    private JLabel userIdLabel = null;
    
    private User user = null;
    /**
     * This method initializes 
     * 
     */
    public InfoDialog(ArrayList al) 
    {
        super();
        initialize();
    }
    /**
     * This method initializes this
     * 
     * @return void
     */
    private void initialize() 
    {

        this.setContentPane(getJEditorPane());
        initUser();
        
        initPanel();
        initAppInfoPanel();
        initLoginPanel();
        initUserInfoPanel();
        //监听事件
        addListioner();
        

        System.out.println(user.name);
        System.out.println(user.avatar);
        System.out.println(user.token);
        System.out.println(user.userId);
//        JLabel jlable_token = new JLabel("开发者Token");
//        jt = new JTextArea(20,20);
//        jt.setBorder (BorderFactory.createEmptyBorder (1,1,1,5));
//        jt.setColumns (30); 
//        jt.setRows (0);
//        this.mailPanel.add(jlable_token);
//        this.mailPanel.add(jt);
//        jbtn = new JButton("确定");
//        this.mailPanel.add(jbtn);
//        jbtn.addActionListener(this);
//        
//        absolutPathJa = new JTextArea(20,20);
//        absolutPathJa.setBorder (BorderFactory.createEmptyBorder (1,1,1,5));
//        absolutPathJa.setColumns (30); 
//        absolutPathJa.setRows (0);
//        JLabel jlable_path = new JLabel("apk的path");
//        jlable_path.setLocation(0,100);
//        this.mailPanel.add(jlable_path);
//        this.mailPanel.add(absolutPathJa);
//        absouJbtn = new JButton("Ok");
//        this.mailPanel.add(absouJbtn);
//        absouJbtn.addActionListener(this);
//        
//        String _url = upLoad_url.replace("[appid]", "a.b.c");
//        _url = _url.replace("[token]", "token");
//        String sr=HttpRequest.sendGet(_url,"");
//        
//        JSONObject jsonObject = JSONObject.fromString(sr);
        
        
    }
    
    /**
     *初始化用户
     */
    private void initUser(){
        this.user = new User();
        user.login("jotg9wGkqOFk9cpfPej1s1dvYEXFfMaMY318OlJq");    	
    }
    /**
     * This method initializes jEditorPane	
     * 	
     * @return javax.swing.JEditorPane	
     */    
    private JPanel getJEditorPane() 
    {
    	if(mainPanel == null){
    		mainPanel = new JPanel();
    		mainPanel.setLayout(new GridLayout(3,0)); 
    	}
    	return mainPanel;
    }
    
    /**
     * 初始化mainPanel
     */
    private void initPanel(){
    	loginPanel = new JPanel();
    	appInfoPanel = new JPanel();
    	userInfoPanel = new JPanel();
    	mainPanel.add(loginPanel);
    	mainPanel.add(appInfoPanel);
    	mainPanel.add(userInfoPanel);
    }
    
    /**
     * 初始化LoginPanel
     */
    private void initLoginPanel(){
    	loginLabel = new JLabel("请输入Token");
    	loginText = new JTextArea(0,30);
    	loginBtn = new JButton("确定");
    	loginPanel.add(loginLabel);
    	loginPanel.add(loginText);
    	loginPanel.add(loginBtn);
    }
   
    /**
     * 初始化文件选择器
     */
    private void initFileChoser(){
    	appFileChoser = new JFileChooser("D:\\");
    	appFileChoser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
    	appFileChoser.setDialogTitle("Select path to save");
    	int returnVal = appFileChoser.showOpenDialog(appFileChoser);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
        	String path = appFileChoser.getSelectedFile().getAbsolutePath();
        	System.out.print("文件选择的路径:"+path);
        	if(Util.isApkWorkSpace(path)){
        		System.out.print("this is a apk workspace");
        	}else{
        		System.out.print("this is not a apk workspace");
        	}
        	appPathText.setText(path);
        }
    }
    /**
     * 初始化appInfoPanel
     */
    private void initAppInfoPanel(){
    	//initFileChoser();
    	appPathText = new JTextArea();
    	choseFileBtn = new JButton("选择工程目录");
    	appInfoPanel.add(choseFileBtn);
    	appInfoPanel.add(appPathText);
    }
    
    
    /**
     * 初始化用户信息panel
     */
    private void initUserInfoPanel(){
    	this.userInfoPanel.setLayout(new GridLayout(2,2)); 
    	try {
			this.userAvatarIcon = new ImageIcon(new URL(this.user.avatar));
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	this.userNameLabel = new JLabel("用户名："+this.user.name);
    	this.userInfoPanel.add(this.userNameLabel);
    	this.imageLabel = new JLabel();
    	this.imageLabel.setSize(30, 30);
    	this.imageLabel.setBounds(0,0,20,20);
    	this.imageLabel.setIcon(this.userAvatarIcon);
    	this.userAvatarIcon.setImage(this.userAvatarIcon.getImage().getScaledInstance(50, 50,
    		    Image.SCALE_DEFAULT));
    	this.userInfoPanel.add(this.imageLabel);
    	this.userEmailLabel = new JLabel("邮箱："+user.email);
    	this.userIdLabel = new JLabel("用户ID："+user.userId);
    	this.userInfoPanel.add(this.userEmailLabel);
    	this.userInfoPanel.add(this.userIdLabel);
    }
    
    /**
     * 监听事件
     */
    private void addListioner(){
    	loginBtn.addActionListener(this);
     	choseFileBtn.addActionListener(this);
    }
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
        //登录按钮
        if(e.getSource()==loginBtn){
        	
        }
        //选择文件按钮
        if(e.getSource()==choseFileBtn){
        	initFileChoser();
        }
        
        
	}
	
 
	
}  //  @jve:decl-index=0:visual-constraint="70,19"
