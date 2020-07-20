package com.example.spleshanimataiontest.interfaces;

import com.example.spleshanimataiontest.datamodel.OrderModel;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Url;

public interface ApiInterface {

    @GET("get_online_orders.php?synchronize={\"shop_code\":\"S044\",\"updated_at\":\"2019-12-05\"}")
    Call<OrderModel> getOrder();

    @GET
    Call<JsonObject> setstatus(@Url String url);
}