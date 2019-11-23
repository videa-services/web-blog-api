package services.videa.web.blog.api.models;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class AddBlogResponse {

    private String title;
    private String content;
    private String timestamp;
    private Long id;
    private List<CommentResponse> comments = new ArrayList<>();

}
