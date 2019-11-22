package services.videa.web.blog.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import services.videa.web.blog.api.TimestampUtils;
import services.videa.web.blog.api.entities.Blog;
import services.videa.web.blog.api.models.AddBlogRequest;
import services.videa.web.blog.api.models.AddBlogResponse;
import services.videa.web.blog.api.models.ReadAllBlogsResponse;
import services.videa.web.blog.api.repositories.BlogRepository;

import java.time.LocalDateTime;
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

    @PostMapping("/add")
    @ResponseBody public AddBlogResponse add(@RequestBody AddBlogRequest addRequestBody) {

        Blog blog = new Blog();
        blog.setTitle(addRequestBody.getTitle());
        blog.setContent(addRequestBody.getContent());

        blog.setTimestamp(TimestampUtils.timestamp(LocalDateTime.now()));
        Blog save = blogRepository.save(blog);

        AddBlogResponse addBlogResponse = new AddBlogResponse();
        addBlogResponse.setContent(save.getContent());
        addBlogResponse.setId(save.getId());
        addBlogResponse.setTimestamp(save.getTimestamp());
        addBlogResponse.setTitle(blog.getTitle());

        return addBlogResponse;
    }

}
