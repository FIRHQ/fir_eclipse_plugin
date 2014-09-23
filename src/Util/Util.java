package Util;

import java.io.File;

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
}
