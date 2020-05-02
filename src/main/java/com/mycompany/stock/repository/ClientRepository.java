package com.mycompany.stock.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mycompany.stock.entities.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long>{

}
