package com.mycompany.stock.service;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.stock.entities.Article;
import com.mycompany.stock.exception.NotFoundException;
import com.mycompany.stock.repository.ArticleRepository;



@Service
public class ArticleService {
	
	@Autowired
	ArticleRepository articleRepository;
	
	
	public List<Article> getAll(){
		return articleRepository.findAll();
	}
	
	
	public Article save(Article article) {
		return articleRepository.save(article);
	}
	
	public Article getById(Long id) {
		return articleRepository.findById(id).orElseThrow(()-> new NotFoundException("Article not found !"));
	}
	
	public Article update(Long id,Article article) {
		
		Article articleUpdated = new Article();
		
		Optional<Article> articleFound = articleRepository.findById(id);
		if(articleFound.isPresent()) {
			articleUpdated = articleFound.get();
			articleUpdated.setLibelle(article.getLibelle());
			articleUpdated.setCode_b(article.getCode_b());
			articleUpdated.setCodeCateg(article.getCodeCateg());
			articleUpdated.setCodeScateg(article.getCodeScateg());
			articleUpdated.setPa(article.getPa());
			articleUpdated.setPv(article.getPv());
			articleUpdated.setTva(article.getTva());
			articleUpdated.setStkinit(article.getStkinit());
			articleUpdated.setStock(article.getStock());
		}else {
			throw new NotFoundException("Article not found !");
		}
		return articleRepository.save(articleUpdated);
	}
	
	public Map<String,Boolean> delete(Long id){
		
	 Article articleFound = articleRepository
				.findById(id).orElseThrow(() -> new NotFoundException("Article not found !"));
		
		articleRepository.delete(articleFound);
		Map<String,Boolean> responce = new HashMap<>();
		responce.put("deleted", Boolean.TRUE);
		return responce;
		
	}
	

}
