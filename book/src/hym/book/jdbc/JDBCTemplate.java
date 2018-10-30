package hym.book.jdbc;

import java.io.InputStream;

import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import hym.book.Class.BookInRecord;
//使用jdbcTempalte实现查询
public class JDBCTemplate {
	// 数据库驱动
	public static String JDBC_DRIVER="com.mysql.jdbc.Driver";
	// jdbc连接url
	public static String JDBC_URL="jdbc:mysql:///book_system";
	// 数据库用户名
	public static String JDBC_USER="root";
	// 数据库密码
	public static String JDBC_PASS="root";
	@Test
	public  void add() {
		
		DriverManagerDataSource data = new DriverManagerDataSource();
		data.setDriverClassName(JDBC_DRIVER);
		data.setUrl(JDBC_URL);
		data.setUsername(JDBC_USER);
		data.setPassword(JDBC_PASS);
		
		JdbcTemplate jdbct =new JdbcTemplate(data);
		String sql="select * from t_book_in_record where book_id_fk=(select ID from t_book where book_name=?) ";
		BookInRecord user =(BookInRecord) jdbct.queryForObject(sql, new MyRowMapper(),"WEB开发");
		String sql2="select * from t_in_record where id=?";
		user=(BookInRecord) jdbct.queryForObject(sql2, new My(),user.getT_IN_RECORD_ID_FK());
		System.out.println(user.getT_IN_RECORD_ID_FK());
	}
	
}
