package fr.treeptik.blog.dao;

import java.util.List;

import fr.treeptik.blog.Exception.DAOException;
import fr.treeptik.blog.model.Auteurs;

public interface AuteursDAO {
	
	Auteurs save(Auteurs auteurs) throws DAOException;
	void remove(Auteurs auteurs) throws DAOException;
	List<Auteurs> findAll() throws DAOException;

}
