package com.enset.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.Date;

/**
 * Created by naoufal on 22/02/2017.
 */
@Entity
@DiscriminatorValue(value = "CC")
public class CompteCourant extends Compte {
    private double dicouvert;

    public double getDicouvert() {
        return dicouvert;
    }

    public void setDicouvert(double dicouvert) {
        this.dicouvert = dicouvert;
    }

    public CompteCourant() {
    }

    public CompteCourant(String codeCompte, Date dateCreation, double sold, Client client, double dicouvert) {
        super(codeCompte, dateCreation, sold, client);
        this.dicouvert = dicouvert;
    }

}
