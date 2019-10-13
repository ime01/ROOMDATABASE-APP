package com.example.roomdatabaseapp;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment implements View.OnClickListener {

    private Button addUser, viewUser, deleteUser, updateUser;



    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        addUser = view.findViewById(R.id.addUser);
        viewUser = view.findViewById(R.id.view_users);
        deleteUser = view.findViewById(R.id.delete_users);
        updateUser = view.findViewById(R.id.update_users);


        addUser.setOnClickListener(this);
        viewUser.setOnClickListener(this);
        deleteUser.setOnClickListener(this);
        updateUser.setOnClickListener(this);




        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.addUser:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.frame_container, new AddUserFragment()).
                        addToBackStack(null).commit();
                break;
            case R.id.view_users:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.frame_container, new ReadUserFragment()).
                        addToBackStack(null).commit();
                break;

            case R.id.delete_users:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.frame_container, new DeleteUserFragment()).
                        addToBackStack(null).commit();
                break;

            case R.id.update_users:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.frame_container, new UpdateFragment()).
                        addToBackStack(null).commit();
                break;


        }
    }
}
