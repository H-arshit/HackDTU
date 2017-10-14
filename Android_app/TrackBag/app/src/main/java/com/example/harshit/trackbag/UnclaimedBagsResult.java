package com.example.harshit.trackbag;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.harshit.trackbag.models.MatchStatusT;
import com.example.harshit.trackbag.models.UnclaimedBagsData;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class UnclaimedBagsResult extends AppCompatActivity {

    public static String unclaimedbagQR;
    EditText etLocation;
    Button btnSend;
    String setLoc;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unclaimed_bags_result);
        unclaimedbagQR=getIntent().getStringExtra("unclaimedQR");

        etLocation=(EditText)findViewById(R.id.etLocation);
        btnSend=(Button)findViewById(R.id.btnSend);

        btnSend.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                setLoc=etLocation.getText().toString();

                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(API.BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                API api = retrofit.create(API.class);

                UnclaimedBagsData unclaimedBagsData = new UnclaimedBagsData();
                unclaimedBagsData.setLocation(setLoc);
                unclaimedBagsData.setBaggage_pnr(unclaimedbagQR);

                Call<ResultData> response = api.unclaimed_bag_data_add(unclaimedBagsData);

                response.enqueue(new Callback<ResultData>() {
                    @Override
                    public void onResponse(Call<ResultData> call, Response<ResultData> response) {

                        Toast.makeText(getApplicationContext(),"ADDED",Toast.LENGTH_LONG).show();

                    }

                    @Override
                    public void onFailure(Call<ResultData> call, Throwable t) {

                        Toast.makeText(getApplicationContext(),"Network Error",Toast.LENGTH_LONG).show();

                    }
                });

            }
        });

    }


}
