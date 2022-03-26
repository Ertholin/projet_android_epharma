package com.example.epharma_inf1030_h22_g3.tab;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.epharma_inf1030_h22_g3.R;
import com.example.epharma_inf1030_h22_g3.databinding.FragmentLoginBinding;


public class LoginFragment extends Fragment {
    private FragmentLoginBinding binder;
    EditText email, password;
    Button login_button;


    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        binder = DataBindingUtil.inflate(inflater,
                R.layout.fragment_login,
                container, false);

        email = binder.email;
        password = binder.password;
        login_button = binder.loginButton;

        binder.arrowRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment = new LoginFragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.flFragment, fragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        return binder.getRoot();
    }
}