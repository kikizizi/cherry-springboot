package com.project.cherry.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class testController {
  @RequestMapping("/test")
  public String mainF(){
    System.out.println("test");
    return "index";
  }
}

