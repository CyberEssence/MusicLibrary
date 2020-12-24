package com.example.architectureexample;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ConstraintLayout constraintLayout;
    TextView tvTimeMsg;
    private FirebaseAuth mAuth;

    private TextInputEditText mail;
    private TextInputEditText pass;

    String email;
    String password;

    Button signin;
    Button signup;

    private FirebaseAuth.AuthStateListener mAuthListener;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();

        constraintLayout = findViewById(R.id.container);
        tvTimeMsg = findViewById(R.id.tv_time_msg);

        Calendar c = Calendar.getInstance();

        int timeOfDay = c.get(Calendar.HOUR_OF_DAY);

        mail = (TextInputEditText) findViewById(R.id.email);
        pass = (TextInputEditText) findViewById(R.id.password);

        email = mail.getText().toString();
        password = pass.getText().toString();

        signin = findViewById(R.id.btn_signin);
        signup = findViewById(R.id.btn_signup);

        if(timeOfDay >= 0 && timeOfDay < 12) {
            constraintLayout.setBackground(getDrawable(R.drawable.good_morning_img));
            tvTimeMsg.setText("Good morning!");
        } else if(timeOfDay >= 12 && timeOfDay < 16) {

        } else if(timeOfDay >= 16 && timeOfDay < 21) {

        } else if(timeOfDay >= 21 && timeOfDay < 24) {
            constraintLayout.setBackground(getDrawable(R.drawable.good_night_img));
            tvTimeMsg.setText("Good night!");
        }

        mAuth = FirebaseAuth.getInstance();

        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    // User is signed in
                    /*Intent intent = new Intent(MainActivity.this, NoteActivity.class);
                    startActivity(intent);*/
                } else {
                    // User is signed out

                }

            }
        };

        findViewById(R.id.btn_signup).setOnClickListener(this);
        findViewById(R.id.btn_signin).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.btn_signin)
        {
            signin(mail.getText().toString(), pass.getText().toString());
            Intent intent = new Intent(this, NoteActivity.class);
            startActivity(intent);
        }else if (view.getId() == R.id.btn_signup)
        {
            registration(mail.getText().toString(), pass.getText().toString());
            Intent intent = new Intent(this, NoteActivity.class);
            startActivity(intent);
        }

    }

    public void signin(String email, String password)
    {
        mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()) {
                    Toast.makeText(MainActivity.this, "Autorization succesful", Toast.LENGTH_SHORT).show();
                }else
                    Toast.makeText(MainActivity.this, "Autorization failed", Toast.LENGTH_SHORT).show();

            }
        });
    }
    public void registration (String email, String password){
        mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful())
                {
                    Toast.makeText(MainActivity.this, "Registration succesful", Toast.LENGTH_SHORT).show();
                }
                else
                    Toast.makeText(MainActivity.this, "Registration succesful", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void CreateNewAccount(final String email, final String password) {
        if(TextUtils.isEmpty(email))
        {
            Toast.makeText(this, "Please enter your email", Toast.LENGTH_SHORT).show();
        }
        else if(TextUtils.isEmpty(password))
        {
            Toast.makeText(this, "Please enter your password", Toast.LENGTH_SHORT).show();
        }
        else
        {
            final DatabaseReference mRef;
            mRef = FirebaseDatabase.getInstance().getReference();

            mRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    if(!(dataSnapshot.child("Users").child(email).exists()))
                    {
                        HashMap<String, Object> userdata = new HashMap<>();
                        userdata.put("email", email);
                        userdata.put("password", password);

                        mRef.child("Users").child(String.valueOf(mail)).updateChildren(userdata)
                                .addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {
                                        if(task.isSuccessful())
                                        {
                                            Toast.makeText(MainActivity.this, "Registration succesful", Toast.LENGTH_SHORT).show();
                                        }
                                        else
                                        {
                                            Toast.makeText(MainActivity.this, "Please try again", Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                });
                    }
                    else
                        Toast.makeText(MainActivity.this, "User with this email already exists", Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        }
    }
}
