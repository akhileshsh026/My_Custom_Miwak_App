package com.example.android.miwok;

import android.app.Activity;
import android.content.Context;
import android.provider.UserDictionary;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Currency;

/**
 * Created by Akhileshsh026 on 28-02-2017.
 */

public class WordAdopter extends ArrayAdapter<Word> {

    private int McolourResourseid;
    private int Maudioid;


    public WordAdopter(Activity context, ArrayList<Word> words ,int ColourResourseId)
    {
        super(context,0,words);
        McolourResourseid =ColourResourseId;

    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView== null)
        {
            listItemView = LayoutInflater.from( getContext()).inflate(R.layout.list_item,parent,false);
        }

         Word currentword = getItem(position);

        TextView engwordTV= (TextView) listItemView.findViewById(R.id.textView1);
        engwordTV.setText(currentword.getMengTranslation());

        TextView miwakWordTV= (TextView) listItemView.findViewById(R.id.textView2);
        miwakWordTV.setText(currentword.getMmiwalkTranslation());

        ImageView MimageView= (ImageView) listItemView.findViewById(R.id.Image_View_Numbers_Family);
        MimageView.setImageResource(currentword.getMimage());

        View textcontainer = listItemView.findViewById(R.id.text_container);
        int color = ContextCompat.getColor(getContext(),McolourResourseid);
        textcontainer.setBackgroundColor(color);

        return  listItemView;

    }
}
