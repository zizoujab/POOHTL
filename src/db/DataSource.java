package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataSource {
	private static final String driver = "com.mysql.jdbc.Driver";
	private static final String url = "jdbc:mysql://localhost:3306/data";
	private static final String login = "root";
	private static final String pwd = "";
	private static Connection con;

	private DataSource() {
	}

	public Connection establishConnection() {
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, login, pwd);
			System.out.println("Connexion établie");
		} catch (ClassNotFoundException ex) {
			System.out.println("Erreur de chargement de driver"
					+ ex.getMessage());
		} catch (SQLException ex) {
			System.out.println("probleme d'etablissement de connection"
					+ ex.getMessage());
		}
		return con;
	}

	public static Connection getInstance() {
		if (con == null) {
			new DataSource().establishConnection();
		}
		return con;
	}
}
