package be.bzk.boerzoektklant.adapters;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.Console;
import java.util.ArrayList;

import be.bzk.boerzoektklant.R;
import be.bzk.boerzoektklant.data.models.Business;
import be.bzk.boerzoektklant.data.models.Category;


public class BusinessAdapter extends ArrayAdapter<Business> {
    private ArrayList<Business> singelItem;
    private LayoutInflater thisInflater;

    public BusinessAdapter(Context context, ArrayList<Business> businesses){
        super(context, 0, businesses);
        singelItem = businesses;
        thisInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return singelItem.size();
    }

    @Override
    public Business getItem(int position) {
        return singelItem.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Business business = getItem(position);


        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.fragment_business, parent, false);
        }
        // Lookup view for data population
        ImageView image = convertView.findViewById(R.id.image);
        TextView title = convertView.findViewById(R.id.title);
        TextView excerpt = convertView.findViewById(R.id.excerpt);
        TextView categories = convertView.findViewById(R.id.categories);


        // Populate the data into the template view using the data object
        //image.setImageBitmap(business.getImageBitmap());
        title.setText(business.getTitle());
        excerpt.setText(business.getExcerpt());

        String categoriesString = "";

        if(business.getCategories() != null){
            for(Category category : business.getCategories()){
                categoriesString += category.getName() + " | ";
            }
            if(!categoriesString.equals("")){
                categoriesString = categoriesString.substring(0, categoriesString.length() -2);
            }
        }

        categories.setText(categoriesString);

        // Return the completed view to render on screen
        return convertView;
    }
}
