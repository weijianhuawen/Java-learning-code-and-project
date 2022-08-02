package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UseYml {
    @Value("${custom.name}")
    private String name;
    @Value("${custom.id}")
    private String id;

    private String port;

    @Value("${server.port}")
    public void setPort(String port) {
        this.port = port;
    }

    @ResponseBody
    @RequestMapping("/yml")
    public String configuration() {
        return "name:" + name + "\n"
                + "id:" + id + "\n"
                + "port:" + port;
    }
}
