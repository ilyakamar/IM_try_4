package com.ilyakamar.im_try_4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Customers_Activity extends AppCompatActivity implements View.OnClickListener{// Customers_Activity

    private FirebaseAuth mAuth;
    private DatabaseReference myRef;

    FirebaseUser user = mAuth.getInstance().getCurrentUser();

    //FirebaseListAdapter mAdapter;

    private EditText ET_new_task;
    private Button Btn_new_task;


    TextView t;




    @Override
    protected void onCreate(Bundle savedInstanceState) {// onCreate
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customers);


        myRef = FirebaseDatabase.getInstance().getReference();
        String s = user.getEmail();
        t = (TextView)findViewById(R.id.tv_customerActivity);

        t.setText(s);





    }// end onCreate


    @Override
    public void onClick(View view) {// onClick

    }//end onClick


}// END
