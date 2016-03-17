package com.example.marwaadel.gradapp.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by Marwa Adel on 3/15/2016.
 */
@JsonIgnoreProperties(ignoreUnknown=true)
public class Offer {
    private String offerName;
    private String offerDescription;

     public Offer(){}
    public Offer(String offerName, String offerDescription) {
        this.offerName = offerName;
        this.offerDescription = offerDescription;
    }

    public String getOfferName() {
        return offerName;
    }

    public String getOfferDescription() {
        return offerDescription;
    }
}
