package in.vijai.onlinebookstore.entity.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.vijai.onlinebookstore.entity.Book;

public interface BookRepository extends JpaRepository<Book, Long>{

}
