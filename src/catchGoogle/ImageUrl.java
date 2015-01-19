package catchGoogle;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ImageUrl {
	//从网页代码中得到图片URL
		//w300为icon，h900为大图，h310为小图
		//先正则测试下
		ArrayList<String> test(String re){
		//String re = "ddsaner'> <img class='full-screenshot' alt='冰雪奇緣: 冰紛樂 - screenshot' data-expand-fit-to='screen' data-expand-scroll='true' data-expand-target='full-screenshot-9' data-expand-to='full-screenshot-10' src='https://lh5.ggpht.com/WKVI5E42JPCAc6BvlNJzu87CfYUD5ouO4V7h6F5vnHGrmmI2-famP17V9EWbmXQLBBb7=h900-rw'> </div> </div>dsaddas";
		//String regex1 = "https:\"?(.*?)(\"|>|\\s+)";
			//String regex1 = "https:\"?(.*?)h900";
		String regex1 = "https:(.?)(.?)lh(.*?)ggpht(.*?)h900";
		String regex = "<img.*src=(.*?)[^>]*?>";
		//String[]imgUrl = new String[40];
		ArrayList<String> imgUrl = new ArrayList<String>();
		//String regex1 = "https:\"?(.*?)(\"|>|\\s+)";
		Pattern pattern = Pattern.compile(regex);
		//Matcher matcher = pattern.matcher(re);
		Matcher matcher = Pattern.compile(regex1).matcher(re); 
		int i = 0;
		//System.out.print("hello world");
		while (matcher.find()){
			if(i==0){
				imgUrl.add(matcher.group().substring(matcher.group().length()-96, matcher.group().length() )+"-rw"); //= matcher.group().substring(matcher.group().length()-96, matcher.group().length() )+"-rw";
			//continue;
			}
			else{
			imgUrl.add(matcher.group().substring(0, matcher.group().length() )+"-rw");//[i]=matcher.group().substring(0, matcher.group().length() )+"-rw";
			}
			i++;
		}
		return imgUrl;
		}

}
