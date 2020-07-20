package com.example.spleshanimataiontest.DataBaseConnectionNew;

import android.annotation.TargetApi;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.RequiresApi;

import com.example.spleshanimataiontest.datamodel.OrderModel;
import com.example.spleshanimataiontest.utils.Modules;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;


public class Controller {
    SQLiteDatabase myDatabase = null;
    SqlHelper obHelper = null;
    Context context = null;

    public Controller() {
    }

    String[] sugar = new String[5];

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void InsertData(String Tablename, String insertvalues[], Context context1) {
        context = context1;
        ContentValues values = null;
        try {
            Log.i("tag", "in insert data");

            Log.i("tag", "after content values");
            String myName = "";
            try {
                obHelper = new SqlHelper(context, DataBaseInfo.DataBaseName, null, 1);
                Log.i("tag", "after objherlper");
                values = new ContentValues();
                if (Tablename.equals(DataBaseInfo.TABLENAME_User)) {
                    try {
                        values.put(DataBaseInfo.U_USERNAME, insertvalues[0]);
                        values.put(DataBaseInfo.U_PASSWORD, insertvalues[1]);
                        values.put(DataBaseInfo.U_CONFPW, insertvalues[2]);

                        //  values.put(DataBaseInfo.U_SHOPCODE, insertvalues[2]);
                        Log.i("tag", "user data saved locally");
                    } catch (Exception e) {
                        Toast.makeText(context1, "Oops some thing went wrong : - " + e.getMessage(), Toast.LENGTH_LONG).show();
                        Log.i("tag", "problem in the saving patient :" + e.getMessage());
                    } finally {
                        insertvalues = null;
                    }
                } else if (Tablename.equals(DataBaseInfo.TABLENAME_shopcode)) {
                    try {
                        Log.i("tag", "in Diabeties if");
                        Modules modules = new Modules();
                        // Log.i("tag", "after module-->");
                        Log.i("tag", "time is direct module: - " + modules.gettime());
                        try {
                            values.put(DataBaseInfo.SC_NUMBER, insertvalues[0]);
                            values.put(DataBaseInfo.SC_NAME, insertvalues[1]);
                        } catch (Exception e) {
                            Log.i("tag", "problem in getting values from array : " + e.getMessage());
                        }
                        Log.i("tag", "after user");
                        Log.i("tag", "in user value save ");
                    } catch (Exception e) {
                        Log.i("tag", "Problem in the saveing the user : - " + e.getMessage());
                    } finally {
                        insertvalues = null;
                    }
                } else if (Tablename.equals(DataBaseInfo.TABLENAME_ordertracker)) {
                    try {
                        Log.i("tag", "in ordertracker insert if");
                        try {
                            for (int i = 0; i < insertvalues.length; i++) {
                                Log.i("tag", "////////////////////////integratsion   : " + insertvalues[i]);
                            }

                            values.put(DataBaseInfo.st_booking_id, insertvalues[0]);
                            values.put(DataBaseInfo.st_booking_date, insertvalues[1]);
                            values.put(DataBaseInfo.st_booking_time, insertvalues[2]);
                            values.put(DataBaseInfo.st_total_qty, insertvalues[3]);
                            values.put(DataBaseInfo.st_customername, insertvalues[4]);
                            values.put(DataBaseInfo.st_total, insertvalues[5]);
                            values.put(DataBaseInfo.st_status, insertvalues[6]);
                        } catch (Exception e) {
                            Log.i("tag", "problem in getting values from array : " + e.getMessage());
                        }
                        Log.i("tag", "after user");
                        Log.i("tag", "in user value save ");
                    } catch (Exception e) {
                        Log.i("tag", "Problem in the saveing the user : - " + e.getMessage());
                    } finally {
                        insertvalues = null;
                    }
                } else if (Tablename.equals(DataBaseInfo.TABLENAME_orderitemtracker)) {
                    try {
                        Log.i("tag", "in ordertracker insert if");
                        try {
                            for (int i = 0; i < insertvalues.length; i++) {
                                Log.i("tag", "////////////////////////integratsion   : " + insertvalues[i]);
                            }
                            values.put(DataBaseInfo.sbt_booking_id, insertvalues[0]);
                            values.put(DataBaseInfo.sbt_itemname, insertvalues[1]);
                            values.put(DataBaseInfo.sbt_qty, insertvalues[2]);
                            values.put(DataBaseInfo.sbt_rate, insertvalues[3]);
                            values.put(DataBaseInfo.sbt_status, insertvalues[4]);
                        } catch (Exception e) {
                            Log.i("tag", "problem in insert orderitemtracker values from array : " + e.getMessage());
                        }
                        Log.i("tag", "after insert orderitemtracker");
                        Log.i("tag", "in user value save ");
                    } catch (Exception e) {
                        Log.i("tag", "Problem in the saveing the user : - " + e.getMessage());
                    } finally {
                        insertvalues = null;
                    }
                } else if (Tablename.equals(DataBaseInfo.TABLENAME_orderdetails)) {
                    try {
                        Log.i("tag", "in ordertracker insert if");
                        try {
                            for (int i = 0; i < insertvalues.length; i++) {
                                Log.i("tag", "////////////////////////integratsion   : " + insertvalues[i]);
                            }
                            values.put(DataBaseInfo.sdt_customername, insertvalues[0]);
                            values.put(DataBaseInfo.sdt_booking_date, insertvalues[1]);
                            values.put(DataBaseInfo.sdt_booking_id, insertvalues[2]);
                            values.put(DataBaseInfo.sdt_call, insertvalues[3]);
                            values.put(DataBaseInfo.sdt_email, insertvalues[4]);
                            values.put(DataBaseInfo.sdt_location, insertvalues[5]);
                            values.put(DataBaseInfo.sdt_subtotal, insertvalues[6]);
                            values.put(DataBaseInfo.sdt_delivery_fee, insertvalues[7]);
                            values.put(DataBaseInfo.sdt_service_tax, insertvalues[8]);
                            values.put(DataBaseInfo.sdt_discount, insertvalues[9]);
                            values.put(DataBaseInfo.sdt_grand_total, insertvalues[10]);
                            values.put(DataBaseInfo.sbt_orderstatus, insertvalues[11]);
                        } catch (Exception e) {
                            Log.i("tag", "problem in insert orderitemtracker values from array : " + e.getMessage());
                        }
                        Log.i("tag", "after insert orderitemtracker");
                        Log.i("tag", "in user value save ");
                    } catch (Exception e) {
                        Log.i("tag", "Problem in the saveing the user : - " + e.getMessage());
                    } finally {
                        insertvalues = null;
                    }
                }
                Log.i("tag", "after setting values");
                Log.i("tag", "after mydatabase : ** " + DataBaseInfo.DataBaseName);
                Log.i("tag", "after Tablename : *** " + Tablename);
                myDatabase = obHelper.getWritableDatabase();
                myDatabase.insert(Tablename, null, values);
                Toast.makeText(context, "Record Saved", Toast.LENGTH_SHORT).show();
            } catch (Exception ex) {
                Toast.makeText(context, "Oops something went wrong while Saving : " + ex.getMessage(), Toast.LENGTH_LONG).show();
                Log.i("tag", "problem in saving : - " + ex.getMessage());
            } finally {
                if (values != null) values = null;
            }
        } catch (Exception e) {
            Log.i("tag", "problem in the operation controller  *** : - " + e.getMessage());
            Log.i("tag", "stack : " + e.getStackTrace());
            Log.i("tag", "stack : " + e.getCause());
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void InsertShopcodeData(Context context1) {
//    public void InsertData(String Tablename, String insertvalues[], String insertvaluesname[], Context context1) {
        context = context1;
        ContentValues values = null;
        try {
            Log.i("tag", "in insert data");

            Log.i("tag", "after content values");
            String myName = "";
            try {
                obHelper = new SqlHelper(context, DataBaseInfo.DataBaseName, null, 1);
                Log.i("tag", "after objherlper");
                values = new ContentValues();
                try {
                    Log.i("tag", "in Diabeties if");
                    Modules modules = new Modules();

                    String arraysavecode[] = new String[6];
                    String arraysavecodename[] = new String[6];
                    arraysavecode = new String[6];
                    arraysavecode[0] = "S06A";
                    arraysavecode[1] = "S018";
                    arraysavecode[2] = "S044";
                    arraysavecode[3] = "S016";

                    arraysavecodename = new String[6];
                    arraysavecodename[0] = "CUS";
                    arraysavecodename[1] = "AIR";
                    arraysavecodename[2] = "GLE";
                    arraysavecodename[3] = "BOT";
                    Log.i("tag", "time is direct module: - " + modules.gettime());
                    try {
                        for (int counter = 0; counter < arraysavecode.length; counter++) {
                            values.put(DataBaseInfo.SC_NUMBER, arraysavecode[counter]);
                            values.put(DataBaseInfo.SC_NAME, arraysavecodename[counter]);
                            Log.e("insert", "counter : " + counter);
                            myDatabase = obHelper.getWritableDatabase();
                            myDatabase.insert(DataBaseInfo.TABLENAME_shopcode, null, values);
                        }


                    } catch (Exception e) {
                        Log.i("tag", "problem in getting values from array : " + e.getMessage());
                    }

                } catch (Exception e) {
                    Log.i("tag", "Problem in the saveing the diabeties : - " + e.getMessage());
                } finally {
                    //insertvalues = null;
                }
                Log.i("tag", "after setting values");
                Log.i("tag", "after mydatabase : ** " + DataBaseInfo.DataBaseName);
                // Log.i("tag", "after Tablename : *** " + Tablename);
               /* myDatabase = obHelper.getWritableDatabase();
//                myDatabase.insert(Tablename, null, values);
                myDatabase.insert(DataBaseInfo.TABLENAME_shopcode, null, values);*/
                Toast.makeText(context, " SHOP CODE Record Saved", Toast.LENGTH_SHORT).show();
            } catch (Exception ex) {
                Toast.makeText(context, "Oops something went wrong while Saving : " + ex.getMessage(), Toast.LENGTH_LONG).show();
                Log.i("tag", "problem in saving : - " + ex.getMessage());
            } finally {
                if (values != null) values = null;
            }
        } catch (Exception e) {
            Log.i("tag", "problem in the operation controller  *** : - " + e.getMessage());
            Log.i("tag", "stack : " + e.getStackTrace());
            Log.i("tag", "stack : " + e.getCause());
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void InsertOrderData(String tabename, List items, Context context1) {
//    public void InsertData(String Tablename, String insertvalues[], String insertvaluesname[], Context context1) {
        context = context1;
        ContentValues values = null;
        List<OrderModel.OrderHdr> data;
        try {
            Log.i("tag", "in insert data");

            Log.i("tag", "after content values");
            String myName = "";
            try {
                obHelper = new SqlHelper(context, DataBaseInfo.DataBaseName, null, 1);
                Log.i("tag", "after objherlper");
                data = items;
                values = new ContentValues();
                try {
                    Log.i("tag", "in Diabeties if");
                    Modules modules = new Modules();


                    Log.i("tag", "time is direct module: - " + modules.gettime());
                    Log.i("tag", "valude of getorder id from server : - " + data.get(0).getOrderId());
                    try {
//                        data.get(counter).getCashOut();
                        for (int counter = 0; counter < items.size(); counter++) {
//                            values.put(DataBaseInfo.SC_NUMBER, arraysavecode[counter]);
//                            values.put(DataBaseInfo.SC_NAME, arraysavecodename[counter]);
                            values.put(DataBaseInfo.oh_ID, counter);
                            values.put(DataBaseInfo.order_id, data.get(counter).getOrderId());
                            values.put(DataBaseInfo.order_no, data.get(counter).getOrderNo());
                            values.put(DataBaseInfo.station_code, data.get(counter).getStationCode());
                            values.put(DataBaseInfo.user_id, data.get(counter).getUserId());
                            values.put(DataBaseInfo.order_date, data.get(counter).getOrderDate());
                            values.put(DataBaseInfo.order_time, data.get(counter).getOrderTime());
                            values.put(DataBaseInfo.shift_id, data.get(counter).getShiftId());
                            values.put(DataBaseInfo.customer_id, data.get(counter).getCustomerId());
                            values.put(DataBaseInfo.detail_total, data.get(counter).getDetailTotal());
                            values.put(DataBaseInfo.total_tax1, data.get(counter).getTotalTax1());
                            values.put(DataBaseInfo.total_tax2, data.get(counter).getTotalTax2());
                            values.put(DataBaseInfo.total_tax3, data.get(counter).getRefundTotalTax3());
                            values.put(DataBaseInfo.total_gst, data.get(counter).getTotalGst());
                            values.put(DataBaseInfo.total_sc, data.get(counter).getTotalSc());
                            values.put(DataBaseInfo.total_detail_discount, data.get(counter).getTotalDetailDiscount());
                            values.put(DataBaseInfo.final_round_amount, data.get(counter).getFinalRoundAmount());
                            values.put(DataBaseInfo.total_amount, data.get(counter).getTotalAmount());
                            values.put(DataBaseInfo.total_amount_paid, data.get(counter).getTotalAmountPaid());
                            values.put(DataBaseInfo.total_balance, data.get(counter).getTotalBalance());
                            values.put(DataBaseInfo.actual_balance_paid, data.get(counter).getActualBalancePaid());
                            values.put(DataBaseInfo.closing_date, data.get(counter).getClosingDate());
                            values.put(DataBaseInfo.closing_time, data.get(counter).getClosingTime());
                            values.put(DataBaseInfo.status, data.get(counter).getStatus());
                            values.put(DataBaseInfo.total_print_count, data.get(counter).getTotalPrintCount());
                            values.put(DataBaseInfo.created_by, data.get(counter).getCreatedBy());
                            values.put(DataBaseInfo.created_at, data.get(counter).getCreatedAt());
                            values.put(DataBaseInfo.updated_by, data.get(counter).getUpdatedBy());
                            values.put(DataBaseInfo.updated_at, data.get(counter).getUpdatedAt());
                            values.put(DataBaseInfo.sync_status, data.get(counter).getSyncStatus());
                            values.put(DataBaseInfo.sync_message, data.get(counter).getSyncMessage());
                            values.put(DataBaseInfo.remarks, data.get(counter).getRemarks());
                            values.put(DataBaseInfo.shop_code, data.get(counter).getShopCode());
                            values.put(DataBaseInfo.is_ar_customer, data.get(counter).getIsArCustomer());
                            values.put(DataBaseInfo.bill_less_tax_amount, data.get(counter).getBillLessTaxAmount());
                            values.put(DataBaseInfo.bill_discount_amount, data.get(counter).getBillDiscountAmount());
                            values.put(DataBaseInfo.cash_out, data.get(counter).getCashOut());
                            values.put(DataBaseInfo.refund_total_tax1, data.get(counter).getRefundTotalTax1());
                            values.put(DataBaseInfo.refund_total_tax2, data.get(counter).getRefundTotalTax2());
                            values.put(DataBaseInfo.refund_total_tax3, data.get(counter).getRefundTotalTax3());
                            values.put(DataBaseInfo.refund_total_gst, data.get(counter).getRefundTotalGst());
                            values.put(DataBaseInfo.refund_total_sc, data.get(counter).getRefundTotalSc());
                            values.put(DataBaseInfo.refund_amount, data.get(counter).getRefundAmount());
                            values.put(DataBaseInfo.serving_table_id, data.get(counter).getServiceType());
                            values.put(DataBaseInfo.served_by, data.get(counter).getServedBy());
                            values.put(DataBaseInfo.service_type, data.get(counter).getServiceType());
                            values.put(DataBaseInfo.covers, data.get(counter).getCovers());
                            Log.e("insert", "counter : " + counter);
                            myDatabase = obHelper.getWritableDatabase();
                            myDatabase.insert(DataBaseInfo.TABLENAME_OrderHeadermaster, null, values);
                        }
                        Log.i("from controller ", "order header data saved successfully");
                    } catch (Exception e) {
                        Log.i("tag", "problem in getting values from array header: " + e.getMessage());
                    }

                } catch (Exception e) {
                    Log.i("tag", "Problem in the saveing the diabeties : - " + e.getMessage());
                } finally {
                    //insertvalues = null;
                }
                Log.i("tag", "after setting values");
                Log.i("tag", "after mydatabase : ** " + DataBaseInfo.DataBaseName);
                // Log.i("tag", "after Tablename : *** " + Tablename);
               /* myDatabase = obHelper.getWritableDatabase();
//                myDatabase.insert(Tablename, null, values);
                myDatabase.insert(DataBaseInfo.TABLENAME_shopcode, null, values);*/
                Toast.makeText(context, " SHOP CODE Record Saved", Toast.LENGTH_SHORT).show();
            } catch (Exception ex) {
                Toast.makeText(context, "Oops something went wrong while Saving : " + ex.getMessage(), Toast.LENGTH_LONG).show();
                Log.i("tag", "problem in saving : - " + ex.getMessage());
            } finally {
                if (values != null) values = null;
            }
        } catch (Exception e) {
            Log.i("tag", "problem in the operation controller  *** : - " + e.getMessage());
            Log.i("tag", "stack : " + e.getStackTrace());
            Log.i("tag", "stack : " + e.getCause());
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void InsertOrderDetailData(String tabename, List items, Context context1) {
//    public void InsertData(String Tablename, String insertvalues[], String insertvaluesname[], Context context1) {
        context = context1;
        ContentValues values = null;
        List<OrderModel.OrderHdr.OrderDtl> data;
        try {
            Log.i("tag", "in insert data");

            Log.i("tag", "after content values");
            String myName = "";
            try {
                obHelper = new SqlHelper(context, DataBaseInfo.DataBaseName, null, 1);
                Log.i("tag", "after objherlper");
                data = items;
                values = new ContentValues();
                try {
                    Log.i("tag", "in Diabeties if");
                    Modules modules = new Modules();


                    Log.i("tag", "time is direct module: - " + modules.gettime());
                    Log.i("tag", "valude of getorder id from server : - " + data.get(0).getOrderId());
                    try {
//                        data.get(counter).getCashOut();
                        for (int counter = 0; counter < items.size(); counter++) {
//                            values.put(DataBaseInfo.SC_NUMBER, arraysavecode[counter]);
//                            values.put(DataBaseInfo.SC_NAME, arraysavecodename[counter]);
                            values.put(DataBaseInfo.OD_id, counter);
                            values.put(DataBaseInfo.OD_order_id, data.get(counter).getOrderId());
                            values.put(DataBaseInfo.OD_sale_item_id, data.get(counter).getSaleItemId());
                            values.put(DataBaseInfo.OD_sale_item_code, data.get(counter).getSaleItemCode());
                            values.put(DataBaseInfo.OD_sub_class_id, data.get(counter).getSubClassId());
                            values.put(DataBaseInfo.OD_sub_class_code, data.get(counter).getSubClassCode());
                            values.put(DataBaseInfo.OD_sub_class_name, data.get(counter).getSubClassName());
                            values.put(DataBaseInfo.OD_name, data.get(counter).getName());
                            values.put(DataBaseInfo.OD_description, data.get(counter).getDescription());
                            values.put(DataBaseInfo.OD_alternative_name, data.get(counter).getAlternativeName());
                            values.put(DataBaseInfo.OD_name_to_print, data.get(counter).getNameToPrint());
                            values.put(DataBaseInfo.OD_alternative_name_to_print, data.get(counter).getAlternativeName());
                            values.put(DataBaseInfo.OD_qty, data.get(counter).getQty());
                            values.put(DataBaseInfo.OD_is_open, data.get(counter).getIsOpen());
                            values.put(DataBaseInfo.OD_uom_code, data.get(counter).getUomCode());
                            values.put(DataBaseInfo.OD_uom_name, data.get(counter).getUomName());
                            values.put(DataBaseInfo.OD_uom_symbol, data.get(counter).getUomSymbol());
                            values.put(DataBaseInfo.OD_is_combo_item, data.get(counter).getIsComboItem());
                            values.put(DataBaseInfo.OD_fixed_price, data.get(counter).getFixedPrice());
                            values.put(DataBaseInfo.OD_tax_calculation_method, data.get(counter).getTaxCalculationMethod());
                            values.put(DataBaseInfo.OD_tax_id, data.get(counter).getTaxId());
                            values.put(DataBaseInfo.OD_tax_code, data.get(counter).getTaxCode());
                            values.put(DataBaseInfo.OD_tax_name, data.get(counter).getTaxName());
                            values.put(DataBaseInfo.OD_is_tax1_applied, data.get(counter).getIsTax1Applied());
                            values.put(DataBaseInfo.OD_tax1_name, data.get(counter).getTaxName());
                            values.put(DataBaseInfo.OD_tax1_pc, data.get(counter).getTax1Pc());
                            values.put(DataBaseInfo.OD_tax1_amount, data.get(counter).getTax1Amount());
                            values.put(DataBaseInfo.OD_is_tax2_applied, data.get(counter).getIsTax1Applied());
                            values.put(DataBaseInfo.OD_tax2_name, data.get(counter).getTaxName());
                            values.put(DataBaseInfo.OD_tax2_pc, data.get(counter).getTax1Pc());
                            values.put(DataBaseInfo.OD_tax2_amount, data.get(counter).getTax2Amount());
                            values.put(DataBaseInfo.OD_is_tax3_applied, data.get(counter).getIsTax1Applied());
                            values.put(DataBaseInfo.OD_tax3_name, data.get(counter).getTax3Name());
                            values.put(DataBaseInfo.OD_tax3_pc, data.get(counter).getTax3Pc());
                            values.put(DataBaseInfo.OD_tax3_amount, data.get(counter).getTax3Amount());
                            values.put(DataBaseInfo.OD_is_sc_applied, data.get(counter).getIsScApplied());
                            values.put(DataBaseInfo.OD_sc_name, data.get(counter).getScName());
                            values.put(DataBaseInfo.OD_sc_pc, data.get(counter).getScPc());
                            values.put(DataBaseInfo.OD_sc_amount, data.get(counter).getScAmount());
                            values.put(DataBaseInfo.OD_is_gst_applied, data.get(counter).getIsGstApplied());
                            values.put(DataBaseInfo.OD_gst_name, data.get(counter).getGstName());
                            values.put(DataBaseInfo.OD_gst_pc, data.get(counter).getGstPc());
                            values.put(DataBaseInfo.OD_is_tax1_included_in_gst, data.get(counter).getIsTax1IncludedInGst());
                            values.put(DataBaseInfo.OD_is_tax2_included_in_gst, data.get(counter).getIsTax2IncludedInGst());
                            values.put(DataBaseInfo.OD_is_tax3_included_in_gst, data.get(counter).getIsTax3IncludedInGst());
                            values.put(DataBaseInfo.OD_is_sc_included_in_gst, data.get(counter).getIsScIncludedInGst());
                            values.put(DataBaseInfo.OD_gst_amount, data.get(counter).getGstAmount());
                            values.put(DataBaseInfo.OD_item_total, data.get(counter).getItemTotal());
                            values.put(DataBaseInfo.OD_discount_type, data.get(counter).getDiscountType());
                            values.put(DataBaseInfo.OD_discount_id, data.get(counter).getDiscountId());
                            values.put(DataBaseInfo.OD_discount_code, data.get(counter).getDiscountCode());
                            values.put(DataBaseInfo.OD_discount_name, data.get(counter).getDiscountName());
                            values.put(DataBaseInfo.OD_discount_description, data.get(counter).getDiscountdescription());
                            values.put(DataBaseInfo.OD_discount_price, data.get(counter).getDiscountPrice());
                            values.put(DataBaseInfo.OD_discount_is_percentage, data.get(counter).getDiscountIsPercentage());
                            values.put(DataBaseInfo.OD_discount_is_overridable, data.get(counter).getDiscountIsOverridable());
                            values.put(DataBaseInfo.OD_discount_is_item_specific, data.get(counter).getDiscountIsItemSpecific());
                            values.put(DataBaseInfo.OD_discount_permitted_for, data.get(counter).getDiscountPermittedFor());
                            values.put(DataBaseInfo.OD_discount_amount, data.get(counter).getDiscountAmount());
                            values.put(DataBaseInfo.OD_discount_is_promotion, data.get(counter).getDiscountIsPromotion());
                            values.put(DataBaseInfo.OD_discount_grouping_quantity, data.get(counter).getDiscountGroupingQuantity());
                            values.put(DataBaseInfo.OD_discount_allow_editing, data.get(counter).getDiscountAllowEditing());
                            values.put(DataBaseInfo.OD_round_adjustment, data.get(counter).getRoundAdjustment());
                            values.put(DataBaseInfo.OD_attrib1_name, data.get(counter).getAttrib1Name());
                            values.put(DataBaseInfo.OD_attrib1_options, data.get(counter).getAttrib1Options());
                            values.put(DataBaseInfo.OD_attrib2_name, data.get(counter).getAttrib2Name());
                            values.put(DataBaseInfo.OD_attrib2_options, data.get(counter).getAttrib2Options());
                            values.put(DataBaseInfo.OD_attrib3_name, data.get(counter).getAttrib3Name());
                            values.put(DataBaseInfo.OD_attrib3_options, data.get(counter).getAttrib3Options());
                            values.put(DataBaseInfo.OD_attrib4_name, data.get(counter).getAttrib4Name());
                            values.put(DataBaseInfo.OD_attrib4_options, data.get(counter).getAttrib4Options());
                            values.put(DataBaseInfo.OD_attrib5_name, data.get(counter).getAttrib5Name());
                            values.put(DataBaseInfo.OD_attrib5_options, data.get(counter).getAttrib5Options());
                            values.put(DataBaseInfo.OD_attrib1_selected_option, data.get(counter).getAttrib1SelectedOption());
                            values.put(DataBaseInfo.OD_attrib2_selected_option, data.get(counter).getAttrib2SelectedOption());
                            values.put(DataBaseInfo.OD_attrib3_selected_option, data.get(counter).getAttrib3SelectedOption());
                            values.put(DataBaseInfo.OD_attrib4_selected_option, data.get(counter).getAttrib4SelectedOption());
                            values.put(DataBaseInfo.OD_attrib5_selected_option, data.get(counter).getAttrib5SelectedOption());
                            values.put(DataBaseInfo.OD_status, data.get(counter).getStatus());
                            values.put(DataBaseInfo.OD_is_printed_to_kitchen, data.get(counter).getIsPrintedToKitchen());
                            values.put(DataBaseInfo.OD_remarks, data.get(counter).getRemarks());
                            values.put(DataBaseInfo.OD_is_void, data.get(counter).getIsVoid());
                            values.put(DataBaseInfo.OD_cashier_id, data.get(counter).getCashierId());
                            values.put(DataBaseInfo.OD_order_date, data.get(counter).getOrderId());
                            values.put(DataBaseInfo.OD_order_time, data.get(counter).getOrderTime());
                            values.put(DataBaseInfo.OD_customer_price_variance, data.get(counter).getCustomerPriceVariance());
                            values.put(DataBaseInfo.OD_discount_variants, data.get(counter).getDiscountVariants());
                            values.put(DataBaseInfo.OD_service_type, data.get(counter).getService_type());
                            values.put(DataBaseInfo.OD_serving_table_id, data.get(counter).getServing_table_id());
                            values.put(DataBaseInfo.OD_served_by, data.get(counter).getServed_by());
                            Log.e("insert", "counter : " + counter);
                            myDatabase = obHelper.getWritableDatabase();
                            myDatabase.insert(DataBaseInfo.TABLENAME_OrderDetailmaster, null, values);
                        }
                        Log.i("from controller ", "order details data saved successfully");
                    } catch (Exception e) {
                        Log.i("tag", "problem in getting values from array details: " + e.getMessage());
                    }

                } catch (Exception e) {
                    Log.i("tag", "Problem in the saveing the diabeties : - " + e.getMessage());
                } finally {
                    //insertvalues = null;
                }
                Log.i("tag", "after setting values");
                Log.i("tag", "after mydatabase : ** " + DataBaseInfo.DataBaseName);

                Toast.makeText(context, " SHOP CODE Record Saved", Toast.LENGTH_SHORT).show();
            } catch (Exception ex) {
                Toast.makeText(context, "Oops something went wrong while Saving : " + ex.getMessage(), Toast.LENGTH_LONG).show();
                Log.i("tag", "problem in saving : - " + ex.getMessage());
            } finally {
                if (values != null) values = null;
            }
        } catch (Exception e) {
            Log.i("tag", "problem in the operation controller  *** : - " + e.getMessage());
            Log.i("tag", "stack : " + e.getStackTrace());
            Log.i("tag", "stack : " + e.getCause());
        }
    }


    @RequiresApi(api = Build.VERSION_CODES.N)
    public void InsertOrderHdrExtData(String tabename, List items, Context context1) {
//    public void InsertData(String Tablename, String insertvalues[], String insertvaluesname[], Context context1) {
        context = context1;
        ContentValues values = null;
        List<OrderModel.OrderHdr.OrderHdrExt> data;
        try {
            Log.i("tag", "in insert data");

            Log.i("tag", "after content values");
            String myName = "";
            try {
                obHelper = new SqlHelper(context, DataBaseInfo.DataBaseName, null, 1);
                Log.i("tag", "after objherlper");
                data = items;
                values = new ContentValues();
                try {
                    Log.i("tag", "in Diabeties if");
                    Modules modules = new Modules();


                    Log.i("tag", "time is direct module: - " + modules.gettime());
                    Log.i("tag", "valude of getorder id from server : - " + data.get(0).getOrderId());
                    try {
//                        data.get(counter).getCashOut();
                        for (int counter = 0; counter < items.size(); counter++) {
//                            values.put(DataBaseInfo.SC_NUMBER, arraysavecode[counter]);
//                            values.put(DataBaseInfo.SC_NAME, arraysavecodename[counter]);
                            values.put(DataBaseInfo.OD_id, counter);
                            values.put(DataBaseInfo.OHE_id, data.get(counter).getOrderId());
                            values.put(DataBaseInfo.OHE_order_id, data.get(counter).getOrderId());
                            values.put(DataBaseInfo.OHE_tax_invoice_no, data.get(counter).getTaxInvoiceNo());
                            values.put(DataBaseInfo.OHE_delivery_date, data.get(counter).getDeliveryDate());
                            values.put(DataBaseInfo.OHE_delivery_time, data.get(counter).getDeliveryTime());
                            values.put(DataBaseInfo.OHE_order_mail_receipt, data.get(counter).getOrderMailReceipt());
                            Log.e("insert", "counter : " + counter);
                            myDatabase = obHelper.getWritableDatabase();
                            myDatabase.insert(DataBaseInfo.TABLENAME_OrderHeaderExt, null, values);
                        }
                        Log.i("from controller ", "order details data saved successfully");
                    } catch (Exception e) {
                        Log.i("tag", "problem in getting values from array order hdr ext: " + e.getMessage());
                    }

                } catch (Exception e) {
                    Log.i("tag", "Problem in the saveing the diabeties : - " + e.getMessage());
                } finally {
                    //insertvalues = null;
                }
                Log.i("tag", "after setting values");
                Log.i("tag", "after mydatabase : ** " + DataBaseInfo.DataBaseName);
                // Log.i("tag", "after Tablename : *** " + Tablename);
               /* myDatabase = obHelper.getWritableDatabase();
//                myDatabase.insert(Tablename, null, values);
                myDatabase.insert(DataBaseInfo.TABLENAME_shopcode, null, values);*/
                Toast.makeText(context, " SHOP CODE Record Saved", Toast.LENGTH_SHORT).show();
            } catch (Exception ex) {
                Toast.makeText(context, "Oops something went wrong while Saving : " + ex.getMessage(), Toast.LENGTH_LONG).show();
                Log.i("tag", "problem in saving : - " + ex.getMessage());
            } finally {
                if (values != null) values = null;
            }
        } catch (Exception e) {
            Log.i("tag", "problem in the operation controller  *** : - " + e.getMessage());
            Log.i("tag", "stack : " + e.getStackTrace());
            Log.i("tag", "stack : " + e.getCause());
        }
    }

    public Cursor DisplayData(String Tablename) {
        Cursor cursor = null;
        return cursor;
    }


    public void UpdateStatus(Context context, String bookingid, String status) {

        SQLiteDatabase myDatabase;
        String query = "";
        Cursor cur = null;
        int count = 0;
        try {

            query = "UPDATE " + DataBaseInfo.TABLENAME_ordertracker + " SET status =" + status + " WHERE booking_id = " + bookingid;
            obHelper = new SqlHelper(context, DataBaseInfo.DataBaseName, null, 1);
            myDatabase = obHelper.getWritableDatabase();
            myDatabase = (new SqlHelper(context, DataBaseInfo.DataBaseName, null, 1)).getReadableDatabase();

            cur = myDatabase.rawQuery(query, null);
            Log.i("update flag()", "flag after update : ***************");
            cur.moveToFirst();
            count = cur.getCount();
            Log.i("update", "flag removed ");
//            }?
        } catch (Exception e) {
            Log.e("tag", "problem in update : " + e.getMessage());
        }

    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public String getdate() {
        Log.i("tag", "in date1");
        GregorianCalendar now = new GregorianCalendar();
        Log.i("tag", "after ger");
        int year = now.get(Calendar.YEAR);
        Log.i("tag", "year");
        int month = now.get(Calendar.MONTH) + 1;
        Log.i("tag", "month");
        int day = now.get(Calendar.DATE);
        Log.i("tag", "date");
        String date = year + "-" + month + "-" + day;
//        Date = date;
        return date;
        // 2012-04-10%2010:22:40
    }

    //    @RequiresApi(api = Build.VERSION_CODES.N)
    @TargetApi(Build.VERSION_CODES.N)
    public String gettime() {
        GregorianCalendar now = new GregorianCalendar();
        int hour = now.get((Calendar.HOUR_OF_DAY) + 1);
        int minute = now.get((Calendar.MINUTE) + 1);
        int second = now.get((Calendar.SECOND) + 1);
        //        Date = date;
        String time = hour + ":" + minute + ":" + second;
        Log.i("tag", "direct time --------------------: " + time);
        return time;
        // 2012-04-10%2010:22:40
    }

    public Cursor getUserlist(Context context, String userid, String password) {
//    public int getUserlist(Context context, String userid, String password) {

        SQLiteDatabase myDatabase;
        String rec[] = null;
        Cursor cur = null;
        int count = 0;
        try {
            myDatabase = (new SqlHelper(context, DataBaseInfo.DataBaseName, null, 1)).getReadableDatabase();
            cur = myDatabase.rawQuery("Select username,password from " + DataBaseInfo.TABLENAME_User + " Where " + DataBaseInfo.U_USERNAME + "=" + userid + " and " + DataBaseInfo.U_PASSWORD + "=" + password, null);
            cur.moveToFirst();
            rec = new String[cur.getCount()];
            count = cur.getCount();
            Log.e("count", "total row : " + cur.getCount());
            for (int i = 0; i <= cur.getCount(); i++) {
//            rec[i]=cur.getString(counter)+" : "+cur.getString(1)+" : "+ cur.getString(2)+" : "+ cur.getString(3);
                rec[i] = cur.getString(2);
                Log.e("Checking", " " + cur.getString(0) + " : " + cur.getString(1));
                cur.moveToNext();
                Log.i("tejas ", "field name : " + DataBaseInfo.U_USERNAME);
            }
        } catch (Exception e) {
        }
//    return rec;
        return cur;
//        return count;
    }

    public String ShopcodeName(Context context, String shopcode) {

        SQLiteDatabase myDatabase;
        String rec[] = null;
        Cursor cur = null;
        int count = 0;
        String sname = "";
        try {
            myDatabase = (new SqlHelper(context, DataBaseInfo.DataBaseName, null, 1)).getReadableDatabase();
            cur = myDatabase.rawQuery("Select " + DataBaseInfo.SC_NAME + " from " + DataBaseInfo.TABLENAME_shopcode + " Where " + DataBaseInfo.SC_NUMBER + "=" + shopcode, null);
            cur.moveToFirst();
            rec = new String[cur.getCount()];
            count = cur.getCount();
            sname = cur.getString(0);

            Log.e("shopcode ", "shopcode : " + cur.getString(0));
            Log.e("count", "total row : " + cur.getCount());

        } catch (Exception e) {
        }
        return sname;
    }

    public void getshopcodelist(Context context, String snumber) {

        SQLiteDatabase myDatabase;
        String rec[] = null;
        Cursor cur = null;
        int count = 0;
        try {
            myDatabase = (new SqlHelper(context, DataBaseInfo.DataBaseName, null, 1)).getReadableDatabase();
            cur = myDatabase.rawQuery("Select shop_name from " + DataBaseInfo.TABLENAME_shopcode + " WHERE shopcode_number=" + snumber, null);
            cur.moveToFirst();
            rec = new String[cur.getCount()];
            count = cur.getCount();
            Log.e("count", "total row : " + cur.getCount());
            for (int i = 0; i < cur.getCount(); i++) {
//            rec[i]=cur.getString(counter)+" : "+cur.getString(1)+" : "+ cur.getString(2)+" : "+ cur.getString(3);
                //rec[i] = cur.getString(2);
                Log.e("Checking", " " + cur.getString(0) + " : " + cur.getString(1) + " : " + cur.getString(2));
                cur.moveToNext();
                Log.i("tejas ", "field name : " + DataBaseInfo.U_USERNAME);
            }
        } catch (Exception e) {
        }

    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    //    public Cursor getflag(Context context,String serviceid,String sercatid) {
    public String[] getuser(Context context, String username, String password) {
        SQLiteDatabase myDatabase;
        String rec[] = new String[2];
        Cursor cur = null;
        String fullquery = "", flag = "";
        int count = 0;
        try {
//            fullquery = "SELECT " + DataBaseInfo.o_flag + " FROM " + DataBaseInfo.TABLENAME_OPEN_ORDER + " WHERE " + DataBaseInfo.o_serviceid + " = " + serviceid + " AND " + DataBaseInfo.o_subcategoryid + " = " + sercatid + " AND  " + DataBaseInfo.o_status + "=1";
            Log.i("select", "--------------------------------------------");//WHERE email=\'"+ email+"\'" +" AND pass=\'"+password+"\'";
            if (!password.equals("")) {
                fullquery = "SELECT " + DataBaseInfo.U_USERNAME + "," + DataBaseInfo.U_PASSWORD +","+DataBaseInfo.U_SHOPCODE +" from " + DataBaseInfo.TABLENAME_User + " WHERE username = \'" + username + "\'" + " AND password = \'" + password + "\'";
            } else {
                fullquery = "SELECT " + DataBaseInfo.U_USERNAME + " from " + DataBaseInfo.TABLENAME_User + " WHERE username = \'" + username + "\'" ;
            }
            Log.i("select", "--------------------------------------------");
            Log.i("getflag()", "flag from db : " + fullquery);
            myDatabase = (new SqlHelper(context, DataBaseInfo.DataBaseName, null, 1)).getReadableDatabase();
            cur = myDatabase.rawQuery(fullquery, null);
            cur.moveToFirst();
            count = cur.getCount();
            if (count >= 1) {
                Log.i("cur count ", "counter : " + cur.getCount());
                rec[0] = cur.getString(0);
                rec[1] = cur.getString(1);
                rec[2] = cur.getString(2);
                Log.i("getflag()", "flag from db : " + flag);
                flag = cur.getString(0);
                return rec;
            } else {
                if(!password.equals(""))
                Toast.makeText(context, "User not found please enter  valide credencals ", Toast.LENGTH_LONG).show();
            }


        } catch (Exception e) {
        }
        return rec;
//        return cur;
//        return flag;
    }

    public int getMaxBookingID(Context context, String bookingid) {

        SQLiteDatabase myDatabase;
        Cursor cur = null;
        int id = 0, count = 0;

        String strid = "";
        try {
            myDatabase = (new SqlHelper(context, DataBaseInfo.DataBaseName, null, 1)).getReadableDatabase();
            String query = "Select MAX (" + DataBaseInfo.st_booking_id + ") from " + DataBaseInfo.TABLENAME_ordertracker;

//          String query ="delete from "+DataBaseInfo.TABLENAME_ordertracker;
            Log.i("tag", "query : " + query);
            cur = myDatabase.rawQuery(query, null);
            cur.moveToFirst();
//            count = cur.getCount();
            Log.e("count", "total row : " + cur.getCount());
            if (cur.getCount() == 1) {
//                change valu of count and check cursor value from data base
                Log.e("Checking", "max booking id : " + cur.getString(0));
                id = Integer.parseInt(cur.getString(0));
                cur.moveToNext();
                Log.i("tejas ", "field name : " + DataBaseInfo.st_booking_id);
            }
        } catch (Exception e) {
            id = 0;
            Log.e("tag", "Problem in getting last id : " + e.getMessage());
        }
        return id;
    }

    public int getMaxItemBookingID(Context context, String bookingid) {

        SQLiteDatabase myDatabase;
        Cursor cur = null;
        int id = 0, count = 0;

        String strid = "";
        try {
            myDatabase = (new SqlHelper(context, DataBaseInfo.DataBaseName, null, 1)).getReadableDatabase();
            String query = "Select MAX (" + DataBaseInfo.sbt_booking_id+ ") from " + DataBaseInfo.TABLENAME_orderitemtracker;

//          String query ="delete from "+DataBaseInfo.TABLENAME_ordertracker;
            Log.i("tag", "query : " + query);
            cur = myDatabase.rawQuery(query, null);
            cur.moveToFirst();
//            count = cur.getCount();
            Log.e("count", "total row : " + cur.getCount());
            if (cur.getCount() == 1) {
//                change valu of count and check cursor value from data base
                Log.e("Checking", "max booking id : " + cur.getString(0));
                id = Integer.parseInt(cur.getString(0));
                cur.moveToNext();
                Log.i("tejas ", "field name : " + DataBaseInfo.st_booking_id);
            }
        } catch (Exception e) {
            id = 0;
            Log.e("tag", "Problem in getting last id : " + e.getMessage());
        }
        return id;
    }
}
