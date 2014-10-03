package Util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.URL;

public class FileOperate {
	 /**
     * 以行为单位读取文件，常用于读面向行的格式化文件
     */
    public static String readFileByLines(URL url) {
        File file = new File(url.getFile());
        BufferedReader reader = null;
        String res = "";
        try {
            System.out.println("以行为单位读取文件内容，一次读一整行：");
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            int line = 1;
            // 一次读入一行，直到读入null为文件结束
            while ((tempString = reader.readLine()) != null) {
                // 显示行号
                System.out.println("line ===========" + line + ": " + tempString);
                line++;
                res += tempString;
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }
        return res;
    }
    
    /**
     * A方法追加文件：使用RandomAccessFile
     */
    public static void appendMethodA(String fileName, String content) {
        try {
            // 打开一个随机访问文件流，按读写方式
            RandomAccessFile randomFile = new RandomAccessFile(fileName, "rw");
            // 文件长度，字节数
            long fileLength = randomFile.length();
            //将写文件指针移到文件尾。
            randomFile.seek(fileLength);
            randomFile.writeBytes(content);
            randomFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void writeFile(URL url,String content){
    	 try{
    	      String data = content;

    	      File file =new File(url.getFile());

    	      //if file doesnt exists, then create it
    	      if(!file.exists()){
    	       file.createNewFile();
    	      }

    	      //true = append file
    	      FileWriter fileWritter = new FileWriter(file.getAbsoluteFile());
    	             BufferedWriter bufferWritter = new BufferedWriter(fileWritter);
    	             bufferWritter.write(data);
    	             bufferWritter.close();

    	         System.out.println("Done");

    	     }catch(IOException e){
    	      e.printStackTrace();
    	     }
    }
}
