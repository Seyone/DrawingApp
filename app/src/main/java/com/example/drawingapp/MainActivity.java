package com.example.drawingapp;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    private DrawingView drawingView;
    private ImageButton currentColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayout paintLayout = (LinearLayout)findViewById(R.id.paint_colors);
        drawingView = (DrawingView)findViewById(R.id.drawing);
        currentColor = (ImageButton)paintLayout.getChildAt(0);
        currentColor.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.color_pressed));
    }

    public void colorClicked (View view) {
        if(view!=currentColor){
            ImageButton imgView = (ImageButton)view;
            drawingView.setColor(view.getTag().toString());
            imgView.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.color_pressed));
            currentColor.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.color_button));
            currentColor=(ImageButton)view;
        }
    }
}
