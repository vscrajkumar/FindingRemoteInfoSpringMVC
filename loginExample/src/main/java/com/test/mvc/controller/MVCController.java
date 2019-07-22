package com.test.mvc.controller;

import java.net.InetAddress;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MVCController {

	@GetMapping("/greeting")
	public @ResponseBody String greeting(
			@RequestParam(name = "name", required = false, defaultValue = "World") String name, Model model,
			HttpServletRequest request) {
		model.addAttribute("name", name);
		System.out.println("Hello Rajkumar");
		System.out.println("getRemoteAddr---" + request.getRemoteAddr());
		return "greeting";
	}

	@RequestMapping(value = "/testMethod", method = RequestMethod.GET)
	public @ResponseBody String testMethod(
			@RequestParam(name = "name", required = false, defaultValue = "World") String name, Model model,
			HttpServletRequest request) {
		model.addAttribute("name", name);
		System.out.println("Hello Rajkumar");
		System.out.println("getRemoteAddr---" + request.getRemoteAddr());
		System.out.println("getLocalAddr---" + request.getLocalAddr());
		System.out.println("getRemoteHost---" + request.getRemoteHost());
		System.out.println("getLocalName---" + request.getLocalName());
		System.out.println("X-FORWARDED-FOR---" + request.getHeader("X-FORWARDED-FOR"));

		try {
			InetAddress addr = InetAddress.getByName("10.203.48.145");
			System.out.println("Host name is: " + addr.getHostName());
			System.out.println("Ip address is: " + addr.getHostAddress());
		} catch (Exception e) {

		}
		Enumeration headerNames = request.getHeaderNames();
		while (headerNames.hasMoreElements()) {
			String key = (String) headerNames.nextElement();
			String value = request.getHeader(key);
			System.out.println("key---" + key + "  value---" + value);

		}

		return "greeting";
	}
}
