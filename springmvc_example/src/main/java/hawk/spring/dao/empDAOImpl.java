package hawk.spring.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import hawk.spring.jdbc.employeeRowMapper;
import hawk.spring.model.employee;

public class empDAOImpl implements empDAO {
	@Autowired
	DataSource dataSource;

	public List<employee> getEmployeeList() {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM employee";
		List emplist = new ArrayList();
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		emplist = jdbcTemplate.query(sql,new employeeRowMapper());
		return emplist;
	}

	public void insertEmployee(employee empl) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO employee(name,age) VALUES(?,?)";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		jdbcTemplate.update(sql, new Object[]{empl.getName(),empl.getAge()});
		
	}

	public void deleteEmployee(String id) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM employee WHERE id ="+id;
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		jdbcTemplate.update(sql);
		
	}

	public void updateEmpoyee(employee empl) {
		// TODO Auto-generated method stub
		String sql ="UPDATE employee SET name = ?,age = ? WHERE id =?";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		jdbcTemplate.update(sql, new Object[]{empl.getName(),empl.getAge(),empl.getId()});		
		
	}
	

}
