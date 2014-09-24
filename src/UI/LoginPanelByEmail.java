package UI;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 * 登录UI
 * @author will
 *
 */
public class LoginPanelByEmail extends JPanel implements ActionListener{
	private JLabel emailLabel = null;
	private JTextArea emailTextArea = null;
	private JLabel pwLabel = null;
	private JTextArea pwJT = null;
	private JButton loginBtn = null;
	
	private JPanel jp1 = null;//存放用户名
	private JPanel jp2 = null;//
	private JPanel jp3 = null;
	public LoginPanelByEmail(){
		super();
		init();
	}
	
	/**
	 * 初始化
	 */
	private void init(){
		this.setLayout(new GridLayout(2,2));
		this.emailLabel = new JLabel("邮箱：");
		this.emailTextArea = new JTextArea();
		this.emailTextArea.setColumns(20);
		this.pwLabel = new JLabel("密码：");
		this.pwJT = new JTextArea();
		this.pwJT.setColumns(20);
		this.add(this.emailLabel);
		this.add(this.emailTextArea);
		this.add(this.pwLabel);
		this.add(this.pwJT);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
