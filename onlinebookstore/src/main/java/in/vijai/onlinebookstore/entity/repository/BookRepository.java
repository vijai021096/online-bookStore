package in.vijai.onlinebookstore.entity.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import in.vijai.onlinebookstore.entity.Book;

/**
 * 
 * @author Vijai
 * 
 * Pass the entity name and type of the primary key. This inteface should extend JpaRepository for performing basic CRUP operations
 * CrossOrigin is used to allow access from other hosts to the rest endpoints. (to avoid CORS error).
 *
 */

@CrossOrigin("*")
public interface BookRepository extends JpaRepository<Book, Long>{         
	
	
    @RestResource(path="categoryid")                                  //To override the rest end point of query method.In default it will the name of the method.
	Page<Book> findByCategoryId(@Param("id")Long id,Pageable page);   //Creating Query method based on category id
		 
    @RestResource(path="searchByKeyword")                                  //To override the rest end point of query method.In default it will the name of the method.
   	Page<Book> findByNameContaining(@Param("name")String keyword,Pageable page);
	 
}
