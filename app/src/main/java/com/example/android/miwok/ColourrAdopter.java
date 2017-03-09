package com.example.android.miwok;

import android.app.Activity;
import android.media.Image;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Akhileshsh026 on 01-03-2017.
 */

public class ColourrAdopter extends ArrayAdapter<ColourrBC>
{

  public ColourrAdopter (Activity context,ArrayList<ColourrBC> colourrr)
  {
      super(context,0,colourrr);
  }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View ColourrListItemView =  convertView;

        if (ColourrListItemView==null)
        {
            ColourrListItemView = LayoutInflater.from(getContext()).inflate(R.layout.activity_list_item_colour,parent,false);
        }

        ColourrBC CurrentColourposition = getItem(position);

        TextView ColoursinEng = (TextView) ColourrListItemView.findViewById(R.id.Eng_colour_TV);
        ColoursinEng.setText(CurrentColourposition.getMEngColourName());

        TextView ColoursMwk = (TextView) ColourrListItemView.findViewById(R.id.Mwk_colour_TV);
        ColoursMwk.setText(CurrentColourposition.getMMwkColourName());

        ImageView McolourImage= (ImageView) ColourrListItemView.findViewById(R.id.ImageView_Colours);
        McolourImage.setImageResource(CurrentColourposition.getMcolourImage());

        return ColourrListItemView;
    }
}
