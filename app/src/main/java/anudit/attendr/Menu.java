package anudit.attendr;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Menu extends AppCompatActivity {

    SharedPreferences sharedpreferences;
    public static final String DB = "ATTENDR";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        sharedpreferences = getSharedPreferences(DB, Context.MODE_PRIVATE);
        String name = sharedpreferences.getString("username", null);
        if(name == null)
            openLogin();
        else{
            TextView uname = (TextView) findViewById(R.id.menu_tv_uname);
            uname.setText(name);
        }
    }

    public void openScanner(View v){ startActivity(new Intent(this, Scanner.class)); }
    public void openAttendance(View v){ startActivity(new Intent(this, Attendance.class)); }

    public void logout(View v){
        getApplicationContext().getSharedPreferences(DB, 0).edit().clear().commit();
        openLogin();
    }

    public void openLogin(){
        startActivity(new Intent(this, MainActivity.class));
    }

}
