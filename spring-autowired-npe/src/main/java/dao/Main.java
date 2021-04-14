package dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import models.Book;

public class Main {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		BookDAOimplJDBC bookDAOimpljdbc = new BookDAOimplJDBC();
		bookDAOimpljdbc.scratchAdd3books();

		Optional<List<Book>> listOptional = Optional.ofNullable(bookDAOimpljdbc.list());

		/** isEmpty java 11 */
		// listOptional.empty(System.out.println("nbLivres=" +
		// listOptional.get().size()));
		/**
		 * null if(soundcard.isPresent()){
		 * https://www.oracle.com/technical-resources/articles/java/java8-optional.html
		 */
		/** TODO ifPresent(void) */
		// list -> System.out.println("nbLivres=" + listOptional.get().size()
		// listOptional.ifPresent(l -> System.out.println());
		/*********** !!!!ifPresent != isPresent **********/
		if (listOptional.isPresent()) {
			System.out.println("lbl1 exists, size=" + listOptional.get().size());
		} else {
			System.out.println("lbl2 null");
		}

	}

}
