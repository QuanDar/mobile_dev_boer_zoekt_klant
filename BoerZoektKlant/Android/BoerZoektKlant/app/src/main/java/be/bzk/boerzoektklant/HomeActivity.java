package be.bzk.boerzoektklant;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    private void generateCompanyItem(){

        LinearLayout baseLinearLayout = findViewById(R.id.baseLinearLayout);

        LinearLayout companyItemHorizontalLinearLayout = new LinearLayout(this);
        companyItemHorizontalLinearLayout.setOrientation(LinearLayout.HORIZONTAL);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 100);
        companyItemHorizontalLinearLayout.setLayoutParams(params);
        companyItemHorizontalLinearLayout.setId(R.id.companyItemHorizontalLinearLayout);

        baseLinearLayout.addView(companyItemHorizontalLinearLayout);

        ImageView companyItemImageView = new ImageView(this);


    }

}
