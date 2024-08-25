package com.zyixh.code.springweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class ModelController {

    @ModelAttribute
    public void addAttribute(Model model) {
        model.addAttribute("title", "hello world");
        model.addAttribute("msg", "额外信息");
    }

    @ModelAttribute("list")
    public void addListAttribute(Model model) {
        List<String> list = List.of("abc", "123", "$$$");
        model.addAttribute("listData", list);
    }

    @ModelAttribute(value = "str")
    public List<String> addStringListAttribute() {
        return List.of("Hello World", "Apple", "WWW");
    }

    @RequestMapping("/test/modelAttribute")
    public String test() {
        return "test1";
    }

    /**
     * {@link ModelAttribute} 和 {@link RequestMapping} 同时注解一个方法，返回值表示model的值
     * @return
     */
    @RequestMapping("/test1")
    @ModelAttribute("attributeName")
    public String hello() {
        return "value";
    }
}
