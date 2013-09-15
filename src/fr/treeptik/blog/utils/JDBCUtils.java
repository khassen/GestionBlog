package fr.treeptik.blog.utils;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.treeptik.blog.Exception.DAOException;

@Component
public class JDBCUtils {

	private Connection connection;
	@Autowired
	private DataSource dataSource;

	public Connection getConnection() throws DAOException {
		try {
			if (connection == null || connection.isClosed()) {
				
				connection = dataSource.getConnection();

				connection.setAutoCommit(false);
			} else {
				return connection;
			}

		} catch (SQLException e) {
			throw new DAOException(e.getMessage(), e.getCause());
		}
		return connection;
	}
	

}
