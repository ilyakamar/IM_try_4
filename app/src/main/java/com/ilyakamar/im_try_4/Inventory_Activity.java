package com.ilyakamar.im_try_4;

import android.content.Intent;
import android.database.Cursor;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ListView;

public class Inventory_Activity extends AppCompatActivity {// Start



    @Override
    protected void onCreate(Bundle savedInstanceState) {// onCreate
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inventory);


        // FloatingActionButton
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab_activity_inventory);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view,"Replace with yout own action",Snackbar.LENGTH_LONG)
                        .setAction("Action",null).show();
            }
        });// end FloatingActionButton





    }// end onCreate





}// END
