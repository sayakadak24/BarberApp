package com.example.barberapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.drawable.AnimatedVectorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class RequestActivity extends AppCompatActivity {
    TextView tv;
    DatabaseReference rootRef,slot1,slot2,slot3,slot4,slot5,slot6,slot7,slot8;
    MyAdapter adapter,adapter2,adapter3,adapter4,adapter5,adapter6,adapter7,adapter8;
    RecyclerView rV1,rV2,rV3,rV4,rV5,rV6,rV7,rV8;

    @Override
    protected void onStart() {
        super.onStart();
        adapter.startListening();
        adapter2.startListening();
        adapter3.startListening();
        adapter4.startListening();
        adapter5.startListening();
        adapter6.startListening();
        adapter7.startListening();
        adapter8.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        adapter.stopListening();
        adapter2.stopListening();
        adapter3.stopListening();
        adapter4.stopListening();
        adapter5.stopListening();
        adapter6.stopListening();
        adapter7.stopListening();
        adapter8.stopListening();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request);

        rV1 = findViewById(R.id.recycler);
        rV2 = findViewById(R.id.recycler2);
        rV3 = findViewById(R.id.recycler3);
        rV4 = findViewById(R.id.recycler4);
        rV5 = findViewById(R.id.recycler5);
        rV6 = findViewById(R.id.recycler6);
        rV7 = findViewById(R.id.recycler7);
        rV8 = findViewById(R.id.recycler8);

        rV1.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,true));
        rV2.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,true));
        rV3.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,true));
        rV4.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,true));
        rV5.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,true));
        rV6.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,true));
        rV7.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,true));
        rV8.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,true));

        tv = findViewById(R.id.slot1);
        rootRef = FirebaseDatabase.getInstance().getReference();
        slot1 = rootRef.child("slot0900_0930");
        slot2 = rootRef.child("slot0930_1000");
        slot3 = rootRef.child("slot1000_1030");
        slot4 = rootRef.child("slot1030_1100");
        slot5 = rootRef.child("slot1100_1130");
        slot6 = rootRef.child("slot1130_1200");
        slot7 = rootRef.child("slot1200_1230");
        slot8 = rootRef.child("slot1230_0100");

        FirebaseRecyclerOptions<Users> options = new FirebaseRecyclerOptions.Builder<Users>()
                .setQuery(slot1,Users.class).build();
        FirebaseRecyclerOptions<Users> options2 = new FirebaseRecyclerOptions.Builder<Users>()
                .setQuery(slot2,Users.class).build();
        FirebaseRecyclerOptions<Users> options3 = new FirebaseRecyclerOptions.Builder<Users>()
                .setQuery(slot3,Users.class).build();
        FirebaseRecyclerOptions<Users> options4 = new FirebaseRecyclerOptions.Builder<Users>()
                .setQuery(slot4,Users.class).build();
        FirebaseRecyclerOptions<Users> options5 = new FirebaseRecyclerOptions.Builder<Users>()
                .setQuery(slot5,Users.class).build();
        FirebaseRecyclerOptions<Users> options6 = new FirebaseRecyclerOptions.Builder<Users>()
                .setQuery(slot6,Users.class).build();
        FirebaseRecyclerOptions<Users> options7 = new FirebaseRecyclerOptions.Builder<Users>()
                .setQuery(slot7,Users.class).build();
        FirebaseRecyclerOptions<Users> options8 = new FirebaseRecyclerOptions.Builder<Users>()
                .setQuery(slot8,Users.class).build();

        adapter = new MyAdapter(options, slot1);
        adapter2 = new MyAdapter(options2, slot2);
        adapter3 = new MyAdapter(options3, slot3);
        adapter4 = new MyAdapter(options4, slot4);
        adapter5 = new MyAdapter(options5, slot5);
        adapter6 = new MyAdapter(options6, slot6);
        adapter7 = new MyAdapter(options7, slot7);
        adapter8 = new MyAdapter(options8, slot8);

        rV1.setAdapter(adapter);
        rV2.setAdapter(adapter2);
        rV3.setAdapter(adapter3);
        rV4.setAdapter(adapter4);
        rV5.setAdapter(adapter5);
        rV6.setAdapter(adapter6);
        rV7.setAdapter(adapter7);
        rV8.setAdapter(adapter8);

    }
}