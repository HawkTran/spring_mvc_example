package hawk.springmvc.dao;

import java.util.List;

import hawk.springmvc.model.Employee;

public interface EmployeeDAO {
	public List<Employee> getEmployeeList();
	public void insertEmployee(Employee empl);
	public void deleteEmployee(String id);
	public void updateEmpoyee(Employee empl);
}
