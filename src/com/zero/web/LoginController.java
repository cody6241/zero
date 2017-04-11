package com.zero.web;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.utils.MD5Encipher;
import com.zero.directive.TestDirective;
import com.zero.domain.User;
import com.zero.service.UserService;
import com.zero.tags.TagCreator;

import freemarker.template.TemplateException;

@Controller
public class LoginController{
	
	@Autowired
	private UserService userService;
    
	@RequestMapping(value = "/login.html")
	public String loginPage(){
		return "login";
	}
	
	@RequestMapping(value = "/index.html")
	public String index(ModelMap root) throws IOException, TemplateException{
//		Map<String,Object> root = new HashMap<String,Object>();
//		root.put("newTag", new TagCreator());
//		root.put("title", "abc");
//		response.setContentType("text/html;charset=UTF-8");
//		String reqPath = request.getServletPath();
//		String rootPath = StringUtil.getRootPath();
//		String htmlDir = rootPath +"/WEB-INF/html";
//		Configuration cfg = FreeMarkerUtil.getFolderCfg(htmlDir);
//		Template temp = cfg.getTemplate("index.html");
//		temp.process(root, response.getWriter());
		root.put("newTag", new TagCreator());
		root.put("fm", new TestDirective());
		root.put("title", "张三");
		return "index";
		
	}
	
	@RequestMapping(value = "/loginCheck.html")
	public ModelAndView loginCheck(HttpServletRequest request,LoginCommand loginCommand){
		String md5Password = MD5Encipher.doMD5Encipher(loginCommand.getPassword());
		boolean isValidUser = 
			   userService.hasMatchUser(loginCommand.getUserName(),
					   md5Password);
		if (!isValidUser) {
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("error1", "用户名或密码错误。");
			map.put("error2", "真的错了！~");
			return new ModelAndView("login", map);
		} else {
			User user = userService.findUserByUserName(loginCommand
					.getUserName());
			user.setLastIp(request.getLocalAddr());
			user.setLastVisit(new Date());
			userService.loginSuccess(user);
			request.getSession().setAttribute("user", user);
			ModelAndView view = new ModelAndView("../../index");
			view.addObject(user);
			return view;
		}
	}
}
