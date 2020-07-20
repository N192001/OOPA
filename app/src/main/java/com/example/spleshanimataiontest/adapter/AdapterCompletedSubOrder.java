package com.example.spleshanimataiontest.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.spleshanimataiontest.R;
import com.example.spleshanimataiontest.datamodel.OrderModel;

import java.util.List;

public class AdapterCompletedSubOrder extends RecyclerView.Adapter<AdapterCompletedSubOrder.ViewHolder> {
    List<OrderModel.OrderHdr.OrderDtl> data;
    Context mContext;

    public AdapterCompletedSubOrder(Context activity, List<OrderModel.OrderHdr.OrderDtl> data) {
        this.data = data;
        this.mContext = activity;
    }

    @Override
    public AdapterCompletedSubOrder.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.raw_sub_completed_order, parent, false);
        final AdapterCompletedSubOrder.ViewHolder mViewHolder = new AdapterCompletedSubOrder.ViewHolder(mView);
        return mViewHolder;
    }

    @Override
    public void onBindViewHolder(final AdapterCompletedSubOrder.ViewHolder holder, final int position) {
        holder.txtname.setText(data.get(position).getName());
        holder.txtqty.setText("Qty : " + data.get(position).getQty());
        holder.txtprice.setText("$ " + data.get(position).getItemTotal());
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
}