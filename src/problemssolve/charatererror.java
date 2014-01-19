/**
 * WuJian
 */
package problemssolve;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

/**
 * @author WuJian 2013年12月23日下午3:40:15
 */
public class charatererror {
	public static void main(String[] args) throws UnsupportedEncodingException {
		String baidu = "www.baidu.com";
		String Url = "news.163.com/13/1223/09/9GP6VKSE00014JB6.html#from=relevant#xwwzy_35_bottomnewskwd";
		String http="http://";
		@SuppressWarnings({ "resource", "deprecation" })
		HttpClient httpclient =new DefaultHttpClient();
		String url = http+URLEncoder.encode(Url, "UTF-8");
		String bd = http+URLEncoder.encode(baidu,"UTF-8");
		System.out.println(bd);
		try {
			
			HttpGet httpget = new HttpGet(bd);
			HttpResponse response = httpclient.execute(httpget);
			int resStatus = response.getStatusLine().getStatusCode();
			System.out.print(resStatus);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
