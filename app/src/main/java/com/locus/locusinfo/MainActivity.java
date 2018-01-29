package com.locus.locusinfo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button _search=(Button) findViewById(R.id.search_button);
        final EditText _search_edit_text=(EditText)findViewById(R.id.search_data);
        _search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String _search_data=String.valueOf(_search_edit_text.getText());
                Log.i("search", _search_data);
                sql_helper helper=new sql_helper(getApplicationContext(), "stall");
                stall_obj _stall=helper.get_stall_info(_search_data);
                Intent intent=new Intent(getApplicationContext(), DetailInformation.class);
                intent.putExtra("stall",_stall);
                startActivity(intent);
                return;




            }
        });

    }
}
