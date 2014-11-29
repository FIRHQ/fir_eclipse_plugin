package Util;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class ParseApp {
	//Android工程
	private File file = null;
	private String path = "";
	private String appid = "";
	private String appName = "";
	private String appIcon = "";
	private String appVersion = "";
	public String appShort = "";
	
	private File resFile = null;
	public String getAppid() {
		return appid;
	}

	public void setAppid(String appid) {
		this.appid = appid;
	}

	public String getAppName() {
		return appName;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}

	public String getAppIcon() {
		return appIcon;
	}

	public void setAppIcon(String appIcon) {
		this.appIcon = appIcon;
	}

	public String getAppVersion() {
		return appVersion;
	}

	public void setAppVersion(String appVersion) {
		this.appVersion = appVersion;
	}

	public ParseApp(String path){
		this.path = path;
		this.file = new File(path);
		
		try {
			parse();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	private File getAndriodManifestFile(){
		File andMenFile = null;
		File[] files = file.listFiles();
		for (File file : files) {
			System.out.println(file.getName());
			String name = file.getName();
			if(name.toLowerCase().equals("androidmanifest.xml")){
				andMenFile = file;
			}
			if(name.toLowerCase().equals("res")){
				resFile = file;
			}
			
		}
		return andMenFile;
	}
	
	/**
	 * 解析app数据
	 * @throws SAXException
	 * @throws IOException
	 */
	private void parse() throws SAXException, IOException{
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance(); 
		try {
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document document = db.parse(getAndriodManifestFile());
			Element root = document.getDocumentElement();
			this.appid = root.getAttribute("package");
			this.appVersion = root.getAttribute("android:versionName");
			NodeList applications = root.getElementsByTagName("application");
			Element application = (Element)applications.item(0);
			this.appName = application.getAttribute("android:label");
			if(appName.indexOf("@string")>=0){
				//去string.xml中查找
				String sname = appName.substring(8, appName.length());
				getAppNameFromStringXml(sname);
			}
			this.appIcon = application.getAttribute("android:icon");
			if(appIcon.indexOf("@drawable")>=0){
				//去drawable中查找
				String iconName = appIcon.substring(10,appIcon.length());
				getAppIconFromDrable(iconName);
			}

		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	public void getAppNameFromStringXml(String sname){
		File tf = getFile(resFile,"values");
		File tf2 = getFile(tf,"strings.xml");
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance(); 
		DocumentBuilder db = null;
		try {
			db = dbf.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Document document = null;
		try {
			document = db.parse(tf2);
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		NodeList strings = document.getElementsByTagName("string");
		for(int i = 0; i < strings.getLength(); i++){
			 Element element = (Element)strings.item(i);
			 if(element.getAttribute("name").equals(sname)){
				 this.appName = element.getTextContent();
			 }
		}
		
	}
	
	public File getAppIconFromDrable(String icon){
		File iconFile = null;
		File tfxh = getFile(resFile,"drawable-xhdpi");
		File tfh = getFile(resFile,"drawable-hdpi");
		File tfm = getFile(resFile,"drawable-mdpi");
		File tf = getFile(resFile,"drawable");
		
		File _tf = getIconFromDrable(tf,icon);
		if(_tf!=null && _tf.exists()){
			File _iconFile = getIconFromDrable(tf,icon);
			if(_iconFile !=null && _iconFile.exists()){
				iconFile = _iconFile;
			}
		}	
		File _tfm = getIconFromDrable(tfm,icon);
		if(_tfm!=null && _tfm.exists()){
			File _iconFile = getIconFromDrable(tfm,icon);
			if(_iconFile !=null && _iconFile.exists()){
				iconFile = _iconFile;
			}
		}		
		File _tfh = getIconFromDrable(tfh,icon);
		if(_tfh!=null && _tfh.exists()){
			File _iconFile = getIconFromDrable(tfh,icon);
			if(_iconFile !=null && _iconFile.exists()){
				iconFile = _iconFile;
			}
		}	
		File _tfxh = getIconFromDrable(tfxh,icon);
		if(_tfxh!=null&&_tfxh.exists()){
			File _iconFile = getIconFromDrable(tfxh,icon);
			if(_iconFile !=null && _iconFile.exists()){
				iconFile = _iconFile;
			}
		}
		if(iconFile!=null&& iconFile.exists()){
			this.appIcon = iconFile.getAbsolutePath();
		}
		return iconFile;
	}
	
	public File getIconFromDrable(File f,String icon){
		File iconFile = null;
		File[] files = f.listFiles();
		for (File file : files) {
			System.out.println(file.getName());
			String name = file.getName();
			if(name.toLowerCase().indexOf(icon)>=0){
				iconFile = file;
			}			
		}	

		return iconFile;
	}
	
	
	public File parseIcon(File ic,String iname){
		File tf = null;
		File[] files = ic.listFiles();
		for (File file : files) {
			System.out.println(file.getName());
			String name = file.getName();
			if(name.toLowerCase().indexOf(iname)>=0){
				tf = file;
			}			
		}		
		return tf;
	}
	
	public File getFile(File root,String targetName){
		File tfile = null;
		File[] files = root.listFiles();
		for (File file : files) {
			System.out.println(file.getName());
			String name = file.getName();
			if(name.toLowerCase().equals(targetName)){
				tfile = file;
			}			
		}		
		return tfile;
	}
	public ParseApp(){
		
	}
	
	public File getApk(){
		File binFile =  getFile(file,"bin");
		File apkFile = null;
		File[] files = binFile.listFiles();
		for (File file : files) {
			System.out.println(file.getName());
			String name = file.getName();
			if(name.toLowerCase().indexOf(".apk")>=0){
				apkFile = file;
			}
			
		}
		return apkFile;
	}
	
}
