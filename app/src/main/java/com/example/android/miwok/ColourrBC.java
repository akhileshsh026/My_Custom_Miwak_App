package com.example.android.miwok;

import static android.os.Build.VERSION_CODES.M;

/**
 * Created by Akhileshsh026 on 01-03-2017.
 */

public class ColourrBC {

    private String MEngColourName;
    private String MMwkColourName;
    private int McolourImage;
    private int Maudio;

     ColourrBC(String EngColourName, String MwkColourName)
     {
         MEngColourName = EngColourName;
         MMwkColourName = MwkColourName;

     }

    ColourrBC(String EngColourName, String MwkColourName,int colourimage,int audio)
    {
        MEngColourName = EngColourName;
        MMwkColourName = MwkColourName;
        McolourImage = colourimage;
        Maudio = audio;
    }

    public String getMEngColourName()
    {
        return MEngColourName;
    }

    public String getMMwkColourName()
    {
        return MMwkColourName;
    }

    public int getMcolourImage()
    {
        return McolourImage;
    }

    public int getMaudio() {return Maudio;}


}
