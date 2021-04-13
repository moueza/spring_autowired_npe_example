package services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import models.Book;
/**https://www.baeldung.com/spring-boot-hibernate*/
@Service
public class BookService {

	@Autowired
	private BookRepository bookRepository;

	public List<Book> list() {
		return bookRepository.findAll();
	}
}