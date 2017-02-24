package com.enset.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.Date;

/**
 * Created by naoufal on 22/02/2017.
 */
@Entity
@DiscriminatorValue(value = "V")
public class Versement  extends Operation{
    public Versement() {
    }

    public Versement( Date dateOperation, double montant, Compte compte) {
        super(dateOperation, montant, compte);
    }

}
