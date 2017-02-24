package com.enset.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

/**
 * Created by naoufal on 22/02/2017.
 */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type_compte",discriminatorType = DiscriminatorType.STRING,length = 2)
public abstract class Compte implements Serializable {
    @Id
    private String codeCompte;
    private Date dateCreation;
    private double sold;
    @ManyToOne()
    @JoinColumn(name = "code_client")
    private Client client;
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "compte")
    private Collection<Operation> operations;

    public Compte() {
    }

    public Compte(String codeCompte, Date dateCreation, double sold, Client client) {
        this.codeCompte = codeCompte;
        this.dateCreation = dateCreation;
        this.sold = sold;
        this.client = client;
    }

    public String getCodeCompte() {
        return codeCompte;
    }

    public void setCodeCompte(String codeCompte) {
        this.codeCompte = codeCompte;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public double getSold() {
        return sold;
    }

    public void setSold(double sold) {
        this.sold = sold;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Collection<Operation> getOperations() {
        return operations;
    }

    public void setOperations(Collection<Operation> operations) {
        this.operations = operations;
    }
}
