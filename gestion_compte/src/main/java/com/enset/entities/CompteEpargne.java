package com.enset.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.Date;

/**
 * Created by naoufal on 22/02/2017.
 */
@Entity
@DiscriminatorValue(value = "CE")
public class CompteEpargne extends Compte {
    private double taux;

    public double getTaux() {
        return taux;
    }

    public void setTaux(double taux) {
        this.taux = taux;
    }

    public CompteEpargne() {
    }

    public CompteEpargne(String codeCompte, Date dateCreation, double sold, Client client, double taux) {
        super(codeCompte, dateCreation, sold, client);
        this.taux = taux;
    }
}
