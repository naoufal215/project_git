package com.enset.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.Date;

/**
 * Created by naoufal on 22/02/2017.
 */
@Entity
@DiscriminatorValue(value = "R")
public class Retrait extends Operation {
    public Retrait() {
    }

    public Retrait( Date dateOperation, double montant, Compte compte) {
        super( dateOperation, montant, compte);
    }
}

