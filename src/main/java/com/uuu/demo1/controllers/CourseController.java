package com.uuu.demo1.controllers;

import com.uuu.demo1.beans.CourseForm;
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
public class CourseController {

//  private static final Logger LOG = LoggerFactory.getLogger(CourseController.class);

  @GetMapping("/course")
  public String getForm(CourseForm form) {
//    form.setCourseId("1234");
//    form.setCourseName("Spring boot");
//    form.setCourseDuration(4);
    return "courseForm";
  }

  @PostMapping("/course")
  public String setForm(@Valid CourseForm form, BindingResult bindingResult) {
    log.info("course={}", form);
    if (bindingResult.hasErrors()) {
      log.info("{}", bindingResult);
      return "courseForm";
    }
    return "home";
  }
}
