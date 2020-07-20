package com.example.spleshanimataiontest.utils;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import android.os.Environment;
import android.text.format.DateFormat;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CreateInvoice {
    public void createbill() {
        try {
            String h = DateFormat.format("MM-dd-yyyyy-h-mmssaa", System.currentTimeMillis()).toString();
// this will create a new name everytime and unique
            File root = new File(Environment.getExternalStorageDirectory(), "order");
// if external memory exists and folder with name Notes
            if (!root.exists()) {
                root.mkdirs(); // this will create folder.
            }
            File filepath = new File(root, h + ".pdf"); // file path to save
            FileWriter writer = new FileWriter(filepath);
            writer.append("text");
            writer.flush();
            writer.close();
           // String m = "File generated with name " + h + ".txt";


        } catch (
                IOException e) {
            e.printStackTrace();
//            result.setText(e.getMessage().toString());
        }
    }
}
