package com.example.bam.tracker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.TextView;

import com.example.bam.tracker.R;

public class User extends ActionBarActivity {
    TextView vw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        vw = (TextView)findViewById(R.id.textView);
        Bundle b = getIntent().getExtras();
        if (b.getString("Username")!=null)

        {
            vw.setText(b.getString("Username"));

        }

    }
    public void onClick_track(View view)
    {
        Intent onClick_track = new Intent(getApplicationContext(),MapsActivity1.class);
        startActivity(onClick_track);

    }

}
