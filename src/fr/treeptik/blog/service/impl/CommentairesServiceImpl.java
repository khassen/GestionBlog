package fr.treeptik.blog.service.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import fr.treeptik.blog.Exception.DAOException;
import fr.treeptik.blog.Exception.ServiceException;
import fr.treeptik.blog.dao.CommentairesDAO;
import fr.treeptik.blog.model.Commentaires;
import fr.treeptik.blog.service.CommentairesService;
import fr.treeptik.blog.utils.AppMailSender;
import fr.treeptik.blog.utils.JDBCUtils;

@Service
public class CommentairesServiceImpl implements CommentairesService {

	@Autowired private AppMailSender appMailSender;
	
	@Autowired
	@Qualifier("factoryCommentairesDAO")
	 private CommentairesDAO commentairesDAO;
	
//	@Autowired
//	@Qualifier("commentairesXMLDAO")
//	private CommentairesDAO commentairesDAO1;
	
	@Autowired
	private JDBCUtils jDBCUtils;

	@Override
	public Commentaires save(Commentaires commentaires) throws ServiceException {

		try {
			Connection connection = jDBCUtils.getConnection();
			
			commentaires = commentairesDAO.save(commentaires);
			
			connection.commit();
			appMailSender.sendEmail("khelifi_hassen@yahoo.fr", "Ajout d'un commentaires", "commentaires");

		} catch (SQLException | DAOException e) {
			throw new ServiceException(e.getMessage(), e.getCause());
		}

		return commentaires;
	}

	
	
	
	@Override
	public void remove(Commentaires commentaires) throws ServiceException {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Commentaires> findAll() throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

}
