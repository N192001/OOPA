package com.example.spleshanimataiontest;

import android.Manifest;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.InputFilter;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.example.spleshanimataiontest.DataBaseConnectionNew.Controller;

//import android.support.v7.app.AppCompatActivity;

public class ShopcodeActivity extends AppCompatActivity implements View.OnClickListener {

    SQLiteDatabase myDatabase;
    //    boolean flag = true;
    TextView register_now, forgot_pass, shopcode;
    Button login;
    HomeActivity homeActivity;
    int isRegister = 0;
    String Registercode = "";

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_shopcode);
        requestPermission();
        Controller controller = new Controller();
        controller.InsertShopcodeData(ShopcodeActivity.this);

        login = findViewById(R.id.login_proceed);
        shopcode = findViewById(R.id.txtshopcode);
        shopcode.setFilters(new InputFilter[]{new InputFilter.AllCaps()});
//        saveshopcode();
        login.setOnClickListener(this);

        try{
            Boolean Registered;
            final SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
            Registered = sharedPref.getBoolean("Registered", false);

            if (Registered)
            {
                Intent loginIntent = new Intent(ShopcodeActivity.this, Login.class);
                loginIntent.putExtra("shopcode", shopcode.getText().toString().trim());
                startActivity(loginIntent);
            }
        }catch (Exception e){
            Log.e("tag","not user found");
        }
//        adapter = new ViewPagerAdapter(getSupportFragmentManager());
    }

    public void proceed(View view) {
        Toast.makeText(this, "Proceed Clicked", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.login_proceed:
                if (TextUtils.isEmpty(shopcode.getText().toString())) {
                    Toast.makeText(this, "plz enter valid shopcode ", Toast.LENGTH_SHORT).show();
                    // startActivity(new Intent(ShopcodeActivity.this, Login.class));
                    shopcode.setFocusable(true);
                } else {
                    if (shopcodecheck()) {
                   /*if( checkuser()){
                       startActivity(new Intent(ShopcodeActivity.this, NavigationActivity.class));
//                       startActivity(new Intent(ShopcodeActivity.this, Login.class));
                   }else{
                       startActivity(new Intent(ShopcodeActivity.this, Registration.class));
                   }
                }*/
                        Log.i("shopcode", "before intent ++++++++++++" + shopcode.getText().toString().trim());
                        Intent loginIntent = new Intent(ShopcodeActivity.this, Login.class);
                        loginIntent.putExtra("shopcode", shopcode.getText().toString().trim());
                        startActivity(loginIntent);
//                        startActivity(new Intent(ShopcodeActivity.this, Login.class));
                    } else {
                        Toast.makeText(getApplicationContext(), "Enter valid shopcode", Toast.LENGTH_LONG).show();
                    }
                    break;

                }
        }


    }

    public Boolean shopcodecheck() {

        try {
            String sc = "";
            String[] myshopcode = {"S06A", "S063A", "S018", "S044", "S016"};
            sc = shopcode.getText().toString().trim();
            for (int i = 0; i <= 6; i++) {
                if (sc.equalsIgnoreCase(myshopcode[i])) {
                    Log.i("tag", "shopcode found : ");
                    return true;
                }
            }
            //  return true;
        } catch (Exception e) {
        }
        return false;
    }

    public boolean checkuser() {
        try {
            String saveshopcode = "";


            SharedPreferences prefs = getSharedPreferences("shopcode", 0);
            saveshopcode = prefs.getString("shopcode", "No name defined");//"No name defined" is the default value.
//            int idName = prefs.getInt("idName", 0); //0 is the default value.
            /*Modules modules = new Modules();
            Cursor cur = modules.getShopcode(this);
            saveshopcode = cur.getString(3);
            cur.getString(3);
            Log.i("tag","shopcode"+cur.getString(3));*/
            Log.e("tag", "save shopcode : " + saveshopcode);
            if (saveshopcode.equalsIgnoreCase(shopcode.getText().toString().trim())) {
                Log.e("tag", "shopcode found");
                return true;
            } else {
                Log.e("tag", "shopcode not found");
                return false;
            }
        } catch (Exception e) {
            Log.e("tag", "Problem in getting shopcode from database : " + e.getMessage());
        }
        return false;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void saveshopcode() {
        try {
            Controller controller = new Controller();
            controller.InsertShopcodeData(ShopcodeActivity.this);
        } catch (Exception e) {
            Log.e("Shop code activity", "Problem in saving shopcode : " + e.getMessage());
        }
    }
    final private int REQUEST_CODE_ASK_PERMISSIONS = 123;

    private void requestPermission() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED ) {
            ActivityCompat
                    .requestPermissions(ShopcodeActivity.this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, REQUEST_CODE_ASK_PERMISSIONS);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case REQUEST_CODE_ASK_PERMISSIONS:
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // Permission Granted
                    Toast.makeText(ShopcodeActivity.this, "Permission Granted", Toast.LENGTH_SHORT)
                            .show();
                } else {
                    // Permission Denied
                    Toast.makeText(ShopcodeActivity.this, "Permission Denied", Toast.LENGTH_SHORT)
                            .show();
                }
                break;
            default:
                super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }
}
