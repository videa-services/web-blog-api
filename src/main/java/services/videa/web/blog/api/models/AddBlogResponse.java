package services.videa.web.blog.api.models;

import lombok.Data;

@Data
public class AddBlogResponse {

    private String title;
    private String content;
    private String timestamp;
    private Long id;

}
