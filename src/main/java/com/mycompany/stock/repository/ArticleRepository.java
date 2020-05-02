package com.mycompany.stock.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mycompany.stock.entities.Article;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long>{

	
}
