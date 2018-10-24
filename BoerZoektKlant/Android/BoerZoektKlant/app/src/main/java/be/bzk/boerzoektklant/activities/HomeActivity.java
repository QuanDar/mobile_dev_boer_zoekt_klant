package be.bzk.boerzoektklant.activities;

import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import be.bzk.boerzoektklant.R;
import be.bzk.boerzoektklant.adapters.BusinessAdapter;
import be.bzk.boerzoektklant.data.models.Business;
import be.bzk.boerzoektklant.data.models.Category;

public class HomeActivity extends AppCompatActivity {

    private BusinessAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // Construct the data source
        ArrayList<Business> businessArrayList = new ArrayList<Business>();
        // Create the adapter to convert the array to views
        adapter = new BusinessAdapter(this, businessArrayList);

        List<Category> list = new ArrayList<Category>();
        list.add(new Category(1, "eieren"));
        list.add(new Category(1, "kip"));

        this.addBussiness("Boer Jos", "Selder en knollen te koopdddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd", list);
        this.addBussiness("Boer Karel", "Selder en knollen te koop", list);
        this.addBussiness("Boer Jain", "Selder en knollen te koop", list);

    }

    public void addBussiness(String name, String excerpt, List<Category> categories) //Bitmap toevoegen?
    {
        Business newBusiness = new Business();
        newBusiness.setTitle(name);
        newBusiness.setExcerpt(excerpt);
        newBusiness.setCategories(categories);
        newBusiness.setImageBitmap(BitmapFactory.decodeResource(this.getResources(), R.drawable.user));
        adapter.add(newBusiness);

        // Attach the adapter to a ListView
        ListView listView = (ListView) findViewById(R.id.farmerList);
        listView.setAdapter(adapter);
    }
}