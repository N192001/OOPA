package com.example.spleshanimataiontest.fragement;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.spleshanimataiontest.DataBaseConnectionNew.Controller;
import com.example.spleshanimataiontest.DataBaseConnectionNew.DataBaseInfo;
import com.example.spleshanimataiontest.DetailActivity;
import com.example.spleshanimataiontest.R;
import com.example.spleshanimataiontest.adapter.AdapterNewOrder;
import com.example.spleshanimataiontest.datamodel.OrderModel;
import com.example.spleshanimataiontest.interfaces.ApiClient;
import com.example.spleshanimataiontest.interfaces.ApiInterface;

import java.io.Serializable;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class Fragment_New_Order extends Fragment {

    RecyclerView recyclerView;
    AdapterNewOrder adapter;
    Handler mHandler;
    TextView totalorder;

    public Fragment_New_Order() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_new_order, container, false);
        recyclerView = rootView.findViewById(R.id.recycler_view);
        totalorder = rootView.findViewById(R.id.textviewtotalorder);
        return rootView;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getActivity(), 1);
        recyclerView.setLayoutManager(mLayoutManager);

        getOrder();
        try {  // this is use to call runnable method to refresh screen
            this.mHandler = new Handler();
            m_Runnable.run();
        } catch (Exception e) {
        }

    }

    private void getOrder() {
        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<OrderModel> getPatientResponseCall = apiInterface.getOrder();
        final ProgressDialog progressDoalog;
        progressDoalog = new ProgressDialog(getContext());

        progressDoalog.setMessage("Please wait loading orders ....");
        progressDoalog.setTitle("New Orders");
        progressDoalog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        // show it
        progressDoalog.show();
        getPatientResponseCall.enqueue(new Callback<OrderModel>() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onResponse(Call<OrderModel> call, Response<OrderModel> response) {

                assert response.body() != null;
                List<OrderModel.OrderHdr> items = response.body().getOrderHdrs();
                List<OrderModel.OrderHdr.OrderDtl> itemsdetails = response.body().getOrderDtls();
                List<OrderModel.OrderHdr.OrderHdrExt> itemsorderhrd = response.body().getOrderHdrExts();
                Log.e("tag", "item size: " + items.size());
//                Toast.makeText(getContext(),"item_size : "+ items.size(), Toast.LENGTH_LONG).show();
                progressDoalog.dismiss();
                if (items.size() > 0) {

                    totalorder.setText(items.size() + " New Order");
                    adapter = new AdapterNewOrder(getActivity(), items, new AdapterNewOrder.ClickListner() {
                        @Override
                        public void onClick(List<OrderModel.OrderHdr> sheetname, int position) {
getOrder();
                            Intent i = new Intent(getActivity(), DetailActivity.class);

                            i.putExtra("list", (Serializable) sheetname);
                            i.putExtra("position", position);
                            i.putExtra("order", "new");
                            startActivity(i);

                        }
                    });
                    recyclerView.setAdapter(adapter);

                    try {
                        Log.i("new order", "item size : " + items.size());
                        Context context = getContext();
                        Controller controller = new Controller();
                        controller.InsertOrderData(DataBaseInfo.TABLENAME_OrderHeadermaster, items, context);

                        Log.i("Fragement new order", "order entry successfully : ");
                    } catch (Exception e) {
                        Log.e("Fragement new order", "Error in order entry : " + e.getMessage());
                    }
                    try {
                        Context context = null;
                        Controller controller = new Controller();
                        controller.InsertOrderDetailData(DataBaseInfo.TABLENAME_OrderDetailmaster, itemsdetails, context);

                        Log.i("Fragement new order", "order entry successfully : ");
                    } catch (Exception e) {
                        Log.e("Fragement new order", "Error in order entry : " + e.getMessage());
                    }
                    try {
                        Context context = null;
                        Controller controller = new Controller();
                        controller.InsertOrderHdrExtData(DataBaseInfo.TABLENAME_OrderHeaderExt, itemsorderhrd, context);

                        Log.i("Fragement new order", "order entry successfully : ");
                    } catch (Exception e) {
                        Log.e("Fragement new order", "Error in order entry : " + e.getMessage());
                    }
                } else {
                    Toast.makeText(getActivity(), "No data found...!", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<OrderModel> call, Throwable t) {
                progressDoalog.dismiss();
            }
        });
    }

    /***
     * this code help in refressing the screen
     */
    private final Runnable m_Runnable = new Runnable() {
        public void run() {
            //  Toast.makeText(getApplicationContext(), "in runnable", Toast.LENGTH_SHORT).show();
            Log.e("Nikunj", "runnable ");
            Fragment_New_Order.this.mHandler.postDelayed(m_Runnable, 60000);  // call after three minutess
            try {
                getOrder();
                adapter.notifyDataSetChanged();
            } catch (Exception e) {
                Log.e("tag", "problem in refresh  :  " + e.getMessage());
            }
        }

    };
}
