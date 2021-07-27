package com.codeup.springblog.controllers;

import com.codeup.springblog.models.Post;
import com.codeup.springblog.models.PostRepository;
import com.codeup.springblog.models.User;
import com.codeup.springblog.models.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {
    private final PostRepository postDao;
    private final UserRepository userDao;

    public PostController(PostRepository postDao, UserRepository userDao) {
        this.postDao = postDao;
        this.userDao = userDao;
    }

    @GetMapping("/posts")
    public String index(Model model){
        model.addAttribute("posts", postDao.findAll());
        return "posts/index";
    }

    @GetMapping("/posts/{id}/edit")
    public String getOne(Model model,@PathVariable long id){
        model.addAttribute("post", postDao.getById(id));
        return "posts/edit";
    }


    @GetMapping("/posts/{id}")
    public String showOne(Model model,@PathVariable long id){
        model.addAttribute("post", postDao.getById(id));
        return "posts/show";
    }

    @PostMapping("/posts/save/edit/{id}")
    public String editOne(Model model,@PathVariable long id, @ModelAttribute Post post){
        return createPost(post);
    }

    @PostMapping("/posts/delete/{id}")
    public String deleteOne(@PathVariable long id){
        postDao.deleteById(id);
        return "redirect:/posts";
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
    public String createPostForm(Model model){
        model.addAttribute("post", new Post());
        return "posts/create";
    }

    @RequestMapping(path = "/posts/create", method = RequestMethod.POST)
    public <post> String createPost(@ModelAttribute Post post){
        post.setUser(userDao.getById(1L));
        postDao.save(post);
        return "redirect:/posts";
    }
}
