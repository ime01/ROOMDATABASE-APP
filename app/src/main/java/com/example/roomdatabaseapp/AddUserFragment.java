package com.example.roomdatabaseapp;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class AddUserFragment extends Fragment {

    private EditText userId, userName, userEmail;

    private Button saveButton;


    public AddUserFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add_user, container, false);

        userId = view.findViewById(R.id.txt_user_id);
        userName = view.findViewById(R.id.txt_user_name);
        userEmail = view.findViewById(R.id.txt_user_email);
        saveButton = view.findViewById(R.id.save);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int userid = Integer.parseInt(userId.getText().toString());
                String username = userName.getText().toString();
                String useremail = userEmail.getText().toString();

                User user = new User();
                user.setId(userid);
                user.setName(username);
                user.setEmail(useremail);

                MainActivity.myAppDatabase.myDao().addUser(user);

                Toast.makeText(getActivity(), "User addedd successfully,", Toast.LENGTH_SHORT).show();

                userId.setText("");
                userName.setText("");
                userEmail.setText("");

            }
        });



        return view;
    }

}
