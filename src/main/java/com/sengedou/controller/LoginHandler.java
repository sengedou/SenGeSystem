package com.sengedou.controller;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sengedou.service.ILoginService;
import com.sengedou.util.SpringContextUtils;
import com.sengedou.util.ValidateCode;

@Controller
public class LoginHandler {
	
	@Autowired
	private ILoginService service;
	@Autowired
	private SpringContextUtils  springContextUtils;
	
	@RequestMapping("/login.do")
	public String login(HttpSession session){
		System.out.println("登录成功");
		System.out.println(springContextUtils.getBean(ValidateCode.class).getCode());
		
		service.login("xiaowang", "bbb", "ccc");
		return "/index.html";
	}
	
	@RequestMapping("/VlidateCode.do")
	public void getVlidateCode(HttpSession session,HttpServletResponse response) throws IOException{
		// 设置响应的类型格式为图片格式  
	    response.setContentType("image/jpeg");  
	    //禁止图像缓存。  
	    response.setHeader("Pragma", "no-cache");  
	    response.setHeader("Cache-Control", "no-cache");  
	    response.setDateHeader("Expires", 0);
	    //获取生成验证码工具对象
	    ValidateCode vlidateCode = SpringContextUtils.getBean(ValidateCode.class);
	    String code =vlidateCode.getCode();
	    session.setAttribute("code", code);
	    BufferedImage iamge = vlidateCode.getBuffImg();
	    ImageIO.write(iamge, "JPEG", response.getOutputStream());
	}
}
