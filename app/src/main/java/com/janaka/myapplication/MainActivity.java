package com.janaka.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button registerBtn, updateBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        registerBtn = findViewById(R.id.button2);
        updateBtn = findViewById(R.id.button6);

        registerBtn.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( MainActivity.this, ProfileManagementActivity.class );
                startActivity( intent );
            }
        } );

        updateBtn.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( MainActivity.this, EditProfileActivity.class );
                startActivity( intent );
            }
        } );
    }
}
