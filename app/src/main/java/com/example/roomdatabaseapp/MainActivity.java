package com.example.roomdatabaseapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.room.Room;

import android.os.Bundle;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {

    public static FragmentManager fragmentManager;

    public static MyAppDatabase myAppDatabase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager = getSupportFragmentManager();

        myAppDatabase = Room.databaseBuilder(getApplicationContext(), MyAppDatabase.class, "userdb").allowMainThreadQueries().build();

        if (findViewById(R.id.frame_container)!= null)
        {
            if (savedInstanceState!=null){
                return;
            }
        }

       fragmentManager.beginTransaction().add(R.id.frame_container, new HomeFragment()).commit();

    }
}
