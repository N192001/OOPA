package com.example.spleshanimataiontest.utils;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.pdf.PdfDocument;
import android.os.Build;
import android.os.Environment;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.RequiresApi;

import com.example.spleshanimataiontest.adapter.AdapterOngoingSubOrder;
import com.example.spleshanimataiontest.datamodel.ListItem;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CreatePDF  extends Activity {
    /*@RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public void createPdf(String sometext,String bookingid,Context contextmain){
        Context context;
        context=contextmain;
        // create a new document
        PdfDocument document = new PdfDocument();
         List<ListItem> myListsave;
        // crate a page description
        PdfDocument.PageInfo pageInfo = new PdfDocument.PageInfo.Builder(300, 600, 1).create();
        // start a page
        PdfDocument.Page page = document.startPage(pageInfo);
        Canvas canvas = page.getCanvas();
        Paint paint = new Paint();
        paint.setColor(Color.RED);
        canvas.drawCircle(50, 50, 30, paint);
        paint.setColor(Color.BLACK);
//        canvas.drawText(sometext, 80, 50, paint);



        //canvas.drawt
        // finish the page
     //  document.finishPage(page);
// draw text on the graphics object of the page
        // Create Page 2
 *//*       try {
            Modules modules = new Modules();
            myListsave = new ArrayList<>();
            myListsave = modules.getOrderTrackerDetails(context, "4",bookingid);

            canvas.drawText(sometext, 80, 50, paint);

            canvas.drawText("Customer Name : "+myListsave.get(0).getCustomername(), 80, 50, paint);
            canvas.drawText("Date & Time   : "+myListsave.get(0).getDate() + " " + myListsave.get(0).getTime(), 80, 50, paint);
            canvas.drawText("OrderId       : " + myListsave.get(0).getBooking_id(), 80, 50, paint);

            canvas.drawText("Number        : "+myListsave.get(0).getCustomernumber(), 80, 50, paint);
            canvas.drawText("Email         : "+myListsave.get(0).getCustomeremail(), 80, 50, paint);
            canvas.drawText("Address       : "+myListsave.get(0).getLocation(), 80, 50, paint);

            canvas.drawText("Subtotal     : " + myListsave.get(0).getTotal(), 80, 50, paint);
            canvas.drawText("Delivery Fee : " + myListsave.get(0).getDelivery_fee(), 80, 50, paint);
            canvas.drawText("+ GST Included (15%) : " + myListsave.get(0).getService_tax(), 80, 50, paint);
            canvas.drawText("+ Discount (20%) : " + myListsave.get(0).getDiscount(), 80, 50, paint);
            canvas.drawText("Total : " + myListsave.get(0).getGrand_total(), 80, 50, paint);
        } catch (Exception e) {
            Log.e("tag", "Problem in the list : " + e.getMessage());
        }*//*
        pageInfo = new PdfDocument.PageInfo.Builder(300, 600, 2).create();
        page = document.startPage(pageInfo);
        canvas = page.getCanvas();
       *//* paint = new Paint();
        paint.setColor(Color.BLUE);*//*
      //  canvas.drawCircle(100, 100, 100, paint);
        document.finishPage(page);
        // write the document content
        String directory_path = Environment.getExternalStorageDirectory().getPath() + "/order/";
        File file = new File(directory_path);
        if (!file.exists()) {
            file.mkdirs();
        }
        String targetPdf = directory_path+"test-2.pdf";
        File filePath = new File(targetPdf);




        try {
            document.writeTo(new FileOutputStream(filePath));
           // Toast.makeText(getApplicationContext(), "Done", Toast.LENGTH_LONG).show();
        } catch (IOException e) {
            Log.e("main", "error "+e.toString());
            //Toast.makeText(this, "Something wrong: " + e.toString(),  Toast.LENGTH_LONG).show();
        }
        // close the document
        document.close();
    }*/
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public void createPdf(String sometext,String booking,Context context){
        // create a new document
        PdfDocument document = new PdfDocument();

        // crate a page description
        PdfDocument.PageInfo pageInfo = new PdfDocument.PageInfo.Builder(300, 600, 1).create();

        // start a page
        PdfDocument.Page page = document.startPage(pageInfo);
        Canvas canvas = page.getCanvas();
        Paint paint = new Paint();
        paint.setColor(Color.RED);
        canvas.drawCircle(50, 50, 30, paint);
        paint.setColor(Color.BLACK);
        canvas.drawText(sometext, 80, 50, paint);
        //canvas.drawt
        // finish the page
        document.finishPage(page);
// draw text on the graphics object of the page

        // Create Page 2
     /*   pageInfo = new PdfDocument.PageInfo.Builder(300, 600, 2).create();
        page = document.startPage(pageInfo);
        canvas = page.getCanvas();
        paint = new Paint();
        paint.setColor(Color.BLUE);
        canvas.drawCircle(100, 100, 100, paint);
        document.finishPage(page);*/

        // write the document content
        String directory_path = Environment.getExternalStorageDirectory().getPath() + "/order/";
        File file = new File(directory_path);
        if (!file.exists()) {
            file.mkdirs();
        }
        String targetPdf = directory_path+"test-2.pdf";
        File filePath = new File(targetPdf);
        try {
            document.writeTo(new FileOutputStream(filePath));
      //     Toast.makeText(this, "Done", Toast.LENGTH_LONG).show();
        } catch (IOException e) {
            Log.e("main", "error "+e.toString());
            Toast.makeText(this, "Something wrong: " + e.toString(),  Toast.LENGTH_LONG).show();
        }

        // close the document
        document.close();
    }
}
