package com.example.spleshanimataiontest.ui.home;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.spleshanimataiontest.R;
import com.example.spleshanimataiontest.datamodel.ListItem;
import com.example.spleshanimataiontest.utils.CreatePDF;

import java.util.ArrayList;
import java.util.List;


/*
class MyAdapter {
}
package in.co.giriits.gloveson.testlist;
*/

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    //we are storing all the products in a list
    private static List<ListItem> listItemList;
    private ArrayList<ListItem> selectedlistItem;

    //this context we will use to inflate the layout
    private Context context;

    int getsize = 0;
    String customername = "", service = "", name = "", date = "", price = "", time = "", status = "", offerprice = "", discount = "", qty = "";

    CartClick cartClick;

    public interface CartClick {
        void cartclcik(int cart, String data);
    }

    public MyAdapter() {

    }

    //getting the context and product list with constructor
    public MyAdapter(List<ListItem> listItemList) {
        this.listItemList = listItemList;
        this.context = context;

        Log.i("tag", "1");
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflating and returning our view holder
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.raw_new_order, parent, false);
        Log.i("tag", "2 view  create");
        return new ViewHolder(v);
    }

CreatePDF createPDF=new CreatePDF();
    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        try {


//            getsize = listItemList.size();
//            customername = new String[getsize];
//            service name
//            date = new String[getsize];
//            price = new String[getsize];
//            time = new String[getsize];
//            status = new String[getsize];
//            offerprice = new String[getsize];
//            discount = new String[getsize];
//            qty = new String[getsize];


            Log.i("tag", "3 holder");
        } catch (Exception e) {
            Log.e("tag", "problem in inalitaling array : " + e.getMessage());
        }
        //getting the item of the specified position
        final ListItem listItem = listItemList.get(position);
        holder.customername.setText(listItem.getCustomername());
        holder.servicename.setText(listItem.getStatus());
        holder.date.setText(listItem.getDate());
        /*holder.time.setText(listItem.getTime());
        holder.print.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        holder.accept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        holder.createpdf.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View v) {
                try {
                    createPDF.createPdf(listItem.getCustomername() + "  " + listItem.getStatus() + " " + listItem.getTime());
                }catch (Exception e){
                    Log.i("tag","problrem in creating pdf "+e.getMessage());
                }
                }
        });*/






        /*holder.img_info.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("NewApi")
            @Override
            public void onClick(View v) {
                holder.img_info.setTooltipText("Bank details are required for makeing direct and transprent jobwork payment to providers");
            }
        });*/


    }






    /*public void updatelist(int position) {
        strselectedname = selectedname[position];
        strselecteddesc = selecteddesc[position];
        strselectedprice = selectedprice[position];
        strselecteddiscount = selecteddiscount[position];
        strselectedofferprice = selectedofferprice[position];
        strselectedsubtotal = selectedsubtotal[position];
        strselectedquantity = selectedquantity[position];
//            selectedlistItem.add(new ListItem(strselectedname, strselecteddesc, strselectedprice, strselecteddiscount, strselectedofferprice, strselectedsubtotal, strselectedquantity));
        listItemList.add(new ListItem(strselectedname, strselecteddesc, strselectedprice, strselecteddiscount, strselectedofferprice, strselectedsubtotal, strselectedquantity));
        Log.e("tag", "list :" + listItemList.get(position));
        Log.e("tag", "after adding list myadpter  : " + listItemList);
    }*/

    @Override
    public int getItemCount() {
        return listItemList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView customername, servicename,date,price,status,offerprice,discount,qty;
        public ImageButton testminus, testadd, testcart;
        public LinearLayout layouttotal;
//        public Button accept,print,createpdf;
        TextView texttime;
        ImageView img_info;

        public ViewHolder(View itemView) {
            super(itemView);
            int totalsize = 0;
            totalsize = getItemCount();

            customername = (TextView) itemView.findViewById(R.id.txtcustomername);
            servicename = (TextView) itemView.findViewById(R.id.txt_booking_id);
            date= (TextView) itemView.findViewById(R.id.txt_booking_date);
//            price= (TextView) itemView.findViewById(R.id.testcounter);
//            time= (TextView) itemView.findViewById(R.id.txt_booking_time);
//            accept= (Button) itemView.findViewById(R.id.cmdaccept);
//            print= (Button) itemView.findViewById(R.id.cmdprint);
//            createpdf= (Button) itemView.findViewById(R.id.cmdpfd);
          /*  qty= (ImageButton) itemView.findViewById(R.id.testminus);
            testadd = (ImageButton) itemView.findViewById(R.id.testplus);
            testcart = (ImageButton) itemView.findViewById(R.id.testcart);
            img_info = (ImageView) itemView.findViewById(R.id.img_info);*/
//            layouttotal= (LinearLayout) itemView.findViewById(R.id.layouttotal);

        }
    }




    public int getSelecteditemsize() {
        return selectedlistItem.size();
    }


}
