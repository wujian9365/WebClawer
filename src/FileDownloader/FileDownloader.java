/**
 * WuJian
 */
package FileDownloader;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

/**
 * @author WuJian 2013年12月16日下午9:58:38
 */
public class FileDownloader {
	public static String getFileNamebyUrl(String Url) {
		Url = Url.substring(7);
		return Url.replace("/", "+")+".html";
		//return Url.replace("[\\?/:*|<>\"]", "_") + System.nanoTime()+".html";
	}

	public static void SavetoLocal(byte[] data_String, String filepath) {
		try {
			DataOutputStream out = new DataOutputStream(new FileOutputStream(
					new File(filepath)));
			for(int i=0;i<data_String.length;i++){
				out.write(data_String[i]);
			}
			out.flush();
			out.close();

		} catch (Exception e) {
			System.out.println(e);
		}

	}
	
	public static String downloadFile(String Url){
		String filepath = null;
		HttpClient httpclient = new DefaultHttpClient();
		HttpGet httpget = new HttpGet(Url);
		try{
			HttpResponse httpresponse = httpclient.execute(httpget);
			int statuscode =  httpresponse.getStatusLine().getStatusCode();
			if(statuscode==HttpStatus.SC_OK){
				HttpEntity entity = httpresponse.getEntity();	
				byte[] httpcontent = EntityUtils.toString(entity).getBytes();
				filepath = "/Users/maggiewu/Desktop/dig/"+getFileNamebyUrl(Url);
				SavetoLocal(httpcontent,filepath);
			}
			
			
			
		}catch(Exception e){
			System.out.println(e);
		}
		return filepath;
		
	}
}
