package com.ilyakamar.im_try_4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class Main_Activity extends AppCompatActivity implements View.OnClickListener{// Main_Activity

    Button bt_sale;
    Button bt_statistica;
    Button bt_customers;
    Button bt_inventory;

    private static final String TAG = "Main_Activity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {// onCreate
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initControl();

    }// end

    private void initControl() {// initControl


        bt_statistica = (Button)findViewById(R.id.bt_mainActivity_statistica);
        bt_customers = (Button)findViewById(R.id.bt_mainActivity_customers);
        bt_inventory = (Button)findViewById(R.id.bt_mainActivity_inventory);
        bt_sale = (Button)findViewById(R.id.bt_mainActivity_sale);

        bt_sale.setOnClickListener(this);
        bt_statistica.setOnClickListener(this);
        bt_customers.setOnClickListener(this);
        bt_inventory.setOnClickListener(this);



    }// initControl

    @Override
    public void onClick(View v) {// onClick

        switch (v.getId()) {
            case R.id.bt_mainActivity_sale:
                Log.d(TAG, "onClick: bt_mainActivity_sale");
                Intent intent_sale = new Intent(Main_Activity.this,Sale_Activity.class);
                startActivity(intent_sale);

                break;

            case R.id.bt_mainActivity_statistica:
                Log.d(TAG, "onClick: bt_mainActivity_statistica");

                break;

            case R.id.bt_mainActivity_customers:
                Log.d(TAG, "onClick: bt_mainActivity_customers");
                Intent intent_customers = new Intent(Main_Activity.this,Customers_Activity.class);
                startActivity(intent_customers);

                break;

            case R.id.bt_mainActivity_inventory:
                Log.d(TAG, "onClick: bt_mainActivity_inventory");

                Intent intent_inventory = new Intent(Main_Activity.this,Inventory_Activity.class);
                startActivity(intent_inventory);
                break;






        }// end switch

    }// end onClick
}// END
