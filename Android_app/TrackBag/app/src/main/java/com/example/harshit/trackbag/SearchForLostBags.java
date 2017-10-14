package com.example.harshit.trackbag;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import android.widget.Toast;

import com.example.harshit.trackbag.models.UnclaimedBagsData;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SearchForLostBags extends AppCompatActivity implements SearchView.OnQueryTextListener {

    TextView tv,tvSearch;
    SearchView search_for_bags;

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(getBaseContext(),MainActivity.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_for_lost_bags);
        tv=(TextView)findViewById(R.id.tvsearchpnr);
        tvSearch=(TextView)findViewById(R.id.tvSearch);

        search_for_bags = (SearchView)findViewById(R.id.search_for_bags);
        search_for_bags.setOnQueryTextListener(this);

    }


    @Override
    public boolean onQueryTextSubmit(String query) {

        InputMethodManager inputManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);



        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        API api = retrofit.create(API.class);

        UnclaimedBagsData unclaimedBagsData = new UnclaimedBagsData();
        unclaimedBagsData.setBaggage_pnr(query);

        Call<ResultData> response = api.search_unclaimed_data(unclaimedBagsData);

        response.enqueue(new Callback<ResultData>() {
            @Override
            public void onResponse(Call<ResultData> call, Response<ResultData> response) {

                if (response.body() != null)

                    tvSearch.setText(response.body().getMessage());

               // Toast.makeText(getApplicationContext(), response.body().getMessage() ,Toast.LENGTH_LONG).show();

                else
                    tvSearch.setText("NOT FOUND YET!!!");
                    //Toast.makeText(getApplicationContext(), "Not Found Yet" ,Toast.LENGTH_LONG).show();


            }

            @Override
            public void onFailure(Call<ResultData> call, Throwable t) {

                Toast.makeText(getApplicationContext(),"Network Error",Toast.LENGTH_LONG).show();

            }
        });





        return true;
    }

    @Override
    public boolean onQueryTextChange(String newText) {

        tv.setText(" ");

        return false;
    }
}
