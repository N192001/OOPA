package com.example.spleshanimataiontest.adapter;

import android.content.Context;
import android.content.SharedPreferences;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.ToneGenerator;
import android.os.Build;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.spleshanimataiontest.DataBaseConnectionNew.Controller;
import com.example.spleshanimataiontest.DataBaseConnectionNew.DataBaseInfo;
import com.example.spleshanimataiontest.R;
import com.example.spleshanimataiontest.datamodel.OrderModel;
import com.example.spleshanimataiontest.utils.PrrintBill;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class AdapterNewOrder extends RecyclerView.Adapter<AdapterNewOrder.ViewHolder> {
    List<OrderModel.OrderHdr> data;
    Context mContext;

    ClickListner clickListner;
    PrrintBill prrintBill = new PrrintBill();
    String[] headerdetails = new String[6];
    String[] itemdetails = new String[100];
    String[] ordertracker = new String[10];
    SharedPreferences sharedpreferences;
    String saveshopcode = "", bookingid = "", bookingdate = "", bookingtime = "", bookedqty = "", customername = "", total = "", stauts = "";
    String booking_id = "", booking_date = "", booking_time = "", booked_qty = "";

    @RequiresApi(api = Build.VERSION_CODES.N)
    public AdapterNewOrder(Context activity, List<OrderModel.OrderHdr> data, ClickListner clickListner1) {
        this.data = data;
        this.mContext = activity;
        clickListner = clickListner1;
        // playbeep(1);
        // playAlertTone(mContext);
      /* Context context=null;
        Controller controller=new Controller();
        controller.InsertOrderData(DataBaseInfo.TABLENAME_OrderDetailmaster,data, context);*/
    }

    public interface ClickListner {
        void onClick(List<OrderModel.OrderHdr> sheetname, int position);

    }

    @Override
    public AdapterNewOrder.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.raw_new_order, parent, false);
        final AdapterNewOrder.ViewHolder mViewHolder = new AdapterNewOrder.ViewHolder(mView);
        return mViewHolder;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override

    public void onBindViewHolder(final AdapterNewOrder.ViewHolder holder, final int position) {

        holder.txtcustomername.setText(data.get(position).getOrderCustomer().getFirstName() + " " + data.get(position).getOrderCustomer().getLastName());
        bookingdate = (data.get(position).getOrderTime());
        //bookingdate.subSequence(11,15);
        holder.txt_booking_date.setText(changedateformat(bookingdate.substring(0, 11)));
        bookingtime = data.get(position).getOrderTime();
        bookingid = data.get(position).getOrderId();
        Log.i("tag", "booking id from adapter : " + bookingid);
        try {
            holder.txt_booking_time.setText(bookingtime.substring(10, 19));
        } catch (Exception e) {
            Log.e("Adapter new Orde", "prblem in booking time :" + e.getMessage());
        }
        holder.txt_booking_id.setText("OrderId : " + bookingid.subSequence(11, 15));
        holder.txt_total.setText("Total : " + data.get(position).getOrderPayments().get(0).getPaidAmount());


        /**
         * headerdetails array is use to save temp printbill data
         * */
        headerdetails[0] = data.get(position).getOrderCustomer().getFirstName() + " " + data.get(position).getOrderCustomer().getLastName();
        headerdetails[1] = data.get(position).getOrderTime();
        headerdetails[2] = data.get(position).getOrderId();
        headerdetails[3] = "Total : " + data.get(position).getOrderPayments().get(0).getPaidAmount();

        holder.recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(mContext, 1);
        holder.recyclerView.setLayoutManager(mLayoutManager);

        AdapterNewSubOrder adapter = new AdapterNewSubOrder(mContext, data.get(position).getOrderDtls());
        holder.recyclerView.setAdapter(adapter);
        adapter.getitemlist();

        try {
            int qty = adapter.getItemCount();
            bookedqty=qty+"";
            holder.txt_total_qty.setText("Qty : " + qty + "");
        } catch (Exception e) {
            Log.e("Adapater", "problem in getting  item coutnt : " + e.getMessage());
        }
        holder.rl_detail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickListner.onClick(data, position);
            }
        });


        holder.rl_print.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    playbeep(2);
                    prrintBill.printData(headerdetails, itemdetails);
                } catch (Exception e) {
                    Log.i("tag", "problem in the print option : " + e.getMessage());
                }
            }
        });




        try {
// saveing value inthe local database from the server
            int id=0;
            booking_id = bookingid.subSequence(11, 15)+"";
            Controller controller = new Controller();
            id=controller.getMaxBookingID(mContext,booking_id);
            Log.i("tag","max id from the db : "+id);
            if(Integer.parseInt(booking_id)>id) {
                booking_date = changedateformat(bookingdate.substring(0, 11));
                booking_time = bookingtime.substring(10, 19);
                booked_qty = bookedqty;
                customername = data.get(position).getOrderCustomer().getFirstName() + " " + data.get(position).getOrderCustomer().getLastName();
                total = data.get(position).getTotalAmount();
                stauts = "2";

                ordertracker[0] = booking_id;
                ordertracker[1] = booking_date;
                ordertracker[2] = booking_time;
                ordertracker[3] = booked_qty;
                ordertracker[4] = customername;
                ordertracker[5] = total;
                ordertracker[6] = stauts;

                controller.InsertData(DataBaseInfo.TABLENAME_ordertracker, ordertracker, mContext);
            }
        } catch (Exception e) {
            Log.e("tag", "Problem in inserting in ordertracker  : " + e.getMessage());
        }


    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView txtcustomername;
        public TextView txt_booking_date;
        public TextView txt_booking_time;
        public TextView txt_booking_id;
        public TextView txt_total;
        public TextView txt_total_qty;

        RecyclerView recyclerView;

        RelativeLayout rl_detail;
        RelativeLayout rl_print;

        ViewHolder(View v) {
            super(v);
            txt_booking_id = v.findViewById(R.id.txt_booking_id);
            txt_booking_date = v.findViewById(R.id.txt_booking_date);
            txt_booking_time = v.findViewById(R.id.txt_booking_time);
            txt_total_qty = v.findViewById(R.id.txt_total_qty);
            txtcustomername = v.findViewById(R.id.txtcustomername);
            txt_total = v.findViewById(R.id.txt_total);
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

    private void playbeep(int play) {

        ToneGenerator toneGen1 = new ToneGenerator(AudioManager.STREAM_MUSIC, 100);
        if (play == 1) {
            toneGen1.startTone(ToneGenerator.TONE_CDMA_PIP, 150);
        } else {
            toneGen1.startTone(ToneGenerator.TONE_CDMA_PIP, 150);
        }
    }


    public void playAlertTone(final Context context) {


        Thread t = new Thread() {
            public void run() {
                MediaPlayer player = null;
                int countBeep = 0;
                while (countBeep < 2) {
                    player = MediaPlayer.create(context, R.raw.beep);
                    player.start();
                    countBeep += 1;
                    try {

                        // 100 milisecond is duration gap between two beep
                        Thread.sleep(player.getDuration() + 100);
                        player.release();
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }


                }
            }
        };

        t.start();

    }
}