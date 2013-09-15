package fr.treeptik.blog.runtime;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import fr.treeptik.blog.Exception.ServiceException;
import fr.treeptik.blog.model.Articles;
import fr.treeptik.blog.model.Auteurs;
import fr.treeptik.blog.model.Categories;
import fr.treeptik.blog.service.ArticlesService;
import fr.treeptik.blog.service.AuteursService;
import fr.treeptik.blog.service.CategoriesService;

public class Main {

	public static void main(String[] args) {

//		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
//				"applicationContext.xml");
//
//		CategoriesService categoriesService = context
//				.getBean(CategoriesService.class);
//
//		AuteursService auteursService = context.getBean(AuteursService.class);
//		
//		ArticlesService articlesService = context.getBean(ArticlesService.class);

		// Save Categories

		// Categories categories = new Categories(null, "cat1", "url1");
		//
		//
		// try {
		// categoriesService.save(categories);
		// System.out.println("cat_id :" +categories.getCatId());
		// } catch (ServiceException e) {
		// e.printStackTrace();
		//
		// }

		// Remove Categories

		// Categories categories = new Categories();
		// categories.setCatId(2);
		// try {
		// categoriesService.remove(categories);
		// System.out.println(categories.getCatId());
		// } catch (ServiceException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }

		// FindAllCategories

		// List<Categories> listCategories = new ArrayList<>();
		// try {
		// listCategories = categoriesService.findAll();
		// for (Categories categories : listCategories) {
		//
		// System.out.println(categories.getCatId()+"***"+categories.getCatName());
		//
		// }
		// } catch (ServiceException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }

		// Save Auteurs

		// Auteurs auteurs = new Auteurs(null, "autn1", "autp1", "aut1Url",
		// "aut1@yahoo.com");
		//
		// try {
		// auteursService.save(auteurs);
		// System.out.println("aut_id :" + auteurs.getAutNom());
		// } catch (ServiceException e) {
		// e.printStackTrace();
		//
		// }

		// Save articles
//		
//		Categories categories = new Categories();
//		categories.setCatId(3);
//		
//		Auteurs auteurs = new Auteurs();
//		auteurs.setAutId(1);
//		
//		String date = "2001-11-01";
//		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
//		java.util.Date d =  new java.util.Date();
//		
//		try {
//			d= formatter.parse(date);
//		} catch (ParseException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//		
//		java.sql.Date dateSQL = new java.sql.Date(d.getTime());
//		
//	    Articles articles = new Articles(null, "t4","ch2","c2",dateSQL,true,categories,auteurs);
//	    
//	    try {
//			articlesService.save(articles);
//			System.out.println("oo");
//		} catch (ServiceException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	    
//	
//		context.close();
}
}
