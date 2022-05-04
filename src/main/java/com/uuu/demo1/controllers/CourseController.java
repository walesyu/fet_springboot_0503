package com.uuu.demo1.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CourseController {

  @GetMapping("/course")
  public String getForm() {
    return "courseForm";
  }
}
