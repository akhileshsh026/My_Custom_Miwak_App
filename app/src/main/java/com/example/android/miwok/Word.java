package com.example.android.miwok;

import android.media.Image;
import android.widget.ImageView;

/**
 * Created by Akhileshsh026 on 28-02-2017.
 */

public class Word {

    private String MmiwalkTranslation;
    private  String MengTranslation;
    private int Mimage;
    private int Maudio;

    public Word(String miwalkTranslation, String engTranslation)
    {
        MmiwalkTranslation = miwalkTranslation;
        MengTranslation = engTranslation;
    }

    public Word(String miwalkTranslation, String engTranslation,int iimage, int audio)
    {
        MmiwalkTranslation = miwalkTranslation;
        MengTranslation = engTranslation;
        Mimage = iimage;
        Maudio = audio;
    }

    public String getMmiwalkTranslation()
    {
        return MmiwalkTranslation;
    }

    public String getMengTranslation()
    {
        return MengTranslation;
    }

    public int getMimage()
    {
        return Mimage;
    }

    public int getMaudio() {return Maudio;}


    @Override
    public String toString() {
        return "Word{" +
                "MmiwalkTranslation='" + MmiwalkTranslation + '\'' +
                ", MengTranslation='" + MengTranslation + '\'' +
                ", Mimage=" + Mimage +
                ", Maudio=" + Maudio +
                '}';
    }
}
