package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class YmlString {
    @Value("${mystring.str1}")
    private String str1;
    @Value("${mystring.str2}")
    private String str2;
    @Value("${mystring.str3}")
    private String str3;

    @ResponseBody
    @RequestMapping("/str")
    public String mystr() {

        System.out.println("str1:" + str1);
        System.out.println("str2:" + str2);
        System.out.println("str3:" + str3);

        return str1 +"\n"
                + str2 + "\n"
                + str3;
    }
}
