package hym.book.jdbc;

import java.io.InputStream;

import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import hym.book.Class.BookInRecord;
//ʹ��jdbcTempalteʵ�ֲ�ѯ
public class JDBCTemplate {
	// ���ݿ�����
	public static String JDBC_DRIVER="com.mysql.jdbc.Driver";
	// jdbc����url
	public static String JDBC_URL="jdbc:mysql:///book_system";
	// ���ݿ��û���
	public static String JDBC_USER="root";
	// ���ݿ�����
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
		BookInRecord user =(BookInRecord) jdbct.queryForObject(sql, new MyRowMapper(),"WEB����");
		String sql2="select * from t_in_record where id=?";
		user=(BookInRecord) jdbct.queryForObject(sql2, new My(),user.getT_IN_RECORD_ID_FK());
		System.out.println(user.getT_IN_RECORD_ID_FK());
	}
	
}
