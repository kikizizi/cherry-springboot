package com.project.cherry.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class testController {
  @RequestMapping("/")
  public String mainF(){
    System.out.println("test");
    return "index";
  }
}

