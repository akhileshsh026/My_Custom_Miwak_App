package com.example.android.miwok;

/**
 * Created by Akhileshsh026 on 01-03-2017.
 */

public class FamilyBaseClass {

    private String MEngFamilyMembers;
    private String MMwkFamilyMembers;
    private int MFamilyImage;
    private int Maudio;

    FamilyBaseClass(String EngFamilyMembers, String MwkFamilyMembers)
    {
        MEngFamilyMembers = EngFamilyMembers;
        MMwkFamilyMembers = MwkFamilyMembers;
    }

    FamilyBaseClass(String EngFamilyMembers, String MwkFamilyMembers,int FamilyImage,int audio)
    {
        MEngFamilyMembers = EngFamilyMembers;
        MMwkFamilyMembers = MwkFamilyMembers;
        MFamilyImage=FamilyImage;
        Maudio =audio;
    }

    public String getMEngFamilyMembers()
    {
        return MEngFamilyMembers;
    }

    public String getMMwkFamilyMembers()
    {
        return MMwkFamilyMembers;
    }

    public int getMFamilyImage()
    {
        return MFamilyImage;
    }

    public int getMaudio() {return Maudio;}

}
