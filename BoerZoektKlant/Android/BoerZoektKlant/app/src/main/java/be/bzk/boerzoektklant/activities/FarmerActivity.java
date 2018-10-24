package be.bzk.boerzoektklant.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.widget.RatingBar;
import android.widget.TextView;


import be.bzk.boerzoektklant.R;

public class FarmerActivity extends AppCompatActivity {

    public TextView adressTextView;
    public RatingBar ratingBar;
    public  TextView ratingText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_farmer);

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
}
