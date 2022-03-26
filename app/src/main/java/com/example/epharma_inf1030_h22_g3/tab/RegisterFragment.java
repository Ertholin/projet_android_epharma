package com.example.epharma_inf1030_h22_g3.tab;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.epharma_inf1030_h22_g3.R;
import com.example.epharma_inf1030_h22_g3.databinding.FragmentLoginBinding;


public class RegisterFragment extends Fragment {

    private FragmentLoginBinding binder;
    private EditText email, password;
    private Button register_button;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_register, container, false);

        email = view.findViewById(R.id.email);
        password = view.findViewById(R.id.password);
        register_button = view.findViewById(R.id.register_button);

        register_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        return view;
    }
}