package be.bzk.boerzoektklant.activities;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import be.bzk.boerzoektklant.R;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    TextView adressTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_farmer);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        String htmlString = "• First item €<br/>"+
                "• Second item €<br/>"+
                "• Third item €";

        TextView mTextViewThird = (TextView) findViewById(R.id.bulletTextView);
        mTextViewThird.setText(Html.fromHtml(htmlString));

        TextView phoneNumberTextView = (TextView) findViewById(R.id.phoneNumberTextView);
        phoneNumberTextView.setText("+32 42463463");

        adressTextView = (TextView) findViewById(R.id.adressTextView);
        adressTextView.setText("3500 Hasselt | Elfde-Liniestraat 23");
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng adress = new LatLng(-50.937154, 5.348635);
        mMap.addMarker(new MarkerOptions().position(adress).title("Super ultra vlees boer"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(adress));
    }



}
