package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public class ConnectionPool {
//	members:
	private static ConnectionPool _instance = new ConnectionPool();
	private Set<Connection> _connections;
	private String _url = "jdbc:mysql://localhost:3306/Megabyte?allowPublicKeyRetrieval=true&useSSL=false&&serverTimezone=UTC";
	private String _user = "user";
	private String _password = "12345678";

//	Constructors:
	private ConnectionPool() {
		_connections = new HashSet<Connection>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			for (int i = 0; i <= 9; i++) {
				_connections.add(DriverManager.getConnection(_url, _user, _password));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}// c-tor
//	Methods:

	public static ConnectionPool getConnectionPool() {
		return _instance;
	}// get connection pool

	public synchronized Connection getConnection() throws InterruptedException {
		if (_connections.iterator().hasNext() != true) {
			wait();
		}
		return _connections.iterator().next();
	}// getConnection

	public synchronized void returnConnection(Connection conn) {
		_connections.add(conn);
		notify();
	}// returnConnection

	public void closeAllConnections() throws SQLException {
		for (Connection conn : _connections) {
			conn.close();
		}
	}// closeAllConnections

}// ConnectionPool
