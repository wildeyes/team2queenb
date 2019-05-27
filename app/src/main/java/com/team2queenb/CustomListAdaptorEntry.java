package com.team2queenb;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.team2queenb.app.R;

public class CustomListAdaptorEntry extends ArrayAdapter {


        //to reference the Activity
        private  Activity context;

        //to store the images
        private  Integer[] imageIDarray;

        //to store the list of countries
        private  String[] nameArray;

        private  String [] Info;



        public CustomListAdaptorEntry(Activity context, String[] nameArrayParam, Integer[] imageIDArrayParam,String[] infoArrayParam) {

            super(context, R.layout.listview_row, nameArrayParam);

            this.context=context;
            this.imageIDarray = imageIDArrayParam;
            this.nameArray = nameArrayParam;
            this.Info= infoArrayParam;

        }

        public View getView(int position, View view, ViewGroup parent) {
            LayoutInflater inflater=context.getLayoutInflater();
            View rowView=inflater.inflate(R.layout.listview_row, null,true);

            //this code gets references to objects in the listview_row.xml file
            TextView nameTextField = (TextView) rowView.findViewById(R.id.nameTextViewID);
            TextView infoTextField = (TextView) rowView.findViewById(R.id.infoTextViewID);
            ImageView imageView = (ImageView) rowView.findViewById(R.id.imageView1ID);

            //this code sets the values of the objects to values from the arrays
            nameTextField.setText(nameArray[position]);
            imageView.setImageResource(imageIDarray[position]);

            return rowView;

        };
    }

