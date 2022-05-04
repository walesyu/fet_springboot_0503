package com.uuu.demo1.controllers;

import com.uuu.demo1.beans.CourseForm;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CourseController {


  @GetMapping("/course")
  public String getForm(CourseForm form) {
    form.setCourseId("1234");
    form.setCourseName("Spring boot");
    form.setCourseDuration(4);
    return "courseForm";
  }
}
