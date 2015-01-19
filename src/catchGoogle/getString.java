package catchGoogle;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class getString {
	String[] getName() throws IOException{
		String sb[] = new String[10];
		File f = new File ("packagename.txt");
		//System.out.print(f.exists());
		FileReader fr = new FileReader(f);
		BufferedReader br = new BufferedReader(fr);
		int i = 0;
		String length = null;
		while((length = br.readLine())!=null){
			sb[i] = length;
			i++;
		}
		br.close();
		return sb;
		
	}

}
