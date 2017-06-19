package com.example.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/post")
public class CustomController {

	@RequestMapping("/list")
	public String list(){
		return "list posts...";
	}
	
}
