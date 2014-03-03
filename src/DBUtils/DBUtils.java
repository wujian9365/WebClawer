/**
 * WuJian
 */
package DBUtils;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import UrlDB.MyLinkDB;
import DB.DBOperation;
import DB.WebnewBean;

/**
 * @author WuJian 2014年1月26日下午11:13:55
 */
public class DBUtils {

	public static int addDB(Document doc, String cTitle, String cTime,
			String cContent, String Src, String URL) {
		WebnewBean news = new WebnewBean("blank", "blank", "blank", "blank");
		Element Title = doc.select(cTitle).first();
		Element Context = doc.select(cContent).first();
		Element Time = doc.select(cTime).first();

		if (Title != null && Time != null && Context != null) {
			String title = Title.text();
			String time = Time.text();
			String content = Context.text();
			if (Src.startsWith(URL)
					&& Src.endsWith("shtml")) {
				// 组装Beans
				news.setContent(content);
				news.setTime(time);
				news.setTitle(title);
				news.setSrc(Src);

				boolean result = DBOperation.MyInsert(news);
			}
		}

		return 0;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
