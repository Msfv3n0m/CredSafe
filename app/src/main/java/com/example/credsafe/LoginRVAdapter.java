package com.example.credsafe;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class LoginRVAdapter extends RecyclerView.Adapter<LoginRVAdapter.ViewHolder> {

    // variable for our array list and context
    private ArrayList<LoginModal> loginModalArrayList;
    private Context context;

    // constructor
    public LoginRVAdapter(ArrayList<LoginModal> loginModalArrayList, Context context) {
        this.loginModalArrayList = loginModalArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // on below line we are inflating our layout
        // file for our recycler view items.
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.login_rv_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // on below line we are setting data
        // to our views of recycler view item.
        LoginModal modal = loginModalArrayList.get(position);
        holder.siteNameTV.setText("Website: " + modal.getsiteName());
        holder.usernameTV.setText("Username: " + modal.getUsername());
        holder.passwordTV.setText("Password: " + modal.getPassword());
    }

    @Override
    public int getItemCount() {
        // returning the size of our array list
        return loginModalArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        // creating variables for our text views.
        private TextView siteNameTV, usernameTV, passwordTV;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            // initializing our text views
            siteNameTV = itemView.findViewById(R.id.idTVSiteName);
            usernameTV = itemView.findViewById(R.id.idTVUsername);
            passwordTV = itemView.findViewById(R.id.idTVPassword);
        }
    }
}
