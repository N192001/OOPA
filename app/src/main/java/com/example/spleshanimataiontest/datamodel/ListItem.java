package com.example.spleshanimataiontest.datamodel;

import java.io.Serializable;

public class ListItem implements Serializable {
    private String customername;//service name
    private String date;
    private String price;
    private String time;
    private String status;
    private String offerprice;
    private String discount;
    private String qty;
    private String total;
    private String itemname;

    private String booking_id;
    private String customernumber;
    private String customeremail;
    private String location;
    private String subtotal;
    private String delivery_fee;
    private String service_tax;
    private String grand_total;

    public ListItem() {

    }
//    customername,date,time,booking_id,total,qty

    public ListItem(String customername, String date, String time, String qty, String total, String booking_id) {
        this.customername = customername;
        this.date = date;
        this.time = time;
        this.qty = qty;
        this.total = total;
        this.booking_id = booking_id;
    }

    public ListItem(String customername, String date, String time, String qty, String total, String booking_id,String status) {
        this.customername = customername;
        this.date = date;
        this.time = time;
        this.qty = qty;
        this.total = total;
        this.booking_id = booking_id;
        this.status=status;
    }
    public ListItem(String price, String qty, String itemname, String booking_id) {
        this.price = price;
        this.qty = qty;
        this.itemname = itemname;
        this.booking_id = booking_id;
    }

    public ListItem(String customername, String booking_date, String booking_id, String call, String email, String location, String subtotal, String delivery_fee, String service_tax, String discount, String grand_total, String orderstatus) {
        this.customername = customername;
        this.date = booking_date;
        this.booking_id = booking_id;
        this.customernumber = call;
        this.customeremail = email;
        this.location = location;
        this.subtotal = subtotal;
        this.delivery_fee = delivery_fee;
        this.service_tax = service_tax;
        this.discount = discount;
        this.grand_total = grand_total;
        this.status = orderstatus;
    }


    public ListItem(String customername, String date, String price, String time, String status, String offerprice, String discount, String qty) {
        this.customername = customername;
        this.date = date;
        this.price = price;
        this.time = time;
        this.status = status;
        this.offerprice = offerprice;
        this.discount = discount;
        this.qty = qty;
    }

    public String getItemname() {
        return itemname;
    }

    public void setItemname(String itemname) {
        this.itemname = itemname;
    }

    public String getCustomername() {
        return customername;
    }

    public void setCustomername(String customername) {
        this.customername = customername;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getBooking_id() {
        return booking_id;
    }

    public void setBooking_id(String booking_id) {
        this.booking_id = booking_id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getOfferprice() {
        return offerprice;
    }

    public void setOfferprice(String offerprice) {
        this.offerprice = offerprice;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public String getQty() {
        return qty;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getCustomernumber() {
        return customernumber;
    }

    public void setCustomernumber(String customernumber) {
        this.customernumber = customernumber;
    }

    public String getCustomeremail() {
        return customeremail;
    }

    public void setCustomeremail(String customeremail) {
        this.customeremail = customeremail;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(String subtotal) {
        this.subtotal = subtotal;
    }

    public String getDelivery_fee() {
        return delivery_fee;
    }

    public void setDelivery_fee(String delivery_fee) {
        this.delivery_fee = delivery_fee;
    }

    public String getService_tax() {
        return service_tax;
    }

    public void setService_tax(String service_tax) {
        this.service_tax = service_tax;
    }

    public String getGrand_total() {
        return grand_total;
    }

    public void setGrand_total(String grand_total) {
        this.grand_total = grand_total;
    }
}
