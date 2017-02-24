package com.enset.metier;

import com.enset.entities.Compte;
import com.enset.entities.Operation;
import org.springframework.data.domain.Page;

/**
 * Created by naoufal on 22/02/2017.
 */
public interface IBanqueMetier {
    public Compte consulterCompte(String codeCompte);
    public void verser(String codeCompte,double montant);
    public void retirer(String codeCompte,double montant);
    public void virement(String code1, String code2, double montant);
    public Page<Operation> listOperation(String codeCompte, int page,int saze);

}
