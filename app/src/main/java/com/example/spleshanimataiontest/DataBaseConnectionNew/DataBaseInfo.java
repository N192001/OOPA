package com.example.spleshanimataiontest.DataBaseConnectionNew;

import android.content.Context;

/**
 * Created by admin on 11/7/2016.
 */

public class DataBaseInfo {

    //add new database name
    public static String DataBaseName = "foodorder.db";

    // Table Names
    public static String TABLENAME_shopcode = "shopcodemaster";
    public static String TABLENAME_User = "usermaster";
    public static String TABLENAME_OrderHeadermaster = "orderheadermaster";
    public static String TABLENAME_OrderDetailmaster = "orderdetailmaster";
    public static String TABLENAME_OrderPaymentmaster = "orderpaymentmaster";
    public static String TABLENAME_OrderCustomermaster = "ordercustomermaster";
    public static String TABLENAME_OrderHeaderExt = "orderheaderext";
    public static String TABLENAME_OrderHistory = "orderhistory";
    public static String TABLENAME_OrderHistoryExt = "orderhistoryext";
    public static String TABLENAME_ordertracker = "ordertracker";
    public static String TABLENAME_orderitemtracker = "orderitemtracker";
    public static String TABLENAME_orderdetails="orderdetails";

    // Fields of NewRegistration arraysavelist[0] = userfullname.getText().toString().trim();
    public static String U_ID = "_id";
    public static String U_USERNAME = "username";
    public static String U_PASSWORD = "password";
    public static String U_CONFPW = "passwordconf";
     public static String U_SHOPCODE = "shopcode";


    //Field of Shopcode
    public static String SC_ID = "_id";
    public static String SC_NUMBER = "shopcode_number";
    public static String SC_NAME = "shop_name";


    // Field of Order_hdrs
    public static String oh_ID = "_id";
    public static String order_id = "order_id";
    public static String order_no = "order_no";
    public static String station_code = "station_code";
    public static String user_id = "user_id";
    public static String order_date = "order_date";
    public static String order_time = "order_time";
    public static String shift_id = "shift_id";
    public static String customer_id = "customer_id";
    public static String detail_total = "detail_total";
    public static String total_tax1 = "total_tax1";
    public static String total_tax2 = "total_tax2";
    public static String total_tax3 = "total_tax3";
    public static String total_gst = "total_gst";
    public static String total_sc = "total_sc";
    public static String total_detail_discount = "total_detail_discount";
    public static String final_round_amount = "final_round_amount";
    public static String total_amount = "total_amount";
    public static String total_amount_paid = "total_amount_paid";
    public static String total_balance = "total_balance";
    public static String actual_balance_paid = "actual_balance_paid";
    public static String closing_date = "closing_date";
    public static String closing_time = "closing_time";
    public static String status = "status";
    public static String total_print_count = "total_prrint_count";
    public static String created_by = "created_by";
    public static String created_at = "crated_at";
    public static String updated_by = "updated_by";
    public static String updated_at = "updated_at";
    public static String sync_status = "sync_status";
    public static String sync_message = "sync_message";
    public static String remarks = "remarks";
    public static String shop_code = "shop_code";
    public static String is_ar_customer = "is_ar_customer";
    public static String bill_less_tax_amount = "bill_less_tax_amount";
    public static String bill_discount_amount = "bill_discount_amount";
    public static String cash_out = "cash_out";
    public static String refund_total_tax1 = "refund_total_tax1";
    public static String refund_total_tax2 = "refund_total_tax2";
    public static String refund_total_tax3 = "refund_total_tax3";
    public static String refund_total_gst = "refund_total_gst";
    public static String refund_total_sc = "refund_total_sc";
    public static String refund_amount = "refund_amount";
    public static String serving_table_id = "serving_table_id";
    public static String served_by = "served_by";
    public static String service_type = "service_type";
    public static String covers = "covers";

    // Field for Order Details
    public static String od_mID;


