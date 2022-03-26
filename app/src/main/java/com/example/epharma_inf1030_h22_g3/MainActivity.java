package com.example.epharma_inf1030_h22_g3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.example.epharma_inf1030_h22_g3.databinding.ActivityMainBinding;
import com.example.epharma_inf1030_h22_g3.tab.LoginFragment;
import com.example.epharma_inf1030_h22_g3.tab.RegisterFragment;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binder = DataBindingUtil.setContentView(this, R.layout.activity_main);
        setContentView(binder.getRoot());
        binder.appMenu.setOnItemReselectedListener(this::menuClicked);
    }

    private boolean menuClicked(MenuItem menuItem){
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        switch (menuItem.getItemId()){
            case R.id.menu_profile:
                LoginFragment lf = new LoginFragment();
                transaction.replace(R.id.flFragment, lf, "Login");
                transaction.commit();
                break;

            case R.id.menu_home:
                RegisterFragment rf = new RegisterFragment();
                transaction.replace(R.id.flFragment, rf, "Register");
                transaction.commit();
                break;
        }
        return false;
    }
}