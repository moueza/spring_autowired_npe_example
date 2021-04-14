package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import models.Book;

/** Strategy */
public class BookDAOimplJDBC implements BookDAOi {
	/** TODO into general bean */
	String myDriver = "com.mysql.cj.jdbc.Driver";

	String myUrl = "jdbc:mysql://localhost/npe";
	Connection conn = null;
	PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;
	List<Book> booksCollection;

	public BookDAOimplJDBC() throws SQLException {
		super();
		conn = DriverManager.getConnection(this.myUrl, "npe", "npe");

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
		Class.forName(myDriver);

		/**
		 * PreparedStatement :
		 * https://www.infoworld.com/article/3379043/what-is-jpa-introduction-to-the-java-persistence-api.html
		 */
		// String query = " insert into users (id, name) values (?, ?)";
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

	/** https://www.vogella.com/tutorials/MySQLJava/article.html */
	private void writeResultSetBOOK(ResultSet resultSet) throws SQLException {
		// ResultSet is initially before the first data set
		while (resultSet.next()) {
			// It is possible to get the columns via name
			// also possible to get the columns via the column number
			// which starts at 1
			// e.g. resultSet.getSTring(2);
			Integer id = resultSet.getInt("id");
			String titre = resultSet.getString("auteur");
			String auteur = resultSet.getString("titre");

			// Date date = resultSet.getDate("datum");
			System.out.println("User: " + id);
			System.out.println("Website: " + titre);
			System.out.println("summary: " + auteur);
			// System.out.println("Date: " + date);
			Book book = new Book(id, titre, auteur);

		}
	}

	/**
	 * findAll
	 * 
	 * @throws SQLException https://www.vogella.com/tutorials/MySQLJava/article.html
	 */
	public List<Book> list() throws SQLException {
		List<Book> booksCollection = new ArrayList<>();

		/** Resultset delete https://www.vogella.com/tutorials/MySQLJava/article.html */
		preparedStatement = conn.prepareStatement("SELECT id, titre, autheur from npe.Book");
		resultSet = preparedStatement.executeQuery();
		writeResultSetBOOK(resultSet);
		return this.booksCollection;
	}

}
