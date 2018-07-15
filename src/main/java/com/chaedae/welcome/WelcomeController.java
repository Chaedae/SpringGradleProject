package com.chaedae.welcome;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.chaedae.model.User;
import com.chaedae.service.UserService;

@Controller
public class WelcomeController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/")
	public String welcome(Locale locale, Model model) {
		Date date = new Date();
		String simpleDate = new SimpleDateFormat("YYYY년 MM월 dd일 HH:mm:ss").format(date);
		model.addAttribute("time", simpleDate);
		
		User user = new User();
		user.setUserId("master");
		model.addAttribute("user", this.userService.selectByUserId(user));
		model.addAttribute("userList", this.userService.selectList(user));
		
		return "welcome";
	}
}
