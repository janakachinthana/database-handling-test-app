package com.janaka.myapplication.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import com.janaka.myapplication.EditProfileActivity;
import com.janaka.myapplication.UserProfile;

import java.util.ArrayList;
import java.util.List;



public class DBHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "UserInfo.db";
    public static long newRowId = 0;
    public DBHelper(Context context) {
        super( context, DATABASE_NAME, null, 1 );

    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        String SQL_CREATE_ENTRIES =
                "CREATE TABLE " + UserProfile.Users.TABLE_NAME + "(" +
                        UserProfile.Users._ID + " INTEGER PRIMARY KEY," +
                        UserProfile.Users.COLUMN_NAME_USERNAME + "," +
                        UserProfile.Users.COLUMN_NAME_BIRTHDAY + "," +
                        UserProfile.Users.COLUMN_NAME_GENDER + "," +
                        UserProfile.Users.COLUMN_NAME_PASSWORD + " )";

        db.execSQL( SQL_CREATE_ENTRIES );

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


    public final boolean addInfo(String userName, String birthDay ,String password, String gender){

        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(UserProfile.Users.COLUMN_NAME_USERNAME, userName);
        values.put(UserProfile.Users.COLUMN_NAME_BIRTHDAY, birthDay);
        values.put(UserProfile.Users.COLUMN_NAME_PASSWORD, password);
        values.put(UserProfile.Users.COLUMN_NAME_GENDER, gender);

        newRowId = db.insert(UserProfile.Users.TABLE_NAME, null, values);
        String id = String.valueOf( newRowId );

        if (id!=null) {
            return true;
        }else {
            return false;
        }
    }

    public boolean update(String id, String userName, String birthDay, String gender, String password){
        SQLiteDatabase db = getReadableDatabase();

        ContentValues values = new ContentValues();
        values.put( UserProfile.Users.COLUMN_NAME_USERNAME, userName);
        values.put( UserProfile.Users.COLUMN_NAME_BIRTHDAY, birthDay);
        values.put( UserProfile.Users.COLUMN_NAME_GENDER, gender);
        values.put( UserProfile.Users.COLUMN_NAME_PASSWORD, password);

        String selection = UserProfile.Users._ID + " LIKE?";
        String[] selectionArgs = {id};

        String status = String.valueOf( db.update(
                UserProfile.Users.TABLE_NAME,
                values,
                selection,
                selectionArgs
        ) );

        if (status == null) {
            return false;
        }
        else{
            return true;
        }
    }

    public List readAllInfo(){
        SQLiteDatabase db = getReadableDatabase();

        String[] projection = {
          UserProfile.Users._ID,
                UserProfile.Users.COLUMN_NAME_USERNAME,
                UserProfile.Users.COLUMN_NAME_BIRTHDAY,
                UserProfile.Users.COLUMN_NAME_GENDER,
                UserProfile.Users.COLUMN_NAME_PASSWORD
        };

        Cursor cursor = db.query(
                UserProfile.Users.TABLE_NAME,
                projection,
                null,
                null,
                null,
                null,
                null

        );

        List userNames = new ArrayList<>();
        List passwords = new ArrayList<>();

        while (cursor.moveToNext()){
            String username = cursor.getString( cursor.getColumnIndexOrThrow( UserProfile.Users.COLUMN_NAME_USERNAME ) );
            String birthDay = cursor.getString( cursor.getColumnIndexOrThrow( UserProfile.Users.COLUMN_NAME_BIRTHDAY ) );
            String gender = cursor.getString( cursor.getColumnIndexOrThrow( UserProfile.Users.COLUMN_NAME_GENDER ) );
            String password = cursor.getString( cursor.getColumnIndexOrThrow( UserProfile.Users.COLUMN_NAME_PASSWORD ) );
        }
        cursor.close();
        return userNames;
    }

    public boolean readInfo(String userName){
//        String username = null;
        String username = null;
        String birthDay = null;
        String gender = null;
        String password = null;

        SQLiteDatabase db = getReadableDatabase();
        boolean value = false;
        String[] projection = {
                UserProfile.Users._ID,
                UserProfile.Users.COLUMN_NAME_USERNAME,
                UserProfile.Users.COLUMN_NAME_PASSWORD,
                UserProfile.Users.COLUMN_NAME_BIRTHDAY,
                UserProfile.Users.COLUMN_NAME_GENDER
        };

        String selection = UserProfile.Users.COLUMN_NAME_USERNAME + " LIKE ?";
        String[] selectionArgs= {userName};

        Cursor cursor = db.query(
                UserProfile.Users.TABLE_NAME,
                projection,
                selection,
                selectionArgs,
                null,
                null,
                null
        );

        while (cursor.moveToNext()){
           String userID= cursor.getString(cursor.getColumnIndexOrThrow(UserProfile.Users._ID));
           username= cursor.getString(cursor.getColumnIndexOrThrow(UserProfile.Users.COLUMN_NAME_USERNAME));
           birthDay= cursor.getString(cursor.getColumnIndexOrThrow(UserProfile.Users.COLUMN_NAME_BIRTHDAY));
           gender= cursor.getString(cursor.getColumnIndexOrThrow(UserProfile.Users.COLUMN_NAME_GENDER));
           password= cursor.getString(cursor.getColumnIndexOrThrow(UserProfile.Users.COLUMN_NAME_PASSWORD));
            value =  username.equals(userName);


        }
        cursor.close();

        UserProfile.Users.birthDay = birthDay;
        UserProfile.Users.gender = gender;
        UserProfile.Users.password = password;
        return value;


    }

    public void deleteInfo(String id){
        SQLiteDatabase db = getReadableDatabase();

        String selection = UserProfile.Users._ID + " LIKE ?";

        String[] selectionArgs = { id };

        db.delete( UserProfile.Users.TABLE_NAME, selection, selectionArgs );


    }
}
