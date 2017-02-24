package com.enset.dao;

import com.enset.entities.Operation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Created by naoufal on 22/02/2017.
 */
public interface OperationRepository extends JpaRepository<Operation,Long> {
    @Query("select o from Operation o where o.compte.codeCompte= :x order by o.dateOperation desc ")
    Page<Operation> getOperations(@Param("x") String codeCompte, Pageable pageable);
}
