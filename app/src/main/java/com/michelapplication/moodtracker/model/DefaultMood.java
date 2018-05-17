package com.michelapplication.moodtracker.model;

import com.michelapplication.moodtracker.R;

/**
 * Created by michel on 21/12/2017.
 */

public class DefaultMood {

    private int color;
    private float sizeColor;
    private String comment;

    public DefaultMood() {
    }

    public DefaultMood(int color, float sizeColor, String comment) {
        this.color = R.color.white;
        this.sizeColor = 0.0f;
        this.comment = "";
    }

    public int getColor() {
        return R.color.white;
    }

    public float getSizeColor() {
        return 0.0f;
    }

    public String getComment() {
        return "";
    }
}
