package com.example.spleshanimataiontest.utils;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.Intent;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Set;
import java.util.UUID;

public class PrrintBill extends AppCompatActivity {
    BluetoothAdapter bluetoothAdapter;
    BluetoothSocket bluetoothSocket;
    BluetoothDevice bluetoothDevice;

    OutputStream outputStream;
    InputStream inputStream;
    Thread thread;

    byte[] readBuffer;
    int readBufferPosition;
    volatile boolean stopWorker;

//    FindBluetoothDevice();
    //   openBluetoothPrinter();

    public String FindBluetoothDevice() { // use this fucnction to find bluetooth device
        String printerDiscover = "", printername = "";
        try {

            bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
            if (bluetoothAdapter == null) {
                //lblPrinterName.setText("No Bluetooth Adapter found");
                return printerDiscover = "No Bluetooth Adapter found";
            }
            if (bluetoothAdapter.isEnabled()) {
                Intent enableBT = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                startActivityForResult(enableBT, 0);
            }

            Set<BluetoothDevice> pairedDevice = bluetoothAdapter.getBondedDevices();

            if (pairedDevice.size() > 0) {
                for (BluetoothDevice pairedDev : pairedDevice) {

                    // My Bluetoth printer name is BTP_F09F1A
                    if (pairedDev.getName().equals("BTP_F09F1A")) {
                        bluetoothDevice = pairedDev;
                        //lblPrinterName.setText("Bluetooth Printer Attached: "+pairedDev.getName());
                        return printername = "Bluetooth Printer Attached: " + pairedDev.getName();
                        //  break;
                    }
                }
            }

            //lblPrinterName.setText("Bluetooth Printer Attached");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public void openBluetoothPrinter() throws IOException {  //use this fucntion to find bluetooth printer
        try {

            //Standard uuid from string //
            UUID uuidSting = UUID.fromString("00001101-0000-1000-8000-00805f9b34fb");
            bluetoothSocket = bluetoothDevice.createRfcommSocketToServiceRecord(uuidSting);
            bluetoothSocket.connect();
            outputStream = bluetoothSocket.getOutputStream();
            inputStream = bluetoothSocket.getInputStream();

            beginListenData();

        } catch (Exception ex) {

        }
    }

    public String beginListenData() { // this function return printer name
        final String[] name = new String[1];
        try {

            final Handler handler = new Handler();
            final byte delimiter = 10;
            stopWorker = false;
            readBufferPosition = 0;
            readBuffer = new byte[1024];

            thread = new Thread(new Runnable() {
                @Override
                public void run() {

                    while (!Thread.currentThread().isInterrupted() && !stopWorker) {
                        try {
                            int byteAvailable = inputStream.available();
                            if (byteAvailable > 0) {
                                byte[] packetByte = new byte[byteAvailable];
                                inputStream.read(packetByte);

                                for (int i = 0; i < byteAvailable; i++) {
                                    byte b = packetByte[i];
                                    if (b == delimiter) {
                                        byte[] encodedByte = new byte[readBufferPosition];
                                        System.arraycopy(
                                                readBuffer, 0,
                                                encodedByte, 0,
                                                encodedByte.length
                                        );
                                        final String data = new String(encodedByte, "US-ASCII");
                                        readBufferPosition = 0;
                                        handler.post(new Runnable() {
                                            @Override
                                            public void run() {
                                                //lblPrinterName.setText(data);
                                                name[0] = data;
                                            }
                                        });
                                    } else {
                                        readBuffer[readBufferPosition++] = b;
                                    }
                                }
                            }
                        } catch (Exception ex) {
                            stopWorker = true;
                        }
                    }

                }
            });

            thread.start();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return name[0];
    }


    // Printing Text to Bluetooth Printer //
    public void printData(String[] headerdetails, String[] amountdetails, String[] itemlist) throws IOException {
        String printstatus = "";
        try {
            //String msg = textBox.getText().toString();
            String header = "", amount = "", list = "";
            FindBluetoothDevice();
            openBluetoothPrinter();
            for (int i = 0; i <= headerdetails.length;i++) {
                header += headerdetails[i] + "\n";
            }
            for (int i = 0; i <= amountdetails.length;i++) {
                amount += headerdetails[i] + "\n";
            }
            for (int i = 0; i <= itemlist.length;i++) {
                list += headerdetails[i] + "\n";
            }

            outputStream.write(header.getBytes());
            outputStream.write(list.getBytes());
            outputStream.write(amount.getBytes());
            //lblPrinterName.setText("Printing Text...");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


    public void printData(String[] headerdetails, String[] itemlist) throws IOException {
        String printstatus = "";
        try {
            //String msg = textBox.getText().toString();
            FindBluetoothDevice();
            openBluetoothPrinter();
            String header = "", amount = "", list = "";
            for (int i = 0; i <= headerdetails.length;i++) {
                header += headerdetails[i] + "\n";
            }

            for (int i = 0; i <= itemlist.length;i++) {
                list += headerdetails[i] + "\n";
            }

            outputStream.write(header.getBytes());
            outputStream.write(list.getBytes());
//            outputStream.write(amount.getBytes());
            //lblPrinterName.setText("Printing Text...");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public String disconnectBT() throws IOException { // to  disconncet bluetooth printer from the deevice
        String status = "";
        try {
            stopWorker = true;
            outputStream.close();
            inputStream.close();
            bluetoothSocket.close();
            //lblPrinterName.setText("Printer Disconnected.");
            status = "Printer Disconnected";
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return status;
    }
}
