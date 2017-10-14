package com.example.harshit.trackbag;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.harshit.trackbag.models.MatchStatusT;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ResultCheck extends AppCompatActivity {


    TextView resultcheck;
    private static String passqr , bagqr;
    private static boolean check_status;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_check);


        passqr = getIntent().getStringExtra("passqr");
        bagqr = getIntent().getStringExtra("bagqr");
        resultcheck = (TextView)findViewById(R.id.resultcheck);


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        API api = retrofit.create(API.class);


        MatchStatusT matchStatusT = new MatchStatusT();
        matchStatusT.setBaggage_pnr(bagqr);
        matchStatusT.setPass_pnr(passqr);



        if (passqr.equals(bagqr)) {
            check_status = true;


            resultcheck.setText("Matched");


            Call<ResultData> result = api.match_true(matchStatusT);

            result.enqueue(new Callback<ResultData>() {
                @Override
                public void onResponse(Call<ResultData> call, Response<ResultData> response) {

                    Toast.makeText(getApplicationContext(),response.body().getMessage(),Toast.LENGTH_LONG).show();

                }

                @Override
                public void onFailure(Call<ResultData> call, Throwable t) {

                    Toast.makeText(getApplicationContext(),"Network Error",Toast.LENGTH_LONG).show();

                }
            });


        }

        else{
            Call<ResultData> result = api.match_false(matchStatusT);

            result.enqueue(new Callback<ResultData>() {
                @Override
                public void onResponse(Call<ResultData> call, Response<ResultData> response) {
                    Toast.makeText(getApplicationContext(),response.body().getMessage(),Toast.LENGTH_LONG).show();

                }

                @Override
                public void onFailure(Call<ResultData> call, Throwable t) {

                    Toast.makeText(getApplicationContext(),"Network Error",Toast.LENGTH_LONG).show();

                }
            });

            resultcheck.setText("Not Matched");

        }






    }
}
