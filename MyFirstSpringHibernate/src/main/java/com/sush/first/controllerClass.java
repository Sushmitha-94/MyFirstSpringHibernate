package com.sush.first;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.sush.first.model.User;
import com.sush.first.service.UserService;

@Controller
@SessionAttributes("user")
public class controllerClass {

	@Autowired
	private UserService userService;
	
	@RequestMapping("/")
	public ModelAndView firstPage() {
		ModelAndView modelAndView=new ModelAndView("loginPage");
		return modelAndView;
	}
	
	@RequestMapping(value="/loginValidate",method=RequestMethod.POST)
	public ModelAndView loggedInPage(HttpServletRequest request,@RequestParam("username") String username, @RequestParam("password") String password) {
		User user = userService.userLogin(username,password);
		HttpSession session=request.getSession();  
        session.setAttribute("user",user);
		ModelAndView modelAndView;
		if(user!=null)
		{
			modelAndView=new ModelAndView("firstPage");
			modelAndView.addObject("user", user);
		}
		else
			modelAndView=new ModelAndView("loginFailedPage");
		return modelAndView;
	}
	
	@RequestMapping(value="/signUp",method=RequestMethod.POST)
	public ModelAndView loggedInPage(HttpServletRequest request,@RequestParam("email") String email,@RequestParam("username") String username, @RequestParam("password") String password) {
		User user=new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setEmail(email);
		user = userService.setUpUser(user);
		HttpSession session=request.getSession();  
        session.setAttribute("user",user);
		ModelAndView modelAndView;
		modelAndView=new ModelAndView("firstPage");
		modelAndView.addObject("user", user);
		return modelAndView;
	}
	
	@RequestMapping(value="/saveNewPassword",method=RequestMethod.POST)
	public ModelAndView changePassword(HttpServletRequest request,@RequestParam("oldPassword") String oldPassword, @RequestParam("newPassword") String newPassword) {
		ModelAndView modelAndView;
		HttpSession session=request.getSession(false);
		User user=(User)session.getAttribute("user");
		if(user.getPassword().equals(oldPassword))
		{
			user = userService.updatePassword(user,newPassword);
			modelAndView = new ModelAndView("password");
		}
		else
			modelAndView = new ModelAndView("loginFailedPage");
		return modelAndView;
	}
	
	@RequestMapping(value="/saveNewEmail",method=RequestMethod.POST)
	public ModelAndView changeEmail(HttpServletRequest request,@RequestParam("password") String password, @RequestParam("email") String email) {
		ModelAndView modelAndView;
		HttpSession session=request.getSession(false);
		User user=(User)session.getAttribute("user");
		if(user.getPassword().equals(password))
		{
			user = userService.updateEmail(user,email);
			modelAndView=new ModelAndView("email");
		}
		else
			modelAndView=new ModelAndView("loginFailedPage");
		return modelAndView;
	}
	
	@RequestMapping(value="/deleteUser",method=RequestMethod.POST)
	public ModelAndView deleteUser(HttpServletRequest request,@RequestParam("password") String password) {
		ModelAndView modelAndView;
		HttpSession session=request.getSession(false);
		User user=(User)session.getAttribute("user");
		if(user.getPassword().equals(password))
		{
			userService.deleteUser(user);
			modelAndView=new ModelAndView("email");
		}
		else
			modelAndView=new ModelAndView("loginFailedPage");
		return modelAndView;
	}
}
