package hawk.springmvc.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

import hawk.springmvc.model.Employee;

public class EmployeeRowMapper implements RowMapper<Employee> {
	
	
	public Employee mapRow(ResultSet rs, int arg1) throws SQLException {
		Employee emp = new Employee();
		emp.setId(rs.getInt("ID"));
		emp.setName(rs.getString("NAME"));
		emp.setAge(rs.getInt("AGE"));
		return emp;
	}
}
