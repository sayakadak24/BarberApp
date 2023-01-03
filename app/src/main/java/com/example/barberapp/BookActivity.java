package com.example.barberapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Map;

public class BookActivity extends AppCompatActivity{

    CardView card1,card2,card3,card4,card5,card6,card7,card8;
    DatabaseReference rootRef,n1,n2,n3,n4,n5,n6,n7,n8,pU;
    ValueEventListener vEL1,vEL2,vEL3,vEL4,vEL5,vEL6,vEL7,vEL8;
    TextView name1,name2,name3,name4,name5,name6,name7,name8,pending1,pending2,pending3,pending4,pending5,pending6,pending7,pending8;
    String mail, name, phone, uid;
    Map<String,String> map;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);
        rootRef = FirebaseDatabase.getInstance().getReference();

        n1 = rootRef.child("slot0900_0930");
        n2 = rootRef.child("slot0930_1000");
        n3 = rootRef.child("slot1000_1030");
        n4 = rootRef.child("slot1030_1100");
        n5 = rootRef.child("slot1100_1130");
        n6 = rootRef.child("slot1130_1200");
        n7 = rootRef.child("slot1200_1230");
        n8 = rootRef.child("slot1230_0100");
        pU = rootRef.child("Pending Users");
        pending1 = findViewById(R.id.pending1);
        pending2 = findViewById(R.id.pending2);
        pending3 = findViewById(R.id.pending3);
        pending4 = findViewById(R.id.pending4);
        pending5 = findViewById(R.id.pending5);
        pending6 = findViewById(R.id.pending6);
        pending7 = findViewById(R.id.pending7);
        pending8 = findViewById(R.id.pending8);
        card1 = findViewById(R.id.card1);
        card2 = findViewById(R.id.card2);
        card3 = findViewById(R.id.card3);
        card4 = findViewById(R.id.card4);
        card5 = findViewById(R.id.card5);
        card6 = findViewById(R.id.card6);
        card7 = findViewById(R.id.card7);
        card8 = findViewById(R.id.card8);
        name1 = findViewById(R.id.name1);
        name2 = findViewById(R.id.name2);
        name3 = findViewById(R.id.name3);
        name4 = findViewById(R.id.name4);
        name5 = findViewById(R.id.name5);
        name6 = findViewById(R.id.name6);
        name7 = findViewById(R.id.name7);
        name8 = findViewById(R.id.name8);
        uid = getIntent().getStringExtra("uid");

        map = new HashMap<>();
        map.put("status", "Pending");
        rootRef.child("Users").orderByChild("uid").equalTo(uid).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot snapshot1: snapshot.getChildren()){
                    Users user = snapshot1.getValue(Users.class);
                    name = user.getName();
                    mail = user.getMail();
                    phone = user.getPhone();
                    uid = user.getUid();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        n1.orderByChild("status").equalTo("Confirmed").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    int v = (name1.getVisibility() == View.GONE)?View.VISIBLE:View.GONE;
                    card1.setCardBackgroundColor(ContextCompat.getColor(card1.getContext(), R.color.teal_200));
                    for(DataSnapshot snapshot1: snapshot.getChildren()){
                        Users user = snapshot1.getValue(Users.class);
                        name = user.getName();
                        name1.setVisibility(v);
                        name1.setText(name);
                    }

                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        n2.orderByChild("status").equalTo("Confirmed").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    int v = (name2.getVisibility() == View.GONE)?View.VISIBLE:View.GONE;
                    card2.setCardBackgroundColor(ContextCompat.getColor(card2.getContext(), R.color.teal_200));
                    for(DataSnapshot snapshot1: snapshot.getChildren()){
                        Users user = snapshot1.getValue(Users.class);
                        name = user.getName();
                        name2.setVisibility(v);
                        name2.setText(name);
                    }

                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        n3.orderByChild("status").equalTo("Confirmed").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    int v = (name3.getVisibility() == View.GONE)?View.VISIBLE:View.GONE;
                    card3.setCardBackgroundColor(ContextCompat.getColor(card3.getContext(), R.color.teal_200));
                    for(DataSnapshot snapshot1: snapshot.getChildren()){
                        Users user = snapshot1.getValue(Users.class);
                        name = user.getName();
                        name3.setVisibility(v);
                        name3.setText(name);
                    }

                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        n4.orderByChild("status").equalTo("Confirmed").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    int v = (name4.getVisibility() == View.GONE)?View.VISIBLE:View.GONE;
                    card4.setCardBackgroundColor(ContextCompat.getColor(card4.getContext(), R.color.teal_200));
                    for(DataSnapshot snapshot1: snapshot.getChildren()){
                        Users user = snapshot1.getValue(Users.class);
                        name = user.getName();
                        name4.setVisibility(v);
                        name4.setText(name);
                    }

                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        n5.orderByChild("status").equalTo("Confirmed").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    int v = (name5.getVisibility() == View.GONE)?View.VISIBLE:View.GONE;
                    card5.setCardBackgroundColor(ContextCompat.getColor(card5.getContext(), R.color.teal_200));
                    for(DataSnapshot snapshot1: snapshot.getChildren()){
                        Users user = snapshot1.getValue(Users.class);
                        name = user.getName();
                        name5.setVisibility(v);
                        name5.setText(name);
                    }

                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        n6.orderByChild("status").equalTo("Confirmed").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    int v = (name6.getVisibility() == View.GONE)?View.VISIBLE:View.GONE;
                    card6.setCardBackgroundColor(ContextCompat.getColor(card6.getContext(), R.color.teal_200));
                    for(DataSnapshot snapshot1: snapshot.getChildren()){
                        Users user = snapshot1.getValue(Users.class);
                        name = user.getName();
                        name6.setVisibility(v);
                        name6.setText(name);
                    }

                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        n7.orderByChild("status").equalTo("Confirmed").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    int v = (name7.getVisibility() == View.GONE)?View.VISIBLE:View.GONE;
                    card7.setCardBackgroundColor(ContextCompat.getColor(card7.getContext(), R.color.teal_200));
                    for(DataSnapshot snapshot1: snapshot.getChildren()){
                        Users user = snapshot1.getValue(Users.class);
                        name = user.getName();
                        name7.setVisibility(v);
                        name7.setText(name);
                    }

                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        n8.orderByChild("status").equalTo("Confirmed").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    int v = (name8.getVisibility() == View.GONE)?View.VISIBLE:View.GONE;
                    card8.setCardBackgroundColor(ContextCompat.getColor(card8.getContext(), R.color.teal_200));
                    for(DataSnapshot snapshot1: snapshot.getChildren()){
                        Users user = snapshot1.getValue(Users.class);
                        name = user.getName();
                        name8.setVisibility(v);
                        name8.setText(name);
                    }

                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        vEL();

        n1.addListenerForSingleValueEvent(vEL1);
        n2.addListenerForSingleValueEvent(vEL2);
        n3.addListenerForSingleValueEvent(vEL3);
        n4.addListenerForSingleValueEvent(vEL4);
        n5.addListenerForSingleValueEvent(vEL5);
        n6.addListenerForSingleValueEvent(vEL6);
        n7.addListenerForSingleValueEvent(vEL7);
        n8.addListenerForSingleValueEvent(vEL8);

        card1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                map.put("name", name);
                map.put("mail", mail);
                map.put("phone", phone);
                map.put("uid", uid);
                n1.child(uid).setValue(map);
                n1.addListenerForSingleValueEvent(vEL1);
            }
        });
        card2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                map.put("name", name);
                map.put("mail", mail);
                map.put("phone", phone);
                map.put("uid", uid);
                n2.child(uid).setValue(map);
                n2.addListenerForSingleValueEvent(vEL2);
            }
        });
        card3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                map.put("name", name);
                map.put("mail", mail);
                map.put("phone", phone);
                map.put("uid", uid);
                n3.child(uid).setValue(map);
                n3.addListenerForSingleValueEvent(vEL3);
            }
        });
        card4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                map.put("name", name);
                map.put("mail", mail);
                map.put("phone", phone);
                map.put("uid", uid);
                n4.child(uid).setValue(map);
                n4.addListenerForSingleValueEvent(vEL4);
            }
        });
        card5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                map.put("name", name);
                map.put("mail", mail);
                map.put("phone", phone);
                map.put("uid", uid);
                n5.child(uid).setValue(map);
                n5.addListenerForSingleValueEvent(vEL5);
            }
        });
        card6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                map.put("name", name);
                map.put("mail", mail);
                map.put("phone", phone);
                map.put("uid", uid);
                n6.child(uid).setValue(map);
                n6.addListenerForSingleValueEvent(vEL6);
            }
        });
        card7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                map.put("name", name);
                map.put("mail", mail);
                map.put("phone", phone);
                map.put("uid", uid);
                n7.child(uid).setValue(map);
                n7.addListenerForSingleValueEvent(vEL7);
            }
        });
        card8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                map.put("name", name);
                map.put("mail", mail);
                map.put("phone", phone);
                map.put("uid", uid);
                n8.child(uid).setValue(map);
                n8.addListenerForSingleValueEvent(vEL8);
            }
        });
    }

    private void vEL() {
        vEL1 = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                long count = dataSnapshot.getChildrenCount();
                pending1.setText(count+ " pending");

            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {}
        };
        vEL2 = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                long count = dataSnapshot.getChildrenCount();
                pending2.setText(count+ " pending");
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {}
        };
        vEL3 = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                long count = dataSnapshot.getChildrenCount();
                pending3.setText(count+ " pending");
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {}
        };
        vEL4 = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                long count = dataSnapshot.getChildrenCount();
                pending4.setText(count+ " pending");
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {}
        };
        vEL5 = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                long count = dataSnapshot.getChildrenCount();
               pending5.setText(count+ " pending");
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {}
        };
        vEL6 = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                long count = dataSnapshot.getChildrenCount();
                pending6.setText(count+ " pending");
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {}
        };
        vEL7 = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
               long count = dataSnapshot.getChildrenCount();
               pending7.setText(count+ " pending");
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {}
        };

        vEL8 = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                long count = dataSnapshot.getChildrenCount();
                pending8.setText(count+ " pending");
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {}
        };
    }

}