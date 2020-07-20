package com.example.spleshanimataiontest.fragement;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.spleshanimataiontest.Detail_onging;
import com.example.spleshanimataiontest.R;
import com.example.spleshanimataiontest.adapter.AdapterOngoingOrder;
import com.example.spleshanimataiontest.datamodel.ListItem;
import com.example.spleshanimataiontest.datamodel.OrderModel;
import com.example.spleshanimataiontest.interfaces.ApiClient;
import com.example.spleshanimataiontest.interfaces.ApiInterface;
import com.example.spleshanimataiontest.utils.Modules;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class Fragment_Ongoing_Order extends Fragment {
    Handler mHandler;
    RecyclerView recyclerView;
    AdapterOngoingOrder adapter;
    public List<ListItem> listOngoingItemList;

    public Fragment_Ongoing_Order() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_ongoing_order, container, false);
        recyclerView = rootView.findViewById(R.id.recycler_view);
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getActivity(), 1);
        recyclerView.setLayoutManager(mLayoutManager);

        // getOrder();
        loaddata();
        try {  // this is use to call runnable method to refresh screen
            this.mHandler = new Handler();
            m_Runnable.run();
        } catch (Exception e) {
        }
    }

    private void loaddata() {
        listOngoingItemList = new ArrayList<>();
        Modules modules = new Modules();
        listOngoingItemList = modules.getOrderTracker(getContext(), "4");
//        Toast.makeText(getContext(), "loading data : ", Toast.LENGTH_LONG).show();
        if (listOngoingItemList.size() > 0) {
            adapter = new AdapterOngoingOrder(getActivity(), listOngoingItemList, new AdapterOngoingOrder.ClickListner() {
                public void onClick(List<ListItem> sheetname, int position) {
                    Intent i = new Intent(getActivity(), Detail_onging.class);
                    i.putExtra("list", (Serializable) sheetname);
                    i.putExtra("position", position);
                    i.putExtra("order", "ongoing");
                    startActivity(i);
                }
            }, "");
            recyclerView.setAdapter(adapter);
        } else {
            Toast.makeText(getActivity(), "No data found...!", Toast.LENGTH_SHORT).show();
        }
    }

    private final Runnable m_Runnable = new Runnable() {
        public void run() {
            //  Toast.makeText(getApplicationContext(), "in runnable", Toast.LENGTH_SHORT).show();
            Log.e("Nikunj", "runnable ");
            Fragment_Ongoing_Order.this.mHandler.postDelayed(m_Runnable, 60000);  // call after three minutess
            try {
                loaddata();
                //adapter.notifyDataSetChanged();
            } catch (Exception e) {
                Log.e("tag", "problem in refresh  :  " + e.getMessage());
            }
        }

    };
    private void getOrder() {
        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<OrderModel> getPatientResponseCall = apiInterface.getOrder();

        getPatientResponseCall.enqueue(new Callback<OrderModel>() {
            @Override
            public void onResponse(Call<OrderModel> call, Response<OrderModel> response) {

                assert response.body() != null;
//                if (response.body().getResultcode() == 200) {
                List<OrderModel.OrderHdr> items = response.body().getOrderHdrs();

               /* if (items.size() > 0) {
                    adapter = new AdapterOngoingOrder(getActivity(), items, new AdapterOngoingOrder.ClickListner() {
                        @Override
                        public void onClick(List<OrderModel.OrderHdr> sheetname, int position) {
                            Intent i = new Intent(getActivity(), DetailActivity.class);
                            i.putExtra("list", (Serializable) sheetname);
                            i.putExtra("position", position);
                            i.putExtra("order", "ongoing");
                            startActivity(i);
                        }
                    });
                    recyclerView.setAdapter(adapter);
                } else {
                    Toast.makeText(getActivity(), "No data found...!", Toast.LENGTH_SHORT).show();
                }*/

//                } else {
//                    Toast.makeText(getActivity(), "No data found...!", Toast.LENGTH_SHORT).show();
//                }
            }

            @Override
            public void onFailure(Call<OrderModel> call, Throwable t) {
            }
        });
    }
}
