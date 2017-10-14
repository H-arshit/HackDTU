package com.example.harshit.trackbag;

import com.example.harshit.trackbag.models.MatchStatusT;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by harshit on 14/10/17.
 */

public interface API {

    String BASE_URL = "http://192.168.43.126:3000/pnr/";


    @POST("match_status_true")
    Call<ResultData> match_true(@Body MatchStatusT requestData);

    @POST("match_status_false")
    Call<ResultData> match_false(@Body MatchStatusT requestData);
}
