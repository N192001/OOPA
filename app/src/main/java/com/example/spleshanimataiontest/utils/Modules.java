package com.example.spleshanimataiontest.utils;

import android.app.DatePickerDialog;
import android.app.FragmentManager;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.util.Log;
import android.widget.DatePicker;

import androidx.annotation.RequiresApi;

import com.example.spleshanimataiontest.DataBaseConnectionNew.DataBaseInfo;
import com.example.spleshanimataiontest.DataBaseConnectionNew.SqlHelper;
import com.example.spleshanimataiontest.datamodel.ListItem;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;


public class Modules {

    static String[] entrydate = null;

    public String getdateandtime() {
        GregorianCalendar now = new GregorianCalendar();
        int year = now.get(Calendar.YEAR);
        int month = now.get(Calendar.MONTH) + 1;
        int day = now.get(Calendar.DATE);
        int hour = now.get(Calendar.HOUR_OF_DAY);
        int minute = now.get(Calendar.MINUTE);
        int second = now.get(Calendar.SECOND);
        String date = year + "-" + month + "-" + day;
        String time = " " + hour + ":" + minute + ":" + second;
        return date + time;
    }

    public String getdate() {

        GregorianCalendar now = new GregorianCalendar();
        int year = now.get(Calendar.YEAR);
        int month = now.get(Calendar.MONTH) + 1;
        int day = now.get(Calendar.DATE);

        String date = year + "-" + month + "-" + day;

        return date;
    }

    public String gettime() {
        GregorianCalendar now = new GregorianCalendar();
        int hour = now.get((Calendar.HOUR));
//        int hour = now.get((Calendar.HOUR_OF_DAY));
        int minute = now.get((Calendar.MINUTE));
        int second = now.get(Calendar.SECOND);
        String time = " " + hour + ":" + minute + ":" + second;
//Log.i("tag","date from module//////////////*/******** : "+time);
        return time;
    }


    //    public Cursor getPatientlist(Context context) {
    public String[] getUserlist(Context context) {
        SQLiteDatabase myDatabase;
        String rec[] = null;
        Cursor cur = null;
        try {
            myDatabase = (new SqlHelper(context, DataBaseInfo.DataBaseName, null, 1)).getReadableDatabase();
            cur = myDatabase.query(DataBaseInfo.TABLENAME_User, null, null, null, null, null, null);
            cur.moveToFirst();
            rec = new String[cur.getCount()];
            for (int i = 0; i < cur.getCount(); i++) {
//            rec[i]=cur.getString(0)+" : "+cur.getString(1)+" : "+ cur.getString(2)+" : "+ cur.getString(3);
                rec[i] = cur.getString(1);
                // Log.e("Checking", " " + cur.getString(0) + " : " + cur.getString(1) + " : " + cur.getString(2) + " : " + cur.getString(3) + " : " + cur.getString(4));
                cur.moveToNext();
                Log.i("tag ", "field name : " + DataBaseInfo.U_USERNAME);
            }
        } catch (Exception e) {
        }
        return rec;
//        return cur;
    }


    public List getOrderTracker(Context context, String status) {
        SQLiteDatabase myDatabase;
        String rec[] = null;
        Cursor cur = null;
        String customername = "", date = "", time = "", qty = "", total = "", booking_id = "",status1="";
        List<ListItem> listItemList = new ArrayList<>();
        try {
            myDatabase = (new SqlHelper(context, DataBaseInfo.DataBaseName, null, 1)).getReadableDatabase();
//            cur = myDatabase.query(DataBaseInfo.TABLENAME_ordertracker, null, null, null, null, null, null);
            String query = "";
//            query = "SELECT * FROM " + DataBaseInfo.TABLENAME_ordertracker + " WHERE Status =2 ";
            if (status.equals("9")){
                query = "SELECT * FROM " + DataBaseInfo.TABLENAME_ordertracker + " WHERE Status =7 OR Status=8";
            } else{
                query = "SELECT * FROM " + DataBaseInfo.TABLENAME_ordertracker + " WHERE Status = " + status;
            }

            Log.i("tag", " from get order tracking : " + query);
            cur = myDatabase.rawQuery(query, null);
            cur.moveToFirst();

            rec = new String[cur.getCount()];
            for (int i = 0; i < cur.getCount(); i++) {
//            rec[i]=cur.getString(0)+" : "+cur.getString(1)+" : "+ cur.getString(2)+" : "+ cur.getString(3);
                rec[i] = cur.getString(1);
                Log.e("Checking", " " + cur.getString(0) + " : " + cur.getString(1) + " : " + cur.getString(2) + " : " + cur.getString(3) + cur.getString(4) + " : " + cur.getString(5) + " : " + cur.getString(6) + " : " + cur.getString(7));

                Log.i("module", "id " + cur.getString(0));
                Log.i("module", "book id" + cur.getString(1));
                Log.i("module", "" + cur.getString(2));
                Log.i("module", "" + cur.getString(3));
                Log.i("module", "" + cur.getString(4));
                Log.i("module", "" + cur.getString(5));
                Log.i("module", "" + cur.getString(6));
                Log.i("module", "" + cur.getString(7));

                customername = cur.getString(5);
                date = cur.getString(2);
                time = cur.getString(3);
                qty = cur.getString(4);
                total = cur.getString(6);
                booking_id = cur.getString(1);
                status1=cur.getString(7);
                listItemList.add(new ListItem(customername, date, time, qty, total, booking_id,status1));
                cur.moveToNext();
                Log.i("tag ", "field name : " + DataBaseInfo.SC_NUMBER);
            }
        } catch (Exception e) {
            Log.e("tag", "problem in getting data from  tracker : " + e.getMessage());
        }
//        return rec[0].toString().trim();
        return listItemList;

    }

