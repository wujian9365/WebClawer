/**
 * WuJian
 */
package DB;

/**
 * @author WuJian
 *2014年1月6日下午10:54:56
 */
public class WebnewBean {
	private String title;
	private String time;
	private String content;
	private String src;
	
	public WebnewBean(){
		
	}
	/**
	 * @param title
	 * @param time
	 * @param content
	 * @param src
	 */
	public WebnewBean(String title, String time, String content, String src) {
		super();
		this.title = title;
		this.time = time;
		this.content = content;
		this.src = src;
	}
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * @return the time
	 */
	public String getTime() {
		return time;
	}
	/**
	 * @param time the time to set
	 */
	public void setTime(String time) {
		this.time = time;
	}
	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}
	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}
	/**
	 * @return the src
	 */
	public String getSrc() {
		return src;
	}
	/**
	 * @param src the src to set
	 */
	public void setSrc(String src) {
		this.src = src;
	}
	
}
