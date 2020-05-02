package com.mycompany.stock.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mycompany.stock.entities.Scategorie;

@Repository
public interface ScategorieRepository extends JpaRepository<Scategorie, Long>{

}
