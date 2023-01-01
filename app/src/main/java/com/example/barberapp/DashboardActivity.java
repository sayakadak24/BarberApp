package com.example.barberapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Objects;

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

        book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = Objects.requireNonNull(auth.getCurrentUser()).getEmail();
                String name = Objects.requireNonNull(auth.getCurrentUser()).getDisplayName();
                String uid = auth.getUid();
                Intent intent = new Intent(DashboardActivity.this, BookActivity.class);
                intent.putExtra("mail",uid);
                startActivity(intent);
            }
        });

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                auth.signOut();
                Intent intent = new Intent(DashboardActivity.this, RegisterActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}