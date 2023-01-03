package com.example.barberapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookActivity1 extends AppCompatActivity implements
        View.OnClickListener{
    private List<TextView> tvs;
    private static final int[] BUTTON_IDS = {
            R.id.b1,
            R.id.b2,
            R.id.b3,
            R.id.b4,
            R.id.b5,
            R.id.b6,
            R.id.b7,
            R.id.b8,
    };
    private static final int[] TEXT_IDS = {
            R.id.t1,
            R.id.t2,
            R.id.t3,
            R.id.t4,
            R.id.t5,
            R.id.t6,
            R.id.t7,
            R.id.t8,
    };
    Button cancel;
    DatabaseReference rootRef,n1,n2,n3,n4,n5,n6,n7,n8,pU;
    ValueEventListener vEL1,vEL2,vEL3,vEL4,vEL5,vEL6,vEL7,vEL8;
    String name;
    String phone;
    String uid;
    Map<String,Object> map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book1);

        rootRef = FirebaseDatabase.getInstance().getReference();

        pU = rootRef.child("Pending Users");
        n1 = rootRef.child("slot0900_0930");
        n2 = rootRef.child("slot0930_1000");
        n3 = rootRef.child("slot1000_1030");
        n4 = rootRef.child("slot1030_1100");
        n5 = rootRef.child("slot1100_1130");
        n6 = rootRef.child("slot1130_1200");
        n7 = rootRef.child("slot1200_1230");
        n8 = rootRef.child("slot1230_0100");
        cancel = findViewById(R.id.cancel);
        uid = getIntent().getStringExtra("mail");
        Button button1= findViewById(R.id.b1);

        List<Button> buttons = new ArrayList<>();
        for(int id : BUTTON_IDS) {
            Button button = (Button)findViewById(id);
            button.setOnClickListener(this);
            buttons.add(button);
        }

        tvs = new ArrayList<TextView>();
        for(int text_id : TEXT_IDS){
            TextView tv = findViewById(text_id);
            tvs.add(tv);
        }
        vEL();
        cancel.setEnabled(false);
        bDisable();

        pU.orderByChild("mail").equalTo(uid).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.getValue() == null){
                    bEnable();

                }else{
//                    Log.i("Rick", String.valueOf(snapshot.getValue()));
                    cancel.setEnabled(true);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    private void vEL() {
        vEL1 = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                n1.push().setValue(map);
                long count = dataSnapshot.getChildrenCount();
                tvs.get(0).setText(count+ " pending");

            }
            @Override
            public void onCancelled(DatabaseError databaseError) {}
        };
        n1.addListenerForSingleValueEvent(vEL1);
        vEL2 = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                n2.push().setValue(map);
                long count = dataSnapshot.getChildrenCount();
                tvs.get(1).setText(count+ " pending");
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {}
        };
        n2.addListenerForSingleValueEvent(vEL2);
        vEL3 = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                n3.push().setValue(map);
                long count = dataSnapshot.getChildrenCount();
                tvs.get(2).setText(count+ " pending");
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {}
        };
        n3.addListenerForSingleValueEvent(vEL3);
        vEL4 = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                n4.push().setValue(map);
                long count = dataSnapshot.getChildrenCount();
                tvs.get(3).setText(count+ " pending");
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {}
        };
        n4.addListenerForSingleValueEvent(vEL4);
        vEL5 = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                n5.push().setValue(map);
                long count = dataSnapshot.getChildrenCount();
                tvs.get(4).setText(count+ " pending");
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {}
        };
        n5.addListenerForSingleValueEvent(vEL5);
        vEL6 = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                n6.push().setValue(map);
                long count = dataSnapshot.getChildrenCount();
                tvs.get(5).setText(count+ " pending");
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {}
        };
        n6.addListenerForSingleValueEvent(vEL6);
        vEL7 = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                n7.push().setValue(map);
                long count = dataSnapshot.getChildrenCount();
                tvs.get(6).setText(count+ " pending");
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {}
        };
        n7.addListenerForSingleValueEvent(vEL7);
        vEL8 = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                n8.push().setValue(map);
                long count = dataSnapshot.getChildrenCount();
                tvs.get(7).setText(count+ " pending");
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {}
        };
        n8.addListenerForSingleValueEvent(vEL8);
    }

    @Override
    public void onClick(View view) {
        map = new HashMap<>();
        uid = getIntent().getStringExtra("mail");
        rootRef.child("Users").orderByChild("mail").equalTo(uid).addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                if(snapshot.exists()){
                    Users user = snapshot.getValue(Users.class);
                    assert user != null;
                    name = user.getName();
                    phone = user.getPhone();
                    map.put("name", name);
                    map.put("mail", uid);
                    map.put("phone", phone);
                }
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        pU.push().child("mail").setValue(uid);
        switch (view.getId()){
            case R.id.b1:
                n1.addListenerForSingleValueEvent(vEL1);
                bDisable();
                break;
            case R.id.b2:
                n2.addListenerForSingleValueEvent(vEL2);
                bDisable();
                break;
            case R.id.b3:
                n3.addListenerForSingleValueEvent(vEL3);
                bDisable();
                break;
            case R.id.b4:
                n4.addListenerForSingleValueEvent(vEL4);
                bDisable();
                break;
            case R.id.b5:
                n5.addListenerForSingleValueEvent(vEL5);
                bDisable();
                break;
            case R.id.b6:
                n6.addListenerForSingleValueEvent(vEL6);
                bDisable();
                break;
            case R.id.b7:
                n7.addListenerForSingleValueEvent(vEL7);
                bDisable();
                break;
            case R.id.b8:
                n8.addListenerForSingleValueEvent(vEL8);
                bDisable();
                break;
        }
    }

    private void bDisable() {
        for(int id : BUTTON_IDS) {
            Button button = (Button)findViewById(id);
            button.setEnabled(false);
        }
    }

    private void bEnable() {
        for(int id : BUTTON_IDS) {
            Button button = findViewById(id);
            button.setEnabled(true);
        }
    }
}