package fr.treeptik.blog.service;

import java.util.List;

import fr.treeptik.blog.Exception.ServiceException;
import fr.treeptik.blog.model.Auteurs;

public interface AuteursService {
	

	Auteurs save(Auteurs auteurs) throws ServiceException;
	void remove(Auteurs auteurs) throws ServiceException;
	List<Auteurs> findAll() throws ServiceException;

}
