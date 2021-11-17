package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import model.User;
import service.UserService;

@Controller
public class UserController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		return "home";
	}

	@RequestMapping(value = "/user", method = RequestMethod.POST)
	public String fetchDetails(@Validated User user, Model model) {

		UserService service = new UserService();
		User userFromDB = service.fetchUserDetails(user);
		if (userFromDB != null) {
			System.out.println("The user exists");
			model.addAttribute("user", userFromDB);
			return "user";
		} else {
			model.addAttribute("userId", user.getUserId());
			return "error";
		}

	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(@Validated User user, Model model) {

		UserService service = new UserService();
		service.updateUserDetails(user);
		model.addAttribute("userId", user.getUserId());

		return "success";
	}

}
