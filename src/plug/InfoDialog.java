
package plug;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.*;

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
        initPanel();
        initAppInfoPanel();
        initLoginPanel();
        
        //监听事件
        addListioner();
       
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
    
    //登陆
    private String Login(String email,String password){
        String sr=HttpRequest.sendPost("http://fir.im/api/v2/user/signin", "email=email&password=password");
        
        System.out.println(sr);
        return sr;
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
    
    private void addListioner(){
    	loginBtn.addActionListener(this);
     	choseFileBtn.addActionListener(this);
    }
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
        if(e.getSource()==jbtn) {
            //你要处理的事件
    		String token = jt.getText();
    		System.out.print("token" + token);
        }
        if(e.getSource()==absouJbtn) {
            //你要处理的事件
    		String path = absolutPathJa.getText();
    		System.out.print("绝对路径" + path);
    		File f = new File(path);
    		
        }
        
        //登录按钮
        if(e.getSource()==loginBtn){
        }
        //选择文件按钮
        if(e.getSource()==choseFileBtn){
        	initFileChoser();
//        	appPathText.setText(path);
        }
        
        
	}
	
 
	
}  //  @jve:decl-index=0:visual-constraint="70,19"
