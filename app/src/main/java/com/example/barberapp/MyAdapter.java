package com.example.barberapp;

import android.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Objects;

public class MyAdapter extends FirebaseRecyclerAdapter<Users,MyAdapter.MyViewHolder>{

    @Nullable
    private final DatabaseReference time_slot;

    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     */

    public MyAdapter(@NonNull FirebaseRecyclerOptions<Users> options, @Nullable DatabaseReference time_slot) {
        super(options);
        this.time_slot = time_slot;
    }

    @Override
    protected void onBindViewHolder(@NonNull MyViewHolder holder, int position, @NonNull Users model) {
        holder.mail.setText(model.getName());
        holder.email.setText(model.getMail());
        holder.phone.setText(model.getPhone());
        holder.mail.setOnClickListener(view -> {
            int v = (holder.email.getVisibility() == View.GONE)?View.VISIBLE:View.GONE;
            int v1 = (holder.phone.getVisibility() == View.GONE)?View.VISIBLE:View.GONE;
            int v2 = (holder.tickCross.getVisibility() == View.GONE)?View.VISIBLE:View.GONE;
            holder.email.setVisibility(v);
            holder.phone.setVisibility(v1);
            holder.tickCross.setVisibility(v2);
        });
        holder.tickCross.setOnClickListener(view -> {
            // Deleting request
            AlertDialog.Builder builder = new AlertDialog.Builder(holder.mail.getContext());
            if(!holder.tick){
                builder.setTitle("Are you sure?");
                builder.setMessage("This action can't be undone");

                builder.setPositiveButton("Delete", (dialogInterface, i) -> {
                    String s = time_slot+"";
                    // Strings are immutable that's why new string is created
                    String n = s.substring(52);
                    FirebaseDatabase.getInstance().getReference().child(n)
                            .child(Objects.requireNonNull(getRef(holder.getAdapterPosition()).getKey())).removeValue();
                });

                builder.setNegativeButton("Cancel", (dialogInterface, i) -> {
                    holder.tick = false;
                    holder.tickCross.setImageDrawable(holder.tickToCross);
                    Toast.makeText(holder.mail.getContext(), "Cancelled", Toast.LENGTH_SHORT).show();
                });
            }
            else{
                builder.setTitle("Confirmation");
                builder.setMessage("Confirm " + model.getName() + "'s booking? ");
                builder.setPositiveButton("Yes", (dialogInterface, i) -> {
                    String s = time_slot+"";
                    // Strings are immutable that's why new string is created
                    String n = s.substring(52) + "confirm";
                    FirebaseDatabase.getInstance().getReference().child(n).push().child("confirmed").setValue(model.getName());
                });

                builder.setNegativeButton("Cancel", (dialogInterface, i) -> {
                    holder.tick = true;
                    holder.tickCross.setImageDrawable(holder.crossToTick);
                    Toast.makeText(holder.mail.getContext(), "Cancelled", Toast.LENGTH_SHORT).show();
                });

            }
            builder.show();

            // Animation
            if (holder.tick) holder.drawable = holder.tickToCross;
            else holder.drawable = holder.crossToTick;
            holder.tickCross.setImageDrawable(holder.drawable);
            holder.drawable.start();
            holder.tick = !holder.tick;
        });
    }


    // Inflates the cards at barber side of the app
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.slot,parent,false);
        return new MyViewHolder(v);
    }

    static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView mail,email,phone;
        ImageView tickCross;
        AnimatedVectorDrawableCompat tickToCross,crossToTick,drawable;
        boolean tick = true;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tickCross = itemView.findViewById(R.id.tick_cross);
            mail = itemView.findViewById(R.id.slot1);
            email = itemView.findViewById(R.id.slot1_mail);
            phone = itemView.findViewById(R.id.slot1_phone);
            tickToCross = AnimatedVectorDrawableCompat.create(itemView.getContext(),
                    R.drawable.avd_tick_to_cross);
            crossToTick = AnimatedVectorDrawableCompat.create(itemView.getContext(), R.drawable.avd_cross_to_tick);
        }
    }
}