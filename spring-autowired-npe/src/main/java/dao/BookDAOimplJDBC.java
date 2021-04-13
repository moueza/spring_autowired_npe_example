package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import models.Book;

/** Strategy */
public class BookDAOimplJDBC implements BookDAOi {
	/** findAll */
	public List<Book> list() {
		List<Book> booksCollection = new ArrayList<>();

		/** Resultset delete https://www.vogella.com/tutorials/MySQLJava/article.html */

		return booksCollection;
	}

	public void scratchAdd3books() throws ClassNotFoundException, SQLException {
		Book b1 = new Book("Relativite generale", "MOUEZA");
		Book b2 = new Book("Neo4j", "Neo4j");
		Book b3 = new Book("Compatible Technical analysis trading", "MOUEZA");
		System.out.println(b3.getTitre().length());
		/**
		 * https://www.infoworld.com/article/3379043/what-is-jpa-introduction-to-the-java-persistence-api.html
		 */
		// Musician georgeHarrison = new Musician(0, "George Harrison");

		// String myDriver = "org.gjt.mm.mysql.Driver";
		// String myDriver = "com.mysql.jdbc.Driver";
		String myDriver = "com.mysql.cj.jdbc.Driver";

		String myUrl = "jdbc:mysql://localhost/npe";
		Class.forName(myDriver);
		Connection conn = DriverManager.getConnection(myUrl, "npe", "npe");

		/**
		 * PreparedStatement :
		 * https://www.infoworld.com/article/3379043/what-is-jpa-introduction-to-the-java-persistence-api.html
		 */
//		String query = " insert into users (id, name) values (?, ?)";
		String query = " insert into Book (titre, auteur) values (?, ?)";
		PreparedStatement preparedStmt = conn.prepareStatement(query);

		preparedStmt.setString(1, b1.getTitre());
		preparedStmt.setString(2, b1.getAuteur());
		// preparedStmt.setString(2, "Rubble");
		preparedStmt.execute();

		preparedStmt.setString(1, b2.getTitre());
		preparedStmt.setString(2, b2.getAuteur());
		// preparedStmt.setString(2, "Rubble");
		preparedStmt.execute();

		preparedStmt.setString(1, b3.getTitre());
		preparedStmt.setString(2, b3.getAuteur());
		// preparedStmt.setString(2, "Rubble");
		preparedStmt.execute();

		conn.close();

		// Error handling removed for brevity
	}

}
