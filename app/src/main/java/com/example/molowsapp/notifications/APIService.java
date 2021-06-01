package com.example.molowsapp.notifications;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface APIService {

    @Headers({
            "Content-Type:application/json",
            "Authorization:key=AAAAMAlP890:APA91bHpcHuYvztIGhRCNsiXINywLw3sPK7pDH9BEvuAsqVx-EM1mMESCve-uGrXMmEPZHUp1fisw0c5_vNCh6hFbmrRpYK6trYJeUA_2895xSfKVLcIYw10XVttZd-_IC2GQ08ijbeU"
    })

    @POST("fcm/send")
    Call<Response> sendNotification(@Body Sender body);
}
