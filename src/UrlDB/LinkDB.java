/**
 * WuJian
 */
package UrlDB;

import java.util.HashSet;
import java.util.Set;

import Queue.Queue;

/**
 * @author WuJian 2013年12月16日1:10:17
 */
public class LinkDB {
	private static Set<String> VisitedUrl = new HashSet<String>();
	private static Queue<String> unVisitedUrl = new Queue<String>();

	public static Queue<String> getUnVisitedUrl() {
		return unVisitedUrl;
	}

	public static void addVisitedUrl(String url) {
		VisitedUrl.add(url);
	}

	public static void removeVisitedUrl(String url) {
		VisitedUrl.remove(url);
	}

	public static String unVisitedUrldeQueue() {
		return unVisitedUrl.deQueue();
	}

	public static void addUnVisitedUrl(String url) {
		if (url != null && !url.trim().equals("") && !VisitedUrl.contains(url)
				&& !unVisitedUrl.contains(url)) {
			unVisitedUrl.enQueue(url);
		}
	}
	
	public static int getVisitedUrlNum(){
		return VisitedUrl.size();
	}
	
	public static boolean unVisitedUrlIsEmpty(){
		return unVisitedUrl.isQueueEmpty();
	} 

}
