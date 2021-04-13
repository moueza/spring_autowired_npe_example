package services;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import models.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}