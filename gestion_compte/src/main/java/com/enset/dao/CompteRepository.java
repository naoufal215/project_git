package com.enset.dao;

import com.enset.entities.Compte;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by naoufal on 22/02/2017.
 */
public interface CompteRepository extends JpaRepository<Compte,String>{
}
