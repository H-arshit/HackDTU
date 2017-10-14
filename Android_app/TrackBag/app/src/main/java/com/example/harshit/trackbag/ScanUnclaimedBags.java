package com.example.harshit.trackbag;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.zxing.Result;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class ScanUnclaimedBags extends AppCompatActivity implements View.OnClickListener , ZXingScannerView.ResultHandler{

    private ZXingScannerView zXingScannerView;
    Button scan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan_unclaimed_bags);

        zXingScannerView = new ZXingScannerView(getApplicationContext());
        scan = (Button)findViewById(R.id.scan);
        scan.setOnClickListener(this);

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

        Toast.makeText(getApplicationContext(),result.getText(),Toast.LENGTH_SHORT).show();
        zXingScannerView.resumeCameraPreview(this);
    }
}
