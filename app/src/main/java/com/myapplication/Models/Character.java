package com.myapplication.Models;

import com.google.gson.annotations.SerializedName;

public class Character {

    @SerializedName("id")
    private String idCharacter;

    @SerializedName("name")
    private  String nameCharacter;

    @SerializedName("status")
    private  String statusCharacter;

    @SerializedName("species")
    private  String speciesCharacter;

    @SerializedName("gender")
    private  String genderCharacter;

    @SerializedName("image")
    private  String imageCharacter;

    public String getIdCharacter() {
        return idCharacter;
    }

    public void setIdCharacter(String idCharacter) {
        this.idCharacter = idCharacter;
    }

    public String getNameCharacter() {
        return nameCharacter;
    }

    public void setNameCharacter(String nameCharacter) {
        this.nameCharacter = nameCharacter;
    }

    public String getStatusCharacter() {
        return statusCharacter;
    }

    public void setStatusCharacter(String statusCharacter) {
        this.statusCharacter = statusCharacter;
    }

    public String getSpeciesCharacter() {
        return speciesCharacter;
    }

    public void setSpeciesCharacter(String speciesCharacter) {
        this.speciesCharacter = speciesCharacter;
    }

    public String getGenderCharacter() {
        return genderCharacter;
    }

    public void setGenderCharacter(String genderCharacter) {
        this.genderCharacter = genderCharacter;
    }

    public String getImageCharacter() {
        return imageCharacter;
    }

    public void setImageCharacter(String imageCharacter) {
        this.imageCharacter = imageCharacter;
    }
}
