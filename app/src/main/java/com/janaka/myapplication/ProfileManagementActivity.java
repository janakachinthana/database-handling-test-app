package com.janaka.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.janaka.myapplication.database.DBHelper;

public class ProfileManagementActivity extends AppCompatActivity {

    EditText userName, birthDay, password;
    String uName, Ub, Up;
    RadioGroup radioGroup;
    RadioButton radioButton;
    Button updateBtn;
    DBHelper dbHelper;
    public String Gender = "male";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_profile_management );

        userName = findViewById( R.id.editText2 );
        birthDay = findViewById( R.id.editText3 );
        password = findViewById( R.id.editText4 );

        radioGroup = findViewById( R.id.radioGroup);
        updateBtn = findViewById( R.id.button3);
        dbHelper = new DBHelper( this );
        String j = String.valueOf( DBHelper.newRowId );
        updateBtn.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String UserName = userName.getText().toString();
                String BirthDay = birthDay.getText().toString();
                String Password = password.getText().toString();

                if (dbHelper.addInfo( UserName, BirthDay, Password, Gender ))
                {
                Toast.makeText( ProfileManagementActivity.this, "insert Success", Toast.LENGTH_SHORT ).show();
                 }
               else{
                   Toast.makeText( ProfileManagementActivity.this, "error", Toast.LENGTH_SHORT ).show();
               }
            }
        } );

    }

    public void checkButton(View view){
         int radioId = radioGroup.getCheckedRadioButtonId();

         radioButton = findViewById(radioId);
          Gender = radioButton.getText().toString();
        Toast.makeText( this, "selected button is " + Gender, Toast.LENGTH_SHORT ).show();
    }
}
