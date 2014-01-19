/**
 * WuJian
 */
package webcrawler;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

/**
 * @author WuJian 2013年12月15日下午4:03:40
 */

@SuppressWarnings("deprecation")
public class crawler {

	public static void Testcrawler(String url) throws FileNotFoundException {
		HttpClient httpclient = new DefaultHttpClient();
		String html = "";
		HttpGet httpget = new HttpGet(url);
		DataOutputStream out = new DataOutputStream(new FileOutputStream(
				new File("/Users/maggiewu/Desktop/a.rtf")));
		
		try {
			HttpResponse response = httpclient.execute(httpget);
			int resStatus = response.getStatusLine().getStatusCode();
			if (resStatus == HttpStatus.SC_OK) {
				HttpEntity entity = response.getEntity();
				if (entity != null) {
					
					//html = EntityUtils.toString(entity);
					//html = entity.getContent().toString();
					byte a[] = new byte[1024];
					//in.read(a);
					html = EntityUtils.toString(entity);
					System.out.println(html); 
					
				}

			}

		} catch (Exception e) {
			System.out.println("出现异常");
		} finally {
			httpclient.getConnectionManager().shutdown();
		}
	}

	public static void main(String[] args) throws FileNotFoundException {
		Testcrawler("http://bbs.nju.edu.cn/cache_bbsleft.htm");
	}
}
