package services.videa.web.blog.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import services.videa.web.blog.api.entities.Blog;
import services.videa.web.blog.api.repositories.BlogRepository;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Configuration
public class WebBlogApiConfiguration {

    @Autowired
    private BlogRepository blogRepository;

    @PostConstruct
    public void initialiseData() {
        Blog blog = new Blog();

        blog.setTitle("Hitchhiker's guide to the galaxy");
        blog.setContent("The Hitchhiker's Guide to the Galaxy (sometimes referred to as HG2G, HHGTTG, H2G2, or tHGttG) " +
                "is a comedy science fiction series created by Douglas Adams.");

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String timestamp = LocalDateTime.now().format(dateTimeFormatter);
        blog.setTimestamp(timestamp);

        blogRepository.save(blog);
    }

}
