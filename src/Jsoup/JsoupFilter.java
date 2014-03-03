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
		if (Url.getDepth() > ConDepth) {

		} else {
			try {
				HttpGet httpget = new HttpGet(Url.getUrl());
				HttpResponse response = httpclient.execute(httpget);
				int resStatus = response.getStatusLine().getStatusCode();
				if (resStatus == HttpStatus.SC_OK) {
					doc = Jsoup.connect(Url.getUrl()).get();
					Elements links = doc.select("a[href]");

					try {
						DBUtils.DBUtils.addDB(doc, "h1#artibodyTitle",
								"span#pub_date", "p", Url.getUrl(),
								"http://green.sina.com.cn/");
						for (Element link : links) {
							String linkHref = link.attr("abs:href");
							MyUrl Assmble = new MyUrl(linkHref, Depth + 1);
							if (Assmble.getUrl().startsWith(
									"http://roll.green.sina.com.cn/green")) {
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
		System.out.println("http://blog.sina.com.cn/yizhongtian".startsWith("http://blog.sina.com.cn"));
	}
}
