package com.example.spleshanimataiontest;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;

import com.example.spleshanimataiontest.DataBaseConnectionNew.Controller;
import com.example.spleshanimataiontest.DataBaseConnectionNew.DataBaseInfo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Registration extends Activity implements View.OnClickListener {
    String arraysavelist[];
    String arraysavecode[];
    String arraysavecodename[];
    private Pattern patternpass;
    private Pattern patternemail;
    private Matcher matcher;


    private static final String PASSWORD_PATTERN = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})";  // for password
    private static final String EMAIL_PATTERN = "[a-zA-Z0-9._-]+@[a-zA-Z]+\\.+[a-z]+";                      // for email
    static int test = 0;
    String shopcodetxt = "";
    Button register;
    TextView login_now, shopcode;
    EditText userid, password, passwordconf;//, shopcode;
    ImageView view1, view2;
    SharedPreferences sharedpreferences;
    public static final String SAVEDSHOPCODE = "shopcode";
    String details[] = new String[2];

    @Override
    @RequiresApi(api = Build.VERSION_CODES.N)
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        register = findViewById(R.id.register);
        //login_now = findViewById(R.id.login_now);
        userid = findViewById(R.id.txtusername);
        password = findViewById(R.id.txtpassword);
        passwordconf = findViewById(R.id.txtpasswordconfirm);
        view1 = findViewById(R.id.imageView3);
        view2 = findViewById(R.id.imageView4);
        //shopcode = findViewById(R.id.txtshopcode);

        register.setOnClickListener(this);
//        login_now.setOnClickListener(this);


        sharedpreferences = getSharedPreferences(SAVEDSHOPCODE, Context.MODE_PRIVATE);
        shopcode = (TextView) findViewById(R.id.txtregistershopcode);
        shopcodetxt = getIntent().getStringExtra("shopcode");
        setTitle(shopcodetxt);
        shopcode.setText(shopcodetxt);

        view1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // test = 1;
                if (test == 0) {
                    password.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    test = 1;
                } else {
                    //test=1;
                    password.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    test = 0;
                }
            }
        });

        userid.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
               try {
                   if (!hasFocus) {
                       Controller controller = new Controller();
                       details = controller.getuser(Registration.this, userid.getText().toString().trim(), "");
                       if (details[0].equalsIgnoreCase(userid.getText().toString().trim())) {
                           AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(Registration.this);
                           alertDialogBuilder.setMessage("User ID Not available ");
                           alertDialogBuilder.setPositiveButton("Try other User ID",
                                   new DialogInterface.OnClickListener() {
                                       @Override
                                       public void onClick(DialogInterface arg0, int arg1) {
                                           userid.setFocusable(true);
                                       }
                                   });
                           AlertDialog alertDialog = alertDialogBuilder.create();
                           alertDialog.show();
                           userid.setFocusable(true);
                       }
                   }
               }catch (Exception e){
                   Log.e("tag","problem in chicking the userid :"+e.getMessage());
               }
               }
        });

    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
          /*  case R.id.login_now:
                finish();
                break;*/
            case R.id.register:
                try {
                    if (TextUtils.isEmpty(userid.getText().toString())) {
                        Toast.makeText(this, "plz enter valid userid", Toast.LENGTH_SHORT).show();
                        userid.setFocusable(true);
                    } else {
                        String strpassword = "", stremailid = "", strconfpassword = "";
                        patternpass = Pattern.compile(PASSWORD_PATTERN);
                        patternemail = Pattern.compile(EMAIL_PATTERN);
                        stremailid = userid.getText().toString().trim();
                        strpassword = password.getText().toString().trim();
                        strconfpassword = passwordconf.getText().toString().trim();
                        if (strpassword.equals(strconfpassword)) {
                            if (validateemail(stremailid)) {
                                if (validate(strpassword)) {
                                    try {
                                        arraysavelist = new String[4];
                                        arraysavelist[0] = userid.getText().toString().trim();
                                        arraysavelist[1] = password.getText().toString().trim();
                                        arraysavelist[2] = passwordconf.getText().toString().trim();
                                        arraysavelist[3] = shopcodetxt.toString();
                                        //  arraysavelist[2] = shopcode.getText().toString().trim();
//                                        arraysavelist[3] = "";
                                        Controller controller = new Controller();
                                        controller.InsertData(DataBaseInfo.TABLENAME_User, arraysavelist, getApplication()); // to save data in database

                                        final SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
                                        SharedPreferences.Editor editor = sharedPref.edit();
                                        editor.putBoolean("Registered", true);
                                        editor.putString("Username", arraysavelist[0]);
                                        editor.putString("Password", arraysavelist[1]);
                                        editor.apply();
                                  /*  arraysavecode = new String[4];
                                    arraysavecode[0] = "S06A";
                                    arraysavecode[1] = "S018";
                                    arraysavecode[2] = "S044";
                                    arraysavecode[3] = "S016";

                                    arraysavecodename = new String[4];
                                    arraysavecodename[0] = "CUS";
                                    arraysavecodename[1] = "AIR";
                                    arraysavecodename[2] = "GLE";
                                    arraysavecodename[3] = "BOT";*/
                                        //  Controller controller = new Controller();
//                                    controller.InsertData(DataBaseInfo.TABLENAME_shopcode, arraysavecode, arraysavecodename, getApplicationContext()); // to save data in database


                                        SharedPreferences.Editor editor1 = sharedpreferences.edit(); // to save  data locally
                                        editor1.putString("shopcode", arraysavelist[3]);
                                        editor1.putString("isregister", "1");
                                        editor1.commit();

                                        Toast.makeText(this, "Registered successfully", Toast.LENGTH_SHORT).show();
                                        startActivity(new Intent(Registration.this, NavigationActivity.class));
                                    } catch (Exception e) {
                                        Log.e("tag", "Problem in Registration  :" + e.getMessage());
                                    }
                                } else {
                                    Toast.makeText(this, "Password must contain Capital, Small, Number and Special character", Toast.LENGTH_SHORT).show();
                                }
                            } else {
                                Toast.makeText(getApplicationContext(), "Enter Valid Email-ID ", Toast.LENGTH_LONG).show();
                            }

                        } else {
                            Toast.makeText(getApplicationContext(), "Password does not match", Toast.LENGTH_LONG).show();
                        }
                    }
                } catch (Exception e) {
                    Log.e("tag", "problem in registration : " + e.getMessage());
                }
                break;
            default:
                break;
        }

    }

    public boolean validate(final String password) {

        matcher = patternpass.matcher(password);

        return matcher.matches();

    }

    public boolean validateemail(final String email) {

        matcher = patternemail.matcher(email);

        return matcher.matches();

    }
}
