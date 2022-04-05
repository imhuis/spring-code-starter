package com.imhuis.code.examples.web.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author: imhuis
 * @date: 2022/4/2
 * @description:
 */
@Controller
@Slf4j
public class ModelAttributeController {

    @ModelAttribute
    public void addAttribute(Model model) {
        log.info("doing...[@ModelAttribute]");
        model.addAttribute("title", "hello world");
        model.addAttribute("msg", "额外信息");
    }

    @ModelAttribute("list")
    public void addListAttribute(Model model) {
        log.info("doing...[addListAttribute]");
        List<String> list = List.of("abc", "123", "$$$");
        model.addAttribute("listData", list);
    }

    @ModelAttribute(value = "str")
    public List<String> addStringListAttribute() {
        log.info("doing...[addStringListAttribute]");
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
