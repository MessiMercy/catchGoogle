package catchGoogle;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class getWebcode {
	public static final String ECODING = "utf-8";
	String getHTML(String url) throws Exception {  
        URL uri = new URL(url);  
        URLConnection connection = uri.openConnection();  
        InputStream in = connection.getInputStream();  
        byte[] buf = new byte[10];  
        int length = 0;  
        StringBuffer sb = new StringBuffer();  
        while ((length = in.read(buf, 0, buf.length)) > 0) {  
            sb.append(new String(buf, ECODING));  
        }
        //length--;
        in.close(); 
        return sb.toString();  
    }


}
