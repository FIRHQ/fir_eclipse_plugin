package model;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.io.File;

import javax.swing.JComponent;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

public class ListModel extends JComponent implements ListCellRenderer {
	   public Font font;  
	    public Color background;  
	    public Color foreground; 
	    public String text;
	    public File file;
	    //实现ListCellRenderer接口的方法  
	    public Component getListCellRendererComponent(JList list, Object value,  
	            int index, boolean isSelected, boolean cellHasFocus) {  
	        font = ((ListModel) value).font;  
	        text = ((ListModel) value).text;
	        background=isSelected?list.getSelectionBackground():list.getBackground();  
	        foreground=isSelected?list.getSelectionForeground():list.getForeground();  
	        return this;  
	    }  
	    
	    public ListModel(Font font,String text,File file){
	    	this.font = font;
	    	this.text = text;
	    	this.file = file;
	    }
	    
	    public ListModel(){
	    	
	    }
	    //实现每行的绘制  
	    @Override  
	    protected void paintComponent(Graphics g) {  
	        String text=this.text;  
	        FontMetrics fm=g.getFontMetrics(font);  
	        g.setColor(background);  
	        g.fillRect(0, 0, this.getWidth(), this.getHeight());  
	        g.setColor(foreground);  
	        g.setFont(font);  
	        g.drawString(text, 0, fm.getAscent());  
	    }  
	    //计算每行的宽度，在显示时会被调用  
	    @Override  
	    public Dimension getPreferredSize() {  
	        String text=font.getFamily();  
	        Graphics g=this.getGraphics();  
	        FontMetrics fm=g.getFontMetrics(font);  
	        return new Dimension(fm.stringWidth(text),fm.getHeight());  
	    }  
	      
}
