package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import web.service.UserService;

import java.security.Principal;


@Controller
public class UserController {

//	@RequestMapping(value = "hello", method = RequestMethod.GET)
//	public String printWelcome(ModelMap model) {
//		List<String> messages = new ArrayList<>();
//		messages.add("Hello!");
//		messages.add("I'm Spring MVC-SECURITY application");
//		messages.add("5.2.0 version by sep'19 ");
//		model.addAttribute("messages", messages);
//		return "hello";
//	}
//
//	@RequestMapping(value = "test", method = RequestMethod.GET)
//	public String printTest(ModelMap model) {
//		return "test";
//	}
//
//    @RequestMapping(value = "login", method = RequestMethod.GET)
//    public String loginPage() {
//        return "login";
//    }

	private final UserService userService;

	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}


	@GetMapping(value = "/lk")
	public String getUserPage2(ModelMap modelMap, Principal principal) {
		modelMap.addAttribute("user", userService.loadUserByUsername(principal.getName()));
		return "userPage";
	}
}