package com.example.marwaadel.gradapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import com.estimote.sdk.Beacon;
import com.estimote.sdk.BeaconManager;
import com.estimote.sdk.Region;
import com.example.marwaadel.gradapp.model.Offer;
import com.example.marwaadel.gradapp.utils.Constants;
import com.firebase.client.Firebase;

import java.util.List;
import java.util.UUID;

public class MainActivity extends AppCompatActivity {
    private BeaconManager beaconManager;
    private offerAdapter mOfferListAdapter;
    ListView listview;
    Firebase refListName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listview = (ListView) findViewById(R.id.list_view_offer_lists);
        refListName = new Firebase(Constants.FIREBASE_URL_ACTIVE_LIST);
        mOfferListAdapter = new offerAdapter(this, Offer.class, R.layout.list_item, refListName);
        beaconManager = new BeaconManager(getApplicationContext());
        beaconManager.connect(new BeaconManager.ServiceReadyCallback() {
            @Override
            public void onServiceReady() {
                beaconManager.startMonitoring(new Region
                        (
                                "monitored region",
                                UUID.fromString("77b3670e-454b-434d-8445-787cc0e1ffb8"),
                                19755, 3891));
            }
        });

        beaconManager.setMonitoringListener(new BeaconManager.MonitoringListener() {

            @Override
            public void onEnteredRegion(Region region, List<Beacon> list) {

                      /*write data*/
//        Firebase listsRef = new Firebase(Constants.FIREBASE_URL).child("OfferList");
//                Firebase newListRef = listsRef.push();
//
//                final String listId = newListRef.getKey();
//
//                Offer NewOffer = new Offer("okksg", "ppp");
//                newListRef.setValue(NewOffer);
          /*read data*/
                Toast.makeText(getApplicationContext(), "enter", Toast.LENGTH_LONG).show();
                listview.setAdapter(mOfferListAdapter);

            }

            @Override
            public void onExitedRegion(Region region) {
                Toast.makeText(getApplicationContext(), "Exit", Toast.LENGTH_LONG).show();


            }
        });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mOfferListAdapter.cleanup();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
