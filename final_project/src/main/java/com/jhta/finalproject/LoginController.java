package com.jhta.finalproject;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jhta.service.MyUserService;

@Controller
public class LoginController {
	@Autowired private MyUserService service;
	
	@RequestMapping(value="/member/login",method=RequestMethod.GET)
	public String loginForm(){
		return ".login";
	}
	@RequestMapping(value="/member/login",method=RequestMethod.POST)
	public String login(HttpServletRequest request){
		String id=request.getParameter("id");
		String pwd=request.getParameter("pwd");
		HashMap<String,Object> map=new HashMap<String, Object>();
		map.put("id",id);
		map.put("pwd",pwd);
		
		HashMap<String,Object> user=service.isMember(map);
		if(user==null){
			request.setAttribute("errMsg","���̵� �Ǵ� ��й�ȣ�� ��ġ���� �ʾƿ�!");
			return "member/login"; //��Ʈ��Ÿ���� �����Ѱ�  ���̸��� �ǹ���
		}else{
			HttpSession session=request.getSession();//���ǰ�ü ������  ����صα�
			session.setAttribute("id",id);
			return "redirect:/";
		}
	}
	@RequestMapping("/member/logout")
	public String logout(HttpSession session){
		session.invalidate();
		return "redirect:/";
	}
}