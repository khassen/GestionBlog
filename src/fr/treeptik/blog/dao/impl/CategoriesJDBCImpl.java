package fr.treeptik.blog.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.treeptik.blog.Exception.DAOException;
import fr.treeptik.blog.dao.CategoriesDAO;
import fr.treeptik.blog.model.Categories;
import fr.treeptik.blog.utils.JDBCUtils;

@Repository
public class CategoriesJDBCImpl implements CategoriesDAO {

	// @Autowired
	// private DataSource dataSource;
	@Autowired
	private JDBCUtils jDBCUtils;

	@Override
	public Categories save(Categories categories) throws DAOException {

		try {
			Connection connection = jDBCUtils.getConnection();

			PreparedStatement preparedStatement = connection.prepareStatement(
					"insert into categories(cat_name,cat_url) values (?,?)",
					PreparedStatement.RETURN_GENERATED_KEYS);

			preparedStatement.setString(1, categories.getCatName());
			preparedStatement.setString(2, categories.getCatUrl());

			preparedStatement.executeUpdate();

			ResultSet resultSet = preparedStatement.getGeneratedKeys();
			resultSet.next();

			categories.setCatId(resultSet.getInt(1));

		} catch (SQLException e) {

			throw new DAOException(e.getMessage(), e.getCause());
		}
		return categories;
	}

	@Override
	public int remove(Categories categories) throws DAOException {
		int nbRemove;
		try {
			Connection connection = jDBCUtils.getConnection();

			PreparedStatement preparedStatement = connection
					.prepareStatement("delete from categories where cat_id = ?");

			preparedStatement.setInt(1, categories.getCatId());

			nbRemove = preparedStatement.executeUpdate();

			if (nbRemove != 1) {
				System.out.println("pas de suppression");
			}

		} catch (SQLException e) {

			throw new DAOException(e.getMessage(), e.getCause());
		}

		return nbRemove;
	}

	@Override
	public List<Categories> findAll() throws DAOException {

		List<Categories> listCategories = new ArrayList<>();
		Connection connection = jDBCUtils.getConnection();

		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("select * from categories");

			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.afterLast();

			while (resultSet.previous()) {
				Categories categories = new Categories();

				categories.setCatId(resultSet.getInt("cat_id"));
				categories.setCatName(resultSet.getString("cat_name"));
				categories.setCatUrl(resultSet.getString("cat_url"));

				listCategories.add(categories);

			}
		} catch (SQLException e) {
			throw new DAOException(e.getMessage(), e.getCause());
		}

		return listCategories;
	}

}
