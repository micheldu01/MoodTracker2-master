package com.michelapplication.moodtracker.model;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.icu.util.Calendar;
import android.media.MediaPlayer;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.view.NestedScrollingChild;
import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.michelapplication.moodtracker.R;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import static android.content.Context.MODE_PRIVATE;
import static com.michelapplication.moodtracker.controller.MainActivity.DATE;
import static com.michelapplication.moodtracker.controller.MainActivity.MOOD_TEMPORARY;

/**
 * Created by michel on 26/10/2017.
 */

public class MpagerAdapter extends PagerAdapter {

    private static final String MYMOOD = "MyMood";
    // variables
    private int[] layouts;
    private int[] arrayColor= {R.color.banana_yellow,R.color.light_sage,R.color.cornflower_blue_65,R.color.warm_grey,R.color.faded_red};
    private int[] arraySmiley = {R.drawable.smiley_super_happy,R.drawable.smiley_happy,
            R.drawable.smiley_normal,R.drawable.smiley_disappointed,R.drawable.smiley_sad};
    private LayoutInflater layoutInflater;
    private Context context;
    private SharedPreferences mSharedPreferences;
    private long saveDay;
    private Calendar thatDay;




    // constructor
    public MpagerAdapter(int[] layouts, Context context)
    {
        this.layouts = layouts;
        this.context = context;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return layouts.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }

    // set the current smiley
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public Object instantiateItem(ViewGroup container, int  position) {
        View view = layoutInflater.inflate(R.layout.first_screen,container,false);
        ImageView smiley = (ImageView) view.findViewById(R.id.image_smiley_super_happy);
        smiley.setImageResource(arraySmiley[position]);
        view.setBackgroundResource(arrayColor[position]);

        mSharedPreferences = context.getSharedPreferences(MYMOOD, Context.MODE_PRIVATE);
        // save date
        thatDay = Calendar.getInstance();
        thatDay.get(Calendar.DAY_OF_MONTH);
        thatDay.get(Calendar.MONTH);
        thatDay.get(Calendar.YEAR);
        saveDay = thatDay.getTimeInMillis();
        mSharedPreferences.edit().putLong(DATE, saveDay).commit();


        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        View view = (View)object;
        container.removeView(view);
    }
}