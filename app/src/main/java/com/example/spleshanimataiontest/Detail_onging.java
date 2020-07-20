package com.example.spleshanimataiontest;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.spleshanimataiontest.DataBaseConnectionNew.Controller;
import com.example.spleshanimataiontest.adapter.AdapterCompletedOrder;
import com.example.spleshanimataiontest.adapter.AdapterOngoingSubOrder;
import com.example.spleshanimataiontest.datamodel.ListItem;
import com.example.spleshanimataiontest.interfaces.ApiClient;
import com.example.spleshanimataiontest.interfaces.ApiInterface;
import com.example.spleshanimataiontest.utils.CreatePDF;
import com.example.spleshanimataiontest.utils.Modules;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Detail_onging extends AppCompatActivity {

    String order, orderstatus = "", address = "", bookingid = "";
    int position;
    //    List<OrderModel.OrderHdr> myList;
    List<ListItem> myList;
    List<ListItem> myListsave;
    public List<ListItem> listOngoingSubItemList;

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

        myListsave = new ArrayList<ListItem>();
        myList = (ArrayList<ListItem>) getIntent().getSerializableExtra("list");
        position = getIntent().getIntExtra("position", 0);
        order = getIntent().getStringExtra("order");
        try {
            Modules modules = new Modules();
            myListsave = modules.getOrderTrackerDetails(context, "4", myList.get(position).getBooking_id());

        } catch (Exception e) {
            Log.e("tag", "problem in getting detail data from db : " + e.getMessage());
        }


        txt_subtotal = findViewById(R.id.txt_subtotal);
        txt_delivery_fee = findViewById(R.id.txt_delivery_fee);
        txt_service_tax = findViewById(R.id.txt_service_tax);
        txt_discount = findViewById(R.id.txt_discount);
        txt_grand_total = findViewById(R.id.txt_grand_total);

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
        try {
            Modules modules = new Modules();
            listOngoingSubItemList = new ArrayList<>();
            listOngoingSubItemList = modules.getOrderItemTracker(context, "4", myListsave.get(position).getBooking_id() + "");
            AdapterOngoingSubOrder adapter = new AdapterOngoingSubOrder(context, listOngoingSubItemList,"");
            recycler_view.setAdapter(adapter);

        } catch (Exception e) {
            Log.e("tag", "Problem in the list : " + e.getMessage());
        }
        Log.i("tag", "order id : " + myList.get(position).getBooking_id());

        try {


            if (order.matches("ongoing")) {
                setTitle("Ongoing Order : " + myList.get(position).getBooking_id());
                txt_order_status.setText("Order Status : Onging Order");
                bottomstatus.setBackgroundColor(R.color.blue);
                txtdelivery.setText("Read");
                statusid = 7; //  status: sent to Kitchen
                orderid = myList.get(position).getBooking_id();
                shopid = 27;
                updateat = "";
            }
        } catch (Exception e) {
            Log.e("Detail activity ", "Problem in setting title : " + e.getMessage());
            Log.e("Detail activity ", "Problem in setting title : " + e.getCause());
        }
try {
    txtcustomername.setText(myListsave.get(position).getCustomername());
    txt_booking_date.setText(myListsave.get(position).getDate() + " " + myListsave.get(position).getTime());
    txt_booking_id.setText("OrderId : " + myListsave.get(position).getBooking_id());
    bookingid = myListsave.get(position).getBooking_id();
    txt_call.setText(myListsave.get(position).getCustomernumber());
    txt_email.setText(myListsave.get(position).getCustomeremail());
    txt_location.setText(myListsave.get(position).getLocation());

    txt_subtotal.setText("Subtotal : " + myListsave.get(position).getTotal());
    txt_delivery_fee.setText("Delivery Fee : " + myListsave.get(position).getDelivery_fee());
    txt_service_tax.setText("+ GST Included (15%) : " + myListsave.get(position).getService_tax());
    txt_discount.setText("+ Discount (20%) : " + myListsave.get(position).getDiscount());
    txt_grand_total.setText("Total : " + myListsave.get(position).getGrand_total());

    orderstatus = myListsave.get(position).getStatus();
    Toast.makeText(getApplicationContext(), "order : " + orderstatus, Toast.LENGTH_SHORT).show();
}catch (Exception e){
    Log.e("tag","problem in initcompo: "+e.getMessage());
}

        rl_call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel: " + myListsave.get(position).getCustomernumber()));
                startActivity(intent);
            }
        });
        rl_email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Toast.makeText(getApplicationContext(), "calling email ", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(Intent.ACTION_SEND);
                    String[] recipients = {myListsave.get(position).getCustomeremail()};
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
                Controller controller = new Controller();
                controller.UpdateStatus(context, bookingid,  statusid + "");
                Toast.makeText(getApplicationContext(), "updated", Toast.LENGTH_LONG).show();
                setStstus(orderid, shopid, statusid, updateat);
                finish();
            }
        });
        rl_print.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CreatePDF createPDF = new CreatePDF();
                createPDF.createPdf("this nikunk test",bookingid,context);
            }
        });



        txtvoid.setOnClickListener(new View.OnClickListener() { // cancel order void button
            @Override
            public void onClick(View v) {
                try {
                    Toast.makeText(getApplicationContext(), "calling void ", Toast.LENGTH_LONG).show();
                    statusid = 8;
                    setStstus(orderid, shopid, statusid, updateat);
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
