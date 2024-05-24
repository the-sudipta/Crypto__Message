package com.example.cryptomessage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Support extends AppCompatActivity {

    TextView developer_info,name_textview,contactUs_textview;
    ImageView mail_imageView,facebook_imageView,instragram_imageView,logo_imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_support);

        // Getting values from layout Variables

        developer_info = findViewById(R.id.developer_info);
        name_textview = findViewById(R.id.name_textview);
        contactUs_textview = findViewById(R.id.contactUs_textview);

        mail_imageView = findViewById(R.id.mail_imageView);
        facebook_imageView = findViewById(R.id.facebook_imageView);
        instragram_imageView = findViewById(R.id.instragram_imageView);
        logo_imageView = findViewById(R.id.logo_imageView);



        /// Action Listener
        mail_imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMail("sudipta.kumar020@gmail.com");
            }
        });

        facebook_imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl("https://www.facebook.com/sudipta.kumar.3154/");

            }
        });


        instragram_imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl("https://www.instagram.com/yaarian_roy/");
            }
        });




    }

    private void sendMail(String recipient){
        //Intent intent = new Intent(Intent.ACTION_SEND);
        Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:"+recipient));
        startActivity(intent);
    }

    private void gotoUrl(String s) {
        Uri uri = Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW,uri));
    }

}