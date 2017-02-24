package com.enset.dao;

import com.enset.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by naoufal on 22/02/2017.
 */
public interface ClientRepository extends JpaRepository<Client,Long> {
}
