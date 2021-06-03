package com.example.molowsapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.PopupMenu;

import com.example.molowsapp.fragments.ChatListFragment;
import com.example.molowsapp.fragments.GroupChatsFragment;
import com.example.molowsapp.fragments.HomeFragment;
import com.example.molowsapp.fragments.ProfileFragment;
import com.example.molowsapp.fragments.UsersFragment;
import com.example.molowsapp.notifications.Token;
import com.example.molowsapp.teams.CochesActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
//import com.google.firebase.iid.FirebaseInstanceId;

public class DashboardActivity extends AppCompatActivity {

    //firebase auth
    FirebaseAuth firebaseAuth;

    ActionBar actionBar;

    String mUID;

    private BottomNavigationView navigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        //ActionBar and its title
        actionBar = getSupportActionBar();
        actionBar.setTitle("Profile");

        //init
        firebaseAuth = FirebaseAuth.getInstance();

        //botom navigation
        navigationView = findViewById(R.id.navigation);
        navigationView.setOnNavigationItemSelectedListener(selectedListener);

        //home fragment transaction(default, on start)
        actionBar.setTitle("Home");//change actionbar title
        HomeFragment fragment1 = new HomeFragment();
        FragmentTransaction ft1 = getSupportFragmentManager().beginTransaction();
        ft1.replace(R.id.content, fragment1, "");
        ft1.commit();

        checkUserStatus();


    }

    @Override
    protected void onResume() {
        checkUserStatus();
        super.onResume();
    }

    public void updateToken(String token){
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference("Tokens");
        Token mToken = new Token(token);
        ref.child(mUID).setValue(mToken);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener selectedListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                    //handle item clicks
                    switch (menuItem.getItemId()){
                        case R.id.nav_home:
                            //home fragment transaction
                            actionBar.setTitle("Home");//change actionbar title
                            HomeFragment fragment1 = new HomeFragment();
                            FragmentTransaction ft1 = getSupportFragmentManager().beginTransaction();
                            ft1.replace(R.id.content, fragment1, "");
                            ft1.commit();
                            return true;
                        case R.id.nav_profile:
                            //profile fragment transation
                            actionBar.setTitle("Profile");//change actionbar title
                            ProfileFragment fragment2 = new ProfileFragment();
                            FragmentTransaction ft2 = getSupportFragmentManager().beginTransaction();
                            ft2.replace(R.id.content, fragment2, "");
                            ft2.commit();
                            return true;
                        case R.id.nav_users:
                            //users fragment transaction
                            actionBar.setTitle("Users");//change actionbar title
                            UsersFragment fragment3 = new UsersFragment();
                            FragmentTransaction ft3 = getSupportFragmentManager().beginTransaction();
                            ft3.replace(R.id.content, fragment3, "");
                            ft3.commit();
                            return true;
                        case R.id.nav_info:
                            //users fragment transaction
                            actionBar.setTitle("Information");//change actionbar title
                            startActivity(new Intent(DashboardActivity.this, CochesActivity.class));
                            return true;
                        case R.id.nav_more:
                            showMoreOptions();
                            return true;
                    }

                    return false;
                }
            };

    private void showMoreOptions() {
        //popup menu to show more options
        PopupMenu popupMenu = new PopupMenu(this, navigationView, Gravity.END);
        //items to show in menu
        popupMenu.getMenu().add(Menu.NONE, 0, 0, "Chat");
        popupMenu.getMenu().add(Menu.NONE, 1, 0, "Group Chats");

        //menu clicks
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                int id = item.getItemId();
                if (id == 0) {
                    //Chat fragment transaction
                    actionBar.setTitle("Chat");//change actionbar title
                    ChatListFragment fragment4 = new ChatListFragment();
                    FragmentTransaction ft4 = getSupportFragmentManager().beginTransaction();
                    ft4.replace(R.id.content, fragment4, "");
                    ft4.commit();
                }
                else if (id == 1){
                    //Group Chats fragment transaction
                    actionBar.setTitle("Group Chats");//change actionbar title
                    GroupChatsFragment fragment5 = new GroupChatsFragment();
                    FragmentTransaction ft5 = getSupportFragmentManager().beginTransaction();
                    ft5.replace(R.id.content, fragment5, "");
                    ft5.commit();
                }
                return false;
            }
        });
        popupMenu.show();
    }

    private void checkUserStatus(){
        //get current user
        FirebaseUser user = firebaseAuth.getCurrentUser();
        if (user != null){
            //user is signed in stay here
            //mProfileTv.setText(user.getEmail());
            mUID = user.getUid();

            //save uid of currently signed in user shared preferences
            SharedPreferences sp = getSharedPreferences("SP_USER", MODE_PRIVATE);
            SharedPreferences.Editor editor = sp.edit();
            editor.putString("Current_USERID", mUID);
            editor.apply();

            //update token
            //updateToken(FirebaseInstanceId.getInstance().getToken());
        }
        else{
            //user not signed in, go to main Activity
            startActivity(new Intent(DashboardActivity.this, MainActivity.class));
            finish();
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    @Override
    protected void onStart() {
        //check on start of app
        checkUserStatus();
        super.onStart();
    }

}