/*
 * Created on 2004-9-25
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package plug;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

import javax.swing.*;

import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.ISelectionService;
import org.eclipse.ui.internal.Workbench;
import org.eclipse.core.internal.resources.WorkspaceRoot;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.ISelectionService;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.IWorkbenchWindowActionDelegate;
import org.eclipse.ui.internal.Workbench;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.fieldassist.DecoratedField;
import org.eclipse.jface.fieldassist.TextControlCreator;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.*;
import org.eclipse.swt.widgets.*;

/**
 * @author zhaoyong
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

public class InfoDialog extends JDialog implements ActionListener
{
    
    String city="";
    String upLoad_url = "http://fir.im/api/v2/app/info/[appid]?type=android&token=[token]";
    private JPanel jPanel = null;
    private JButton jbtn = null;
    private JTextArea jt = null;
    private JList jlist=null;
    private ArrayList al = new ArrayList();
    private JTextArea absolutPathJa = null;
    private JButton absouJbtn = null;
    /**
     * This method initializes 
     * 
     */
    public InfoDialog(ArrayList al) 
    {
        super();
        this.al = al;
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
        JLabel jlable_token = new JLabel("开发者Token");
        jt = new JTextArea(20,20);
        jt.setBorder (BorderFactory.createEmptyBorder (1,1,1,5));
        jt.setColumns (30); 
        jt.setRows (0);
        this.jPanel.add(jlable_token);
        this.jPanel.add(jt);
        jbtn = new JButton("确定");
        this.jPanel.add(jbtn);
        jbtn.addActionListener(this);
//        jlist = new JList([1,2,3]);
//        this.jPanel.add(jlist);
        
        absolutPathJa = new JTextArea(20,20);
        absolutPathJa.setBorder (BorderFactory.createEmptyBorder (1,1,1,5));
        absolutPathJa.setColumns (30); 
        absolutPathJa.setRows (0);
        JLabel jlable_path = new JLabel("apk的path");
        jlable_path.setLocation(0,100);
        this.jPanel.add(jlable_path);
        this.jPanel.add(absolutPathJa);
        absouJbtn = new JButton("Ok");
        this.jPanel.add(absouJbtn);
        absouJbtn.addActionListener(this);
        
        String _url = upLoad_url.replace("[appid]", "a.b.c");
        _url = _url.replace("[token]", "token");
        String sr=HttpRequest.sendGet(_url,"");
        
        JSONObject jsonObject = JSONObject.fromString(sr);
        
//        
//        
//        try
//        {
//            //����URL����
//            URL url 
//            	=new URL("http://weather.news.sina.com.cn//cgi-bin/figureWeather/simpleSearch.cgi?city="
//            			+city);
//           
//            
//            String temp="";
//            
//            BufferedReader in 
//            	= new BufferedReader(new InputStreamReader(url.openStream()));
//            //ʹ��openStream�õ�һ���������ɴ˹���һ��BufferedReader����
//            String inputLine;
//            //�����������ϵĶ���ݣ�ֱ������Ϊֹ
//            while ((inputLine = in.readLine()) != null)
//                temp=temp+inputLine+"\n";
//            //�ر�������
//            in.close();  
//            
//            String  weather	
//            	=temp.substring ( temp.indexOf( "<body"),
//                                  temp.lastIndexOf( "body>")+5);
//            // Font f=new  Font("SansSerif", 0, 12);
//            //  this.jEditorPane.setFont( f);
//            this.jEditorPane .setText(weather);
            //  this.jEditorPane .setText("<a href=aa">xxxxxxxxxxxx</a>");
            
//        } 
//        catch (Exception e)
//        {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        } 
//        this.setTitle("hello FIR.im");
//        this.setSize(400, 166);
//        for(int i=0;i<this.al.size();i++){
//        	System.out.print("+++++++++++++++"+this.al.get(i));
//        }
        
        
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
//        if (jEditorPane == null) 
//        {
//            jEditorPane = new JEditorPane();
//            jEditorPane.setContentType( "text/html");
//        }
//        return jEditorPane;
    	if(jPanel == null){
    		jPanel = new JPanel();
    	}
    	return jPanel;
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
	}
	
 
	
}  //  @jve:decl-index=0:visual-constraint="70,19"
