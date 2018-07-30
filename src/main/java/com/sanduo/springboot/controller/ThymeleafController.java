package com.sanduo.springboot.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sanduo.springboot.entity.Person;

/**
 * @author sanduo
 * @date 2018/06/22
 */
@Controller
public class ThymeleafController {

    @RequestMapping("/home")
    public String index(Model model) {
        Person single = new Person("sanduo", 26, null);
        List<Person> persons = new ArrayList<Person>();
        Person p1 = new Person("xx", 11, null);
        Person p2 = new Person("yy", 22, null);
        Person p3 = new Person("zz", 33, null);
        persons.add(p1);
        persons.add(p2);
        persons.add(p3);
        model.addAttribute("singlePerson", single);
        model.addAttribute("people", persons);
        return "index";
    }
}
