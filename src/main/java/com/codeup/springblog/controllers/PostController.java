package com.codeup.springblog.controllers;

import com.codeup.springblog.models.Post;
import com.codeup.springblog.models.PostRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PostController {
    private final PostRepository postDao;

    public PostController(PostRepository postDao) {
        this.postDao = postDao;
    }

    @GetMapping("/posts")
    public String index(Model model){
        model.addAttribute("posts", postDao.findAll());
        return "posts/index";
    }

    @GetMapping("/posts/edit/{id}")
    public String getOne(Model model,@PathVariable long id){
        model.addAttribute("post", postDao.getById(id));
        return "posts/edit";
    }

    @PostMapping("/posts/edit/{id}")
    public String editOne(@PathVariable long id, @RequestParam(name = "title") String title, @RequestParam(name = "body") String body){

    }

//    List<Post> posts = new ArrayList<>();
//
//    @RequestMapping(path = "/posts", method = RequestMethod.GET)
//    public String takeToIndex(Model model){
//        posts.add(new Post("This is post1", "This is post1s body"));
//        posts.add(new Post("This is post2", "This is post2s body"));
//        model.addAttribute("posts", posts);
//        return "posts/index";
//    }
//
//    @RequestMapping(path = "/posts/{id}", method = RequestMethod.GET)
//    public String takeToIndivPost(@PathVariable long id, Model model){
//        Post post =  new Post("Jeff buys a bicycle", "No one knows why, must really like the wind");
//        model.addAttribute("post", post);
//        return "posts/show";
//    }

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
