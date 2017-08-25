package com.moli.admin.controller;

import com.moli.admin.model.HelloMesage;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * Created by gary on 17/8/25.
 */
@RestController
@RequestMapping("/demo")
public class demoController {

    @GetMapping("{userName}/say")
    public String sayHello(@Valid HelloMesage helloMesage, @PathVariable("userName") String userName){
        return userName + " " + helloMesage.getName() + " " + helloMesage.getMessage();
    }

}
