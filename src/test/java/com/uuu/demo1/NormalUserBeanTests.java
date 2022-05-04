package com.uuu.demo1;

import com.uuu.demo1.beans.NormalUser;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class NormalUserBeanTests {
    static Validator validator;

    @BeforeAll
    public static void setup(){
        validator = Validation.buildDefaultValidatorFactory().getValidator();
    }
    
    @Test
    public void test1(){
        NormalUser normalUser = new NormalUser("John");
        Set<ConstraintViolation<NormalUser>> violations = validator.validate(normalUser);
        assertThat(violations.size()).isEqualTo(0);
    }

    @Test
    public void test2(){
        NormalUser normalUser = new NormalUser("");
        Set<ConstraintViolation<NormalUser>> violations = validator.validate(normalUser);
        assertThat(violations.size()).isEqualTo(0);
    }

    @Test
    public void test3(){
        NormalUser normalUser = new NormalUser();
        Set<ConstraintViolation<NormalUser>> violations = validator.validate(normalUser);
        for(ConstraintViolation<NormalUser> violation: violations){
            System.out.println(violation.getMessage());
        }
        assertThat(violations.size()).isEqualTo(1);
    }
}
