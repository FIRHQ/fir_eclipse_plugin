package UI;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.io.File;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import main.Main;
import model.ListModel;

/**
 * 工程列表
 * @author will
 *
 */
public class WorkSpaceList extends JPanel implements ListSelectionListener {
	
	private JScrollPane jp1 = null;
	private JPanel jp2 = null;
	private DefaultListModel<String> listModel = new DefaultListModel();
	private JList jList = null;
	public WorkSpaceList(){
		super();
		initList();
		initPanel();
	}
	
	private void initList(){
		
        ArrayList<ListModel> fonts=new ArrayList<ListModel>();  
		for(File f : Main.programList){
			fonts.add(new ListModel(new Font("Cambria",Font.BOLD,20),f.getName(),f)); 
		}
   		jList = new JList(fonts.toArray());
		jList.setCellRenderer(new ListModel());
		jList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		jList.setSize(380, 200);
		jList.setFixedCellWidth(380);
		jList.setFixedCellHeight(30);
		jList.addListSelectionListener(this);
		//this.add(jList);
	}
	
	private void initPanel(){
		jp1 = new JScrollPane(jList);
		jp1.setPreferredSize(new Dimension(400, 200));
        int index = 0;
        //jList.setSelectedIndex(index);
        Point p = jList.indexToLocation(index);
        JScrollBar jScrollBar = jp1.getVerticalScrollBar();//获得垂直滚动条  
        jScrollBar.setValue(p.y);//设置垂直滚动条位置
		this.add(jp1);
		jp2 = new JPanel();
		jp2.add(Main.userUI);
		this.add(jp2);
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		// TODO Auto-generated method stub
		
		if (e.getValueIsAdjusting() == false) 
		{
			ListModel curLM = (ListModel) this.jList.getSelectedValue();
			File curF = curLM.file;
			Main.selectApp(curF.getAbsolutePath());
		}
		
	}
	
	
}
