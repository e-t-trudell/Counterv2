
package com.erictrudell.counterv2.controllers;



import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	@GetMapping("/")
	public String home(HttpSession session, Model model) {
		
		
		if (session.getAttribute("count") == null){
			session.setAttribute("count", 0);
			System.out.println(session.getAttribute("count"));
		}
		else{
			Integer currentCount = (Integer) session.getAttribute("count");
			System.out.println("before increment "+currentCount);
			currentCount ++;
			System.out.println("after increment: "+ currentCount);
			session.setAttribute("count", currentCount);
			System.out.println("count is: " + currentCount);
		}
		
		return "index.jsp";
		
	}
	@GetMapping("/show")
	public String show(HttpSession session, Model model) {
		Integer currentCount = (Integer) session.getAttribute("count");
		model.addAttribute("count", currentCount);
		model.getAttribute("count");
		return "show.jsp";
		
	}
	@GetMapping("/show2")
	public String show2(HttpSession session, Model model) {
		Integer currentCount = (Integer) session.getAttribute("count");
		System.out.println("before increment "+currentCount);
		currentCount +=2;
		System.out.println("after increment: "+ currentCount);
		session.setAttribute("count", currentCount);
		System.out.println("count is: " + currentCount);
		
		model.addAttribute("count", currentCount);
		model.getAttribute("count");
		return "show2.jsp";
		
	}
	
	
}
