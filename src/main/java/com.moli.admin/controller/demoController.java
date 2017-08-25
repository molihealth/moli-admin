package com.moli.admin.controller;

import com.moli.admin.model.HelloMesage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static final Logger LOGGER = LoggerFactory.getLogger(demoController.class);

    @GetMapping("{userName}/say")
    public String sayHello(@Valid HelloMesage helloMesage, @PathVariable("userName") String userName){
        LOGGER.info(">>>>>>>>my logger");
        return userName + " " + helloMesage.getName() + " " + helloMesage.getMessage();
    }

}
