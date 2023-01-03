package com.example.barberapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

public class DashboardActivity extends AppCompatActivity {
    Button book,contact,btnLogout;

    FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        book = findViewById(R.id.book);
        contact = findViewById(R.id.contact);
        btnLogout = findViewById(R.id.btnLogout);

        auth = FirebaseAuth.getInstance();

        book.setOnClickListener(view -> {
            String uid = auth.getUid();
            Intent intent = new Intent(DashboardActivity.this, BookActivity.class);
            intent.putExtra("uid",uid);
            startActivity(intent);
        });

        btnLogout.setOnClickListener(view -> {
            auth.signOut();
            Intent intent = new Intent(DashboardActivity.this, RegisterActivity.class);
            startActivity(intent);
            finish();
        });
    }
}