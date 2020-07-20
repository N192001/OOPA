package com.example.spleshanimataiontest;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.example.spleshanimataiontest.DataBaseConnectionNew.Controller;
import com.example.spleshanimataiontest.utils.PreferenceStorage;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

//import android.support.v7.app.AppCompatActivity;

public class Login extends AppCompatActivity implements View.OnClickListener {
    SharedPreferences pref = null;
    SharedPreferences.Editor editor = null;
    private static final String EMAIL_PATTERN = "[a-zA-Z0-9._-]+@[a-zA-Z]+\\.+[a-z]+";                      // for email
    //    boolean flag = true;
    TextView register_now, forgot_pass, shopcode;
    Button login;
    HomeActivity homeActivity;
    EditText userid, password, passwordconf;//, shopcode;
    String saveuserid = "", savepassword = "", shopcodetxt = "", shopname = "";
    SharedPreferences sharedpreferences;
    private Pattern patternemail;
    private Matcher matcher;

    PreferenceStorage storage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
//setTitle();
        try {
            pref = this.getSharedPreferences("MyPref", 0); // 0 - for private mode
            editor = pref.edit();
        } catch (Exception e) {
            Log.e("Login onCreate Error ", "Problem in :" + e.getMessage());
        }


       /* if (pref.getBoolean("userlogin", false)) {
            startActivity(new Intent(Login.this, NavigationActivity.class));
        }*/

        register_now = findViewById(R.id.register_now);
        forgot_pass = findViewById(R.id.forgot_pass);
        login = findViewById(R.id.login_proceed);



        register_now.setOnClickListener(this);
        forgot_pass.setOnClickListener(this);
        login.setOnClickListener(this);
        userid = findViewById(R.id.txtuserid);
        password = findViewById(R.id.txtpassword);
        shopcode = (TextView) findViewById(R.id.txtshopcode);
        shopcodetxt = getIntent().getStringExtra("shopcode");

        //userid.setText("nikunj.kakadiya2012@gmail.com");
        //password.setText("Nik@91");

        Log.e("***************", "shop code : " + shopcodetxt);
        if (shopcodetxt.equals("S063A")) {
            setTitle("Custum St");
            shopname = "Custum St";
        } else if (shopcodetxt.equals("S018")) {
            setTitle("Auckland Air");
            shopname = "Auckland Air";
        } else if (shopcodetxt.equals("S044")) {
            setTitle("Glenn Inn");
            shopname = "Glenn Inn";
        } else if (shopcodetxt.equals("S016")) {
            setTitle("Botany Town Center");
            shopname = "Botany Town Center";
        }


