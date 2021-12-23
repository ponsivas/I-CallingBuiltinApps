package com.example.callingbuiltinapps;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button GMAPS,GPLAY,SENDEMAIL,SENDTEXT,IMAGEVIEW;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GMAPS = (Button)findViewById(R.id.GMaps);
        GPLAY = (Button)findViewById(R.id.GPlay);
        SENDEMAIL = (Button)findViewById(R.id.Email);
        SENDTEXT = (Button)findViewById(R.id.SendTextContent);
        IMAGEVIEW = (Button)findViewById(R.id.ViewImages);

        GMAPS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(android.content.Intent.ACTION_VIEW);
                i.setData(Uri.parse("geo:30.8773385,76.8701457"));
                startActivity(i);
            }

        });

        GPLAY.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse("market://details?id=com.institute.chitkara"));
                startActivity(i);
            }
        });

        SENDEMAIL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_SEND);
                i.setData(Uri.parse("mailto:"));
                String[] to = { "prashant5010.be20@chitkarauniversity.edu.in" , "jatin5006.be20@chitkarauniversity.edu.in" };
                String[] cc = { "yashika5037.be20@chitkarauniversity.edu.in" };
                i.putExtra(Intent.EXTRA_EMAIL, to);
                i.putExtra(Intent.EXTRA_CC, cc);
                i.putExtra(Intent.EXTRA_SUBJECT, "Subject here...");
                i.putExtra(Intent.EXTRA_TEXT, "Message here...");
                i.setType("message/rfc822");
                startActivity(Intent.createChooser(i, "Email"));
            }
        });

        SENDTEXT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(android.content.Intent.ACTION_SEND);
                i.setType("text/plain");
                i.putExtra(Intent.EXTRA_SUBJECT, "Subject...");
                i.putExtra(Intent.EXTRA_TEXT, "Text...");
                startActivity(Intent.createChooser(i, "Apps that can respond to this"));
            }
        });

        IMAGEVIEW.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(android.content.Intent.ACTION_VIEW);
                //---indicates the type that the target activity will handle---
                i.setType("image/jpeg");
                startActivity(i);
            }
        });

    }
}