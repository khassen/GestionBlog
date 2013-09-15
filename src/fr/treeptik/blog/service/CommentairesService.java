package fr.treeptik.blog.service;

import java.util.List;

import fr.treeptik.blog.Exception.ServiceException;
import fr.treeptik.blog.model.Commentaires;

public interface CommentairesService {
	
	Commentaires save(Commentaires commentaires) throws ServiceException;
	void remove(Commentaires commentaires) throws ServiceException;
	List<Commentaires> findAll() throws ServiceException;

}
