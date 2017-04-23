package com.example.regx.plantatree;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by Madhav on 4/22/2017.
 */

public class LoginDisplay extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_display);
        Button btnSignup = (Button) findViewById(R.id.btn_signup);
        btnSignup.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), SignUpDisplay.class);
                startActivity(i);
            }
        });

    }
}
