package catchGoogle;

import java.awt.Image;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Download {
	void imageDownload(ArrayList<String> imgUrl,String dirname) {
		List<String> listImgSrc = imgUrl;
		//String []imgUrl 
		//String i = "";
		//for (String url : listImgSrc)
        try {  
        	for (int i=0;i<listImgSrc.size();i++) {  
                //String imageName = listImgSrc.get(i).substring(listImgSrc.get(i).lastIndexOf("/") + 1, listImgSrc.get(i).length());
                String imageName = listImgSrc.get(i).substring(listImgSrc.get(i).lastIndexOf("/") + 1, listImgSrc.get(i).lastIndexOf("/") + 5);
                System.out.println(imageName.length()+"|"+listImgSrc.get(i).length()+listImgSrc.get(i));
                if(listImgSrc.get(i).length()>100|!this.isValid(listImgSrc.get(i))){
                	continue;
                }
                else{
                URL uri = new URL(listImgSrc.get(i));  
                InputStream in = uri.openStream();
                File dir = new File(dirname);
                if(!dir.exists()){dir.mkdir();}
                File image1 = new File(dir.getPath(),imageName);
                FileOutputStream fo = new FileOutputStream(image1);  
                byte[] buf = new byte[1024];  
                int length = 0;  
                System.out.println("开始下载:" + listImgSrc.get(i));  
                while ((length = in.read(buf, 0, buf.length)) != -1) {  
                    fo.write(buf, 0, length);  
                }  
                in.close();  
                fo.close();  
                System.out.println(imageName + "下载完成");
                String cwebp="";
        		//判断当前jdk的版本位数		
        		cwebp = System.getProperty("user.dir")+"/libwebp-0.4.2-windows-x86/bin/dwebp.exe";
        		String[] at = new String[]{cwebp, dir.getAbsoluteFile()+"\\"+imageName, "-o", dir.getAbsoluteFile()+"\\"+imageName+".png"};
        		Runtime.getRuntime().exec(at);
                }
                
        		/*File image2 = new File(imageName);
        		if(image2.exists()){
        			image2.delete();
        		}*/
        		//image1.delete();
        		
               // count++;
               // System.out.println("已下载"+count+"张图片");
            } 
            //i++;
        } catch (Exception e) {  
            System.out.println(e);
            //Syetem.out.println();
        }
 }
	public boolean isValid(String strLink)  {
		//return false;
		URL uri;
		try {
			uri = new URL(strLink);
			HttpURLConnection connt = (HttpURLConnection)uri.openConnection();
			connt.setRequestMethod("HEAD");
			String str = connt.getResponseMessage();
			if(str.compareTo("Not Found")==0){
				return false;
			}
			connt.disconnect();
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			System.out.println(e);
			return false;
		}
		return true;
		
		
		
	}
	

}
