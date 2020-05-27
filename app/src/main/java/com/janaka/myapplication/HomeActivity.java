package com.janaka.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.janaka.myapplication.database.DBHelper;

public class HomeActivity extends AppCompatActivity {

    private Button register;
    private EditText userName;
    private  EditText Password;
    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_home );



        register = (Button)findViewById(R.id.reg);
        userName = findViewById( R.id.editText );
        Password = findViewById( R.id.editText1 );
        final String US = userName.getText().toString();
        final String PS = Password.getText().toString();
        dbHelper = new DBHelper( this );

//        register.setOnClickListener( new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//               if (dbHelper.addInfo(US, PS)) {
//                   Intent intent = new Intent( HomeActivity.this, ProfileManagementActivity.class );
//                   startActivity( intent );
//                   Toast.makeText( HomeActivity.this, "insert Success", Toast.LENGTH_SHORT ).show();
//               }
//               else{
//                   Toast.makeText( HomeActivity.this, "insert failed", Toast.LENGTH_SHORT ).show();
//               }
//            }
//        } );
    }


}
