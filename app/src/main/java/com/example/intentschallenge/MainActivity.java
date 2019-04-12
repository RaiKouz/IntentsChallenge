package com.example.intentschallenge;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    ImageView ivFace, ivPhone, ivMap, ivWeb;
    TextView tvContact;
    Button btnCreateContact;
    final int INSERTINFOACTIVITY = 3;
    int face;
    String website, address, name, number;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ivFace = findViewById(R.id.ivFace);
        ivMap  = findViewById(R.id.ivMap);
        ivPhone = findViewById(R.id.ivPhone);
        ivWeb = findViewById(R.id.ivWeb);
        btnCreateContact = findViewById(R.id.btnCreateContact);
        tvContact = findViewById(R.id.tvContact);


        btnCreateContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,com.example.intentschallenge.InsertInfoActivity.class);
                startActivityForResult(intent, INSERTINFOACTIVITY);
            }
        });

        ivPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+number));
                startActivity(intent);
            }
        });

        ivWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(website));
                startActivity(intent);
            }
        });

        ivMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q="+address));
                startActivity(intent);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == INSERTINFOACTIVITY) {
            if(resultCode == RESULT_OK) {
                name = data.getStringExtra("name");
                address = data.getStringExtra("address");
                number = data.getStringExtra("number");
                website = data.getStringExtra("website");
                face = data.getIntExtra("face", 1);


                switch (face) {
                    case 1:
                        ivFace.setImageResource(R.drawable.smileface);
                        break;
                    case 2:
                        ivFace.setImageResource(R.drawable.mehface);
                        break;
                    case 3:
                        ivFace.setImageResource(R.drawable.sadface);
                }
                ivFace.setVisibility(View.VISIBLE);
                ivPhone.setVisibility(View.VISIBLE);
                ivWeb.setVisibility(View.VISIBLE);
                ivMap.setVisibility(View.VISIBLE);
            }
        }
    }
}
