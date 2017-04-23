package com.example.regx.plantatree;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by Madhav on 4/23/2017.
 */

public class SignUpDisplay extends AppCompatActivity {
    private FirebaseAuth auth;
    private DatabaseReference dbref;
    private DatabaseReference ref;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dbref = FirebaseDatabase.getInstance().getReferenceFromUrl("https://plantatree-dd065.firebaseio.com/User");
        setContentView(R.layout.signup_display);

        EditText password = (EditText) findViewById(R.id.editPassword1);
        EditText confirm = (EditText) findViewById(R.id.editPassword2);
        if (password.getText().toString().equals(confirm.getText().toString())) {
            //Passwords match allow sign up

        } else {
            password.setError("Password and confirm password do not match");
        }


        EditText name = (EditText) findViewById(R.id.editName);
        EditText dob = (EditText) findViewById(R.id.editDOB);
        EditText phone = (EditText) findViewById(R.id.editPhone);
        EditText email = (EditText) findViewById(R.id.editEmail);
        Button cancel = (Button) findViewById(R.id.btn_cancel);
        Button signup = (Button) findViewById(R.id.btn_sign_up);

        auth.createUserWithEmailAndPassword(email.getText().toString(), password.getText().toString())
                .addOnCompleteListener(SignUpDisplay.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Toast.makeText(SignUpDisplay.this, "createUserWithEmail:onComplete:" + task.isSuccessful(), Toast.LENGTH_SHORT).show();
                        // If sign in fails, display a message to the user. If sign in succeeds
                        // the auth state listener will be notified and logic to handle the
                        // signed in user can be handled in the listener.
                        if (!task.isSuccessful()) {
                            Toast.makeText(SignUpDisplay.this, "Authentication failed." + task.getException(),
                                    Toast.LENGTH_SHORT).show();
                        } else {
                            startActivity(new Intent(SignUpDisplay.this, MainActivity.class));
                            finish();
                        }
                    }
                });
    }
}
