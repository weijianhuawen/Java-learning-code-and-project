package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class ConfigController {
    @Autowired
    private Student student;
    @Resource
    private ConfigList configList;
    @RequestMapping("/student")
    @ResponseBody
    public String sayStu() {
        System.out.println(student);
        return student.toString();
    }
    @RequestMapping("/list")
    @ResponseBody
    public String sayList() {
        System.out.println(configList.getName());
        return configList.getName().toString();
    }
}
