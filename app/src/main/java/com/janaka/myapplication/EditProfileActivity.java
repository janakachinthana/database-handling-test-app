package com.janaka.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.janaka.myapplication.database.DBHelper;

import java.util.List;

public class EditProfileActivity extends AppCompatActivity {

    RadioGroup radioGroup;
    RadioButton radioButton;
    Button search, edit, delete;
    DBHelper dbHelper;
    public EditText userName;
    public EditText birthDay, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_edit_profile );

        radioGroup = findViewById( R.id.radioGroup2);
        search = findViewById( R.id.button5 );
        userName = findViewById( R.id.editText2X );
        birthDay = findViewById( R.id.editText3X );
        password = findViewById( R.id.editText4X );
        dbHelper = new DBHelper( this );
//        final
        final UserProfile.Users us = new UserProfile.Users();

        search.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = userName.getText().toString();

                boolean User = dbHelper.readInfo( username );

                birthDay.setText(us.getBirthDay());
                password.setText( us.getPassword() );

                if (User == false){
                    Toast.makeText( EditProfileActivity.this, "error", Toast.LENGTH_SHORT ).show();
                }else{
                    Toast.makeText( EditProfileActivity.this, "success", Toast.LENGTH_SHORT ).show();

                }
            }
        } );

    }

    public void checkButton(View view){

        int id = radioGroup.getCheckedRadioButtonId();
        radioButton = findViewById( id );

        Toast.makeText( this, "button is" + radioButton.getText(), Toast.LENGTH_SHORT ).show();

    }
}