    public static String OD_id = "_id";
    public static String OD_order_id = "order_id";
    public static String OD_sale_item_id = "sale_item_id";
    public static String OD_sale_item_code = "sale_item_code";
    public static String OD_sub_class_id = "sub_class_id";
    public static String OD_sub_class_code = "sub_class_code";
    public static String OD_sub_class_name = "sub_class_name";
    public static String OD_name = "name";
    public static String OD_description = "description";
    public static String OD_alternative_name = "alternative_name";
    public static String OD_name_to_print = "name_to_print";
    public static String OD_alternative_name_to_print = "alternative_name_to_print";
    public static String OD_qty = "qty";
    public static String OD_is_open = "is_open";
    public static String OD_uom_code = "uom_code";
    public static String OD_uom_name = "uom_name";
    public static String OD_uom_symbol = "uom_symbol";
    public static String OD_is_combo_item = "is_combo_item";
    public static String OD_fixed_price = "fixed_price";
    public static String OD_tax_calculation_method = "tax_calculation_method";
    public static String OD_tax_id = "tax_id";
    public static String OD_tax_code = "tax_code";
    public static String OD_tax_name = "tax_name";
    public static String OD_is_tax1_applied = "is_tax1_applied";
    public static String OD_tax1_name = "tax1_name";
    public static String OD_tax1_pc = "tax1_pc";
    public static String OD_tax1_amount = "tax1_amount";
    public static String OD_is_tax2_applied = "is_tax2_applied";
    public static String OD_tax2_name = "tax2_name";
    public static String OD_tax2_pc = "tax2_pc";
    public static String OD_tax2_amount = "tax2_amount";
    public static String OD_is_tax3_applied = "is_tax3_applied";
    public static String OD_tax3_name = "tax3_name";
    public static String OD_tax3_pc = "tax3_pc";
    public static String OD_tax3_amount = "tax3_amount";
    public static String OD_is_sc_applied = "is_sc_applied";
    public static String OD_sc_name = "sc_name";
    public static String OD_sc_pc = "sc_pc";
    public static String OD_sc_amount = "sc_amount";
    public static String OD_is_gst_applied = "is_gst_applied";
    public static String OD_gst_name = "gst_name";
    public static String OD_gst_pc = "gst_pc";
    public static String OD_is_tax1_included_in_gst = "is_tax1_included_in_gst";
    public static String OD_is_tax2_included_in_gst = "is_tax2_included_in_gst";
    public static String OD_is_tax3_included_in_gst = "is_tax3_included_in_gst";
    public static String OD_is_sc_included_in_gst = "is_sc_included_in_gst";
    public static String OD_gst_amount = "gst_amount";
    public static String OD_item_total = "item_total";
    public static String OD_discount_type = "discount_type";
    public static String OD_discount_id = "discount_id";
    public static String OD_discount_code = "discount_code";
    public static String OD_discount_name = "discount_name";
    public static String OD_discount_description = "discount_description";
    public static String OD_discount_price = "discount_price";
    public static String OD_discount_is_percentage = "discount_is_percentage";
    public static String OD_discount_is_overridable = "discount_is_overridable";
    public static String OD_discount_is_item_specific = "discount_is_item_specific";
    public static String OD_discount_permitted_for = "discount_permitted_for";
    public static String OD_discount_amount = "discount_amount";
    public static String OD_discount_is_promotion = "discount_is_promotion";
    public static String OD_discount_grouping_quantity = "discount_grouping_quantity";
    public static String OD_discount_allow_editing = "discount_allow_editing";
    public static String OD_round_adjustment = "round_adjustment";
    public static String OD_attrib1_name = "attrib1_name";
    public static String OD_attrib1_options = "attrib1_options";
    public static String OD_attrib2_name = "attrib2_name";
    public static String OD_attrib2_options = "attrib2_options";
    public static String OD_attrib3_name = "attrib3_name";
    public static String OD_attrib3_options = "attrib3_options";
    public static String OD_attrib4_name = "attrib4_name";
    public static String OD_attrib4_options = "attrib4_options";
    public static String OD_attrib5_name = "attrib5_name";
    public static String OD_attrib5_options = "attrib5_options";
    public static String OD_attrib1_selected_option = "attrib1_selected_option";
    public static String OD_attrib2_selected_option = "attrib2_selected_option";
    public static String OD_attrib3_selected_option = "attrib3_selected_option";
    public static String OD_attrib4_selected_option = "attrib4_selected_option";
    public static String OD_attrib5_selected_option = "attrib5_selected_option";
    public static String OD_status = "status";
    public static String OD_is_printed_to_kitchen = "is_printed_to_kitchen";
    public static String OD_remarks = "remarks";
    public static String OD_is_void = "is_void";
    public static String OD_cashier_id = "cashier_id";
    public static String OD_order_date = "order_date";
    public static String OD_order_time = "order_time";
    public static String OD_customer_price_variance = "customer_price_variance";
    public static String OD_discount_variants = "discount_variants";
    public static String OD_service_type = "service_type";
    public static String OD_serving_table_id = "serving_table_id";
    public static String OD_served_by = "served_by";


