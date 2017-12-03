package com.chaedae.welcome;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WelcomeController {
	
	@GetMapping("/")
	public String welcome(Locale locale, Model model) {
		Date date = new Date();
		String simpleDate = new SimpleDateFormat("YYYY년 MM월 dd일 HH:mm:ss").format(date);
		model.addAttribute("time", simpleDate);
		
		return "welcome";
	}
}
