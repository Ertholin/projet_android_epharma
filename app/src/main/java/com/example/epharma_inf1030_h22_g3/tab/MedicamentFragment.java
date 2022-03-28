package com.example.epharma_inf1030_h22_g3.tab;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.epharma_inf1030_h22_g3.R;
import com.example.epharma_inf1030_h22_g3.databinding.FragmentItemListBinding;
import com.example.epharma_inf1030_h22_g3.tab.placeholder.PlaceholderContent;
import com.example.epharma_inf1030_h22_g3.viewmodels.MedicamentViewModel;

/**
 * A fragment representing a list of Items.
 */
public class MedicamentFragment extends Fragment {
    private MyMedicamentFragmentRecyclerViewAdapter adapter;
    private FragmentItemListBinding binder;
    private MedicamentViewModel model;


    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        binder = DataBindingUtil.inflate(inflater,
                R.layout.fragment_item_list,
                container,
                false);
        return binder.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view,
                              @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        adapter = new MyMedicamentFragmentRecyclerViewAdapter(getContext());
        binder.list.setAdapter(adapter);

        model = new ViewModelProvider(getActivity())
                .get(MedicamentViewModel.class);
        model.liveAll().observe(getViewLifecycleOwner(), list->{
            list.forEach(adapter::addItems);
        });

    }
}