package fr.treeptik.blog.service.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.treeptik.blog.Exception.DAOException;
import fr.treeptik.blog.Exception.ServiceException;
import fr.treeptik.blog.dao.AuteursDAO;
import fr.treeptik.blog.model.Auteurs;
import fr.treeptik.blog.service.AuteursService;
import fr.treeptik.blog.utils.JDBCUtils;

@Service
public class AuteursServiceImpl implements AuteursService{
	
	@Autowired private AuteursDAO auteursDAO;
	@Autowired
	private JDBCUtils jDBCUtils;
	@Override
	public Auteurs save(Auteurs auteurs) throws ServiceException {
		try {
			Connection connection = jDBCUtils.getConnection();

			auteurs = auteursDAO.save(auteurs);

			connection.commit();

		} catch (SQLException | DAOException e) {
			throw new ServiceException(e.getMessage(), e.getCause());

		}		return auteurs;
	}

	@Override
	public void remove(Auteurs auteurs) throws ServiceException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Auteurs> findAll() throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

}
