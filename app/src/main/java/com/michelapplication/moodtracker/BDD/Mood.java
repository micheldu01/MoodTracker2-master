package com.michelapplication.moodtracker.BDD;

/**
 * Created by michel on 29/11/2017.
 */

public class Mood {

    //mood values
    private int id;
    private int color;
    private float sizeColor;
    private String comment;

    // create constructors
    public Mood() {
    }

    public Mood(int color, float sizeColor, String comment) {
        this.color = color;
        this.sizeColor = sizeColor;
        this.comment = comment;
    }

    // getter and setter
    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public float getSizeColor() {
        return sizeColor;
    }

    public void setSizeColor(float sizeColor) {
        this.sizeColor = sizeColor;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
