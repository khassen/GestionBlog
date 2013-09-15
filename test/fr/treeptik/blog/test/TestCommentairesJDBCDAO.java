package fr.treeptik.blog.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.treeptik.blog.Exception.ServiceException;
import fr.treeptik.blog.model.Articles;
import fr.treeptik.blog.model.Commentaires;
import fr.treeptik.blog.service.CommentairesService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class TestCommentairesJDBCDAO {

	@Autowired
	private CommentairesService commentairesService;

	// @Autowired
	// private CommentairesDAO commentairesDAO;

	@Test
	@Ignore
	public void testSaveCommentaires() {

		Articles articles = new Articles();
		articles.setArtId(1);

		String date = "2010-12-12";
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date d = new java.util.Date();
		try {
			d = format.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		java.sql.Date dateSql = new java.sql.Date(d.getTime());

		Commentaires commentaires = new Commentaires(null, "com1",
				"com1@yahoo.fr", "text1", dateSql, "o", articles);

		try {
			commentaires = commentairesService.save(commentaires);
			Assert.assertNotNull(commentaires.getComId());
			System.out.println(commentaires.getComId());

		} catch (ServiceException e) {
			Assert.fail(e.getMessage());
		}

	}

	@Test
	public void testSaveCommentairesXML() {
		try {
			String date = "2010-02-02";
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			java.util.Date d = new java.util.Date();

			d = format.parse(date);

			java.sql.Date dateSql = new java.sql.Date(d.getTime());

			Articles articles = new Articles();
			articles.setArtId(1);

			Commentaires commentaires = new Commentaires(null, "com2",
					"com2@gmail.fr", "text2", dateSql, "n", articles);

			commentaires = commentairesService.save(commentaires);
			Assert.assertNotNull(commentaires);
			System.out.println(commentaires.getComId());
		} catch (ParseException | ServiceException e) {
			Assert.fail(e.getMessage());
			e.printStackTrace();
		}

	}

}
