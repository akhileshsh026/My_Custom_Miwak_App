package com.example.android.miwok;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by Akhileshsh026 on 01-03-2017.
 */

public class FamilyAdopter extends ArrayAdapter<FamilyBaseClass> {

    int MFamilyColor;

    public FamilyAdopter(Activity context, ArrayList<FamilyBaseClass> Family_AL_Obj,int Familycolor)
    {
        super(context,0,Family_AL_Obj);
        MFamilyColor=Familycolor;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View FamilyListItemView = convertView;
        if (FamilyListItemView== null)
        {
            FamilyListItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item,parent,false);  //  reusing the List_Item

        }

        FamilyBaseClass CurrentFamilyMember = getItem(position);

        TextView EngFamily = (TextView) FamilyListItemView.findViewById(R.id.textView1);
        EngFamily.setText(CurrentFamilyMember.getMEngFamilyMembers());

        TextView MwkFamily = (TextView) FamilyListItemView.findViewById(R.id.textView2);
        MwkFamily.setText(CurrentFamilyMember.getMMwkFamilyMembers());

        ImageView MfamilyImage = (ImageView) FamilyListItemView.findViewById(R.id.Image_View_Numbers_Family);
        MfamilyImage.setImageResource(CurrentFamilyMember.getMFamilyImage());

        View FamilyColorr = FamilyListItemView.findViewById(R.id.text_container);
        int color = ContextCompat.getColor(getContext(),MFamilyColor);
        FamilyColorr.setBackgroundColor(color);
        return FamilyListItemView;
    }
}
