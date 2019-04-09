package anudit.attendr;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

import anudit.attendr.dbController;

public class MainActivity extends AppCompatActivity {

    SharedPreferences sharedpreferences;
    public static final String DB = "ATTENDR";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedpreferences = getSharedPreferences(DB, Context.MODE_PRIVATE);
        String name = sharedpreferences.getString("username", null);
        if(name != null)
            openMenu();
    }


    public void login(View v){
        EditText uname = (EditText)findViewById(R.id.login_tb_uname);
        EditText pass = (EditText)findViewById(R.id.login_tb_pass);
        String inpUname =  uname.getText().toString();
        String inpPass =  pass.getText().toString();

        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString("username", inpUname);
        editor.putString("password", inpPass);
        editor.apply();

        String name = sharedpreferences.getString("username", "default value");
        openMenu();

    }

    public void openMenu(){
        startActivity(new Intent(this, Menu.class));
    }
}
