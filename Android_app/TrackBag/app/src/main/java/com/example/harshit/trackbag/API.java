package com.example.harshit.trackbag;

import com.example.harshit.trackbag.models.MatchStatusT;
import com.example.harshit.trackbag.models.UnclaimedBagsData;

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

    @POST("unclaimed")
    Call<ResultData> unclaimed_bag_data_add(@Body UnclaimedBagsData unclaimedBagsData);


    @POST("search_for_lost_bag")
    Call<ResultData> search_unclaimed_data(@Body UnclaimedBagsData unclaimedBagsData);

}
