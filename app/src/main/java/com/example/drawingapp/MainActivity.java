package com.example.drawingapp;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private DrawingView drawingView;
    private ImageButton currentColor;
    private ImageButton btnClear;
    private ImageButton btnBrush;
    private ImageButton btnPencil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayout paintLayout = (LinearLayout)findViewById(R.id.paint_colors);
        drawingView = (DrawingView)findViewById(R.id.drawing);
        currentColor = (ImageButton)paintLayout.getChildAt(0);
        currentColor.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.color_pressed));

        btnClear = (ImageButton)findViewById(R.id.btnClear);
        btnBrush = (ImageButton)findViewById(R.id.btnBrush);
        btnPencil = (ImageButton)findViewById(R.id.btnPencil);

        btnClear.setOnClickListener(this);
        btnBrush.setOnClickListener(this);
        btnPencil.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnClear:
                drawingView.clear();
                break;
            case R.id.btnBrush:
                drawingView.setRoundStroke();
                break;
            case R.id.btnPencil:
                drawingView.setSquareStroke();
                break;
        }
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
