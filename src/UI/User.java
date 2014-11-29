package UI;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import main.Main;

public class User extends JPanel  implements ActionListener{
	private ImageIcon userAvatarIcon = null;
	private JLabel imageLabel = null;
	private JLabel userName = null;
	private JButton changePanel = null; //切换上一目录
	public User(){
		super();
		init();
	}
	
	private void init(){
		try {
			this.userAvatarIcon = new ImageIcon(new URL(Main.user.avatar));
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	this.imageLabel = new JLabel();
    	this.imageLabel.setSize(30, 30);
    	this.imageLabel.setBounds(0,0,20,20);
    	this.imageLabel.setIcon(this.userAvatarIcon);
    	this.userAvatarIcon.setImage(this.userAvatarIcon.getImage().getScaledInstance(50, 50,
    		    Image.SCALE_DEFAULT));
    	this.add(this.imageLabel);
    	
    	this.userName = new JLabel(Main.user.name);
    	this.add(this.userName);
    	
    	changePanel = new JButton("回到上一层");
    	this.add(changePanel);
    	changePanel.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == changePanel){
			Main.setCurrentPanel(new WorkSpaceList());
		}
	}
}
