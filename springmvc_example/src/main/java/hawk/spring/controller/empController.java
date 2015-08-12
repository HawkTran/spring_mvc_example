package hawk.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import hawk.spring.dao.empDAOImpl;
import hawk.spring.model.employee;

@Controller
public class empController {
	@Autowired
	private empDAOImpl empDAO;
	String message = "ABCDEFGHT";
	@RequestMapping("/hello")
	public ModelAndView showMess(){
	ModelAndView mv = new ModelAndView("hello","message",message);
		return mv;		
	}
	@RequestMapping("/getlist")
	public ModelAndView showList(){
		List<employee> empList = empDAO.getEmployeeList();
		ModelAndView mv = new ModelAndView("emplist");
		mv.addObject("employeeList", empList);
		return mv;
	}
	@RequestMapping("/insertEmp")
	public ModelAndView inserEmp(){
		ModelAndView mv = new ModelAndView("empAdd");
		employee empl = new employee();
		mv.addObject("newemp", empl);
		return mv;
	}
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public String addEmp(@ModelAttribute employee empl){
		ModelAndView mv = new ModelAndView("empAdd");
		empDAO.insertEmployee(empl);
		mv.addObject("newemp", empl);
		return "redirect:/getlist";
	}
	@RequestMapping(value="/del", method=RequestMethod.GET)
	public String delemp(@RequestParam String id){
		empDAO.deleteEmployee(id);
		return "redirect:/getlist";
	}
	@RequestMapping(value="/edit",method=RequestMethod.GET)
	public ModelAndView editemp(@RequestParam int id){
		ModelAndView mv = new ModelAndView("empEdit");
		employee empl = new employee();
		empl.setId(id);
		mv.addObject("editemp",empl);
		return mv;
	}
	@RequestMapping(value="/update",method = RequestMethod.POST)
	public String updateemp(@ModelAttribute employee empl){
		empDAO.updateEmpoyee(empl);
		System.out.println(empl.getName());
		return "redirect:/getlist";
	}
	
}
