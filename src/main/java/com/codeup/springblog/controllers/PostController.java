package com.codeup.springblog.controllers;

import com.codeup.springblog.models.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PostController {

    List<Post> posts = new ArrayList<>();


    @RequestMapping(path = "/posts", method = RequestMethod.GET)
    public String takeToIndex(Model model){
        posts.add(new Post("This is post1", "This is post1s body"));
        posts.add(new Post("This is post2", "This is post2s body"));
        model.addAttribute("posts", posts);
        return "posts/index";
    }

    @RequestMapping(path = "/posts/{id}", method = RequestMethod.GET)
    @ResponseBody
    public String takeToIndivPost(long id){
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
