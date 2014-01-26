/**
 * WuJian
 */
package Crawler;

import java.io.IOException;

import FileDownloader.FileDownloader;
import Jsoup.JsoupFilter;
import UrlBean.MyUrl;
import UrlDB.LinkDB;
import UrlDB.MyLinkDB;

/**
 * @author WuJian
 *2013��12��16������7:35:09
 */
public class Crawler {
	@SuppressWarnings("unused")
	public void crawling(String seed) throws IOException{
		//LinkDB.addUnVisitedUrl(seed);	
		MyUrl Intial = new MyUrl(seed,0);
		MyLinkDB.addUnVisitedUrl(Intial);
		
		/*����ȿ����㷨
		while(!LinkDB.unVisitedUrlIsEmpty()&&LinkDB.getVisitedUrlNum()<1){
			//String VisitUrl = LinkDB.unVisitedUrldeQueue();
			String VisitUrl = MyLinkDB.unVisitedUrldeQueue().getUrl();
			System.err.println("======"+VisitUrl+"=======");
			if(VisitUrl==null)
				continue;
			//JsoupFilter.getLinks(VisitUrl);
			//FileDownloader.downloadFile(VisitUrl);
			JsoupFilter.getLinks(VisitUrl);
			
		}
		*/
		
		while(!MyLinkDB.unVisitedUrlIsEmpty()&&MyLinkDB.getVisitedUrlNum()<100){
			MyUrl VisitUrl = MyLinkDB.unVisitedUrldeQueue();
			System.err.println("===="+VisitUrl.getUrl()+"===="+"第"+VisitUrl.getDepth()+"层");
			if(VisitUrl==null){
				continue;
			}
			JsoupFilter.getLinks(VisitUrl,100);
			//System.err.println(MyLinkDB.unVisitedUrlIsEmpty());
			MyLinkDB.addVisitedUrl(VisitUrl);
			
		}
	}
	
	public static void main(String[] args) throws IOException{
		Crawler crawler = new Crawler();
		//crawler.crawling("http://war.163.com/13/1223/09/9GP5IJ9H00014OMD.html");
		crawler.crawling("http://roll.green.sina.com.cn/green/hb_gdxw/index.shtml");
		
	}
}
