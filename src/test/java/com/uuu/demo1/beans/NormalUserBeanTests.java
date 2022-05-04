package com.uuu.demo1.beans;

import com.uuu.demo1.beans.NormalUser;
import com.uuu.demo1.beans.NormalUser2;
import com.uuu.demo1.beans.NormalUser3;
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
        NormalUser2 normalUser = new NormalUser2("");
        Set<ConstraintViolation<NormalUser2>> violations = validator.validate(normalUser);
        for(ConstraintViolation<NormalUser2> violation: violations){
            System.out.println(violation.getMessage());
        }
        assertThat(violations.size()).isEqualTo(1);
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

    @Test
    public void test4(){
        NormalUser2 normalUser = new NormalUser2("          ");
        Set<ConstraintViolation<NormalUser2>> violations = validator.validate(normalUser);
        for(ConstraintViolation<NormalUser2> violation: violations){
            System.out.println(violation.getMessage());
        }
        assertThat(violations.size()).isEqualTo(0);
    }

    @Test
    public void test5(){
        NormalUser3 normalUser = new NormalUser3("          ");
        Set<ConstraintViolation<NormalUser3>> violations = validator.validate(normalUser);
        for(ConstraintViolation<NormalUser3> violation: violations){
            System.out.println(violation.getMessage());
        }
        assertThat(violations.size()).isEqualTo(1);
    }

    @Test
    public void test6(){
        NormalUser3 normalUser = new NormalUser3();
        Set<ConstraintViolation<NormalUser3>> violations = validator.validate(normalUser);
        for(ConstraintViolation<NormalUser3> violation: violations){
            System.out.println(violation.getMessage());
        }
        assertThat(violations.size()).isEqualTo(1);
    }

    @Test
    public void test7(){
        NormalUser3 normalUser = new NormalUser3("");
        Set<ConstraintViolation<NormalUser3>> violations = validator.validate(normalUser);
        for(ConstraintViolation<NormalUser3> violation: violations){
            System.out.println(violation.getMessage());
        }
        assertThat(violations.size()).isEqualTo(1);
    }
}
