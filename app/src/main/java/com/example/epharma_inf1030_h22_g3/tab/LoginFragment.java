package com.example.epharma_inf1030_h22_g3.tab;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.epharma_inf1030_h22_g3.R;
import com.example.epharma_inf1030_h22_g3.databinding.FragmentLoginBinding;


public class LoginFragment extends Fragment {
    private FragmentLoginBinding binder;

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        binder = DataBindingUtil.inflate(inflater,
                R.layout.fragment_login,
                container, false);

        return binder.getRoot();
    }
}