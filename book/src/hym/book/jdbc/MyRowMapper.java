package hym.book.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

import hym.book.Class.BookInRecord;
public class MyRowMapper implements RowMapper<BookInRecord> {

	@Override
	public BookInRecord mapRow(ResultSet rs, int num) throws SQLException {
		String in_sum =rs.getString("in_sum");
		String in_record_fk=rs.getString("T_IN_RECORD_ID_FK");
		BookInRecord user =new BookInRecord();
		user.setIN_SUM(in_sum);
		user.setT_IN_RECORD_ID_FK(in_record_fk);
		return user;
	}
	
	
}
