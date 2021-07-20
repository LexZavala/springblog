package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class HelloController {
    @GetMapping("/hello")
    @ResponseBody
    public String hello() {
        return "<h1>Hello from Spring!</h1>";
    }

    @GetMapping("/hello/{name}")
    @ResponseBody
    public String sayHello(@PathVariable String name){
        return "<h1>Hello " + name + "!</h1>";
    }

    @GetMapping("/number/{num}")
    @ResponseBody
    public int displayNumber(@PathVariable int num) {
        return num;
    }

    @RequestMapping(path = "/hello/in/color", method = RequestMethod.GET)
    @ResponseBody
    public String helloInColor(@PathVariable String color){
        return "<h1 style=\"color: " + color + "\">Hello in " + color + "!</h1>";
    }

    @RequestMapping(path = "/posts", method = RequestMethod.GET)
    @ResponseBody
    public String takeToIndex(){
        return "<h1>This is where posts would be</h1>";
    }

    @RequestMapping(path = "/posts/{id}", method = RequestMethod.GET)
    @ResponseBody
    public String takeToIndivPost(Long id){
        return "<h1>This is where to view a single post</h1>";
    }

    @RequestMapping(path = "/posts/create", method = RequestMethod.GET)
    @ResponseBody
    public String createPostForm(){
        return "<h1>This is where the form would be to create a post</h1>";
    }

    @RequestMapping(path = "/posts/create", method = RequestMethod.POST)
    @ResponseBody
    public String createPost(){
        return "<h1>This is where the post creation gets posted and redirects</h1>";
    }


}
