package services.videa.web.blog.api.models;

import lombok.Data;

@Data
public class AddBlogRequest {

    private String title;
    private String content;

}
