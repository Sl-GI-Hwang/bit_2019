package kr.co.itcen.jblog3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.itcen.jblog3.service.UserService;
import kr.co.itcen.jblog3.vo.UserVo;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/join", method=RequestMethod.GET)
	public String join() {
		return "/user/join";		
	}
	
	@RequestMapping(value="/join", method=RequestMethod.POST)
	public String join(
			@ModelAttribute UserVo vo) {
		userService.join(vo);		
		return "/user/joinsuccess";		
	}
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String login() {
		return "/user/login";		
	}
	
}
