package hawk.spring.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import hawk.spring.model.employee;

public class employeeRowMapper implements RowMapper<employee> {
	public employee mapRow(ResultSet rs,int arg1) throws SQLException{
		employee emp = new employee();
		emp.setId(rs.getInt("id"));
		emp.setName(rs.getString("name"));
		emp.setAge(rs.getInt("age"));
		return emp;
	}

}
