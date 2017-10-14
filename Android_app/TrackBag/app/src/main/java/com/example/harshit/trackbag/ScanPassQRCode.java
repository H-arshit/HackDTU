package com.example.harshit.trackbag;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.zxing.Result;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class ScanPassQRCode extends AppCompatActivity implements View.OnClickListener , ZXingScannerView.ResultHandler{

    public String passQR;

    private ZXingScannerView zXingScannerView;
    Button scanPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan_pass_qrcode);


        zXingScannerView = new ZXingScannerView(getApplicationContext());

        scanPass = (Button)findViewById(R.id.scanPass);
        scanPass.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

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
        passQR=result.getText();

        Intent intent = new Intent(getBaseContext(), ScanBagQRCode.class);
        intent.putExtra("passqr",passQR);
        startActivity(intent);



    }
}
