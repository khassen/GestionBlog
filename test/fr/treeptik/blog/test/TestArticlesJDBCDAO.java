package fr.treeptik.blog.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.treeptik.blog.Exception.DAOException;
import fr.treeptik.blog.dao.ArticlesDAO;
import fr.treeptik.blog.model.Articles;
import fr.treeptik.blog.model.Auteurs;
import fr.treeptik.blog.model.Categories;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class TestArticlesJDBCDAO {

	@Autowired
	private ArticlesDAO articlesJDBCDAOImpl;
	
//	@Autowired
//	private ArticlesService articlesService;

	@Test
	public void testSaveArticles() {

		Categories categories = new Categories();
		categories.setCatId(4);

		Auteurs auteurs = new Auteurs();
		auteurs.setAutId(1);

		String date = "2010-11-01";
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date d = new java.util.Date();

		try {
			d = format.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		java.sql.Date dateSQL = new java.sql.Date(d.getTime());

		Articles articles = new Articles(null, "t1", "ch1", "c1", dateSQL,
				true, categories, auteurs);

		try {
			articles = articlesJDBCDAOImpl.save(articles);
			Assert.assertNotNull(articles.getArtId());
			System.out.println(articles.getArtContenu());
		} catch (DAOException e) {
			Assert.fail(e.getMessage());
		}

	}

}
