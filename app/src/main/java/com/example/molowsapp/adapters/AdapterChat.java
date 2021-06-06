package com.example.molowsapp.adapters;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.molowsapp.R;
import com.example.molowsapp.models.ModelChat;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

public class AdapterChat extends RecyclerView.Adapter<AdapterChat.MyHolder> {

    private static final int MSG_TYPE_LEFT = 0;
    private static final int MSG_TYPE_RIGHT = 1;
    Context context;
    List<ModelChat> chatList;
    String imageUrl;

    FirebaseUser fUser;

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        if (i == MSG_TYPE_RIGHT){
            View view = LayoutInflater.from(context).inflate(R.layout.row_chat_right, viewGroup, false);
            return  new MyHolder(view);
        }
        else{
            View view = LayoutInflater.from(context).inflate(R.layout.row_chat_left, viewGroup, false);
            return  new MyHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder myHolder, int i) {
        String message = chatList.get(i).getMensaje();
        String timeStamp = chatList.get(i).getTimestamp();

        //Convertimos el tiempo a dd/MM/yyyy hh:mm am/pm
        Calendar cal = Calendar.getInstance(Locale.ENGLISH);
        cal.setTimeInMillis(Long.parseLong(timeStamp));
        String dateTime = DateFormat.format("dd/MM/yyyy hh:mm aa", cal).toString();

        myHolder.messageTv.setText(message);
        myHolder.timeTv.setText(dateTime);
        try{
            Picasso.get().load(imageUrl).into(myHolder.profileIv);
        }
        catch (Exception e){

        }

        myHolder.messageLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("Delete");
                builder.setMessage("Are you sure to delete this message");
                builder.setPositiveButton("Delete", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        deleteMessage(i);
                    }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                builder.create().show();
            }
        });

        if (i==chatList.size()-1){
            if (chatList.get(i).isSeen()){
                myHolder.isSeenTv.setText("seen");
            }
            else{
                myHolder.isSeenTv.setText("delivered");
            }
        }else{
            myHolder.isSeenTv.setVisibility(View.GONE);
        }
    }

    private void deleteMessage(int position) {
        String myUID = FirebaseAuth.getInstance().getCurrentUser().getUid();

        String msgTimeStamp = chatList.get(position).getTimestamp();
        DatabaseReference dbRef = FirebaseDatabase.getInstance().getReference("Chats");
        Query query = dbRef.orderByChild("timestamp").equalTo(msgTimeStamp);
        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot ds: dataSnapshot.getChildren()) {

                    if (ds.child("enviado").getValue().equals(myUID)){
                        /*Podemos hacer dos formas para borrar el mensaje,
                            1)Borrar el mensaje del chat
                            2)Asignar el valor del mensaje a  "This message was delete..."

                        1) borrar el mensaje del chat*/
                        //ds.getRef().removeValue();

                        //2)Asignar el valor del mensaje a  "This message was delete..."
                        HashMap<String, Object> hashMap = new HashMap<>();
                        hashMap.put("mensaje", "This message was delete...");
                        ds.getRef().updateChildren(hashMap);

                        Toast.makeText(context, "message delete...", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Toast.makeText(context, "You can only delete your message...", Toast.LENGTH_SHORT).show();
                    }

                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }

    @Override
    public int getItemCount() {
        return chatList.size();
    }

    @Override
    public int getItemViewType(int position) {
        fUser = FirebaseAuth.getInstance().getCurrentUser();
        if (chatList.get(position).getEnviado().equals(fUser.getUid())){
            return MSG_TYPE_RIGHT;
        }
        else{
            return  MSG_TYPE_LEFT;
        }
    }

    public AdapterChat(Context context, List<ModelChat> chatList, String imageUrl) {
        this.context = context;
        this.chatList = chatList;
        this.imageUrl = imageUrl;
    }

    class MyHolder extends RecyclerView.ViewHolder{

        ImageView profileIv;
        TextView messageTv, timeTv, isSeenTv;
        LinearLayout messageLayout;

        public MyHolder(@NonNull View itemView) {
            super(itemView);

            profileIv = itemView.findViewById(R.id.profileIv);
            messageTv = itemView.findViewById(R.id.messageTv);
            timeTv = itemView.findViewById(R.id.timeTv);
            isSeenTv = itemView.findViewById(R.id.isSeentTv);
            messageLayout = itemView.findViewById(R.id.messageLayout);

        }
    }
}
