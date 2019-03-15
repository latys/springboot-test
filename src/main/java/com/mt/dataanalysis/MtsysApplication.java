package com.mt.dataanalysis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;




@Controller
@SpringBootApplication
public class MtsysApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(MtsysApplication.class, args);
	}
	
   @Override  
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {  
        return application.sources(MtsysApplication.class);  
    } 
   
	  @RequestMapping("/chart")
	    public String index(){
	        return "chart";
	    }
	  
	  @RequestMapping("/err")
	    public String Error(){
	        return "error";
	    }
	  
	  @RequestMapping("/pages/admin/list")
	    public String list(){
	        return "pages/admin/list";
	    }
	  
	  @RequestMapping("/pages/admin/detail")
	    public String detail(){
	        return "pages/admin/detail";
	    }
}

