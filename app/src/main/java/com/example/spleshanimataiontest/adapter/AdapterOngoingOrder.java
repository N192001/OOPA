package com.example.spleshanimataiontest.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.spleshanimataiontest.DetailActivity;
import com.example.spleshanimataiontest.R;
import com.example.spleshanimataiontest.datamodel.ListItem;
import com.example.spleshanimataiontest.datamodel.OrderModel;
import com.example.spleshanimataiontest.utils.Modules;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static androidx.core.content.ContextCompat.startActivity;

public class AdapterOngoingOrder extends RecyclerView.Adapter<AdapterOngoingOrder.ViewHolder> {
//    List<OrderModel.OrderHdr> data;
    List<ListItem> localdata;
    Context mContext;
    public List<ListItem> listOngoingSubItemList;
    ClickListner clickListner;
    String saveshopcode = "", bookingid = "", bookingdate = "", bookingtime = "", bookedqty = "";

    public AdapterOngoingOrder(Context activity, List<OrderModel.OrderHdr> data, ClickListner clickListner1) {
//        this.data = data;
        this.mContext = activity;
        clickListner = clickListner1;
    }

    public AdapterOngoingOrder(Context activity, List<ListItem> data, ClickListner clickListner1, String empty) {
        this.localdata = data;
        this.mContext = activity;
        clickListner = clickListner1;
    }

    public interface ClickListner {
//        void onClick(List<OrderModel.OrderHdr> sheetname, int position);
        void onClick(List<ListItem> sheetname, int position);
    }

    @Override
    public AdapterOngoingOrder.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.raw_ongoing_order, parent, false);
        final AdapterOngoingOrder.ViewHolder mViewHolder = new AdapterOngoingOrder.ViewHolder(mView);
        return mViewHolder;
    }

    @Override
    public void onBindViewHolder(final AdapterOngoingOrder.ViewHolder holder, final int position) {

      /*  Log.i("tag", ";;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;");
        Log.i("tag", "total : " + localdata.get(position).getTotal());
        Log.i("tag", "time :" + localdata.get(position).getTime());
        Log.i("tag", "status :" + localdata.get(position).getStatus());
        Log.i("tag", "bookid :" + localdata.get(position).getBooking_id());
        Log.i("tag", "customer nme :" + localdata.get(position).getCustomername());
        Log.i("tag", "date" + localdata.get(position).getDate());
        Log.i("tag", "discount :" + localdata.get(position).getDiscount());
        Log.i("tag", "price : " + localdata.get(position).getPrice());
        Log.i("tag", "offer price :" + localdata.get(position).getOfferprice());
        Log.i("tag", "qty :" + localdata.get(position).getQty());
        Log.i("tag", ";;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;");
    */
      holder.txtcustomername.setText(localdata.get(position).getCustomername());
        if (localdata.size() > 0) {
            holder.txtcustomername.setText(localdata.get(position).getCustomername());//+ " " + data.get(position).getOrderCustomer().getLastName());
            holder.txt_booking_date.setText(localdata.get(position).getDate());
            holder.txt_booking_time.setText(localdata.get(position).getTime());
            holder.txt_booking_id.setText("OrderId : " + localdata.get(position).getBooking_id());
            holder.txt_total.setText("Total : " + localdata.get(position).getTotal());
            holder.txtqty.setText("Qty : " + localdata.get(position).getQty());

            holder.recyclerView.setHasFixedSize(true);
            RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(mContext, 1);
            holder.recyclerView.setLayoutManager(mLayoutManager);

//            AdapterOngoingSubOrder adapter = new AdapterOngoingSubOrder(mContext, data.get(position).getOrderDtls());
            //holder.recyclerView.setAdapter(adapter);

            Modules modules = new Modules();
            listOngoingSubItemList=new ArrayList<>();
            listOngoingSubItemList = modules.getOrderItemTracker(mContext, "4",localdata.get(position).getBooking_id()+"");
            Log.i("tag","size :"+listOngoingSubItemList.size());
            AdapterOngoingSubOrder adapter = new AdapterOngoingSubOrder(mContext, listOngoingSubItemList,"");
            holder.recyclerView.setAdapter(adapter);
            try {
                //  int qty = adapter.getItemCount();
                holder.txtqty.setText("Qty : " + localdata.get(position).getQty());
            } catch (Exception e) {
                Log.e("Adapater", "problem in getting  item coutnt : " + e.getMessage());
            }
            holder.rl_detail.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    clickListner.onClick(localdata, position);
//                    Intent detailsintent=new Intent(mContext, DetailActivity.class);
//                    detailsintent.putExtra("bookingid",bookingid);
//                    startActivity(detailsintent);
                }
            });
        }

    }

    @Override
    public int getItemCount() {
        return localdata.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView txtcustomername;
        public TextView txt_booking_date;
        public TextView txt_booking_time;
        public TextView txt_booking_id;
        public TextView txt_total;
        public TextView txtqty;

        RecyclerView recyclerView;

        RelativeLayout rl_detail;
        RelativeLayout rl_print;

        ViewHolder(View v) {
            super(v);
            txt_booking_id = v.findViewById(R.id.txt_booking_id);
            txt_booking_date = v.findViewById(R.id.txt_booking_date);
            txtcustomername = v.findViewById(R.id.txtcustomername);
            txt_total = v.findViewById(R.id.txt_total);
            txt_booking_time = v.findViewById(R.id.txt_booking_time);
            txtqty = v.findViewById(R.id.txtqty);
            recyclerView = v.findViewById(R.id.recycler_view);

            rl_detail = v.findViewById(R.id.rl_detail);
            rl_print = v.findViewById(R.id.rl_print);
        }
    }

    private String changedateformat(String rawDate) {
        DateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd");
        DateFormat outputFormat = new SimpleDateFormat("dd MMM yyyy");
        String inputDateStr = "2013-06-24";
        Date date = null;
        try {
            date = inputFormat.parse(rawDate);
        } catch (Exception e) {
        }

        String outputDateStr = outputFormat.format(date);
        return outputDateStr;
    }
}