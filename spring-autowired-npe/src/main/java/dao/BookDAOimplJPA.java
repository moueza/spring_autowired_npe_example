package dao;

import java.util.ArrayList;
import java.util.List;

import models.Book;
/**Strategy*/
public class BookDAOimplJPA implements BookDAOi{
	public List<Book> list() {
		List<Book> booksCollection = new ArrayList<>();
		return booksCollection;
	}

	public void scratchAdd3books() {
		Book b1 = new Book("Relativite general", "Einstein");
	}
	
	
}
