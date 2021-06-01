package com.example.molowsapp.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.molowsapp.ChatActivity;
import com.example.molowsapp.R;
import com.example.molowsapp.models.ModelUser;
import com.squareup.picasso.Picasso;

import java.util.HashMap;
import java.util.List;

public class AdapterChatlist extends RecyclerView.Adapter<AdapterChatlist.MyHolder>{

    Context context;
    List<ModelUser> usersList; //get user info
    private HashMap<String, String> lastMessageMap;

    public AdapterChatlist(Context context, List<ModelUser> usersList) {
        this.context = context;
        this.usersList = usersList;
        lastMessageMap = new HashMap<>();
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        //inflate layout row_chatlist.xml
        View view = LayoutInflater.from(context).inflate(R.layout.row_chatlist, viewGroup, false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder myHolder, int i) {
        //get data
        String hisUid = usersList.get(i).getUid();
        String userImage = usersList.get(i).getImagen();
        String userName = usersList.get(i).getNombre();
        String lastMessage = lastMessageMap.get(hisUid);

        //set data
        myHolder.nameTv.setText(userName);
        if (lastMessage == null || lastMessage.equals("default")){
            myHolder.lastMessage.setVisibility(View.GONE);
        }
        else{
            myHolder.lastMessage.setVisibility(View.VISIBLE);
            myHolder.lastMessage.setText(lastMessage);
        }
        try{
            Picasso.get().load(userImage).placeholder(R.drawable.ic_default_img).into(myHolder.profileIv);
        }
        catch (Exception e){
            Picasso.get().load(R.drawable.ic_default_img).into(myHolder.profileIv);
        }
        //set online status of other user in chat
       if (usersList.get(i).getOnlineStatus().equals("online")){
           //online
           myHolder.onlineStatusIv.setImageResource(R.drawable.circle_online);
       }
       else{
           //offline
           myHolder.onlineStatusIv.setImageResource(R.drawable.circle_offline);
       }

       //handle click of the user in chat
        myHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //start chat activity with that user
                Intent intent = new Intent(context, ChatActivity.class);
                intent.putExtra("hisUis", hisUid);
                context.startActivity(intent);
            }
        });

    }

    public void setLastMessageMap(String userId, String lastMessage){
        lastMessageMap.put(userId, lastMessage);
    }

    @Override
    public int getItemCount() {
        return usersList.size(); // size of the list
    }


    class MyHolder extends RecyclerView.ViewHolder{
        //views of row_chatlist.xml
        ImageView profileIv, onlineStatusIv;
        TextView nameTv, lastMessage;


        public MyHolder(@NonNull View itemView) {
            super(itemView);

            //init views
            profileIv = itemView.findViewById(R.id.profileIv);
            onlineStatusIv = itemView.findViewById(R.id.onlineStatusIv);
            nameTv = itemView.findViewById(R.id.nameTv);
            lastMessage = itemView.findViewById(R.id.lastMessageTv);
        }
    }

}