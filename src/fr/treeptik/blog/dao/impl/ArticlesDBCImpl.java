package fr.treeptik.blog.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.treeptik.blog.Exception.DAOException;
import fr.treeptik.blog.dao.ArticlesDAO;
import fr.treeptik.blog.model.Articles;
import fr.treeptik.blog.utils.JDBCUtils;

@Repository
public class ArticlesDBCImpl implements ArticlesDAO {

	@Autowired
	private JDBCUtils jDBCUtils;

	@Override
	public Articles save(Articles articles) throws DAOException {

		Connection connection = jDBCUtils.getConnection();
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("insert into articles"
							+ "(art_titre,art_chapeau,art_contenu ,art_date, art_en_ligne,cat_id, aut_id)"
							+ " values (?,?,?,?,?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1, articles.getArtTitre());
			preparedStatement.setString(2, articles.getArtChapeau());
			preparedStatement.setString(3,articles.getArtContenu());
			preparedStatement.setDate(4, new Date(articles.getArtDate().getTime()));
			

			
			preparedStatement.setBoolean(5, articles.isArtEnLigne());
			
			
			preparedStatement.setInt(6,articles.getCtegories().getCatId());
			preparedStatement.setInt(7, articles.getAuteurs().getAutId());
			
			preparedStatement.executeUpdate();
			
			ResultSet resultSet = preparedStatement.getGeneratedKeys();
			resultSet.next();
			
			articles.setArtId(resultSet.getInt(1));
			
			
		} catch (SQLException e) {
			throw new DAOException(e.getMessage(), e.getCause());
		} 
		return articles;
	}

	@Override
	public void remove(Articles articles) throws DAOException {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Articles> findAll() throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

}
