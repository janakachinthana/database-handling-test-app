package com.janaka.myapplication;

import android.provider.BaseColumns;

public final class UserProfile {


    private UserProfile() {
    }


    public static class Users implements BaseColumns {

        String userID;
        String userName;
      public static String birthDay = null;
        public static String gender = null;
        public static String password = null;



        public String getUserID() {
            return userID;
        }

        public void setUserID(String userID) {
            this.userID = userID;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public String getBirthDay() {
            return birthDay;
        }



        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }



        public static final String TABLE_NAME = "userInf";
        public static final String _ID = "userID";
        public static final String COLUMN_NAME_USERNAME = "userName";
        public static final String COLUMN_NAME_BIRTHDAY = "birthDay";
        public static final String COLUMN_NAME_PASSWORD = "password";
        public static final String COLUMN_NAME_GENDER = "gender";

    }

}
