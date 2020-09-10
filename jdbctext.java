package database_connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.print.attribute.standard.Sides;

import com.mysql.cj.xdevapi.Result;
import com.mysql.cj.xdevapi.Statement;
import com.mysql.jdbc.Driver;

public class jdbctext {
	public static void main(String[] args) throws SQLException {
		
		try {
			// 旧版本需要自己手动写加载驱动，新版本不需要
			// 新版本加载驱动写法不同多了.cj
			// 1、加载驱动
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// 2、建立连接对象
			String url = "jdbc:mysql://localhost:3308/userinfo?serverTimezone=GMT";
			Connection conn = DriverManager.getConnection(url,"root","123456");
			System.out.println("connect success");
			
			// 3、创建声明语句
			java.sql.Statement stmt = conn.createStatement();
			
			// 4、发送sql语句
			 String sql = "select *from t_user";
			 ResultSet rs = stmt.executeQuery(sql);
			 System.out.println(rs);
			 
			 // 5、分析结果（打印数据）
			 while(rs.next()) {
				// true：当前行有数据 false:当前行不存在数据
				
				// 打印每一列
				int sid = rs.getInt("sid");
				String account = rs.getString("account");
				String pwd = rs.getString("pwd");
				System.out.println(sid + " " + account + " " + pwd);
			 }; 		 
			 
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
	}
}
	