    public List getOrderItemTracker(Context context, String status, String bookingid) {
        SQLiteDatabase myDatabase;
        String rec[] = null;
        Cursor cur = null;
        String itemname = "", date = "", time = "", qty = "", price = "", booking_id = "";
        List<ListItem> listItemList = new ArrayList<>();
        try {
            myDatabase = (new SqlHelper(context, DataBaseInfo.DataBaseName, null, 1)).getReadableDatabase();
//            cur = myDatabase.query(DataBaseInfo.TABLENAME_ordertracker, null, null, null, null, null, null);
            String query = "";
            query = "SELECT * FROM " + DataBaseInfo.TABLENAME_orderitemtracker + " WHERE Status = "+status+" and booking_id = "+bookingid;//+status ;
//            query = "SELECT * FROM " + DataBaseInfo.TABLENAME_ordertracker + " WHERE Status = " + status + " and booking_id = " + bookingid;
            Log.i("tag", " from get order tracking : " + query);
            cur = myDatabase.rawQuery(query, null);
            cur.moveToFirst();

            rec = new String[cur.getCount()];
            for (int i = 0; i < cur.getCount(); i++) {
                rec[i] = cur.getString(1);
                Log.e("Checking", " " + cur.getString(0) + " : " + cur.getString(1) + " : " + cur.getString(2) + " : " + cur.getString(3) + cur.getString(4) + " : " + cur.getString(5));

                Log.i("module", "id " + cur.getString(0));
                Log.i("module", "book id" + cur.getString(1));
                Log.i("module", "item name" + cur.getString(2));
                Log.i("module", "qty" + cur.getString(3));
                Log.i("module", "rate" + cur.getString(4));
                Log.i("module", "status" + cur.getString(5));
               /* I/module: id 1
                I/module: book id3061
                I/module: item nameLarge Teriyaki Chicken on Rice with Mayo
                I/module: qty1.00
                I/module: rate9.90
                I/module: status4*/

                itemname = cur.getString(2);

                qty = cur.getString(3);
                price = cur.getString(4);
                booking_id = cur.getString(1);
                listItemList.add(new ListItem(price, qty, itemname, booking_id));

                cur.moveToNext();
                Log.i("tag ", "field name : " + DataBaseInfo.SC_NUMBER);
            }
        } catch (Exception e) {
            Log.e("tag", "problem in getting data from  tracker : " + e.getMessage());
        }
//        return rec[0].toString().trim();
        return listItemList;

    }

