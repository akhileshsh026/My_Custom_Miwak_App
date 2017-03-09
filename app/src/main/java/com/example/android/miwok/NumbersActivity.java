package com.example.android.miwok;

import android.app.LauncherActivity;
import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.logging.Handler;

import static android.media.AudioManager.AUDIOFOCUS_GAIN;
import static android.media.AudioManager.AUDIOFOCUS_LOSS;
import static android.media.AudioManager.AUDIOFOCUS_LOSS_TRANSIENT;
import static android.media.AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK;

public class NumbersActivity extends AppCompatActivity {

    private AudioManager maudioManager ;

    private MediaPlayer mmediaPlayer;
    AudioManager.OnAudioFocusChangeListener afChangeListener =
            new AudioManager.OnAudioFocusChangeListener() {
                public void onAudioFocusChange(int focusChange) {
                    if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT || focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) {
                        mmediaPlayer.pause();
                        mmediaPlayer.seekTo(0);
                    }
                    else if (focusChange == AUDIOFOCUS_GAIN) {
                        mmediaPlayer.start();
                    } else if (focusChange == AUDIOFOCUS_LOSS) {
                        releaseMediaPlayer();
                    }
                }};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);



/*
        ArrayList<String> Words = new ArrayList<String>();
        Words.add("one");
        Words.add("two");
        Words.add("three");
        Words.add("four");
        Words.add("five");
        Words.add("six");
        Words.add("seven");
        Words.add("eight");
        Words.add("nine");
        Words.add("Ten");
*/

       /* LinearLayout rootview = (LinearLayout) findViewById(R.id.root_view);

        for (int i = 0; i < Words.size(); i++) {
            TextView wordview = new TextView(this); // vvimp
            wordview.setText(Words.get(i));
            rootview.addView(wordview);
        }*/

        /*ArrayAdapter<String> itemAdopter= new ArrayAdapter<String>(this,R.layout.list_item,Words);

        ListView listview= (ListView) findViewById(R.id.list);
        listview.setAdapter(itemAdopter);*/

        maudioManager =(AudioManager) getSystemService(Context.AUDIO_SERVICE);

        final ArrayList<Word> Words = new ArrayList<Word>();
        Word w= new Word("ek","One",R.drawable.number_one,R.raw.number_one);
        Words.add(w);  // Tradational Method

        Words.add(new Word("Gk","Two",R.drawable.number_two,R.raw.number_two));
        Words.add(new Word("teen","three",R.drawable.number_three,R.raw.number_three));
        Words.add(new Word("Chaar","four",R.drawable.number_four,R.raw.number_four));
        Words.add(new Word("panch","five",R.drawable.number_five,R.raw.number_five));
        Words.add(new Word("chahh","six",R.drawable.number_six,R.raw.number_six));
        Words.add(new Word("Saat","seven",R.drawable.number_seven,R.raw.number_seven));
        Words.add(new Word("aatt","eight",R.drawable.number_eight,R.raw.number_eight));
        Words.add(new Word("nauo","nine",R.drawable.number_nine,R.raw.number_nine));
        Words.add(new Word("daas","Ten",R.drawable.number_ten,R.raw.number_ten));

//        ArrayAdapter<Word> itemAdopter= new ArrayAdapter<Word>(this,R.layout.list_item,Words);
//        now we already extend it in our wordadopter class

        final WordAdopter adapter = new WordAdopter(this,Words,R.color.category_numbers);

        ListView listItemView = (ListView) findViewById(R.id.Numbers_list); // in activity_numbers (Final repreasentation
        listItemView.setAdapter(adapter);

        listItemView.setOnItemClickListener( new AdapterView.OnItemClickListener()

        {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Word word = Words.get(position);
                releaseMediaPlayer();
                int result=maudioManager.requestAudioFocus(afChangeListener,AudioManager.STREAM_MUSIC,AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);
                if(result== AudioManager.AUDIOFOCUS_REQUEST_GRANTED)
                {
                    Log.v("NumbersActivity","Current Word : "+word);  // debugging tip in tostring() method
                    mmediaPlayer = MediaPlayer.create(NumbersActivity.this,word.getMaudio());
                    mmediaPlayer.start();
                }



            }
        }
        );





    }
    public void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (mmediaPlayer != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mmediaPlayer.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mmediaPlayer = null;
            maudioManager.abandonAudioFocus(afChangeListener);
        }}

    @Override
    protected void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }
}
