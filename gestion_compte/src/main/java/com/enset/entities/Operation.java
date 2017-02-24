package com.enset.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by naoufal on 22/02/2017.
 */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type_operation",discriminatorType = DiscriminatorType.STRING,length = 1)
public abstract class Operation implements Serializable {
    @Id
    @GeneratedValue
    private Long codeOperation;
    private Date dateOperation;
    private double montant;
    @ManyToOne()
    @JoinColumn(name = "code_compte")
    private Compte compte;

    public Operation() {
    }

    public Operation(Date dateOperation, double montant, Compte compte) {
        this.dateOperation = dateOperation;
        this.montant = montant;
        this.compte = compte;
    }

    public Long getCodeOperation() {
        return codeOperation;
    }

    public void setCodeOperation(Long codeOperation) {
        this.codeOperation = codeOperation;
    }

    public Date getDateOperation() {
        return dateOperation;
    }

    public void setDateOperation(Date dateOperation) {
        this.dateOperation = dateOperation;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public Compte getCompte() {
        return compte;
    }

    public void setCompte(Compte compte) {
        this.compte = compte;
    }
}
