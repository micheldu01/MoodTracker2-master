package com.michelapplication.moodtracker.model;

import com.michelapplication.moodtracker.R;

/**
 * Created by michel on 21/12/2017.
 */

public class Smiley {

    private int smile;
    private int color;
    private float sizeColor;

    public Smiley(int smile) {
        if (smile == 0) {
            this.color = R.color.banana_yellow;
            this.sizeColor = 0.0f;
        }
        if (smile == 1) {
            this.color = R.color.light_sage;
            this.sizeColor = 0.23f;
        }
        if (smile == 2) {
            this.color = R.color.cornflower_blue_65;
            this.sizeColor = 0.65f;
        }
        if (smile == 3) {
            this.color = R.color.warm_grey;
            this.sizeColor = 1.45f;
        }
        if (smile == 4) {
            this.color = R.color.faded_red;
            this.sizeColor = 3.7f;
        }
    }

    public int getColor() {
        return color;
    }

    public float getSizeColor() {
        return sizeColor;
    }
}
