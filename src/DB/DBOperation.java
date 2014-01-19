package DB;

import java.sql.*;

import com.mysql.jdbc.PreparedStatement;
public class DBOperation {
	private static Connection conn;
	public static Connection getConnection()
	{
		Connection conn=null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
          //  String DB = "jdbc:mysql://127.0.0.1:3306/db";
            //conn = DriverManager.getConnection(DB
            	//	);   
			conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test?characterEncoding=utf-8");
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("链接失败"+e.getMessage());
		}
		return conn;
	}
	
	
	public static boolean insert(String userName,String location,String bId,String putTime 
			,double jingdu,double weidu,String message,int zhuanfa,int pinglun)
	{
		conn=getConnection();
		
		try{
			String sql="insert into webnew(userName,location,bId,putTime,jingdu,weidu,message,zhuanfa,pinglun)" +
					" values('"+userName+"','"+location+"','"+bId+"','"+putTime+"',"+jingdu+","+weidu+",'"+message+
			"',"+zhuanfa+","+pinglun+");";
			Statement st=(Statement) conn.createStatement();
			st.executeUpdate(sql);
			conn.close();
			return true;
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println("�����ュけ璐ワ��"+e.getMessage());
			return false;
		}
	}
	public static boolean insert2(String bid,String mid,String con ,String time)
	{
		conn=getConnection();
		
		try{
			String sql="insert into comment(bid,mid,con,time)" +
					" values('"+bid+"','"+mid+"','"+con+"','"+time+"');";
			Statement st=(Statement) conn.createStatement();
			st.executeUpdate(sql);
			conn.close();
			return true;
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println("�����ュけ璐ワ��"+e.getMessage());
			return false;
		}
	}
	
	public static boolean MyInsert(WebnewBean news){
		
		conn = getConnection();
		String sql = "insert into webnew(title,time,content,src) values(?,?,?,?)";
		
		try {
			PreparedStatement st =(PreparedStatement) conn.prepareStatement(sql);
			st.setString(1, news.getTitle());
			st.setString(2, news.getTime());
			st.setString(3, news.getContent());
			st.setString(4, news.getSrc());
			st.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}
	public static void select(){
		Statement stmt = null;
		ResultSet rs = null;
		conn = getConnection();
		try{
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from webnew");
			while (rs.next()) {
			    System.out.println(rs.getInt("id"));
			    System.out.println(rs.getString("userName"));    
			   }
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println("select澶辫触锛�"+e.getMessage());
		}
		finally{
			try{
				if (rs != null){
				     rs.close();
				        rs = null;     
				 }
				 if (stmt != null){
				     stmt.close();
				     stmt = null;
				 }
				 if(conn != null){
				     conn.close();
				     conn = null;
				 }
			}
			catch(SQLException e){
				e.printStackTrace();
			}
		}
		
		
	}
	public static void main(String args[])
	{
		getConnection();
		select();
		System.out.print("ok");
		WebnewBean web = new WebnewBean("k","k","k","k");
		MyInsert(web);
	}


	/**
	 * @param news
	 */
	
}
