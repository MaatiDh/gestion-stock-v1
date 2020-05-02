package com.mycompany.stock.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mycompany.stock.entities.Article;
import com.mycompany.stock.service.ArticleService;


import lombok.extern.log4j.Log4j2;


@Log4j2
@CrossOrigin(origins = "http://http://localhost:4200")
@RestController
@RequestMapping("/articles")
public class ArticleController {
	
	@Autowired
	ArticleService articleService;

	@GetMapping
	public List<Article> getAllArticles(){

		return articleService.getAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Article> getAllArticleById(@PathVariable Long id){

		return ResponseEntity.status(HttpStatus.OK).body(articleService.getById(id));
	}
	
	
	@PostMapping
    public ResponseEntity<Article> saveArticle(@RequestBody Article article){

	     return  ResponseEntity.status(HttpStatus.CREATED).body(articleService.save(article));
		
	}
	
	@PutMapping("/{id}")
    public ResponseEntity<Article> updateArticle(@PathVariable Long id,@RequestBody Article article){
	     return ResponseEntity.status(HttpStatus.OK).body(articleService.update(id, article));	
	}
	
	@DeleteMapping("/delete/{id}")
	 public ResponseEntity<Map<String,Boolean>> deleteArticle(@PathVariable Long id){
	     return ResponseEntity.status(HttpStatus.OK).body(articleService.delete(id));	
	}
	
	
	
}
