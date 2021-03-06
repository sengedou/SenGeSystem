package com.sengedou.controller;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.sengedou.bean.UserBean;
import com.sengedou.service.IUserService;
import com.sengedou.util.SpringContextUtils;
import com.sengedou.util.ValidateCode;

@Controller
public class UserHandler {
	
	@Autowired
	private IUserService service;
	
	@RequestMapping("/login.do")
	@ResponseBody
	public ModelAndView login(HttpSession session, UserBean bean, String vercode) {
		ModelAndView mav = new ModelAndView();
		String realCode = (String) session.getAttribute("code");
		if (!realCode.equalsIgnoreCase(vercode)) {
			mav.setViewName("/login.html");
			mav.addObject("message", "验证码不正确，请重新输入");
			return mav;
		}
		UserBean realBean = service.login(bean);
		if (realBean == null) {
			mav.setViewName("/login.html");
			mav.addObject("message", "用户名或密码不正确，请重新输入");
		} else {
			mav.setViewName("/index.html");
			mav.addObject("message", "登录成功");
		}
		return mav;

	}
	
	@RequestMapping("/loginjson.do")
	@ResponseBody
	public Map loginJson(HttpSession session, UserBean bean, String vercode) {
		Map<String,Object> result = new HashMap<>();
		boolean isLoginOk = false;
		String message = "登录失败";
		String realCode = (String) session.getAttribute("code");
		if (realCode!=null) {
			if (!realCode.equalsIgnoreCase(vercode)) {
				message = "验证码不正确，请重新输入";
				result.put("message", message);
				return result;
			}
		} else {
			message = "验证码已过期";
			result.put("message", message);
			return result;
		}
		UserBean realBean = service.login(bean);
		if (realBean == null) {
			message = "用户名或密码不正确，请重新输入";
			result.put("message", message);
			return result;
		} else {
			message = "登录成功";
			isLoginOk = true;
			result.put("message", message);
			result.put("isLoginOk", isLoginOk);
			return result;
		}
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
