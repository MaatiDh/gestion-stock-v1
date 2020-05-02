package com.mycompany.stock.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mycompany.stock.entities.Categorie;

@Repository
public interface CategorieRepository extends JpaRepository<Categorie, Long>{

}
