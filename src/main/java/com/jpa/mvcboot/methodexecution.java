package com.jpa.mvcboot;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class methodexecution {

	@GetMapping("/")
	public String method()
	{
		return "hello";
	}
	@GetMapping("/admin")
	public String method2()
	{
		return "hello";
	}
	@GetMapping("/user")
	public String method3()
	{
		return "hello";
	}
	@GetMapping("/login")
	public String login()
	{
		return "login";
	}
	@ResponseBody
	@GetMapping("test1")
	public String test1()
	{
		return "<h1>test1</h1>";
	}
	@ResponseBody
	@GetMapping("test2")
	public String test2()
	{
		return "<h1>test2</h1>";
	}
}
