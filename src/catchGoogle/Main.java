package catchGoogle;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) throws Exception {
		//String ii = "https://play.google.com/store/apps/details?id=vn.clonerteam.df5o";
		getString gs = new getString();
		ImageUrl iu = new ImageUrl();
		String ii[] = gs.getName();
		
		String bb[] = new String[ii.length];
		//String[][] cc = new String[bb.length][];
		Download dl = new Download();
		//ArrayList<String> lis = new ArrayList<String>();
		//for(int j=0;j<ii.length;j++){
		for(int i=0;i<ii.length;i++){
			getWebcode gw = new getWebcode();
			bb[i] = gw.getHTML(ii[i]);
			//cc[i] = AsString(iu.test(bb[i]));
			dl.imageDownload(iu.test(bb[i]),ii[i].substring(46));
			
			
		}
		//}
		//String bb = gw.getHTML(ii);
		//System.out.println(bb);
		
		
		
		
		
			
		

	}
	public static String[] AsString(ArrayList<String> aa){
		String[] array = new String[aa.size()];
		for(int i=0;i<aa.size();i++){
			array[i] = aa.get(i);
		}
		return array;
		
	}
	

}
