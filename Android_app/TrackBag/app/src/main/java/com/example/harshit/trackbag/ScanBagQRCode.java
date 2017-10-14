package com.example.harshit.trackbag;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.zxing.Result;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class ScanBagQRCode extends AppCompatActivity implements ZXingScannerView.ResultHandler{

    public String bagQR;

    private ZXingScannerView zXingScannerView;

    public static  String passqr="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan_bag_qrcode);



        zXingScannerView = new ZXingScannerView(getApplicationContext());

        passqr = getIntent().getStringExtra("passqr");

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
        zXingScannerView.resumeCameraPreview(this);
        bagQR=result.getText();

        Intent intent = new Intent(getBaseContext(), ResultCheck.class);
        intent.putExtra("passqr",passqr);
        intent.putExtra("bagqr",bagQR);
        startActivity(intent);



    }
}
