package com.example.molowsapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.molowsapp.adapters.AdapterChat;
import com.example.molowsapp.adapters.AdapterUsers;
import com.example.molowsapp.models.ModelUser;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class PostLikedByActivity extends AppCompatActivity {

    String postId;

    private RecyclerView recyclerViewp;

    private List<ModelUser> userList;
    private AdapterUsers adapterUsers;

    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_liked_by);

        //actionbar
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Post liked by");
        //add back button
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);

        firebaseAuth = FirebaseAuth.getInstance();

        actionBar.setSubtitle(firebaseAuth.getCurrentUser().getEmail());

        recyclerViewp = findViewById(R.id.recyclerViewp);

        userList = new ArrayList<>();

        //get the post id
        Intent intent = getIntent();
        postId = intent.getStringExtra("postId");

        //get list of UID's of users who liked the post
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference("Likes");
        ref.child(postId).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                userList.clear();
                for (DataSnapshot ds: snapshot.getChildren()){
                    String hisUid = ""+ ds.getRef().getKey();

                    //get user info for each id
                    getUser(hisUid);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void getUser(String hisUid) {
        //get information for each user using uid
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference("Usuarios");
        ref.orderByChild("uid").equalTo(hisUid)
                .addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        for (DataSnapshot ds: snapshot.getChildren()){
                            ModelUser modelUser = ds.getValue(ModelUser.class);
                            userList.add(modelUser);
                        }

                        //set up Adapter
                        adapterUsers = new AdapterUsers(PostLikedByActivity.this, userList);
                        //set adapter to recycler
                        recyclerViewp.setAdapter(adapterUsers);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed(); //go to previous activity
        return super.onSupportNavigateUp();
    }
}