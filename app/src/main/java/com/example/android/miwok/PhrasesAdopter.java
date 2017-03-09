package com.example.android.miwok;

import android.app.Activity;
import android.database.CursorIndexOutOfBoundsException;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.security.PublicKey;
import java.util.ArrayList;

/**
 * Created by Akhileshsh026 on 01-03-2017.
 */

public class PhrasesAdopter extends ArrayAdapter<Phrases> {

    private int MPhrasecolor;

     PhrasesAdopter(Activity context, ArrayList<Phrases> Phraes_AList_Obj,int Phrasecolor)
     {
         super(context,0,Phraes_AList_Obj);
         MPhrasecolor = Phrasecolor;
     }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View PhraesListItemView = convertView;
        if (PhraesListItemView==null)
        {
            PhraesListItemView= LayoutInflater.from(getContext()).inflate(R.layout.list_item,parent,false);
        }

        Phrases CurrentPhraes = getItem(position);

        TextView EngPhrase = (TextView) PhraesListItemView.findViewById(R.id.textView1);
        EngPhrase.setText(CurrentPhraes.getMEngPhrase());

        TextView MwkPhrase= (TextView) PhraesListItemView.findViewById(R.id.textView2);
        MwkPhrase.setText(CurrentPhraes.getMMwkPhrase());

        ImageView MphraesImage = (ImageView) PhraesListItemView.findViewById(R.id.Image_View_Numbers_Family);
        if (CurrentPhraes.getMPhraseImage()==0)
        {
            MphraesImage.setVisibility(View.GONE);
        }
        // seeting up the color

        View PhraseColor= PhraesListItemView.findViewById(R.id.text_container);
        int color = ContextCompat.getColor(getContext(),MPhrasecolor);
        PhraseColor.setBackgroundColor(color);

        return PhraesListItemView;
    }
}
