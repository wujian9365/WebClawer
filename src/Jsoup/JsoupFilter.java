/**
 * WuJian
 */
package Jsoup;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.LinkedList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import DB.DBOperation;
import DB.WebnewBean;
import UrlBean.MyUrl;
import UrlDB.LinkDB;
import UrlDB.MyLinkDB;

/**
 * @author WuJian 2013��12��16������5:29:41
 */
public class JsoupFilter {
	public static void getLinks(String Url) throws IOException {
		Document doc;

		String codeUrl = "http://"
				+ URLEncoder.encode(Url.substring(7), "UTF-8");
		HttpClient httpclient = new DefaultHttpClient();
		System.out.print(codeUrl);

		try {
			HttpGet httpget = new HttpGet(codeUrl);
			HttpResponse response = httpclient.execute(httpget);
			int resStatus = response.getStatusLine().getStatusCode();
			if (resStatus == HttpStatus.SC_OK) {
				doc = Jsoup.connect(codeUrl).get();
				Elements links = doc.select("a[href]");

				List<String> Url2 = new LinkedList<String>();

				try {
					for (Element link : links) {
						String linkHref = link.attr("abs:href");
						Url2.add(linkHref);
						// System.out.println(linkHref);
						LinkDB.addUnVisitedUrl(linkHref);
					}
				} catch (Exception e) {
					System.err.println(e);
				}
			}
		} catch (Exception e) {

		}

	}

	// 深度控制的getLinks方法
	public static void getLinks(MyUrl Url, int ConDepth) throws IOException {
		Document doc;

		// String codeUrl = "http://"
		// + URLEncoder.encode(Url.getUrl().substring(7), "UTF-8");
		HttpClient httpclient = new DefaultHttpClient();
		System.out.print(Url);
		int Depth = Url.getDepth();
		String title = "k";
		String time = "k";
		String content = "k";

		if (Url.getDepth() > ConDepth) {

		} else {
			try {
				HttpGet httpget = new HttpGet(Url.getUrl());
				HttpResponse response = httpclient.execute(httpget);
				int resStatus = response.getStatusLine().getStatusCode();
				if (resStatus == HttpStatus.SC_OK) {
					doc = Jsoup.connect(Url.getUrl()).get();
					Elements links = doc.select("a[href]");

					Element Title = doc.select("h1#artibodyTitle").first();
					Elements context = doc.select("p");
					Element Time = doc.select("span#pub_date").first();
					// List<String> Url2 = new LinkedList<String>();
					content = context.text();
					System.out.println(Title + content);
					if (Title!= null && Time != null) {
						title = Title.text();
						time = Time.text();
					}
					System.out.println(Url.getUrl());
					System.out.println(title + time + content + Url.getUrl());
					// 组装Beans
					try {
						WebnewBean news = new WebnewBean(title, time, content,
								Url.getUrl());

						boolean result = DBOperation.MyInsert(news);
					} catch (Exception e) {
						System.err.println(e);
					}
					try {
						for (Element link : links) {
							String linkHref = link.attr("abs:href");

							MyUrl Assmble = new MyUrl();
							Assmble.setUrl(linkHref);
							Assmble.setDepth(Depth + 1);
							// Url2.add(linkHref);
							// System.out.println(linkHref);
							if (Assmble.getUrl().length() > 35
									&& Assmble
											.getUrl()
											.substring(0, 35)
											.equals("http://green.sina.com.cn/news/roll/")
									&& Assmble.getUrl().endsWith("shtml")) {
								MyLinkDB.addUnVisitedUrl(Assmble);
							}
						}
					} catch (Exception e) {
						System.err.println(e);
					}
				}
			} catch (Exception e) {
				System.err.println(e);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		getLinks("http://www.sina.com.cn");
	}
}
