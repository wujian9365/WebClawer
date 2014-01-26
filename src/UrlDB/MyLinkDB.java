/**
 * WuJian
 */
package UrlDB;

import java.util.HashSet;
import java.util.Set;

import Queue.Queue;
import UrlBean.MyUrl;

/**
 * @author WuJian 2014��1��5������12:43:09
 */
public class MyLinkDB {
	private static Set<MyUrl> VisitedUrl = new HashSet<MyUrl>();
	private static Queue<MyUrl> unVisitedUrl = new Queue<MyUrl>();

	public static Queue<MyUrl> getUnVisitedUrl() {
		return unVisitedUrl;
	}

	public static void addVisitedUrl(MyUrl url) {
		VisitedUrl.add(url);
	}

	public static void removeVisitedUrl(MyUrl url) {
		VisitedUrl.remove(url);
	}

	public static MyUrl unVisitedUrldeQueue() {
		return unVisitedUrl.deQueue();
	}

	public static void addUnVisitedUrl(MyUrl url) {
		
		if (url != null && !url.getUrl().trim().equals("") && !VisitedUrl.contains(url)
				&& !unVisitedUrl.contains(url)) {
			unVisitedUrl.enQueue(url);
			
		}
		else{
			
		}
	}

	public static int getVisitedUrlNum() {
		return VisitedUrl.size();
	}

	public static boolean unVisitedUrlIsEmpty() {
		return unVisitedUrl.isQueueEmpty();
	}

	/**
	 * @return the visitedUrl
	 */
	public static Set<MyUrl> getVisitedUrl() {
		return VisitedUrl;
	}

	/**
	 * @param visitedUrl the visitedUrl to set
	 */
	public static void setVisitedUrl(Set<MyUrl> visitedUrl) {
		VisitedUrl = visitedUrl;
	}

	/**
	 * @param unVisitedUrl the unVisitedUrl to set
	 */
	public static void setUnVisitedUrl(Queue<MyUrl> unVisitedUrl) {
		MyLinkDB.unVisitedUrl = unVisitedUrl;
	}
	
	
}
