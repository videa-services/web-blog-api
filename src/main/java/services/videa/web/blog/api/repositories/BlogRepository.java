package services.videa.web.blog.api.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import services.videa.web.blog.api.entities.Blog;

@Repository // optional
public interface BlogRepository extends CrudRepository<Blog, Long> {
}
