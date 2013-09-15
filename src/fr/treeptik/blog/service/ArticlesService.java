package fr.treeptik.blog.service;

import java.util.List;

import fr.treeptik.blog.Exception.ServiceException;
import fr.treeptik.blog.model.Articles;

public interface ArticlesService {
	

	Articles save(Articles articles) throws ServiceException;
    void remove(Articles articles) throws ServiceException;
    List<Articles> findAll() throws ServiceException;

}
