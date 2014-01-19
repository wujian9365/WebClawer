/**
 * WuJian
 */
package UrlBean;

import UrlDB.MyLinkDB;

/**
 * @author WuJian 2014年1月5日下午12:37:08
 */
public class MyUrl {
	private String Url;
	private int Depth;

	public MyUrl() {

	}

	/**
	 * @param url
	 * @param depth
	 */
	public MyUrl(String url, int depth) {
		super();
		Url = url;
		Depth = depth;
	}

	/**
	 * @return the url
	 */
	public String getUrl() {
		return Url;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	
	/**
	 * @param url
	 *            the url to set
	 */
	public void setUrl(String url) {
		Url = url;
	}

	/**
	 * @return the depth
	 */
	public int getDepth() {
		return Depth;
	}

	/**
	 * @param depth
	 *            the depth to set
	 */
	public void setDepth(int depth) {
		Depth = depth;
	}

	@Override
	public String toString() {
		return "MyUrl [Url=" + Url + ", Depth=" + Depth + "]";
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Url == null) ? 0 : Url.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MyUrl other = (MyUrl) obj;
		if (Url == null) {
			if (other.Url != null)
				return false;
		} else if (!Url.equals(other.Url))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	
	public static void main(String [] args){
		MyUrl url = new MyUrl("http://green.sohu.com/20131015/n388229524.shtml",1);
		System.out.println(url.hashCode());
		MyUrl url1 = new MyUrl("http://green.sohu.com/20131015/n388229524.shtml",1);
		System.out.println(url1.hashCode());
		MyLinkDB.addUnVisitedUrl(url1);
		System.out.println("====");
		MyLinkDB.addUnVisitedUrl(url);
	}
}
