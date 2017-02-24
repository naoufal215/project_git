package com.enset.metier;

import com.enset.dao.CompteRepository;
import com.enset.dao.OperationRepository;
import com.enset.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * Created by naoufal on 22/02/2017.
 */
@Service
@Transactional
public class BanqueMetierImpl implements  IBanqueMetier {

    @Autowired
    private CompteRepository compteRepository;
    @Autowired
    private OperationRepository operationRepository;


    @Override
    public Compte consulterCompte(String codeCompte) {
        Compte cp=compteRepository.findOne(codeCompte);
        if(cp==null) throw new RuntimeException("Compte introuvable");
        return cp;

    }

    @Override
    public void verser(String codeCompte, double montant) {
        Compte cp=consulterCompte(codeCompte);
        Versement v=new Versement(new Date(),montant,cp);
        operationRepository.save(v);
        cp.setSold(cp.getSold()+montant);
        compteRepository.save(cp);

    }

    @Override
    public void retirer(String codeCompte, double montant) {
        Compte cp=consulterCompte(codeCompte);
        double facilitesCaisee=0;
        if(cp instanceof CompteCourant)
            facilitesCaisee=((CompteCourant)cp).getDicouvert();
        if(cp.getSold()+facilitesCaisee<montant)
            throw new RuntimeException("solde insuffisant");
        Retrait r=new Retrait(new Date(),montant,cp);
        operationRepository.save(r);
        cp.setSold(cp.getSold()-montant);
        compteRepository.save(cp);
    }

    @Override
    public void virement(String code1, String code2, double montant) {
        if(consulterCompte(code2)==null) throw
                new RuntimeException("ce code de compte "+code2+" n'est pas valide");
        else
        if(code1.equals(code2)) throw
                new RuntimeException("impossible de faire un virement sur le meme compte "+code1);
        else{
            retirer(code1,montant);
            verser(code2,montant);
        }


    }

    @Override
    public Page<Operation> listOperation(String codeCompte, int page, int size) {
        return operationRepository.getOperations(codeCompte,new PageRequest(page,size));
    }
}
