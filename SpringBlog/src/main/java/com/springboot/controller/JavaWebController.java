package com.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.springboot.Service.PostService;
import com.springboot.Service.UserService;
import com.springboot.domain.Post;
import com.springboot.domain.User;

@Controller
public class JavaWebController {
	
	@Autowired
	UserService userService;
	@Autowired
	PostService postService;
	
	
	@RequestMapping( value = { "/" } )
	public ModelAndView semiHome() {
		ModelAndView model = new ModelAndView();
		
		User myAdmins = userService.findByRolesRole("ADMIN");
		
		List<Post> adminPost = postService.findByUsersId(myAdmins.getId());
		
		model.addObject("getAdminPost", adminPost);
		
		model.setViewName("landing");
		
		return model;
		
	}
	/**
	 * @return
	 */
	@RequestMapping( value = { "/login" })
	public ModelAndView LoginPageCustomer() {
		ModelAndView model = new ModelAndView();
		model.addObject("myMsg","Invalid Email / Password");
		model.setViewName("login");
		return model;
	}
	@RequestMapping( value="/signup" , method=RequestMethod.GET)
	public ModelAndView signup() {
		ModelAndView model = new ModelAndView();
		User user = new User();
		model.addObject("users", user);
		model.setViewName("/member/reg");
		return model;
	}
	@RequestMapping( value="/signup" , method=RequestMethod.POST)
	public ModelAndView registerUser(@ModelAttribute("users")User user ) {
		ModelAndView model = new ModelAndView();
		userService.findAndSaved(user);
		model.addObject("users",new User());
		model.addObject("msg","Account Created");
		model.setViewName("/member/reg");
		return model;
	}
	

	
	
}
