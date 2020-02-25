package com.example.myapplication;

import android.os.Parcel;
import android.os.Parcelable;

public class ModelPahlawan implements Parcelable {
    String heroName,heroDetails;
    int heroesImages;



    public ModelPahlawan() {

    }

    protected ModelPahlawan(Parcel in) {
        heroName = in.readString();
        heroDetails = in.readString();
        heroesImages = in.readInt();
    }

    public static final Creator<ModelPahlawan> CREATOR = new Creator<ModelPahlawan>() {
        @Override
        public ModelPahlawan createFromParcel(Parcel in) {
            return new ModelPahlawan(in);
        }

        @Override
        public ModelPahlawan[] newArray(int size) {
            return new ModelPahlawan[size];
        }
    };


    public String getHeroName() {
        return heroName;
    }

    public void setHeroName(String heroName) {
        this.heroName = heroName;
    }

    public String getHeroDetails() {
        return heroDetails;
    }

    public void setHeroDetails(String heroDetails) {
        this.heroDetails = heroDetails;
    }

    public int getHeroesImages() {
        return heroesImages;
    }

    public void setHeroesImages(int heroesImages) {
        this.heroesImages = heroesImages;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(heroName);
        dest.writeString(heroDetails);
        dest.writeInt(heroesImages);
    }
}
