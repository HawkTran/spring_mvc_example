package hawk.spring.dao;

import java.util.List;

import hawk.spring.model.employee;

public interface empDAO {
	public List<employee> getEmployeeList();
	public void insertEmployee(employee empl);
	public void deleteEmployee(String id);
	public void updateEmpoyee(employee empl);
}
