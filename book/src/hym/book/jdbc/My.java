package hym.book.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import hym.book.Class.BookInRecord;

public class My implements RowMapper<BookInRecord>{

	@Override
	public BookInRecord mapRow(ResultSet rs, int num) throws SQLException {
		String record_date =rs.getString("record_date");
		BookInRecord user =new BookInRecord();
		user.setRECOR_DATE(record_date);
		return user;
	}

}
