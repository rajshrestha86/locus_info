package com.locus.locusinfo;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class DetailInformation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_information);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

//        Get Extra Stall Data
        stall_obj _stall=(stall_obj) getIntent().getSerializableExtra("stall");
        if(_stall==null)
        {
            Toast.makeText(getApplicationContext(),"Stall not found.", Toast.LENGTH_SHORT).show();
            finish();
            return;
        }

//        Information Detail
        TextView _detail_information=(TextView) findViewById(R.id.detail_information);
        Log.i("Information", _stall.get_information());
        _detail_information.setText(_stall.get_information());

    }
}
