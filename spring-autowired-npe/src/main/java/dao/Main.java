package dao;

import java.sql.SQLException;

public class Main {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		BookDAOimplJDBC BookDAOimpljdbc = new BookDAOimplJDBC();
		BookDAOimpljdbc.scratchAdd3books();
		System.out.println("nbLivres=" + BookDAOimpljdbc.list().size());
	}

}
