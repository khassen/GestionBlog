package fr.treeptik.blog.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.treeptik.blog.Exception.DAOException;
import fr.treeptik.blog.dao.CommentairesDAO;
import fr.treeptik.blog.model.Commentaires;
import fr.treeptik.blog.utils.JDBCUtils;

@Repository
public class CommentairesJDBCImpl implements CommentairesDAO {

	@Autowired
	private JDBCUtils jDBCUtils;

	@Override
	public Commentaires save(Commentaires commentaires) throws DAOException {
		Connection connection = jDBCUtils.getConnection();

		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement(
							"insert into commentaires(com_nom, com_email,com_text,com_date,com_validation,art_id) "
									+ "values (?,?,?,?,?,?)",
							PreparedStatement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1, commentaires.getComNom());
			preparedStatement.setString(2, commentaires.getcomEmail());
			preparedStatement.setString(3, commentaires.getComText());
			preparedStatement.setDate(4, new Date(commentaires.getComDate()
					.getTime()));
			preparedStatement.setString(5, commentaires.getComValidation());

			preparedStatement.setInt(6, commentaires.getArticles().getArtId());

			preparedStatement.executeUpdate();

			ResultSet resultSet = preparedStatement.getGeneratedKeys();

			resultSet.next();
			commentaires.setComId(resultSet.getInt(1));

		} catch (SQLException e) {
			throw new DAOException(e.getMessage(), e.getCause());
		}

		return commentaires;
	}

	@Override
	public void remove(Commentaires commentaires) throws DAOException {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Commentaires> findAll() throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

}
