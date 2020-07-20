package com.example.spleshanimataiontest.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.spleshanimataiontest.R;
import com.example.spleshanimataiontest.datamodel.ListItem;
import com.example.spleshanimataiontest.datamodel.OrderModel;
import com.example.spleshanimataiontest.utils.Modules;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AdapterCompletedOrder extends RecyclerView.Adapter<AdapterCompletedOrder.ViewHolder> {
//    List<OrderModel.OrderHdr> data;
List<ListItem> localdata;
    Context mContext;
    public List<ListItem> listOngoingSubItemList;
    ClickListner clickListner;
    String saveshopcode = "", bookingid = "", bookingdate = "", bookingtime = "", bookedqty = "";
   /* public AdapterCompletedOrder(Context activity, List<OrderModel.OrderHdr> data, ClickListner clickListner1) {
//        this.data = data;
        this.mContext = activity;
        clickListner = clickListner1;
    }*/

    public AdapterCompletedOrder(Context activity, List<ListItem> data, AdapterCompletedOrder.ClickListner clickListner1, String empty) {
        this.localdata = data;
        this.mContext = activity;
        clickListner =  clickListner1;
    }

    public interface ClickListner {
        void onClick(List<ListItem> sheetname, int position);
    }

    @Override
    public AdapterCompletedOrder.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.raw_completed_order, parent, false);
        final AdapterCompletedOrder.ViewHolder mViewHolder = new AdapterCompletedOrder.ViewHolder(mView);
        return mViewHolder;
    }

    @Override
    public void onBindViewHolder(final AdapterCompletedOrder.ViewHolder holder, final int position) {
        if (localdata.size() > 0) {
            holder.txtcustomername.setText(localdata.get(position).getCustomername());//+ " " + data.get(position).getOrderCustomer().getLastName());
            holder.txt_booking_date.setText(localdata.get(position).getDate());
            holder.txt_booking_time.setText(localdata.get(position).getTime());
            holder.txt_booking_id.setText("OrderId : " + localdata.get(position).getBooking_id());
            holder.txt_total.setText("Total : " + localdata.get(position).getTotal());
           // holder.txtqty.setText("Qty : " + localdata.get(position).getQty());
            holder.txt_total_qty.setText("Qty : " + localdata.get(position).getQty());
            try {
                if (localdata.get(position).getStatus().equals("8")) {
                    holder.rl_cancelorder.setVisibility(View.VISIBLE);
                }
            }catch (Exception e){}
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
        /*holder.txtcustomername.setText(data.get(position).getOrderCustomer().getFirstName() + " " + data.get(position).getOrderCustomer().getLastName());
//        holder.txt_booking_date.setText(data.get(position).getOrderTime());
        holder.txt_booking_id.setText("OrderId : " + data.get(position).getOrderNo());
        holder.txt_total.setText("Total : " + data.get(position).getOrderPayments().get(0).getPaidAmount());
        bookingdate = (data.get(position).getOrderTime());
        holder.txt_booking_date.setText(changedateformat(bookingdate.substring(0, 11)));
        bookingtime = data.get(position).getOrderTime();
        try {
            holder.txt_booking_time.setText(bookingtime.substring(10, 19));
        } catch (Exception e) {
            Log.e("Adapter new Orde", "prblem in booking time :" + e.getMessage());
        }
        holder.recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(mContext, 1);
        holder.recyclerView.setLayoutManager(mLayoutManager);

        AdapterCompletedSubOrder adapter = new AdapterCompletedSubOrder(mContext, data.get(position).getOrderDtls());
        holder.recyclerView.setAdapter(adapter);

        try {
            int qty = adapter.getItemCount();
            holder.txt_total_qty.setText("Qty : "+qty + "");
        } catch (Exception e) {
            Log.e("Adapater", "problem in getting  item coutnt : " + e.getMessage());
        }
        holder.rl_detail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickListner.onClick(data,position);
            }
        });*/
    }

    @Override
    public int getItemCount() {
        return localdata.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView txtcustomername;
        public TextView txt_booking_date;
        public TextView txt_booking_id;
        public TextView txt_total;
        public TextView txt_booking_time;
        public TextView txt_total_qty;
        public TextView txtqty;

        RecyclerView recyclerView;

        RelativeLayout rl_cancelorder;
        RelativeLayout rl_detail;
        RelativeLayout rl_print;

        ViewHolder(View v) {
            super(v);
            txt_booking_id = v.findViewById(R.id.txt_booking_id);
            txt_booking_date = v.findViewById(R.id.txt_booking_date);
            txt_booking_time = v.findViewById(R.id.txt_booking_time);
            txt_total_qty = v.findViewById(R.id.txt_total_qty1);
            txtcustomername = v.findViewById(R.id.txtcustomername);
            txt_total = v.findViewById(R.id.txt_total);
            recyclerView = v.findViewById(R.id.recycler_view);
            txtqty = v.findViewById(R.id.txtqty);
            rl_detail = v.findViewById(R.id.rl_detail);
            rl_print = v.findViewById(R.id.rl_print);
            rl_cancelorder = v.findViewById(R.id.rl_cancelorder);
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