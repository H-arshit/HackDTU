package com.example.harshit.trackbag;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.harshit.trackbag.models.MatchStatusT;
import com.google.zxing.Result;

import me.dm7.barcodescanner.zxing.ZXingScannerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ScanUnclaimedBags extends AppCompatActivity implements  ZXingScannerView.ResultHandler{

    private String unclaimedbagQR;
    private ZXingScannerView zXingScannerView;

    EditText etLocation;

    Button scan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan_unclaimed_bags);

        zXingScannerView = new ZXingScannerView(getApplicationContext());
        setContentView(zXingScannerView);
        zXingScannerView.setResultHandler(this);
        zXingScannerView.startCamera();

    }



    @Override
    protected void onPause() {
        super.onPause();

        zXingScannerView.stopCamera();

    }

    @Override
    public void handleResult(Result result) {

        //Toast.makeText(getApplicationContext(),result.getText(),Toast.LENGTH_SHORT).show();
        zXingScannerView.resumeCameraPreview(this);

        unclaimedbagQR=result.getText();

        Intent intent = new Intent(getBaseContext(), UnclaimedBagsResult.class);
        intent.putExtra("unclaimedQR",unclaimedbagQR);
        startActivity(intent);


    }
}
