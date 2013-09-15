package fr.treeptik.blog.service;

import java.util.List;

import fr.treeptik.blog.Exception.ServiceException;
import fr.treeptik.blog.model.Categories;

public interface CategoriesService {
	
	Categories save(Categories categories) throws ServiceException;
	int remove(Categories categories) throws ServiceException;
	List<Categories> findAll() throws ServiceException;

}
