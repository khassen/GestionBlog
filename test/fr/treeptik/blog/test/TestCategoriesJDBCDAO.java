package fr.treeptik.blog.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.treeptik.blog.Exception.DAOException;
import fr.treeptik.blog.Exception.ServiceException;
import fr.treeptik.blog.dao.CategoriesDAO;
import fr.treeptik.blog.model.Categories;
import fr.treeptik.blog.service.CategoriesService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class TestCategoriesJDBCDAO {

	@Autowired
	private CategoriesService categoriesService;
	
	@Autowired
	private CategoriesDAO CategoriesDAOImpl;

	 @Test
	@Ignore
	 public void testSaveCategories() {
	 try {
	 Categories categories = categoriesService.save(new Categories(null,
	 "nom4", "url4"));
	 Assert.assertNotNull(categories.getCatId());
	 System.out.println(categories.getCatName());
	 } catch (ServiceException e) {
	 Assert.fail(e.getMessage());
	 }
	
	 }

	@Test
	@Ignore
	public void testRemoveCategories() {
		Categories categories = new Categories();
		categories.setCatId(4);
		try {
			int i=categoriesService.remove(categories);
			Assert.assertNotNull(i);
		} catch (ServiceException e) {
			Assert.fail(e.getMessage());
		}
	}
	@Test
	@Ignore
	public void testFindAll(){
		
		List<Categories> listCategories = new ArrayList<>();
	
			try {
				listCategories = CategoriesDAOImpl.findAll();
				Assert.assertNotNull(listCategories.size());
				System.out.println(listCategories.size());
			} catch (DAOException e) {
				Assert.fail(e.getMessage());
			}
			
	
		
	}

}
