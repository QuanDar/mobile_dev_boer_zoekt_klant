package be.bzk.boerzoektklant.activities;

import android.content.Intent;
import android.net.Uri;
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

public class FarmerActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    TextView adressTextView;
    TextView ratingTextView;

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

        TextView mTextViewThird = (TextView) findViewById(R.id.bulletTextView);
        mTextViewThird.setText(Html.fromHtml(htmlString));

        TextView phoneNumberTextView = (TextView) findViewById(R.id.phoneNumberTextView);
        phoneNumberTextView.setText("Telefoonnummer: +32 42463463");

        adressTextView = (TextView) findViewById(R.id.adressTextView);
        adressTextView.setText("Address: 3500 Hasselt | Elfde-Liniestraat 23");

        ratingTextView = (TextView) findViewById(R.id.ratingTextView);
        ratingTextView.setText("Rating: ");
        ratingCalc(4);

    }

    public void ratingCalc(int rating){
        switch (rating){
            case 1:
                ratingTextView.append("★");
                break;
            case 2:
                ratingTextView.append("★★");
                break;
            case 3:
                ratingTextView.append("★★★");
                break;
            case 4:
                ratingTextView.append("★★★★");
                break;
            case 5:
                ratingTextView.append("★★★★★");
                break;
        }
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
