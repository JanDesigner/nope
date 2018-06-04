package com.springboot.controller;

import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.authenticated;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.springboot.Service.LikePostService;
import com.springboot.Service.MessageService;
import com.springboot.Service.PostService;
import com.springboot.Service.UserService;
import com.springboot.domain.Comment;
import com.springboot.domain.LikePost;
import com.springboot.domain.Message;
import com.springboot.domain.Post;
import com.springboot.domain.User;
import com.springboot.repository.MessageRepository;
import com.springboot.repository.RoleRepository;

@Controller
public class JavaIndexController {
	
	@Autowired
	UserService userService;
	@Autowired
	PostService postService;
	@Autowired 
	RoleRepository roleService;
	@Autowired
	LikePostService likePostService;
	@Autowired
	MessageService messageService;
	
	
	@RequestMapping(value="/home")
	public ModelAndView indexhome() {
		
		ModelAndView model = new ModelAndView("/home/index");
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findByEmail(auth.getName());
		
		Post post = new Post();
		Comment comment = new Comment();
		model.addObject("posts",post);
		model.addObject("comments",comment);
		User myAdmins = userService.findByRolesRole("ADMIN");
		
		List<Post> adminPost = postService.findByUsersId(myAdmins.getId());
		
		model.addObject("getAdminPost", adminPost);
		model.addObject("username", user.getFirstName() + " " + user.getLastName());
		model.setViewName("/home/index");
		return model;
		
	}
	
	@RequestMapping( value="/postProcess" , method=RequestMethod.POST )
	public ModelAndView postYourContent(@ModelAttribute("posts")Post post) {
		ModelAndView model = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findByEmail(auth.getName());

		postService.findAndSave(post, user);
		
		model.setViewName("redirect:/home");
		return model;
	}
	
	@RequestMapping( value="/likeProcess/{id}" )
	public ModelAndView likePost(@PathVariable("id")int id) {
		ModelAndView model = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findByEmail(auth.getName());
		Post post = postService.findById(id);
		LikePost likePost = new LikePost();
		
		
		
		
		likePostService.findAndSave(likePost, user, post);
		
		model.setViewName("redirect:/home");
		return model;
	}
	
	
	@RequestMapping( value = "/message")
	public ModelAndView messagePage() {

		ModelAndView model = new ModelAndView();
		Message message = new Message();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findByEmail(auth.getName());
		model.addObject("myInbox",user.getMyMessage());
		model.addObject("myMessage", message );
		model.setViewName("/home/message");
		return model;
	}
	
	@RequestMapping ( value = "sendMessage" , method=RequestMethod.POST)
	public ModelAndView postMessage(@ModelAttribute("myMessage") Message message) {
		
		ModelAndView model = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findByEmail(auth.getName());
		messageService.findAndSaveMessage(message , user);
		model.addObject("myMessage" , new Message());
		model.addObject("messageSuccess", "Message Send");
		model.setViewName("redirect:/message");
		return model;
	}
	
	
	
	
	
}
