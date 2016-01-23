package com.example.bam.tracker;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.telephony.SmsManager;
import android.view.View;

import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.bam.tracker.R;

public class Register extends ActionBarActivity implements View.OnClickListener  {
        EditText User,pass,email,phone,passcheck,otpinput;
        Button bsubmit,otp;
        datatbasehandler d;


        int rand,random;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        User= (EditText) findViewById(R.id.editText);
        pass= (EditText) findViewById(R.id.editText2);
        email= (EditText) findViewById(R.id.editText3);
        phone= (EditText) findViewById(R.id.editText4);
        passcheck=(EditText)findViewById(R.id.PasswordCheck);
        bsubmit=(Button)findViewById(R.id.button);
        otp=(Button)findViewById(R.id.OTPGene);
        otpinput=(EditText)findViewById(R.id.OTP);
        bsubmit.setOnClickListener(this);
        otp.setOnClickListener(this);
        otpinput.setVisibility(View.INVISIBLE);
        d=new datatbasehandler(this,null,null,1);



    }
    public void check(int ran)
    {

        String user=User.getText().toString();
        String password=pass.getText().toString();
        String emailid=email.getText().toString();
        String phoneno=phone.getText().toString();
        random=ran;
        int  tem = Integer.parseInt(otpinput.getText().toString());
      
        if(!user.equals("") && password.equals(passcheck.getText().toString()) && !phoneno.equals("") && tem==random)
        {
            Toast.makeText(getApplicationContext(),"Everthing Is Fine",Toast.LENGTH_LONG).show();
            Data ds = new Data(user, password, emailid, phoneno);
            d.RegisterUser(ds);

        }



        else {
            Toast.makeText(getApplicationContext(),"Incomplete Details Fill Everthing properly",Toast.LENGTH_LONG).show();

        }

    }



    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.OTPGene:
                String no=phone.getText().toString();
                rand=(int)(Math.random()*9000)+1000;
                String pin =String.valueOf(rand);
                otp.setVisibility(View.INVISIBLE);
                otpinput.setVisibility(View.VISIBLE);
                SmsManager manager = SmsManager.getDefault();
                manager.sendTextMessage(no,null,pin,null,null);
                Toast.makeText(getApplicationContext(),"Value of random"+rand,Toast.LENGTH_LONG).show();
                break;
            case R.id.button:
                Toast.makeText(getApplicationContext(),"Value of Rand"+rand,Toast.LENGTH_LONG).show();
                check(rand);
                break;

        }

    }
}
