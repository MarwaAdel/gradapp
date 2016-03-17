package com.example.marwaadel.gradapp;

import android.app.Activity;
import android.view.View;
import android.widget.TextView;

import com.example.marwaadel.gradapp.model.Offer;
import com.firebase.client.Query;
import com.firebase.ui.FirebaseListAdapter;

/**
 * Created by Marwa Adel on 3/15/2016.
 */
public class offerAdapter extends FirebaseListAdapter<Offer> {
    public offerAdapter(Activity activity, Class<Offer> modelClass, int modelLayout, Query ref) {
        super(activity, modelClass, modelLayout, ref);
    }

    @Override
    protected void populateView(View v, Offer model) {
        TextView offerName=(TextView)v.findViewById(R.id.offerName);
        TextView offerDescription=(TextView)v.findViewById(R.id.offerDescription);


        offerName.setText(model.getOfferName());
        offerDescription.setText(model.getOfferDescription());
    }
}
