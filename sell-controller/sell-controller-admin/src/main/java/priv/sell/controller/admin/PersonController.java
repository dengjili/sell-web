package priv.sell.controller.admin;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import priv.sell.service.admin.bean.Person;
import priv.sell.service.admin.service.PersonService;
import priv.sell.service.auth.service.AuthService;

@Controller
@RequestMapping("/person")
public class PersonController {
	
	private static final Logger logger = LoggerFactory.getLogger(PersonController.class);
	
	@Autowired
	private PersonService service;
	
	@Autowired
	private AuthService authService;

	@RequestMapping(value = "/list")
	public String listPerson(Model model) {
		if (authService.getAuthByEntryId(null)) {
			throw new RuntimeException("没有权限访问");
		}
		List<Person> listPerson = service.listPerson();
		logger.debug("查询数据大小：{}", listPerson.size());
		model.addAttribute("persons", listPerson);
		return "person/list";
	}
	
}