    public static String OP_id = "id";
    public static String OP_order_id = "order_id";
    public static String OP_payment_mode = "payment_mode";
    public static String OP_paid_amount = "paid_amount";
    public static String OP_card_name = "card_name";
    public static String OP_card_type = "card_type";
    public static String OP_card_no = "card_no";
    public static String OP_name_on_card = "name_on_card";
    public static String OP_card_expiry_month = "card_expiry_month";
    public static String OP_card_expiry_year = "card_expiry_year";
    public static String OP_card_approval_code = "card_approval_code";
    public static String OP_card_account_type = "card_account_type";
    public static String OP_pos_customer_receipt = "pos_customer_receipt";
    public static String OP_pos_merchant_receipt = "pos_merchant_receipt";
    public static String OP_company_id = "company_id";
    public static String OP_voucher_id = "voucher_id";
    public static String OP_voucher_value = "voucher_value";
    public static String OP_voucher_count = "voucher_count";
    public static String OP_cashier_id = "cashier_id";
    public static String OP_payment_date = "payment_date";
    public static String OP_payment_time = "payment_time";
    public static String OP_discount_id = "discount_id";
    public static String OP_discount_code = "discount_code";
    public static String OP_discount_name = "discount_name";
    public static String OP_discount_description = "discount_description";
    public static String OP_discount_price = "discount_price";
    public static String OP_discount_is_percentage = "discount_is_percentage";
    public static String OP_discount_is_overridable = "discount_is_overridable";
    public static String OP_discount_amount = "discount_amount";
    public static String OP_is_repayment = "is_repayment";
    public static String OP_is_voucher_balance_returned = "is_voucher_balance_returned";


    public static String OC_id = "order_id";
    public static String OC_order_id = "order_id";
    public static String OC_title = "title";
    public static String OC_first_name = "first_name";
    public static String OC_last_name = "last_name";
    public static String OC_address = "address";
    public static String OC_city = "city";
    public static String OC_state = "state";
    public static String OC_country = "country";
    public static String OC_post_code = "post_code";
    public static String OC_gender = "gender";
    public static String OC_dob = "dob";
    public static String OC_phone_number = "phone_number";
    public static String OC_email = "email";


    public static String OHE_id = "	o_id	";
    public static String OHE_order_id = "	order_id	";
    public static String OHE_tax_invoice_no = "	tax_invoice_no	";
    public static String OHE_delivery_date = "	delivery_date	";
    public static String OHE_delivery_time = "	delivery_time	";
    public static String OHE_order_mail_receipt = "		order_mail_receipt	";


    public static String OH_id = "	id	";
    public static String OH_order_id = "	order_id	";
    public static String OH_shop_id = "	shop_id	";
    public static String OH_status = "	status	";
    public static String OH_update_at = "	update_at	";
    public static String OH_sync_status = "	sync_status	";


   /* public static String OHE_id	=	"	order_id	";
    public static String OHE_order_id	=	"	order_id	";
    public static String OHE_tax_invoice_no	=	"	tax_invoice_no	";
    public static String OHE_delivery_date	=	"	delivery_date	";
    public static String OHE_delivery_time	=	"	delivery_time	";
    public static String OHE_order_mail_receipt	=	"	order_mail_receipt	";*/


    /*to save the order according to  status*/
    public static String st_id = "_id";
    public static String st_booking_id = "booking_id";
    public static String st_booking_date = "booking_date";
    public static String st_booking_time = "booking_time";
    public static String st_total_qty = "total_qty";
    public static String st_customername = "customername";
    public static String st_total = "total";
    public static String st_status = "status";

    public static String sbt_id = "_id";
    public static String sbt_booking_id = "booking_id";
    public static String sbt_itemname = "itemname";
    public static String sbt_qty = "qty";
    public static String sbt_rate = "rate";
    public static String sbt_status = "status";

    public static String sdt_customername = "customername";
    public static String sdt_booking_date = "booking_date";
    public static String sdt_booking_id = "booking_id";
    public static String sdt_call = "customernumber";
    public static String sdt_email = "customeremail";
    public static String sdt_location = "location";
    public static String sdt_subtotal = "subtotal";
    public static String sdt_delivery_fee = "delivery_fee";
    public static String sdt_service_tax = "service_tax";
    public static String sdt_discount = "discount";
    public static String sdt_grand_total = "grand_total";
    public static String sbt_orderstatus = "status";


    public DataBaseInfo(Context baseContext, String tablename_notifactionmaster, Object o, int i) {
    }


}
