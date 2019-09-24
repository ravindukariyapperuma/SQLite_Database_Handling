package com.example.sqlite_database_handling;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

import Database.DBHelper;

public class MainActivity extends AppCompatActivity {
    EditText txt_userName, txt_password;
    String userNameUI, passwordUI;
    DBHelper db;
    Button deleteBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt_userName = findViewById(R.id.txtUserName);
        txt_password = findViewById(R.id.txtPassword);
         db = new DBHelper(this);
         deleteBtn = findViewById(R.id.btnDelete);
         deleteBtn.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 int result = db.deleteInfo(txt_userName.getText().toString());
                 if(result == 1){
                     Toast.makeText(getApplicationContext(),"Delete User Success",Toast.LENGTH_LONG).show();
                 }else {
                     Toast.makeText(getApplicationContext(),"Delete error",Toast.LENGTH_LONG).show();
                 }
             }
         });
    }

    public void addInfo(View view){
        userNameUI = txt_userName.getText().toString();
        passwordUI = txt_password.getText().toString();

        boolean result = db.addInfo(userNameUI,passwordUI);

        if(result == true){
            Toast.makeText(getApplicationContext(),"Adding User Success",Toast.LENGTH_LONG).show();
        }else {
            Toast.makeText(getApplicationContext(),"Adding error",Toast.LENGTH_LONG).show();
        }

    }

    public void getAllUsers(View view){
        List usernames;
        usernames = db.readAllInfo();
        for(int i=0; i<usernames.size(); i++){
            Log.i("AAA","user "+i+" : "+ usernames.get(i));
        }
    }

    public void updateUser(View view){
        userNameUI = txt_userName.getText().toString();
        passwordUI = txt_password.getText().toString();
        boolean result = db.updateInfo(txt_userName.getText().toString(),txt_password.getText().toString());
        if (result == true){
            Toast.makeText(getApplicationContext(),"Update User Success",Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(getApplicationContext(),"Update error",Toast.LENGTH_LONG).show();
        }
    }


}
