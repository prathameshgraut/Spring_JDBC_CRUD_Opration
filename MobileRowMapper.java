package Spring_Demo;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class MobileRowMapper implements RowMapper<Mobile_Shop>{

	@Override
	public Mobile_Shop mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Mobile_Shop MS =new Mobile_Shop();
		MS.setId(rs.getInt("Id"));
		MS.setName(rs.getString("Name"));
		MS.setPrice(rs.getDouble("Price"));
		MS.setModel(rs.getString("Model"));
		MS.setProcessor(rs.getString("Processor"));
		
		return MS;
	}

}
