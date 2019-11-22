package services.videa.web.blog.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import services.videa.web.blog.api.entities.Blog;
import services.videa.web.blog.api.repositories.BlogRepository;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;

@Configuration
public class WebBlogApiConfiguration {

    @Autowired
    private BlogRepository blogRepository;

    @PostConstruct
    public void initialiseData() {
        //blogRepository.deleteAll();

        Blog blog = new Blog();

        blog.setTitle("Hitchhiker's guide to the galaxy");
        blog.setContent("The Hitchhiker's Guide to the Galaxy (sometimes referred to as HG2G, HHGTTG, H2G2, or tHGttG) " +
                "is a comedy science fiction series created by Douglas Adams.");

        String timestamp = TimestampUtils.timestamp(LocalDateTime.now());
        blog.setTimestamp(timestamp);

        blogRepository.save(blog);
    }

}
