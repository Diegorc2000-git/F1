package com.example.molowsapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.molowsapp.adapters.AdapterGroupChat;
import com.example.molowsapp.adapters.AdapterGroupChatList;
import com.example.molowsapp.models.ModelGroupChat;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.HashMap;

public class GroupChatActivity extends AppCompatActivity {

    private FirebaseAuth firebaseAuth;

    private String groupId;

    private Toolbar toolbar;
    private ImageView groupeIconIv;
    private ImageButton senBtn;
    private TextView groupeTitleTv;
    private EditText messageEt;
    private RecyclerView chatRv;

    private ArrayList<ModelGroupChat> groupChatList;
    private AdapterGroupChat adapterGroupChat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group_chat);

        //init views
        toolbar = findViewById(R.id.toolbar);
        groupeIconIv = findViewById(R.id.groupeIconIv);
        groupeTitleTv = findViewById(R.id.groupeTitleTv);
        messageEt = findViewById(R.id.messageEt2);
        senBtn = findViewById(R.id.senBtn);
        chatRv = findViewById(R.id.chatRv);

        //get id of the group
        Intent intent = getIntent();
        groupId = intent.getStringExtra("groupId");

        firebaseAuth = FirebaseAuth.getInstance();
        loadGroupInfo();
        loadGroupMessage();


        senBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //input data
                String message = messageEt.getText().toString().trim();
                //validate
                if (TextUtils.isEmpty(message)){
                    //empty don't send
                    Toast.makeText(GroupChatActivity.this, "Can't send empty message", Toast.LENGTH_SHORT).show();
                }else{
                    //send message
                    sendMessage(message);
                }
            }
        });

    }

    private void loadGroupMessage() {
        //init list
        groupChatList = new ArrayList<>();

        DatabaseReference ref = FirebaseDatabase.getInstance().getReference("Groups");
        ref.child(groupId).child("Messages")
                .addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        groupChatList.clear();
                        for (DataSnapshot ds: snapshot.getChildren()){
                            ModelGroupChat model = ds.getValue(ModelGroupChat.class);
                            groupChatList.add(model);
                        }
                        //adapter
                        adapterGroupChat = new AdapterGroupChat(GroupChatActivity.this, groupChatList);
                        //set to recycler
                        chatRv.setAdapter(adapterGroupChat);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });

    }

    private void sendMessage(String message) {

        //timestamp
        String timestamp = ""+System.currentTimeMillis();

        //set up message data
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("sender", "" + firebaseAuth.getUid());
        hashMap.put("message", "" + message);
        hashMap.put("timestamp", "" + timestamp);
        hashMap.put("type", "" + "text"); //text image file

        //add in db
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference("Groups");
        ref.child(groupId).child("Messages").child(timestamp)
                .setValue(hashMap)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        //message sent
                        //clear messageEt
                        messageEt.setText("");
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        //message send failed
                        Toast.makeText(GroupChatActivity.this, ""+e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });

    }

    private void loadGroupInfo() {
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference("Groups");
        ref.orderByChild("groupId").equalTo(groupId)
                .addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        for (DataSnapshot ds: snapshot.getChildren()){
                            String groupTitle = ""+ds.child("groupTitle").getValue();
                            String groupDescription = ""+ds.child("groupDescription").getValue();
                            String groupIcon = ""+ds.child("groupIcon").getValue();
                            String timestamp = ""+ds.child("timestamp").getValue();
                            String createdBy = ""+ds.child("createdBy").getValue();

                            groupeTitleTv.setText(groupTitle);
                            try{
                                Picasso.get().load(groupIcon).placeholder(R.drawable.ic_group_white).into(groupeIconIv);
                            }catch (Exception e) {
                                groupeIconIv.setImageResource(R.drawable.ic_group_white);
                            }
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
    }
}