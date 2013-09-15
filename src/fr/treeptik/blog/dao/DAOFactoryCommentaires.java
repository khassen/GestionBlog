package fr.treeptik.blog.dao;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import fr.treeptik.blog.Exception.DAOException;
import fr.treeptik.blog.dao.impl.CommentairesJDBCImpl;
import fr.treeptik.blog.dao.impl.CommentairesXMLDAO;

@Configuration
public class DAOFactoryCommentaires {

	public final String commentaireJDBC = "JDBC";
	public final String commentaireXML = "XML";

	@Autowired
	private CommentairesJDBCImpl commentairesJDBCImpl;

	@Autowired
	private CommentairesXMLDAO commentairesXMLDAO;

	// @Bean
	// public CommentairesDAO getCommentairesDAO() {
	// return new CommentairesJDBCImpl();
	// }
	//
	// @Bean
	// public CommentairesDAO getCommentairesXMLDAO() {
	// return new CommentairesXMLDAO();
	// }

	@Bean(name = "factoryCommentairesDAO")
	public CommentairesDAO getDAOFactoryCommentaires() throws DAOException,
			FileNotFoundException {

		try {
			Properties properties = new Properties();
			properties.load(new FileReader(new File("application.proporties")));
			String property = properties.getProperty("type");
			System.out.println("salut");
			System.out.println(property);

			switch (property) {
			case commentaireJDBC:

				return commentairesJDBCImpl;

			case commentaireXML: 

				return commentairesXMLDAO;

			

			default:

				return null;
			}

		} catch (IOException e) {
			throw new DAOException(e.getMessage(), e.getCause());

		}
	

	}

}
