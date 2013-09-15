package fr.treeptik.blog.dao.impl;

import java.io.File;

import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.springframework.stereotype.Repository;

import fr.treeptik.blog.Exception.DAOException;
import fr.treeptik.blog.dao.CommentairesDAO;
import fr.treeptik.blog.model.Commentaires;
import fr.treeptik.blog.xml.ListCommentaires;

@Repository
public class CommentairesXMLDAO implements CommentairesDAO {



	@Override
	public Commentaires save(Commentaires commentaires) throws DAOException {
		try {
			JAXBContext context = JAXBContext
					.newInstance("fr.treeptik.blog.xml");
			Unmarshaller unmarshaller = context.createUnmarshaller();
			ListCommentaires listCommentaires = (ListCommentaires) unmarshaller
					.unmarshal(new File("commentaires.xml"));
		
			fr.treeptik.blog.xml.Commentaires commentairesA = new fr.treeptik.blog.xml.Commentaires();
			commentairesA.setComId(commentaires.getComId());
			commentairesA.setComNom(commentaires.getComNom());
			commentairesA.setComEmail(commentaires.getcomEmail());
			commentaires.setComText(commentaires.getComText());
			commentaires.setComDate(commentaires.getComDate());
			commentaires.setComValidation(commentaires.getComValidation());
			
			fr.treeptik.blog.xml.Articles articles = new fr.treeptik.blog.xml.Articles();
			articles.setArtId(commentaires.getArticles().getArtId());
			
			commentairesA.setArticles(articles);
			
			
			
			Marshaller marshaller = context.createMarshaller();
			listCommentaires.getCommentaires().add(commentairesA)	;
			marshaller.marshal(listCommentaires, new File("commentaires.xml"));

		
			

		} catch (JAXBException e) {
			throw new DAOException(e.getMessage(), e.getCause());
		}

		return commentaires;
	}

	@Override
	public void remove(Commentaires commentaires) throws DAOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Commentaires> findAll() throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}


}
