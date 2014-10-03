package Util;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Platform;
import org.osgi.framework.Bundle;

public class Util {
	/**
	 * 判断是否是Android工程
	 * 
	 * @param filePath
	 * @return flag
	 */
	public static Boolean isApkWorkSpace(String filePath) {
		Boolean flg = false;
		File root = new File(filePath);
		File[] files = root.listFiles();
		for (File file : files) {
			System.out.println(file.getName());
			String name = file.getName();
			if(name.equals("AndroidManifest.xml") && name.equals("bin")){
				flg = true;
			}
		}
		return flg;
	}
	
	/**
	 * 获取apk的路径
	 * @param filePath
	 * @return
	 */
	public static String getApkPath(String filePath){
		String path = "";
		File root = new File(filePath);
		File[] files = root.listFiles();
		for (File file : files) {
			System.out.println(file.getName());
			String name = file.getName();
			if(name.equals("bin")){
				String absPath = file.getAbsolutePath();
				File apkRoot = new File(absPath);
				File[] apkFiles = apkRoot.listFiles();
				for(File aFile : apkFiles){
					String aName = aFile.getName();
					if(aName.indexOf(".apk")>=0){
						path = aFile.getAbsolutePath();
					}
				}
			}
		}
		return path;
	}
	
	/**
	 * 获取工程文件的路径
	 * @param path
	 * @return
	 */
	public static URL getIconFilePath(String path){
		String mPath = null;
		String bundleName = "fir.im.eclipse.plug";
		Bundle bundle = Platform.getBundle(bundleName); 
		URL url = bundle.getEntry(path);
		try {
			url = FileLocator.toFileURL(url);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return url;
	}
}
