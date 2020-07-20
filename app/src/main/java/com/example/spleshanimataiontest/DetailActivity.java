package com.example.spleshanimataiontest;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.LongDef;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.spleshanimataiontest.DataBaseConnectionNew.Controller;
import com.example.spleshanimataiontest.DataBaseConnectionNew.DataBaseInfo;
import com.example.spleshanimataiontest.adapter.AdapterCompletedOrder;
import com.example.spleshanimataiontest.adapter.AdapterDetail;
import com.example.spleshanimataiontest.datamodel.OrderModel;
import com.example.spleshanimataiontest.interfaces.ApiClient;
import com.example.spleshanimataiontest.interfaces.ApiInterface;
import com.example.spleshanimataiontest.utils.CreatePDF;
import com.google.gson.JsonObject;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailActivity extends AppCompatActivity {

    String order, orderstatus = "", address = "",bookingid="";
    int position;
    List<OrderModel.OrderHdr> myList;

    String statuscode = "", orderid = "", updateat = "";
    int shopid, statusid;
    TextView txt_order_status;

    TextView txtcustomername;
    TextView txt_booking_date;
    TextView txt_booking_id;

    TextView txt_call;
    TextView txt_email;
    TextView txt_location;

    TextView txt_subtotal;
    TextView txt_delivery_fee;
    TextView txt_service_tax;
    TextView txt_discount;
    TextView txt_grand_total;
    TextView txtprint;

    //    TextView txtdelivery;
//    Button txtdelivery,cmddelivery;
    TextView txtvoid;
    TextView txtdelivery;

    RelativeLayout rl_call;
    RelativeLayout rl_email;
    RelativeLayout rl_location;
    RelativeLayout rl_print;

    LinearLayout bottomstatus;
    String[] insertvalues = new String[13];
    RecyclerView recycler_view;

    Context context = this;
    AdapterCompletedOrder adapter;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        myList = (ArrayList<OrderModel.OrderHdr>) getIntent().getSerializableExtra("list");
        position = getIntent().getIntExtra("position", 0);
        order = getIntent().getStringExtra("order");

        try{
            String tempoid="";
            tempoid=myList.get(position).getOrderCustomer().getOrderId().subSequence(11, 15)+"";
            setStstus(tempoid, 27, 3, updateat);

        }catch (Exception e){
            Log.e("tag","problem in the calling aysnc class: "+e.getMessage());
        }


        txt_subtotal = findViewById(R.id.txt_subtotal);
        txt_delivery_fee = findViewById(R.id.txt_delivery_fee);
        txt_service_tax = findViewById(R.id.txt_service_tax);
        txt_discount = findViewById(R.id.txt_discount);
        txt_grand_total = findViewById(R.id.txt_grand_total);
        txtprint = findViewById(R.id.txtprint);

//        txtdelivery = findViewById(R.id.txt_delivery);
        txtvoid = findViewById(R.id.txtvoid);

        rl_call = findViewById(R.id.rl_call);
        rl_email = findViewById(R.id.rl_email);
        rl_location = findViewById(R.id.rl_location);
        rl_print = findViewById(R.id.rl_print);

        txtcustomername = findViewById(R.id.txtcustomername);
        txt_booking_date = findViewById(R.id.txt_booking_date);
        txt_booking_id = findViewById(R.id.txt_booking_id);

        txt_call = findViewById(R.id.txt_call);
        txt_email = findViewById(R.id.txt_email);
        txt_location = findViewById(R.id.txt_location);

        bottomstatus = findViewById(R.id.bottomstatus);
        txt_order_status = findViewById(R.id.txt_order_status);


        recycler_view = findViewById(R.id.recycler_view);

        recycler_view.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(context, 1);
        recycler_view.setLayoutManager(mLayoutManager);

        AdapterDetail adapter = new AdapterDetail(context, myList.get(position).getOrderDtls());
        recycler_view.setAdapter(adapter);

        Log.i("tag", "order id : " + myList.get(position).getOrderId());

        try {

            if (order.matches("new")) {
                setTitle("New Order : " + myList.get(position).getOrderCustomer().getOrderId().subSequence(11, 15));
                txt_order_status.setText("Order Status : New Order");
                txt_order_status.setTextColor(R.color.colorOrange);
                bottomstatus.setBackgroundColor(R.color.colorOrange);
                 txtdelivery.setText("send to Kitchen");
                statusid = 4;
                orderid = myList.get(position).getOrderId();
                shopid = 27;
                updateat = "";

            } /*else if (order.matches("ongoing")) {
                setTitle("Ongoing Order : " + myList.get(position).getOrderCustomer().getOrderId().subSequence(11, 15));
                txt_order_status.setText("Order Status : Onging Order");
                bottomstatus.setBackgroundColor(R.color.blue);
                //txtdelivery.setText("Read");
                statusid = 7; //  status: sent to Kitchen
                orderid = myList.get(position).getOrderId();
                shopid = 27;
                updateat = "";
            } else if (order.matches("complete")) {
                setTitle("Completed Order : " + myList.get(position).getOrderCustomer().getOrderId().subSequence(11, 15));
                txt_order_status.setText("Order Status : Complete Order");
                bottomstatus.setBackgroundColor(R.color.green);
                statusid = 7;
                orderid = myList.get(position).getOrderNo();
                shopid = 27;
                updateat = "";
            }*/
        } catch (Exception e) {
            Log.e("Detail activity ", "Problem in setting title : " + e.getMessage());
            Log.e("Detail activity ", "Problem in setting title : " + e.getCause());
        }

        txtcustomername.setText(myList.get(position).getOrderCustomer().getFirstName() + " " + myList.get(position).getOrderCustomer().getLastName());
        txt_booking_date.setText(myList.get(position).getOrderTime());
        txt_booking_id.setText("OrderId : " + myList.get(position).getOrderNo());
        bookingid=myList.get(position).getOrderNo();
        txt_call.setText(myList.get(position).getOrderCustomer().getPhoneNumber());
        txt_email.setText(myList.get(position).getOrderCustomer().getEmail());
        txt_location.setText(myList.get(position).getOrderCustomer().getAddress());

        txt_subtotal.setText("Subtotal : " + myList.get(position).getDetailTotal());
        txt_delivery_fee.setText("Delivery Fee : " + myList.get(position).getTotalPrintCount());
        txt_service_tax.setText("+ GST Included (15%) : " + myList.get(position).getTotalTax1());
        txt_discount.setText("+ Discount (20%) : " + myList.get(position).getBillDiscountAmount());
        txt_grand_total.setText("Total : " + myList.get(position).getOrderPayments().get(0).getPaidAmount());

        orderstatus = myList.get(position).getStatus();
        Toast.makeText(getApplicationContext(), "order : " + orderstatus, Toast.LENGTH_SHORT).show();
        try {
            Log.i("insert","----------------->>"+myList.get(position).getOrderCustomer().getFirstName() + " " + myList.get(position).getOrderCustomer().getLastName());
            Log.i("insert","-----------------"+ myList.get(position).getOrderTime());
            Log.i("insert","-----------------"+ myList.get(position).getOrderNo());
            Log.i("insert","-----------------"+ myList.get(position).getOrderCustomer().getPhoneNumber());
            Log.i("insert","-----------------"+ myList.get(position).getOrderCustomer().getEmail());
            Log.i("insert","----------------->>");
            Log.i("insert","-----------------"+ myList.get(position).getDetailTotal());
            Log.i("insert","-----------------"+ myList.get(position).getTotalPrintCount());
            Log.i("insert","-----------------"+ myList.get(position).getTotalTax1());
            Log.i("insert","-----------------"+ myList.get(position).getBillDiscountAmount());
            Log.i("insert","-----------------"+ myList.get(position).getOrderPayments().get(0).getPaidAmount());
            Log.i("insert","-----------------"+ "4");

            insertvalues[0] = myList.get(position).getOrderCustomer().getFirstName() + " " + myList.get(position).getOrderCustomer().getLastName();
            insertvalues[1] = myList.get(position).getOrderTime();
            insertvalues[2] = myList.get(position).getOrderNo();
            insertvalues[3] = myList.get(position).getOrderCustomer().getPhoneNumber();
            insertvalues[4] = myList.get(position).getOrderCustomer().getEmail();
            insertvalues[5]="NA";
            insertvalues[6] = myList.get(position).getDetailTotal();
            insertvalues[7] = myList.get(position).getTotalPrintCount();
            insertvalues[8] = myList.get(position).getTotalTax1();
            insertvalues[9] = myList.get(position).getBillDiscountAmount();
            insertvalues[10] = myList.get(position).getOrderPayments().get(0).getPaidAmount();
            insertvalues[11] = "4";
            Controller controller = new Controller();
            controller.InsertData(DataBaseInfo.TABLENAME_orderdetails, insertvalues, DetailActivity.this);
            Log.i("tag", "after saving");
        } catch (Exception e) {
            Log.e("tag", "problem in array details :" + e.getMessage());
        }
        rl_call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel: " + myList.get(position).getOrderCustomer().getPhoneNumber()));
                startActivity(intent);
            }
        });
        rl_email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Toast.makeText(getApplicationContext(), "calling email ", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(Intent.ACTION_SEND);
                    String[] recipients = {myList.get(position).getOrderCustomer().getEmail()};
                    intent.putExtra(Intent.EXTRA_EMAIL, recipients);
                    intent.putExtra(Intent.EXTRA_SUBJECT, "");//Subject text here...
                    intent.putExtra(Intent.EXTRA_TEXT, "");//Body of the content here...
                    //intent.putExtra(Intent.EXTRA_CC,"mailcc@gmail.com");
                    intent.setType("text/html");
                    intent.setPackage("com.google.android.gm");
                    startActivity(Intent.createChooser(intent, "Send mail"));
                } catch (Exception e) {

                }
            }
        });
        rl_location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Controller controller=new Controller();
                controller.UpdateStatus(context,bookingid,"4");
                Toast.makeText(getApplicationContext(),"updated",Toast.LENGTH_LONG).show();
               try {
                   orderid=myList.get(position).getOrderNo();
                       setStstus(orderid, 27, 4, updateat);
               }catch (Exception e){}
                Log.e("tag","");
                finish();
            }
        });
        rl_print.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CreatePDF createPDF = new CreatePDF();
                createPDF.createPdf("this nikunk test\n is a good boy",bookingid,context);
            }
        });



        txtvoid.setOnClickListener(new View.OnClickListener() { // cancel order void button
            @Override
            public void onClick(View v) {
                try {
                    Toast.makeText(getApplicationContext(), "calling void ", Toast.LENGTH_LONG).show();
                    statusid = 8;
                    orderid=myList.get(position).getOrderNo();
                    setStstus(orderid, 27, 8, updateat);
                    Controller controller = new Controller();
                    controller.UpdateStatus(context, orderid, statusid + "");
                    finish();
                } catch (Exception e) {
                    Log.e("tag", "Problem in cancel  Void : " + e.getMessage());
                }

            }
        });


    }



    private void setStstus(String orderid, int shopid, int statusid, String updateat) {

        String url = "https://mochipos.co.nz/oo-pos-ws-test/oo_status_update.php?synchronize=" +
                "{\"order_id\":\"" +"S044-OOT-00"+ orderid + "\"," +
                " \"shop_id\": " + shopid + ", " +
                "\"status\":" + statusid + ", " +
                "\"updated_at\":\"2020-04-27 18:14:08\"}";
//              "\"updated_at\":\"" + updateat + "\"}";
        Log.i("tag", "url : " + url);
        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<JsonObject> getPatientResponseCall = apiInterface.setstatus(url);

        getPatientResponseCall.enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {

                assert response.body() != null;
                String jsonres = String.valueOf(response.body());
                Log.d("Response", jsonres);
            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {
                Log.d("Error", t.getMessage());
            }
        });
    }



}