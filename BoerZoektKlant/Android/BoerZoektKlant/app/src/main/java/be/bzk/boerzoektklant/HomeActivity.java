package be.bzk.boerzoektklant;

import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;

import be.bzk.boerzoektklant.adapters.BusinessAdapter;
import be.bzk.boerzoektklant.models.Business;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // Construct the data source
        ArrayList<Business> businessArrayList = new ArrayList<Business>();
// Create the adapter to convert the array to views
        BusinessAdapter adapter = new BusinessAdapter(this, businessArrayList);

        Business newBusiness = new Business();
        newBusiness.setTitle( "This is a title");
        newBusiness.setExcerpt("This is an introduction");
        newBusiness.setImageBitmap(BitmapFactory.decodeResource(this.getResources(), R.drawable.user));
        adapter.add(newBusiness);

// Attach the adapter to a ListView
        ListView listView = (ListView) findViewById(R.id.farmerList);
        listView.setAdapter(adapter);
    }

//    private void addBoerItem(Bitmap bitmap, String name, String description, String category){
//        BoerListItem boerItem = new BoerListItem();
//
//        boerItem.setImagePath(bitmap);
//        boerItem.setName(name);
//        boerItem.setDescription(description);
//        boerItem.setCategory(category);
//
//        boerListItems.add(boerItem);
//    }
//
//    private void addArrayToList(){
//        if (boerListItems != null && boerListItems.size() > 0)
//            boerListView.setAdapter(new ListCustomAdapter(getApplicationContext(), boerListItems));
//    }
}
