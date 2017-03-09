package com.example.android.miwok;

import android.media.MediaPlayer;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {
private MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colors);

        final ArrayList<ColourrBC> colourrr= new ArrayList<ColourrBC>();
        colourrr.add(new ColourrBC("Black","काला",R.drawable.color_black,R.raw.color_black));
        colourrr.add(new ColourrBC("white","सफ़ेद",R.drawable.color_white,R.raw.color_white));
        colourrr.add(new ColourrBC("Green","हरा",R.drawable.color_green,R.raw.color_green));
        colourrr.add(new ColourrBC("Yellow","पीला",R.drawable.color_dusty_yellow,R.raw.color_mustard_yellow));
        colourrr.add(new ColourrBC("Pink","गुलाबी",R.drawable.color_gray,R.raw.color_gray));
        colourrr.add(new ColourrBC("Blue","नीला",R.drawable.color_mustard_yellow,R.raw.color_dusty_yellow));
        colourrr.add(new ColourrBC("Indigo","भट्टी",R.drawable.color_gray,R.raw.color_gray));
        colourrr.add(new ColourrBC("Voliet","नारंगी",R.drawable.color_brown,R.raw.color_brown));
        colourrr.add(new ColourrBC("Red","लाल",R.drawable.color_red,R.raw.color_red));

        ColourrAdopter colourr = new ColourrAdopter(this,colourrr);

        final ListView ColourrListItemView = (ListView) findViewById(R.id.activity_colors);
        ColourrListItemView.setAdapter(colourr);

        ColourrListItemView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                ColourrBC colourrBC = colourrr.get(i);
                mediaPlayer = MediaPlayer.create(ColorsActivity.this,colourrBC.getMaudio());
                mediaPlayer.start();
            }
        });
    }
}
