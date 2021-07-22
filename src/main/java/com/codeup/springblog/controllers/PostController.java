package com.codeup.springblog.controllers;

import com.codeup.springblog.models.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
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
    public String takeToIndivPost(@PathVariable long id, Model model){
        Post post =  new Post("Jeff buys a bicycle", "No one knows why, must really like the wind");
        return "posts/show";
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
