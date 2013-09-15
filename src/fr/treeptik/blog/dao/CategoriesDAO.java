package fr.treeptik.blog.dao;

import java.util.List;

import fr.treeptik.blog.Exception.DAOException;
import fr.treeptik.blog.model.Categories;

public interface CategoriesDAO {
	
	Categories save(Categories categories) throws DAOException;
	int remove(Categories categories) throws DAOException;
	List<Categories> findAll() throws DAOException;

}
