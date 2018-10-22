package be.bzk.boerzoektklant.activities;

import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import be.bzk.boerzoektklant.R;

public class FarmerActivity extends FragmentActivity implements OnMapReadyCallback {

    public GoogleMap mMap;
    public TextView adressTextView;
    public RatingBar ratingBar;
    public  TextView ratingText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_farmer);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        String htmlString = "Te bieden:<br/>" +
                "• Lekkere grote vleeskip<br/>"+
                "• Lekkere grote vleeskoe<br/>"+
                "• En schaap, ook lekker veel groot vlees";

        TextView mTextViewThird = findViewById(R.id.bulletTextView);
        mTextViewThird.setText(Html.fromHtml(htmlString));

        TextView phoneNumberTextView = findViewById(R.id.phoneNumberTextView);
        phoneNumberTextView.setText("Telefoonnummer: +32 42463463");

        adressTextView = findViewById(R.id.adressTextView);
        adressTextView.setText("Address: 3500 Hasselt | Elfde-Liniestraat 23");

        progressBarSetup();

    }


    protected void progressBarSetup() {

        ratingBar = findViewById(R.id.ratingBar);
        ratingText = findViewById(R.id.ratingText);

        ratingBar.setOnRatingBarChangeListener((ratingBar, rating, fromUser) -> ratingText.setText("Rating: " + rating));
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

        // Marker map
        LatLng adress = new LatLng(50.937154, 5.348635);
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(adress,14));
        mMap.addMarker(new MarkerOptions().position(adress).title("Super ultra vlees boer"));
    }

    //set location and make textview clickable to maps
    public void adressTextViewButtonClick(View view) {
        String latitude = "50.938207";
        String longitude = "5.348064";
        Uri gmmIntentUri = Uri.parse("geo:" + latitude + "," + longitude + "?q=Hasselt Elfde-Liniestraat 23");
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");
        startActivity(mapIntent);
    }
}
