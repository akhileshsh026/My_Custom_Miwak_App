package com.example.android.miwok;

/**
 * Created by Akhileshsh026 on 01-03-2017.
 */

public class Phrases {

    private String MEngPhrase;
    private String MMwkPhrase;
    private int MPhraseImage = 0;
    private int Maudio;

    Phrases( String EngPhrase , String MwkPhrase, int audio)
    {
        MEngPhrase = EngPhrase;
        MMwkPhrase = MwkPhrase;
        Maudio = audio;
    }


    public String getMEngPhrase()
    {
        return MEngPhrase;
    }
    public String getMMwkPhrase()
    {
        return  MMwkPhrase;
    }
    public int getMPhraseImage() {return MPhraseImage;}
    public int getMaudio() {return Maudio;}


}
