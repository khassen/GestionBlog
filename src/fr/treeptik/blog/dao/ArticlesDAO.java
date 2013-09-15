package fr.treeptik.blog.dao;

import java.util.List;

import fr.treeptik.blog.Exception.DAOException;
import fr.treeptik.blog.model.Articles;

public interface ArticlesDAO {
	
	Articles save(Articles articles) throws DAOException;
    void remove(Articles articles) throws DAOException;
    List<Articles> findAll() throws DAOException;
}
