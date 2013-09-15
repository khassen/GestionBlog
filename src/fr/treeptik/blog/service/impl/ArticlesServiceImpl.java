package fr.treeptik.blog.service.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.treeptik.blog.Exception.DAOException;
import fr.treeptik.blog.Exception.ServiceException;
import fr.treeptik.blog.dao.ArticlesDAO;
import fr.treeptik.blog.model.Articles;
import fr.treeptik.blog.service.ArticlesService;
import fr.treeptik.blog.utils.AppMailSender;
import fr.treeptik.blog.utils.JDBCUtils;



@Service
public class ArticlesServiceImpl implements ArticlesService{

	@Autowired private ArticlesDAO articlesDAO;
	@Autowired private JDBCUtils jDBCUtils;

	
	@Override
	public Articles save(Articles articles)
			throws ServiceException {
		
		try {
			Connection connection = jDBCUtils.getConnection();

			articles = articlesDAO.save(articles);

			connection.commit();
			
		} catch (SQLException | DAOException e) {
			throw new ServiceException(e.getMessage(), e.getCause());

		}
		
		return articles;
	}

	@Override
	public void remove(Articles articles) throws ServiceException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Articles> findAll() throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

}