        editor.putString("shopname", shopname);
        editor.commit();
        // shopcode.setText(shopcodetxt);
        /*Controller controller = new Controller();                                 // to  get shopname user this 2 line
        controller.getshopcodelist(Login.this,shopcodetxt);*/
//        shopname = controller.ShopcodeName(Login.this, shopcodetxt);

//        setTitle(shopname);
//        shopcode.setText(shopname);
//        adapter = new ViewPagerAdapter(getSupportFragmentManager());
    }

    public void proceed(View view) {
        Toast.makeText(this, "Proceed Clicked", Toast.LENGTH_SHORT).show();
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.register_now:

                Intent registerInter = new Intent(this, Registration.class);
                registerInter.putExtra("shopcode", shopname.toString());
                startActivity(registerInter);
                //   startActivity(new Intent(this, Registration.class));
                break;
            case R.id.forgot_pass:
                Toast.makeText(this, "Forgot Password Clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.login_proceed:

//                homeActivity = new HomeActivity();
/*
                adapter = new ViewPagerAdapter(getSupportFragmentManager());
                HomeFragment homeFragment = new HomeFragment();
                adapter.addFragment(homeFragment, "New order");
*/
                try {
                    patternemail = Pattern.compile(EMAIL_PATTERN);
//                    if (validateemail(userid.getText().toString().trim())) {
                    if (checkvalidation()) {
                        Intent navInter = new Intent(this, NavigationActivity.class);
                        navInter.putExtra("shopcode", shopname.toString());
                        startActivity(navInter);
                    }
                    /*} else {

                        Toast.makeText(this, "Enter valid email id ", Toast.LENGTH_LONG).show();
                    }*/
                } catch (Exception e) {
                    Log.e("tag", "problem in login : " + e.getMessage());
                }

            default:
                break;
        }
    }


    @RequiresApi(api = Build.VERSION_CODES.N)
    public Boolean checkvalidation() {
        String txtuserid = "", txtpassword = "";
        if (TextUtils.isEmpty(userid.getText().toString())) {
            Toast.makeText(Login.this, "Enter User id", Toast.LENGTH_LONG).show();
        } else {
            if (TextUtils.isEmpty(password.getText().toString())) {
                Toast.makeText(Login.this, "Enter  Password", Toast.LENGTH_LONG).show();
            } else {

                // if (isValidName(password.getText().toString().trim())) {
                Cursor cursor = null;
                Controller controller = new Controller();


                String details[] = new String[4];
                txtuserid = userid.getText().toString().trim();
                txtpassword = password.getText().toString().trim();
                details = controller.getuser(Login.this, txtuserid, txtpassword);
                Log.i("Login", "username from db : " + details[0]);
                Log.i("Login", "password from db : " + details[1]);

                try {
                    PreferenceStorage.setKey("username", details[0]);
                    SharedPreferences sharedPreferences = PreferenceManager
                            .getDefaultSharedPreferences(this);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("username", details[0]);
                    editor.apply();
                    shopcode.setText(details[2]);
                }catch (Exception e){
                    Toast.makeText(getApplicationContext(),"problem in preferance : "+e.getMessage(),Toast.LENGTH_LONG).show();
                }
//                Toast.makeText(getApplicationContext(), "share : " + PreferenceStorage.getKey("username"), Toast.LENGTH_LONG).show();
                if (details[0].equals(txtuserid)){

                    return true;
                }
//                if (details.length >= 1) {
//                    editor.putBoolean("userlogin", true);
//
//                    editor.commit();
//
//                    return true;
//                } else {
//                    return false;
//                }

                /////////
                /*try {\'"+ email+"\'" +" AND pass=\'"+password+"\'";
                    cursor = controller.getUserlist(Login.this, userid.getText().toString().trim(), password.getText().toString().trim());
                    saveuserid = cursor.getString(0);
                    savepassword = cursor.getString(1);
//                Log.e("userid ","text userid : "+);
//                Log.e("password ","text password: "+);
                    txtuserid = userid.getText().toString().trim();
                    txtpassword = password.getText().toString().trim();
                    if (saveuserid.equals(txtuserid)) {
                        if (savepassword.equals(txtpassword)) {
                            Log.e("userid ", "userid : " + saveuserid);
                            Log.e("password ", "password: " + savepassword);
                            return true;
                        } else {
                            Toast.makeText(Login.this, "Invalide user id  password", Toast.LENGTH_LONG).show();
                            // return false;
                        }
                    } else {
                        Toast.makeText(Login.this, "Invalide user id password", Toast.LENGTH_LONG).show();
                    }
                }catch (Exception e){
                    Log.i("error in login","problem in getting db user : "+e.getMessage());
                    Toast.makeText(Login.this, "Invalide user id  password", Toast.LENGTH_LONG).show();
                }*/
                //}
            }
        }
        return false;
    }

    public static boolean isValidName(String inputString) {

        String specialCharacters = " !#$%&'()*+,-./:;<=>?@[]^_`{|}~0123456789";
        String[] strlCharactersArray = new String[inputString.length()];
        for (int i = 0; i < inputString.length(); i++) {
            strlCharactersArray[i] = Character
                    .toString(inputString.charAt(i));
        }
        //now  strlCharactersArray[i]=[A, d, i, t, y, a]
        int count = 0;
        for (int i = 0; i < strlCharactersArray.length; i++) {
            if (specialCharacters.contains(strlCharactersArray[i])) {
                count++;
            }

        }

        if (inputString != null && count == 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean validateemail(final String email) {

        matcher = patternemail.matcher(email);

        return matcher.matches();

    }
}
