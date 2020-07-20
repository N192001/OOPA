package com.example.spleshanimataiontest.adapter;

import android.content.Context;
import android.os.Build;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import com.example.spleshanimataiontest.DataBaseConnectionNew.Controller;
import com.example.spleshanimataiontest.DataBaseConnectionNew.DataBaseInfo;
import com.example.spleshanimataiontest.R;
import com.example.spleshanimataiontest.datamodel.OrderModel;

import java.util.List;

public class AdapterNewSubOrder extends RecyclerView.Adapter<AdapterNewSubOrder.ViewHolder> {
    List<OrderModel.OrderHdr.OrderDtl> data;
    Context mContext;
    //String itemlist="";
    String itemlist[];
    int temp = 0;
    String price = "", qty = "", itemname = "", booking_id = "",bookingid="";
    String[] orderitemtracker = new String[5];
    public AdapterNewSubOrder(Context activity, List<OrderModel.OrderHdr.OrderDtl> data) {
        this.data = data;
        this.mContext = activity;
        int temp = getItemCount();
        itemlist = new String[temp];
    }

    @Override
    public AdapterNewSubOrder.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.raw_sub_new_order, parent, false);
        final AdapterNewSubOrder.ViewHolder mViewHolder = new AdapterNewSubOrder.ViewHolder(mView);
        return mViewHolder;
    }

    @Override
    @RequiresApi(api = Build.VERSION_CODES.N)
    public void onBindViewHolder(final AdapterNewSubOrder.ViewHolder holder, final int position) {
        holder.txtname.setText(data.get(position).getName());
        holder.txtqty.setText("Qty : " + data.get(position).getQty());
        holder.txtprice.setText("$ " + data.get(position).getItemTotal());
//        holder.txtprice.setText("$ " + data.get(position).getOrderId());


        itemlist[position] = data.get(position).getName() + "   " + data.get(position).getQty() + "   " + data.get(position).getTax1Amount();
        try {
//saveing value inthe local database from the server
            int id=0;
            bookingid=data.get(position).getOrderId();
            booking_id = bookingid.subSequence(11, 15)+"";
            Controller controller = new Controller();
            id=controller.getMaxItemBookingID(mContext,booking_id);
            Log.i("tag","max id from the db : "+id);
            //if(Integer.parseInt(booking_id)>id) {
                price = data.get(position).getItemTotal();
                qty= data.get(position).getQty();
                itemname= data.get(position).getName();
                orderitemtracker[0] = booking_id;
                orderitemtracker[1] = itemname;
                orderitemtracker[2] = qty;
                orderitemtracker[3] = price;
                orderitemtracker[4] = "4";
                controller.InsertData(DataBaseInfo.TABLENAME_orderitemtracker, orderitemtracker, mContext);
            //}
        } catch (Exception e) {
            Log.e("tag", "Problem in inserting in orderitemtracker  : " + e.getMessage());
        }
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView txtname;
        public TextView txtqty;
        public TextView txtprice;

        ViewHolder(View v) {
            super(v);
            txtname = v.findViewById(R.id.txtname);
            txtqty = v.findViewById(R.id.txtqty);
            txtprice = v.findViewById(R.id.txtprice);
        }
    }

    public String[] getitemlist() {

        return itemlist;
    }
}