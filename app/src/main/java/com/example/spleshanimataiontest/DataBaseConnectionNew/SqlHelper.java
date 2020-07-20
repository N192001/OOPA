package com.example.spleshanimataiontest.DataBaseConnectionNew;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class SqlHelper extends SQLiteOpenHelper {

    public SqlHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        // TODO Auto-generated constructor stub
    }
//    public SqlHelper(Context context ) {
//        //super(context, name, null, version);
//    }

    @Override
    public SQLiteDatabase getWritableDatabase() {
        return super.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase CallDataBase) {

        String sqlStringUser;
        sqlStringUser = " Create Table IF NOT EXISTS " + DataBaseInfo.TABLENAME_User;
        sqlStringUser += " ( " + com.example.spleshanimataiontest.DataBaseConnectionNew.DataBaseInfo.U_ID + " Integer Primary Key Autoincrement,";
        sqlStringUser += com.example.spleshanimataiontest.DataBaseConnectionNew.DataBaseInfo.U_USERNAME + " Text,";
        sqlStringUser += com.example.spleshanimataiontest.DataBaseConnectionNew.DataBaseInfo.U_PASSWORD + " Text,";
        sqlStringUser += com.example.spleshanimataiontest.DataBaseConnectionNew.DataBaseInfo.U_CONFPW + " Text,";
        sqlStringUser += DataBaseInfo.U_SHOPCODE + " Text)";
        CallDataBase.execSQL(sqlStringUser);

        String sqlStringShopcode;
        sqlStringShopcode = " Create Table  IF NOT EXISTS " + DataBaseInfo.TABLENAME_shopcode;
        sqlStringShopcode += " ( " + DataBaseInfo.SC_ID + " Integer Primary Key Autoincrement,";
        sqlStringShopcode += DataBaseInfo.SC_NUMBER + " Text,";
        sqlStringShopcode += DataBaseInfo.SC_NAME + " Text)";
        CallDataBase.execSQL(sqlStringShopcode);


        String sqlOrderHeader;
        sqlOrderHeader = " Create Table  IF NOT EXISTS " + DataBaseInfo.TABLENAME_OrderHeadermaster;
        sqlOrderHeader += " (  id Integer Primary Key Autoincrement,";
        sqlOrderHeader += DataBaseInfo.oh_ID + " Integer ,";
        sqlOrderHeader += DataBaseInfo.order_id + " Text,";
        sqlOrderHeader += DataBaseInfo.order_no + " Text,";
        sqlOrderHeader += DataBaseInfo.station_code + " Text,";
        sqlOrderHeader += DataBaseInfo.user_id + " Text,";
        sqlOrderHeader += DataBaseInfo.order_date + " Text,";
        sqlOrderHeader += DataBaseInfo.order_time + " Text,";
        sqlOrderHeader += DataBaseInfo.shift_id + " Text,";
        sqlOrderHeader += DataBaseInfo.customer_id + " Text,";
        sqlOrderHeader += DataBaseInfo.detail_total + " Text,";
        sqlOrderHeader += DataBaseInfo.total_tax1 + " Text,";
        sqlOrderHeader += DataBaseInfo.total_tax2 + " Text,";
        sqlOrderHeader += DataBaseInfo.total_tax3 + " Text,";
        sqlOrderHeader += DataBaseInfo.total_gst + " Text,";
        sqlOrderHeader += DataBaseInfo.total_sc + " Text,";
        sqlOrderHeader += DataBaseInfo.total_detail_discount + " Text,";
        sqlOrderHeader += DataBaseInfo.final_round_amount + " Text,";
        sqlOrderHeader += DataBaseInfo.total_amount + " Text,";
        sqlOrderHeader += DataBaseInfo.total_amount_paid + " Text,";
        sqlOrderHeader += DataBaseInfo.total_balance + " Text,";
        sqlOrderHeader += DataBaseInfo.actual_balance_paid + " Text,";
        sqlOrderHeader += DataBaseInfo.closing_date + " Text,";
        sqlOrderHeader += DataBaseInfo.closing_time + " Text,";
        sqlOrderHeader += DataBaseInfo.status + " Text,";
        sqlOrderHeader += DataBaseInfo.total_print_count + " Text,";
        sqlOrderHeader += DataBaseInfo.created_by + " Text,";
        sqlOrderHeader += DataBaseInfo.created_at + " Text,";
        sqlOrderHeader += DataBaseInfo.updated_by + " Text,";
        sqlOrderHeader += DataBaseInfo.updated_at + " Text,";
        sqlOrderHeader += DataBaseInfo.sync_status + " Text,";
        sqlOrderHeader += DataBaseInfo.sync_message + " Text,";
        sqlOrderHeader += DataBaseInfo.remarks + " Text,";
        sqlOrderHeader += DataBaseInfo.shop_code + " Text,";
        sqlOrderHeader += DataBaseInfo.is_ar_customer + " Text,";
        sqlOrderHeader += DataBaseInfo.bill_less_tax_amount + " Text,";
        sqlOrderHeader += DataBaseInfo.bill_discount_amount + " Text,";
        sqlOrderHeader += DataBaseInfo.cash_out + " Text,";
        sqlOrderHeader += DataBaseInfo.refund_total_tax1 + " Text,";
        sqlOrderHeader += DataBaseInfo.refund_total_tax2 + " Text,";
        sqlOrderHeader += DataBaseInfo.refund_total_tax3 + " Text,";
        sqlOrderHeader += DataBaseInfo.refund_total_gst + " Text,";
        sqlOrderHeader += DataBaseInfo.refund_total_sc + " Text,";
        sqlOrderHeader += DataBaseInfo.refund_amount + " Text,";
        sqlOrderHeader += DataBaseInfo.serving_table_id + " Text,";
        sqlOrderHeader += DataBaseInfo.served_by + " Text,";
        sqlOrderHeader += DataBaseInfo.service_type + " Text,";
        sqlOrderHeader += DataBaseInfo.covers + " Text)";
        CallDataBase.execSQL(sqlOrderHeader);

        String sqlOrderDetail;
        sqlOrderDetail = " Create Table  IF NOT EXISTS " + DataBaseInfo.TABLENAME_OrderDetailmaster;
        sqlOrderDetail += " ( id Integer Primary Key Autoincrement,";
        sqlOrderDetail += DataBaseInfo.OD_id + " Integer ,";
        sqlOrderDetail += DataBaseInfo.OD_order_id + " Text,";
        sqlOrderDetail += DataBaseInfo.OD_sale_item_id + " Text,";
        sqlOrderDetail += DataBaseInfo.OD_sale_item_code + " Text,";
        sqlOrderDetail += DataBaseInfo.OD_sub_class_id + " Text,";
        sqlOrderDetail += DataBaseInfo.OD_sub_class_code + " Text,";
        sqlOrderDetail += DataBaseInfo.OD_sub_class_name + " Text,";
        sqlOrderDetail += DataBaseInfo.OD_name + " Text,";
        sqlOrderDetail += DataBaseInfo.OD_description + " Text,";
        sqlOrderDetail += DataBaseInfo.OD_alternative_name + " Text,";
        sqlOrderDetail += DataBaseInfo.OD_name_to_print + " Text,";
        sqlOrderDetail += DataBaseInfo.OD_alternative_name_to_print + " Text,";
        sqlOrderDetail += DataBaseInfo.OD_qty + " Text,";
        sqlOrderDetail += DataBaseInfo.OD_is_open + " Text,";
        sqlOrderDetail += DataBaseInfo.OD_uom_code + " Text,";
        sqlOrderDetail += DataBaseInfo.OD_uom_name + " Text,";
        sqlOrderDetail += DataBaseInfo.OD_uom_symbol + " Text,";
        sqlOrderDetail += DataBaseInfo.OD_is_combo_item + " Text,";
        sqlOrderDetail += DataBaseInfo.OD_fixed_price + " Text,";
        sqlOrderDetail += DataBaseInfo.OD_tax_calculation_method + " Text,";
        sqlOrderDetail += DataBaseInfo.OD_tax_id + " Text,";
        sqlOrderDetail += DataBaseInfo.OD_tax_code + " Text,";
        sqlOrderDetail += DataBaseInfo.OD_tax_name + " Text,";
        sqlOrderDetail += DataBaseInfo.OD_is_tax1_applied + " Text,";
        sqlOrderDetail += DataBaseInfo.OD_tax1_name + " Text,";
        sqlOrderDetail += DataBaseInfo.OD_tax1_pc + " Text,";
        sqlOrderDetail += DataBaseInfo.OD_tax1_amount + " Text,";
        sqlOrderDetail += DataBaseInfo.OD_is_tax2_applied + " Text,";
        sqlOrderDetail += DataBaseInfo.OD_tax2_name + " Text,";
        sqlOrderDetail += DataBaseInfo.OD_tax2_pc + " Text,";
        sqlOrderDetail += DataBaseInfo.OD_tax2_amount + " Text,";
        sqlOrderDetail += DataBaseInfo.OD_is_tax3_applied + " Text,";
        sqlOrderDetail += DataBaseInfo.OD_tax3_name + " Text,";
        sqlOrderDetail += DataBaseInfo.OD_tax3_pc + " Text,";
        sqlOrderDetail += DataBaseInfo.OD_tax3_amount + " Text,";
        sqlOrderDetail += DataBaseInfo.OD_is_sc_applied + " Text,";
        sqlOrderDetail += DataBaseInfo.OD_sc_name + " Text,";
        sqlOrderDetail += DataBaseInfo.OD_sc_pc + " Text,";
        sqlOrderDetail += DataBaseInfo.OD_sc_amount + " Text,";
        sqlOrderDetail += DataBaseInfo.OD_is_gst_applied + " Text,";
        sqlOrderDetail += DataBaseInfo.OD_gst_name + " Text,";
        sqlOrderDetail += DataBaseInfo.OD_gst_pc + " Text,";
        sqlOrderDetail += DataBaseInfo.OD_is_tax1_included_in_gst + " Text,";
        sqlOrderDetail += DataBaseInfo.OD_is_tax2_included_in_gst + " Text,";
        sqlOrderDetail += DataBaseInfo.OD_is_tax3_included_in_gst + " Text,";
        sqlOrderDetail += DataBaseInfo.OD_is_sc_included_in_gst + " Text,";
        sqlOrderDetail += DataBaseInfo.OD_gst_amount + " Text,";
        sqlOrderDetail += DataBaseInfo.OD_item_total + " Text,";
        sqlOrderDetail += DataBaseInfo.OD_discount_type + " Text,";
        sqlOrderDetail += DataBaseInfo.OD_discount_id + " Text,";
        sqlOrderDetail += DataBaseInfo.OD_discount_code + " Text,";
        sqlOrderDetail += DataBaseInfo.OD_discount_name + " Text,";
        sqlOrderDetail += DataBaseInfo.OD_discount_description + " Text,";
        sqlOrderDetail += DataBaseInfo.OD_discount_price + " Text,";
        sqlOrderDetail += DataBaseInfo.OD_discount_is_percentage + " Text,";
        sqlOrderDetail += DataBaseInfo.OD_discount_is_overridable + " Text,";
        sqlOrderDetail += DataBaseInfo.OD_discount_is_item_specific + " Text,";
        sqlOrderDetail += DataBaseInfo.OD_discount_permitted_for + " Text,";
        sqlOrderDetail += DataBaseInfo.OD_discount_amount + " Text,";
        sqlOrderDetail += DataBaseInfo.OD_discount_is_promotion + " Text,";
        sqlOrderDetail += DataBaseInfo.OD_discount_grouping_quantity + " Text,";
        sqlOrderDetail += DataBaseInfo.OD_discount_allow_editing + " Text,";
        sqlOrderDetail += DataBaseInfo.OD_round_adjustment + " Text,";
        sqlOrderDetail += DataBaseInfo.OD_attrib1_name + " Text,";
        sqlOrderDetail += DataBaseInfo.OD_attrib1_options + " Text,";
        sqlOrderDetail += DataBaseInfo.OD_attrib2_name + " Text,";
        sqlOrderDetail += DataBaseInfo.OD_attrib2_options + " Text,";
        sqlOrderDetail += DataBaseInfo.OD_attrib3_name + " Text,";
        sqlOrderDetail += DataBaseInfo.OD_attrib3_options + " Text,";
        sqlOrderDetail += DataBaseInfo.OD_attrib4_name + " Text,";
//        sqlOrderDetail += DataBaseInfo.OD_attrib4_	+ " Text,";
        sqlOrderDetail += DataBaseInfo.OD_attrib5_name + " Text,";
        sqlOrderDetail += DataBaseInfo.OD_attrib5_options + " Text,";
        sqlOrderDetail += DataBaseInfo.OD_attrib1_selected_option + " Text,";
        sqlOrderDetail += DataBaseInfo.OD_attrib2_selected_option + " Text,";
        sqlOrderDetail += DataBaseInfo.OD_attrib3_selected_option + " Text,";
        sqlOrderDetail += DataBaseInfo.OD_attrib4_selected_option + " Text,";
        sqlOrderDetail += DataBaseInfo.OD_attrib5_selected_option + " Text,";
        sqlOrderDetail += DataBaseInfo.OD_status + " Text,";
        sqlOrderDetail += DataBaseInfo.OD_is_printed_to_kitchen + " Text,";
        sqlOrderDetail += DataBaseInfo.OD_remarks + " Text,";
        sqlOrderDetail += DataBaseInfo.OD_is_void + " Text,";
        sqlOrderDetail += DataBaseInfo.OD_cashier_id + " Text,";
        sqlOrderDetail += DataBaseInfo.OD_order_date + " Text,";
        sqlOrderDetail += DataBaseInfo.OD_order_time + " Text,";
        sqlOrderDetail += DataBaseInfo.OD_customer_price_variance + " Text,";
        sqlOrderDetail += DataBaseInfo.OD_discount_variants + " Text,";
        sqlOrderDetail += DataBaseInfo.OD_service_type + " Text,";
        sqlOrderDetail += DataBaseInfo.OD_serving_table_id + " Text,";
        sqlOrderDetail += DataBaseInfo.OD_served_by + " Text)";
        CallDataBase.execSQL(sqlOrderDetail);

        String sqlOrderPayment;
        sqlOrderPayment = " Create Table  IF NOT EXISTS " + DataBaseInfo.TABLENAME_OrderPaymentmaster;
        sqlOrderPayment += " ( " + DataBaseInfo.OP_id + " Integer Primary Key Autoincrement,";
        sqlOrderPayment += DataBaseInfo.OP_order_id + " TEXT,";
        sqlOrderPayment += DataBaseInfo.OP_payment_mode + " TEXT,";
        sqlOrderPayment += DataBaseInfo.OP_paid_amount + " TEXT,";
        sqlOrderPayment += DataBaseInfo.OP_card_name + " TEXT,";
        sqlOrderPayment += DataBaseInfo.OP_card_type + " TEXT,";
        sqlOrderPayment += DataBaseInfo.OP_card_no + " TEXT,";
        sqlOrderPayment += DataBaseInfo.OP_name_on_card + " TEXT,";
        sqlOrderPayment += DataBaseInfo.OP_card_expiry_month + " TEXT,";
        sqlOrderPayment += DataBaseInfo.OP_card_expiry_year + " TEXT,";
        sqlOrderPayment += DataBaseInfo.OP_card_approval_code + " TEXT,";
        sqlOrderPayment += DataBaseInfo.OP_card_account_type + " TEXT,";
        sqlOrderPayment += DataBaseInfo.OP_pos_customer_receipt + " TEXT,";
        sqlOrderPayment += DataBaseInfo.OP_pos_merchant_receipt + " TEXT,";
        sqlOrderPayment += DataBaseInfo.OP_company_id + " TEXT,";
        sqlOrderPayment += DataBaseInfo.OP_voucher_id + " TEXT,";
        sqlOrderPayment += DataBaseInfo.OP_voucher_value + " TEXT,";
        sqlOrderPayment += DataBaseInfo.OP_voucher_count + " TEXT,";
        sqlOrderPayment += DataBaseInfo.OP_cashier_id + " TEXT,";
        sqlOrderPayment += DataBaseInfo.OP_payment_date + " TEXT,";
        sqlOrderPayment += DataBaseInfo.OP_payment_time + " TEXT,";
        sqlOrderPayment += DataBaseInfo.OP_discount_id + " TEXT,";
        sqlOrderPayment += DataBaseInfo.OP_discount_code + " TEXT,";
        sqlOrderPayment += DataBaseInfo.OP_discount_name + " TEXT,";
        sqlOrderPayment += DataBaseInfo.OP_discount_description + " TEXT,";
        sqlOrderPayment += DataBaseInfo.OP_discount_price + " TEXT,";
        sqlOrderPayment += DataBaseInfo.OP_discount_is_percentage + " TEXT,";
        sqlOrderPayment += DataBaseInfo.OP_discount_is_overridable + " TEXT,";
        sqlOrderPayment += DataBaseInfo.OP_discount_amount + " TEXT,";
        sqlOrderPayment += DataBaseInfo.OP_is_repayment + " TEXT,";
        sqlOrderPayment += DataBaseInfo.OP_is_voucher_balance_returned + " TEXT)";
        CallDataBase.execSQL(sqlOrderPayment);

        String sqlOrderCustomer;
        sqlOrderCustomer = " Create Table  IF NOT EXISTS " + DataBaseInfo.TABLENAME_OrderCustomermaster;
        sqlOrderCustomer += " ( _id Integer Primary Key Autoincrement,";
        sqlOrderCustomer += DataBaseInfo.OC_order_id + " TEXT,";
        sqlOrderCustomer += DataBaseInfo.OC_title + " TEXT,";
        sqlOrderCustomer += DataBaseInfo.OC_first_name + " TEXT,";
        sqlOrderCustomer += DataBaseInfo.OC_last_name + " TEXT,";
        sqlOrderCustomer += DataBaseInfo.OC_address + " TEXT,";
        sqlOrderCustomer += DataBaseInfo.OC_city + " TEXT,";
        sqlOrderCustomer += DataBaseInfo.OC_state + " TEXT,";
        sqlOrderCustomer += DataBaseInfo.OC_country + " TEXT,";
        sqlOrderCustomer += DataBaseInfo.OC_post_code + " TEXT,";
        sqlOrderCustomer += DataBaseInfo.OC_gender + " TEXT,";
        sqlOrderCustomer += DataBaseInfo.OC_dob + " TEXT,";
        sqlOrderCustomer += DataBaseInfo.OC_phone_number + " TEXT,";
        sqlOrderCustomer += DataBaseInfo.OC_email + " TEXT)";
        CallDataBase.execSQL(sqlOrderCustomer);

        String sqlOrderHeaderExt;
        sqlOrderHeaderExt = " Create Table  IF NOT EXISTS " + DataBaseInfo.TABLENAME_OrderHeaderExt;
        sqlOrderHeaderExt += " (  _id Integer Primary Key Autoincrement,";
        sqlOrderHeaderExt += DataBaseInfo.OHE_id + " Integer ,";
        sqlOrderHeaderExt += DataBaseInfo.OHE_order_id + " TEXT,";
        sqlOrderHeaderExt += DataBaseInfo.OHE_tax_invoice_no + " TEXT,";
        sqlOrderHeaderExt += DataBaseInfo.OHE_delivery_date + " TEXT,";
        sqlOrderHeaderExt += DataBaseInfo.OHE_delivery_time + " TEXT,";
        sqlOrderHeaderExt += DataBaseInfo.OHE_order_mail_receipt + " TEXT)";
        CallDataBase.execSQL(sqlOrderHeaderExt);

        String sqlOrderHistory;
        sqlOrderHistory = " Create Table  IF NOT EXISTS " + DataBaseInfo.TABLENAME_OrderHistory;
        sqlOrderHistory += " ( _id Integer Primary Key Autoincrement,";
        sqlOrderHistory += DataBaseInfo.OH_id + " TEXT,";
        sqlOrderHistory += DataBaseInfo.OH_order_id + " TEXT,";
        sqlOrderHistory += DataBaseInfo.OH_shop_id + " TEXT,";
        sqlOrderHistory += DataBaseInfo.OH_status + " TEXT,";
        sqlOrderHistory += DataBaseInfo.OH_update_at + " TEXT,";
        sqlOrderHistory += DataBaseInfo.OH_sync_status + " TEXT)";
        CallDataBase.execSQL(sqlOrderHistory);

        String sqlOrderHistoryExt;
        sqlOrderHistoryExt = " Create Table  IF NOT EXISTS " + DataBaseInfo.TABLENAME_OrderHistoryExt;
        sqlOrderHistoryExt += " ( _id Integer Primary Key Autoincrement,";
        sqlOrderHistoryExt += DataBaseInfo.OHE_id + " Integer,";
        sqlOrderHistoryExt += DataBaseInfo.OHE_order_id + " TEXT,";
        sqlOrderHistoryExt += DataBaseInfo.OHE_tax_invoice_no + " TEXT,";
        sqlOrderHistoryExt += DataBaseInfo.OHE_delivery_date + " TEXT,";
        sqlOrderHistoryExt += DataBaseInfo.OHE_delivery_time + " TEXT,";
        sqlOrderHistoryExt += DataBaseInfo.OHE_order_mail_receipt + " TEXT)";
        CallDataBase.execSQL(sqlOrderHistoryExt);


        String sqlStringOrdertracker;
        sqlStringOrdertracker = " Create Table  IF NOT EXISTS " + DataBaseInfo.TABLENAME_ordertracker;
        sqlStringOrdertracker += "(_id Integer Primary Key Autoincrement,";
        sqlStringOrdertracker += DataBaseInfo.st_booking_id + " Text,";
        sqlStringOrdertracker += DataBaseInfo.st_booking_date + " Text,";
        sqlStringOrdertracker += DataBaseInfo.st_booking_time + " Text,";
        sqlStringOrdertracker += DataBaseInfo.st_total_qty + " Text,";
        sqlStringOrdertracker += DataBaseInfo.st_customername + " Text,";
        sqlStringOrdertracker += DataBaseInfo.st_total + " Text,";
        sqlStringOrdertracker += DataBaseInfo.st_status + " Text)";
        CallDataBase.execSQL(sqlStringOrdertracker);

        String sqlStringOrderitemtracker;
        sqlStringOrderitemtracker=" Create Table  IF NOT EXISTS " + DataBaseInfo.TABLENAME_orderitemtracker;
        sqlStringOrderitemtracker+= "( _id Integer Primary Key Autoincrement,";
        sqlStringOrderitemtracker+= DataBaseInfo.sbt_booking_id+" Text,";
        sqlStringOrderitemtracker+= DataBaseInfo.sbt_itemname+" Text,";
        sqlStringOrderitemtracker+= DataBaseInfo.sbt_qty+" Text,";
        sqlStringOrderitemtracker+= DataBaseInfo.sbt_rate+" Text,";
        sqlStringOrderitemtracker+= DataBaseInfo.sbt_status+" Text)";
        CallDataBase.execSQL(sqlStringOrderitemtracker);

        String sqlStringOrderDetail;
        sqlStringOrderDetail=" Create Table  IF NOT EXISTS " + DataBaseInfo.TABLENAME_orderdetails	;
        sqlStringOrderDetail+= "( _id Integer Primary Key Autoincrement,";
        sqlStringOrderDetail+= DataBaseInfo.sdt_customername+" Text,";
        sqlStringOrderDetail+= DataBaseInfo.sdt_booking_date+" Text,";
        sqlStringOrderDetail+= DataBaseInfo.sdt_booking_id+" Text,";
        sqlStringOrderDetail+= DataBaseInfo.sdt_call+" Text,";
        sqlStringOrderDetail+= DataBaseInfo.sdt_email+" Text,";
        sqlStringOrderDetail+= DataBaseInfo.sdt_location+" Text,";
        sqlStringOrderDetail+= DataBaseInfo.sdt_subtotal+" Text,";
        sqlStringOrderDetail+= DataBaseInfo.sdt_delivery_fee+" Text,";
        sqlStringOrderDetail+= DataBaseInfo.sdt_service_tax+" Text,";
        sqlStringOrderDetail+= DataBaseInfo.sdt_discount+" Text,";
        sqlStringOrderDetail+= DataBaseInfo.sdt_grand_total+" Text,";
        sqlStringOrderDetail+= DataBaseInfo.sbt_orderstatus + " Text)";
        CallDataBase.execSQL(sqlStringOrderDetail);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