    public List getOrderTrackerDetails(Context context, String status, String bookingid) {
        SQLiteDatabase myDatabase;
        String rec[] = null;
        Cursor cur = null;
        String customername = "", booking_date = "", booking_id = "", call = "", email = "", location = "", subtotal = "",
                delivery_fee = "", service_tax = "", discount = "", grand_total = "", orderstatus = "";
        List<ListItem> listItemList = new ArrayList<>();
        try {
            myDatabase = (new SqlHelper(context, DataBaseInfo.DataBaseName, null, 1)).getReadableDatabase();
//            cur = myDatabase.query(DataBaseInfo.TABLENAME_ordertracker, null, null, null, null, null, null);
            String query = "";
            query = "SELECT * FROM " + DataBaseInfo.TABLENAME_orderdetails + " WHERE Status = " + status + " and booking_id = " + bookingid;
            Log.i("tag", " from get order tracking : " + query);
            cur = myDatabase.rawQuery(query, null);
            cur.moveToFirst();

            rec = new String[cur.getCount()];
            for (int i = 0; i < cur.getCount(); i++) {
//            rec[i]=cur.getString(0)+" : "+cur.getString(1)+" : "+ cur.getString(2)+" : "+ cur.getString(3);
                rec[i] = cur.getString(1);
                Log.e("Checking", " " + cur.getString(0) + " : " + cur.getString(1) + " : " + cur.getString(2) + " : " + cur.getString(3) + cur.getString(4) + " : " + cur.getString(5) + " : " + cur.getString(6) + " : " + cur.getString(7));

                Log.i("module", "id " + cur.getString(0));
                Log.i("module", "book id" + cur.getString(1));
                Log.i("module", "" + cur.getString(2));
                Log.i("module", "" + cur.getString(3));
                Log.i("module", "" + cur.getString(4));
                Log.i("module", "" + cur.getString(5));
                Log.i("module", "" + cur.getString(6));
                Log.i("module", "" + cur.getString(7));

                customername = cur.getString(1);
                booking_date = cur.getString(2);
                booking_id = cur.getString(3);
                call = cur.getString(4);
                email = cur.getString(5);
                location = cur.getString(6);
                subtotal = cur.getString(7);
                delivery_fee = cur.getString(8);
                service_tax = cur.getString(9);
                discount = cur.getString(10);
                grand_total = cur.getString(11);
                orderstatus = cur.getString(12);
                listItemList.add(new ListItem(customername, booking_date, booking_id, call, email, location, subtotal, delivery_fee, service_tax, discount, grand_total, orderstatus));
                cur.moveToNext();
                Log.i("tag ", "field name : " + DataBaseInfo.SC_NUMBER);
            }
        } catch (Exception e) {
            Log.e("tag", "problem in getting data from  tracker : " + e.getMessage());
        }
//        return rec[0].toString().trim();
        return listItemList;

    }

    //    public String getShopcode(Context context) {
    public Cursor getShopcode(Context context) {

        SQLiteDatabase myDatabase;
        String rec = "";
        Cursor cur = null;

        //   listItemList.add(new ListItem(service_name, desc, price, discount, offerprice, priceid, time, time));
        try {
            myDatabase = (new SqlHelper(context, DataBaseInfo.DataBaseName, null, 1)).getReadableDatabase();
            cur = myDatabase.query(DataBaseInfo.TABLENAME_shopcode, null, null, null, null, null, null);
            cur.moveToFirst();

            Log.i("tag", "before calling queary");
            for (int i = 0; i < cur.getCount(); i++) {
//                String customername, String date, String time, String qty, String total, String booking_id) {
                Log.e("tag", "id: " + cur.getString(0) + " bookid: " + cur.getString(1) + " date: " + cur.getString(2) + " time: " + cur.getString(3) + "qty : " + cur.getString(4) + " customer name: " + cur.getString(5) + " total : " + cur.getString(6) + " status : " + cur.getString(7));

                cur.moveToNext();
//                Log.i("tag ", "field name : " + DataBaseInfo.P_NAME);
            }
        } catch (Exception e) {
            Log.e("module", "problem in cursor : " + e.getMessage());
        }
//        return rec[0].toString().trim();
//        return rec;
        return cur;
    }


    private FragmentManager supportFragmentManager;
    private DatePickerDialog.OnDateSetListener mDateSetListener = null;
    String dt = "";

    @RequiresApi(api = Build.VERSION_CODES.N)
    public String showDatePicker(Context context) {
//         DatePickerDialog.OnDateSetListener mDateSetListener=null;
        final String[] selectDate = {""};
//        String dt="";
        try {
            Log.i("tag", "in funtion date picker");
            Calendar cal = Calendar.getInstance();
            int year = cal.get(Calendar.YEAR);
            int month = cal.get(Calendar.MONTH);
            int day = cal.get(Calendar.DAY_OF_MONTH);

            DatePickerDialog dialog = new DatePickerDialog(context, android.R.style.Theme_Holo_Light_Dialog_MinWidth, mDateSetListener, year, month, day);
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            dialog.show();


            mDateSetListener = new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                    month = month + 1;
                    Log.d("tag", "onDateSet: mm/dd/yyy: " + month + "/" + day + "/" + year);

                    String date = month + "/" + day + "/" + year;
//                    mDisplayDate.setText(date);

                    selectDate[0] = date.toString().trim();
                }
            };
        } catch (Exception e) {
            Log.i("tag", "error :  - " + e.getMessage());

        }
        return selectDate[0];

    }


}