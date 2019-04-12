package com.example.intentschallenge;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class InsertInfoActivity extends AppCompatActivity {
    EditText etName, etAddress, etWebsite, etNumber;
    ImageView btnHappy, btnMeh, btnSad;
    String name, number, address, website;
    int face;
    boolean checkFields() {
        return !etName.getText().toString().isEmpty() &&
                !etAddress.getText().toString().isEmpty() &&
                !etWebsite.getText().toString().isEmpty() &&
                !etNumber.getText().toString().isEmpty();}
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_info);

        etName = findViewById(R.id.etName);
        etAddress = findViewById(R.id.etAddress);
        etWebsite = findViewById(R.id.etWebsite);
        etNumber = findViewById(R.id.etNumber);
        btnHappy = findViewById(R.id.btnHappy);
        btnMeh   = findViewById(R.id.btnMeh);
        btnSad = findViewById(R.id.btnSad);

        btnHappy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkFields()) {
                    name = etName.getText().toString().trim();
                    number = etNumber.getText().toString().trim();
                    address = etAddress.getText().toString().trim();
                    website = etWebsite.getText().toString().trim();
                    face = 1;

                    Intent intent = new Intent();
                    intent.putExtra("name", name);
                    intent.putExtra("number",number);
                    intent.putExtra("website",website);
                    intent.putExtra("address",address);
                    intent.putExtra("face",face);
                    setResult(RESULT_OK, intent);
                    InsertInfoActivity.this.finish();

                }
                else {
                    Toast.makeText(InsertInfoActivity.this, "Please enter all fields!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnMeh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkFields()) {
                    name = etName.getText().toString().trim();
                    number = etNumber.getText().toString().trim();
                    address = etAddress.getText().toString().trim();
                    website = etWebsite.getText().toString().trim();
                    face = 2;

                    Intent intent = new Intent();
                    intent.putExtra("name", name);
                    intent.putExtra("number",number);
                    intent.putExtra("website",website);
                    intent.putExtra("address",address);
                    intent.putExtra("face",face);
                    setResult(RESULT_OK, intent);
                    InsertInfoActivity.this.finish();
                }
                else {
                    Toast.makeText(InsertInfoActivity.this, "Please enter all fields!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnSad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkFields()) {
                    name = etName.getText().toString().trim();
                    number = etNumber.getText().toString().trim();
                    address = etAddress.getText().toString().trim();
                    website = etWebsite.getText().toString().trim();
                    face = 3;

                    Intent intent = new Intent();
                    intent.putExtra("name", name);
                    intent.putExtra("number",number);
                    intent.putExtra("website",website);
                    intent.putExtra("address",address);
                    intent.putExtra("face",face);
                    setResult(RESULT_OK, intent);
                    InsertInfoActivity.this.finish();
                }
                else {
                    Toast.makeText(InsertInfoActivity.this, "Please enter all fields!", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
