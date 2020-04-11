package in.vijai.onlinebookstore.entity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import in.vijai.onlinebookstore.entity.BookCategory;


/**
 * 
 * @author vijai
 * 
 * @@RepositoryRestResource=> For overriding the url name(Rest end point name).
 *
 */

@CrossOrigin("*")
@RepositoryRestResource(collectionResourceRel = "bookCategory",path = "book-category")
public interface BookCategoryRepository extends JpaRepository<BookCategory, Long> {

}
