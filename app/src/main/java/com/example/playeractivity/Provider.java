package com.example.playeractivity;


import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.media.MediaPlayer;
import android.widget.RemoteViews;

public class Provider extends AppWidgetProvider {
    MediaPlayer player;
    Integer[]list ={R.raw.srivalli,R.raw.oo,R.raw.eyy};
    int currentposition = 0;


    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        super.onUpdate(context, appWidgetManager, appWidgetIds);
        player = MediaPlayer.create(context,list[currentposition]);
//        RemoteViews views = new RemoteViews();
    }
}