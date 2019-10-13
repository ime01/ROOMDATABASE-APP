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
public class UpdateFragment extends Fragment {
    private EditText updaateUserId, updaateUserName, updaateUserEmail;

    private Button saveUpdateButton;


    public UpdateFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_update, container, false);

        updaateUserId = view.findViewById(R.id.txt_updated_user_id);
        updaateUserName = view.findViewById(R.id.txt_updated_user_name);
        updaateUserEmail = view.findViewById(R.id.txt_updated_user_email);
        saveUpdateButton = view.findViewById(R.id.save_updated_info);

        saveUpdateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id = Integer.parseInt(updaateUserId.getText().toString());
                String name = updaateUserName.getText().toString();
                String email = updaateUserEmail.getText().toString();

                User user = new User();
                user.setId(id);
                user.setName(name);
                user.setEmail(email);

                MainActivity.myAppDatabase.myDao().updateUser(user);
                Toast.makeText(getActivity(), "User Updated", Toast.LENGTH_SHORT).show();

                updaateUserId.setText("");
                updaateUserName.setText("");
                updaateUserEmail.setText("");
            }
        });




        return view;
    }

}
