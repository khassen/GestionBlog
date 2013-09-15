package fr.treeptik.blog.service.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.treeptik.blog.Exception.DAOException;
import fr.treeptik.blog.Exception.ServiceException;
import fr.treeptik.blog.dao.CategoriesDAO;
import fr.treeptik.blog.model.Categories;
import fr.treeptik.blog.service.CategoriesService;
import fr.treeptik.blog.utils.JDBCUtils;

@Service
public class CategoriesServiceImpl implements CategoriesService {

	@Autowired
	private CategoriesDAO categoriesDAO;
	@Autowired
	private JDBCUtils jDBCUtils;

	@Override
	public Categories save(Categories categories) throws ServiceException {

		try {
			Connection connection = jDBCUtils.getConnection();

			categories = categoriesDAO.save(categories);

			connection.commit();

		} catch (SQLException | DAOException e) {
			throw new ServiceException(e.getMessage(), e.getCause());

		}

		return categories;
	}

	@Override
	public int remove(Categories categories) throws ServiceException {
int nb;
		try {
			Connection connection = jDBCUtils.getConnection();

			nb = categoriesDAO.remove(categories);

			//connection.commit();

		} catch ( DAOException e) {
			throw new ServiceException(e.getMessage(), e.getCause());

		}
return nb;
	}

	@Override
	public List<Categories> findAll() throws ServiceException {
		List<Categories> listCategories = new ArrayList<>();
		try {
			Connection connection = jDBCUtils.getConnection();

			listCategories = categoriesDAO.findAll();

			connection.commit();

		} catch (SQLException | DAOException e) {
			throw new ServiceException(e.getMessage(), e.getCause());

		}
		return listCategories;
	}

}
