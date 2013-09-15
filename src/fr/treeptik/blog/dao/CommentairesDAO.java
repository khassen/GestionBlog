package fr.treeptik.blog.dao;

import java.util.List;

import fr.treeptik.blog.Exception.DAOException;
import fr.treeptik.blog.model.Commentaires;

public interface CommentairesDAO {
	
	Commentaires save(Commentaires commentaires) throws DAOException;
	void remove(Commentaires commentaires) throws DAOException;
	List<Commentaires> findAll() throws DAOException;

}
