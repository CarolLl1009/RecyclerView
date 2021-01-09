package com.example.recyclerview;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.recyclerview.databinding.FragmentFirstBinding;

import java.util.ArrayList;
import java.util.List;

public class FirstFragment extends Fragment {

    private FragmentFirstBinding mBinding;
    private List<String> dataList = new ArrayList<>();

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        mBinding = FragmentFirstBinding.inflate(inflater, container, false);
        return mBinding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        WordAdapter adapter = new WordAdapter(setData());
        mBinding.recyclerView.setAdapter(adapter);
        mBinding.recyclerView.setLayoutManager( new LinearLayoutManager(getContext()));
        mBinding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //añado una palabra al listado
                dataList.add("PALABRA :" + dataList.size());
                //Notificar al adaptador que insertamos datos
                mBinding.recyclerView.getAdapter().notifyItemInserted(dataList.size());
                //Scroll al final de la lista
                mBinding.recyclerView.smoothScrollToPosition(dataList.size());

            }
        });

    }

    private List<String> setData() {
        for (int i= 0; i < 100; i++) {
            dataList.add("PALABRA : " + i);
        }
        return dataList;
    }
}