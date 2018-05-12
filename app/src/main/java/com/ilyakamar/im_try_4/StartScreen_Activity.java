package com.ilyakamar.im_try_4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class StartScreen_Activity extends AppCompatActivity implements View.OnClickListener {

    Button bt_startScreen_join;
    Button bt_startScreen_logIn ;
    private static final String TAG = "StartScreen_Activity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {// onCreate
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_screen);


        initControl();


    }// end onCreate


    private void initControl() {// initControl


        bt_startScreen_join = (Button) findViewById(R.id.bt_startScreen_join);
        bt_startScreen_logIn = (Button) findViewById(R.id.bt_startScreen_logIn);

        bt_startScreen_join.setOnClickListener(this);
        bt_startScreen_logIn.setOnClickListener(this);

    }// end initControl


    @Override
    public void onClick(View view) {// onClick

        switch (view.getId()) {
            case R.id.bt_startScreen_join:
                Intent signupIntent = new Intent(StartScreen_Activity.this,Signup_Activity.class);
                startActivity(signupIntent);
                Log.d(TAG, "onClick: bt_startScreen_join");

                break;

            case R.id.bt_startScreen_logIn:
                Intent loginIntent = new Intent(StartScreen_Activity.this,Login_Activity.class);
                startActivity(loginIntent);
                Log.d(TAG, "onClick: bt_startScreen_logIn");
                break;
        }// end switch
    }// end onClick


}// END
