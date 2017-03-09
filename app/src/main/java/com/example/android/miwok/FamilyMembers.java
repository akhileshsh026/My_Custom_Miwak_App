package com.example.android.miwok;

import android.media.MediaPlayer;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class FamilyMembers extends AppCompatActivity {

    private MediaPlayer mediaPlayer;
    private MediaPlayer.OnCompletionListener mcompletion = new MediaPlayer.OnCompletionListener(){
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            releaseMediaPlayer();
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_family_members);

        final ArrayList<FamilyBaseClass> Family_AL_Obj = new ArrayList<FamilyBaseClass>();
        Family_AL_Obj.add(new FamilyBaseClass("Father","पिताजी",R.drawable.family_father,R.raw.family_father));
        Family_AL_Obj.add(new FamilyBaseClass("Mother","माता",R.drawable.family_mother,R.raw.family_mother));
        Family_AL_Obj.add(new FamilyBaseClass("Uncle","चाचा, मामा",R.drawable.family_younger_brother,R.raw.family_younger_brother));
        Family_AL_Obj.add(new FamilyBaseClass("Aunt","चाची,मामी",R.drawable.family_younger_sister,R.raw.family_younger_sister));
        Family_AL_Obj.add(new FamilyBaseClass("GrandFather","दादाजी",R.drawable.family_grandfather,R.raw.family_grandfather));
        Family_AL_Obj.add(new FamilyBaseClass("Brother","भाई",R.drawable.family_younger_brother,R.raw.family_grandmother));

        final FamilyAdopter familyAdopter = new FamilyAdopter(this,Family_AL_Obj,R.color.category_family);

        ListView FamilyListItem = (ListView) findViewById(R.id.activity_family_members);
        FamilyListItem.setAdapter(familyAdopter);

        FamilyListItem.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                FamilyBaseClass familyBaseClass = Family_AL_Obj.get(i);
                mediaPlayer= MediaPlayer.create(FamilyMembers.this,familyBaseClass.getMaudio());
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(mcompletion);
            }
        });}

        private void releaseMediaPlayer() {
            // If the media player is not null, then it may be currently playing a sound.
            if (mediaPlayer != null) {
                // Regardless of the current state of the media player, release its resources
                // because we no longer need it.
                mediaPlayer.release();

                // Set the media player back to null. For our code, we've decided that
                // setting the media player to null is an easy way to tell that the media player
                // is not configured to play an audio file at the moment.
                mediaPlayer= null;
            }

        }
    }

