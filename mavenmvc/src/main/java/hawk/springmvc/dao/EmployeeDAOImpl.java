package hawk.springmvc.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import hawk.springmvc.jdbc.EmployeeRowMapper;
import hawk.springmvc.model.Employee;

public class EmployeeDAOImpl implements EmployeeDAO {
@Autowired
DataSource dataSource;


public List<Employee> getEmployeeList() {
	
	List employlist = new ArrayList();
	String 	sql ="SELECT * FROM employee";
	JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
	employlist = jdbcTemplate.query(sql,new EmployeeRowMapper());
	return employlist;
	}

	public void insertEmployee(Employee empl) {
	// TODO Auto-generated method stub
		String sql = "INSERT INTO Employee(NAME,AGE) VALUES (?,?)";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);  
		jdbcTemplate.update(sql, new Object[] {empl.getName(), empl.getAge()});  
	
	}

public void deleteEmployee(String id) {
	// TODO Auto-generated method stub
	String sql = "DELETE FROM Employee WHERE ID = "+id;
	JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);  
	jdbcTemplate.update(sql); 
	
}

public void updateEmpoyee(Employee empl) {
	// TODO Auto-generated method stub
	String sql = "UPDATE Employee SET NAME = ?, AGE = ? WHERE ID = ?";
	JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
	jdbcTemplate.update(sql, new Object[]{empl.getName(), empl.getAge(), empl.getId()});
	
}



}
