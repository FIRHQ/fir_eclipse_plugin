package UI;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import model.User;

/**
 * 通过token来登录
 * @author will
 *
 */
public class LoginByToken extends JPanel implements ActionListener{

	
	private JPanel jp1 = null;
	private JPanel jp2 = null;
	private JPanel jp3 = null;
	private JPanel jp4 = null;
	
	private JLabel descLabel = null;
	private JLabel tokenLabel = null;
	private JLabel noticeLabel = null;
	private JTextArea tokenTx = null;
	
	private JButton loginBtn = null;
	private JButton cancelBtn = null;
	
	private User user;
	
	public LoginByToken() {
		super();
		// TODO Auto-generated constructor stub
		init();
	}

	private void init(){
		jp1 = new JPanel();
		jp2 = new JPanel();
		jp3 = new JPanel();
		jp4 = new JPanel();
		this.setLayout(new GridLayout(4,1));
		descLabel = new JLabel("用户登录");	
		descLabel.setFont(new Font("Dialog",   1,   30));
		tokenLabel = new JLabel("请输入TOKEN：");
		tokenTx = new JTextArea();
		tokenTx.setColumns(20);
		loginBtn = new JButton("登录");
		cancelBtn = new JButton("取消");
		noticeLabel = new JLabel();
		noticeLabel.setFont(new Font("Dialog",   1,   20));
		noticeLabel.setForeground(Color.BLUE);
		
		jp1.add(descLabel);
		jp2.add(tokenLabel);
		jp2.add(tokenTx);
		jp3.add(loginBtn);
		jp3.add(cancelBtn);
		jp4.add(noticeLabel);
		
		this.add(jp1);
		this.add(jp2);
		this.add(jp3);
		this.add(jp4);
		
		addListener();
	}
	public LoginByToken(boolean isDoubleBuffered) {
		super(isDoubleBuffered);
		// TODO Auto-generated constructor stub
	}

	public LoginByToken(LayoutManager layout, boolean isDoubleBuffered) {
		super(layout, isDoubleBuffered);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * 监听事件
	 */
	private void addListener(){
		this.cancelBtn.addActionListener(this);
		this.loginBtn.addActionListener(this);
	}
	public LoginByToken(LayoutManager layout) {
		super(layout);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == this.loginBtn){
			System.out.print(".............login");
			if(this.tokenTx.getText().isEmpty()){
				this.noticeLabel.setText("请输入Token");
			}else{
				user = new User();
				user.login(this.tokenTx.getText());
				if(user.isLogin.equals(true)){
					this.noticeLabel.setText("登录成功");
				}else{
					this.noticeLabel.setText("登录失败");
				}
			}
		}
		if(e.getSource() == this.cancelBtn){
			System.out.print(".............cancel");
		}
	}

}
