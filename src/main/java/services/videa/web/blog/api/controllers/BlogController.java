package services.videa.web.blog.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import services.videa.web.blog.api.entities.Blog;
import services.videa.web.blog.api.models.ReadAllBlogsResponse;
import services.videa.web.blog.api.repositories.BlogRepository;

import java.util.List;

@RestController
@RequestMapping("/blog")
public class BlogController {

    @Autowired
    private BlogRepository blogRepository;

    @GetMapping("/readAll")
    @ResponseBody public ReadAllBlogsResponse readAll() {

        Iterable<Blog> all = blogRepository.findAll();
        ReadAllBlogsResponse readAllBlogsResponse = new ReadAllBlogsResponse();
        readAllBlogsResponse.setBlogs((List) all);

        return readAllBlogsResponse;
    }

}
