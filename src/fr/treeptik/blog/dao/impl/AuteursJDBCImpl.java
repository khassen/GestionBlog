package fr.treeptik.blog.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.treeptik.blog.Exception.DAOException;
import fr.treeptik.blog.dao.AuteursDAO;
import fr.treeptik.blog.model.Auteurs;
import fr.treeptik.blog.utils.JDBCUtils;

@Repository
public class AuteursJDBCImpl implements AuteursDAO{

	@Autowired
	private JDBCUtils jDBCUtils;
	@Override
	public Auteurs save(Auteurs auteurs) throws DAOException {
        

		try {
			Connection connection = jDBCUtils.getConnection();

			PreparedStatement preparedStatement = connection.prepareStatement(
					"insert into auteurs(aut_nom,aut_prenom,aut_url,aut_email) values (?,?,?,?)",
					PreparedStatement.RETURN_GENERATED_KEYS);

			preparedStatement.setString(1, auteurs.getAutNom());
			preparedStatement.setString(2, auteurs.getAutPrenom());
			preparedStatement.setString(3, auteurs.getAutUrl());
			preparedStatement.setString(4, auteurs.getAutEmail());

			preparedStatement.executeUpdate();

			ResultSet resultSet = preparedStatement.getGeneratedKeys();
			resultSet.next();

			auteurs.setAutId(resultSet.getInt(1));

		} catch (SQLException e) {

			throw new DAOException(e.getMessage(), e.getCause());
		}
		
		return auteurs;
	}

	@Override
	public void remove(Auteurs auteurs) throws DAOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Auteurs> findAll() throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}



}
