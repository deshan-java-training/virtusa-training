package com.smsui.smsui.uicontroller;

import com.smsui.smsui.accesstoken.AccessTokenConfigurer;
import com.smsui.smsui.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

@Controller
@EnableOAuth2Sso
public class UiController extends WebSecurityConfigurerAdapter {
    @Autowired
    RestTemplate restTemplate;

    @Bean
    RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/","/css/**","/js/**")
                .permitAll()
                .anyRequest()
                .authenticated();
    }

    @RequestMapping(value = "/report")
    public String showReport(){

        return "report";
    }

    @RequestMapping(value = "/create-student")
    public String studentForm(){
        return "student-form";
    }

    @RequestMapping(value = "/")
    public String showHome(){
return "home";
    }

@RequestMapping(value = "/search-student")
    public String searchStudentById(){
        return "search-student";
    }

    @RequestMapping(value = "/all-students")
    public String getAllStudents(Model model){
HttpHeaders httpHeaders = new HttpHeaders();
         httpHeaders.add("Authorization", AccessTokenConfigurer.getToken());
        HttpEntity<Student> studentHttpEntity = new HttpEntity<Student>(httpHeaders);
        ResponseEntity<Student[]> responseEntity = restTemplate.exchange("http://localhost:8083/sms/students", HttpMethod.GET,studentHttpEntity,Student[].class);
model.addAttribute("students", responseEntity);
        return "all-students";
    }



}
