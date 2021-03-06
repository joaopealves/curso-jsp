package connection;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.management.RuntimeErrorException;

/**
 * 
 * respons�vel em fazer a conex�o com o banco de dados
 * 
 * **/

public class SingleConnection {
	
	private static String url = "jdbc:postgresql://localhost:5432/curso-jsp?autoReconnect=true";
	private static String password = "admin";
	private static String user = "postgres";
	private static Connection connection = null;
	
	
	public SingleConnection() {
		conectar();
	}	
	
	static {
		conectar();	}	
	
	
	private static void conectar() {
		try {
			
			if(connection == null) {
				Class.forName("org.postgresql.Driver");
				connection = DriverManager.getConnection(url, user, password);
				connection.setAutoCommit(false);
			}
			
		} catch (Exception e) {
			throw new RuntimeException("Erro ao conectar com o banco de dados");
		}
	}
	
	public static Connection getConnection() {
		return connection;
	}
			

}
