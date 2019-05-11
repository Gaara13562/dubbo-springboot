package study.consumer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.dubbo.config.annotation.Reference;

import study.pojo.User;
import study.service.IUserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Reference
	private IUserService userService;

	@RequestMapping("/")
	public String index(Model model) {
		model.addAttribute("allUsers", userService.getAllUsers());
		return "all";
	}
	
	@RequestMapping("/toAddUI")
	public String toAddUI() {
		return "add";
	}
	
	@RequestMapping("/add")
	public String add(User user) {
		userService.addUser(user);
		// 后台重定向
		return "redirect:/user/";
	}
	
	@RequestMapping("/toUpdateUI/{id}")
	public String toUpdateUI(Model model, @PathVariable("id")Integer id) {
		model.addAttribute("user", userService.getUserById(id));
		return "update";
	}
	
	@RequestMapping("/update")
	public String update(User user) {
		userService.updateUser(user);
		return "redirect:/user/";
	}
	
	@RequestMapping("/del/{id}")
	public String deleteUser(@PathVariable("id")Integer id) {
		userService.deleteUserById(id);
		return "redirect:/user/";
	}
	
	
}
