package services.videa.web.blog.api.models;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ReadAllBlogsResponse {

    private List blogs = new ArrayList();

}
