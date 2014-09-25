package UI;

import java.awt.Dimension;
import java.awt.Point;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

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
		listModel.addElement("Debbie Scott");
		listModel.addElement("Debbie Scott");
		listModel.addElement("Debbie Scott");
		listModel.addElement("Debbie Scott");
		listModel.addElement("Debbie Scott");
		listModel.addElement("Debbie Scott");
		listModel.addElement("Debbie Scott");
		listModel.addElement("Debbie Scott");
		listModel.addElement("Debbie Scott");
		jList = new JList(listModel);
		jList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		jList.setSize(400, 200);
		jList.setFixedCellWidth(400);
		jList.setFixedCellHeight(50);
		jList.addListSelectionListener(this);
		//this.add(jList);
	}
	
	private void initPanel(){
		jp1 = new JScrollPane(jList);
		jp1.setPreferredSize(new Dimension(410, 200));
        int index = 0;
        jList.setSelectedIndex(index);
        Point p = jList.indexToLocation(index);
        JScrollBar jScrollBar = jp1.getVerticalScrollBar();//获得垂直滚动条  
        jScrollBar.setValue(p.y);//设置垂直滚动条位置
		this.add(jp1);
		jp2 = new JPanel();
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
}
