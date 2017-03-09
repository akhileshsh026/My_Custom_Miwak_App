package com.example.android.miwok;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.concurrent.Phaser;

import static android.os.Build.VERSION_CODES.M;

public class PhrasesActivity extends AppCompatActivity {
     private MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phrases);

        final ArrayList<Phrases> Phrases_AList_Obj = new ArrayList<Phrases>();

        Phrases_AList_Obj.add(new Phrases("Hakona Ma Tata","टीमों एंड पुम्बा",R.raw.phrase_are_you_coming));
        Phrases_AList_Obj.add(new Phrases("Joney Bravo","जोनी ब्रावो",R.raw.phrase_come_here));
        Phrases_AList_Obj.add(new Phrases("Tom and Jerry","टॉम एंड जेरी",R.raw.phrase_how_are_you_feeling));
        Phrases_AList_Obj.add(new Phrases("The Mask","थे मास्क",R.raw.phrase_im_coming));
        Phrases_AList_Obj.add(new Phrases("Richy Rich","रिची रिच",R.raw.phrase_im_feeling_good));

        PhrasesAdopter phraesAdopter = new PhrasesAdopter(this,Phrases_AList_Obj,R.color.category_phrases);
        ListView PhraesListItemView = (ListView) findViewById(R.id.activity_phrases);
        PhraesListItemView.setAdapter(phraesAdopter);

        PhraesListItemView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Phrases phrases = Phrases_AList_Obj.get(i);
                mediaPlayer = MediaPlayer.create(PhrasesActivity.this,phrases.getMaudio());
                mediaPlayer.start();
            }
        });
    }
}
