package hawk.springmvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import hawk.springmvc.dao.EmployeeDAOImpl;
import hawk.springmvc.model.Employee;

@Controller
public class EmployeeController {
	
	@Autowired
	private EmployeeDAOImpl employeeDAO;

	@RequestMapping("/getList")
	public ModelAndView getEmpList() {
		List<Employee> empList = employeeDAO.getEmployeeList();
		ModelAndView md = new ModelAndView("employeeList");
		md.addObject("employeeList", empList);
		return md;
	}
	@RequestMapping("/insertEmployee")
	public ModelAndView insertEmployee(){
		ModelAndView model = new ModelAndView("employeeAdd");
		Employee empl = new Employee();
		model.addObject("addnew", empl);
		return model;
	}
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public String addEmployee(@ModelAttribute Employee empl) {
		ModelAndView mv = new ModelAndView("insertEmp");
		employeeDAO.insertEmployee(empl);;
		mv.addObject("newEmp", empl);
		return "redirect:/getList";
	}
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public String updateEmp(@ModelAttribute Employee empl) {
		
		employeeDAO.updateEmpoyee(empl);;
		
		System.out.println(empl.getName());
		
		return "redirect:/getList";
	}
	@RequestMapping(value="/edit", method=RequestMethod.GET)
	public ModelAndView editEmp(@RequestParam int id) {
		
		ModelAndView modelv = new ModelAndView("employeeUpdate");
		
		Employee empl = new Employee();
		empl.setId(id);
		
		modelv.addObject("emp", empl);
		
		
		return modelv;
	}	
	@RequestMapping(value="/delete", method=RequestMethod.GET)
	public String deleteEmp(@RequestParam String id) {
		employeeDAO.deleteEmployee(id);;
		return "redirect:/getList";
	}
}
