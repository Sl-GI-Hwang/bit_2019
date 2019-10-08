package kr.co.itcen.jblog3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.itcen.jblog3.service.AdminService;
import kr.co.itcen.jblog3.vo.PostVo;

@Controller
@RequestMapping("/{id:(?!assets).*}/admin")
public class AdminController {
	@Autowired
	private AdminService adminService;
	
	@RequestMapping(value="/basic", method=RequestMethod.GET)
	public String adminBasic(@PathVariable String id){
		return "blog/blog-admin-basic";
	}
	
	@RequestMapping(value="/category", method=RequestMethod.GET)
	public String adminCategory(@PathVariable String id){
		return "blog/blog-admin-category";
	}
	
	@RequestMapping(value="/write", method=RequestMethod.GET)
	public String adminWrite(@PathVariable String id,
			Model model){
		// 카테고리 리스트
		model.addAttribute("categoryList", adminService.getCategory(id));
		return "blog/blog-admin-write";
	}
	
	@RequestMapping(value="/write", method=RequestMethod.POST)
	public String adminWrite(@PathVariable String id,
			@ModelAttribute PostVo postVo
			){
		// 빋은걸로 처리
		adminService.write(postVo);
		return "blog/blog-admin-write";
	}
}
