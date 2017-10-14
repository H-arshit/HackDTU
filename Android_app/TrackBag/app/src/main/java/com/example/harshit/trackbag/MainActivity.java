package com.example.harshit.trackbag;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    Button btncheck,btnunclaimed , search_button;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btncheck=(Button)findViewById(R.id.btncheck);
        btnunclaimed=(Button)findViewById(R.id.btnunclaimed);
        search_button=(Button)findViewById(R.id.search_button);

        btncheck.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,ScanPassQRCode.class));
            }
        });
        btnunclaimed.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,ScanUnclaimedBags.class));
            }
        });

        search_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,SearchForLostBags.class));
            }
        });





    }


    boolean doubleBackToExitPressedOnce = false;

    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            moveTaskToBack(true);
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this,"Press Back Again To Exit",Toast.LENGTH_LONG).show();


        //moveTaskToBack(true);
    }




}
