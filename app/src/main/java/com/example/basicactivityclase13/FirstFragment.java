package com.example.basicactivityclase13;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.basicactivityclase13.databinding.FragmentFirstBinding;

import java.util.ArrayList;
import java.util.List;

public class FirstFragment extends Fragment {

    private FragmentFirstBinding mBinding;
    private  List<String> listado = new ArrayList<>();
    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
       mBinding = FragmentFirstBinding.inflate(inflater,container, false);
       return mBinding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Instanciamos el Adapter y le pasamos el listado de datos
        WordsAdapter mAdapter = new WordsAdapter(wordList());
        // le pasamos el adapter a nuestro Recycler View
        mBinding.rv.setAdapter(mAdapter);
        // Le indicamos al Recycler View como mostrar los elementos
        mBinding.rv.setLayoutManager(new LinearLayoutManager(getContext()));

        mBinding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // añadir palabra a listado
                listado.add("Palabra  " + listado.size());
                // notiificamos al adapter que la data cambió
                mBinding.rv.getAdapter().notifyItemInserted(listado.size());
                // Scroll al final
                mBinding.rv.smoothScrollToPosition(listado.size());
            }
        });
        }




    private List<String> wordList(){

        for (int i = 0; i < 100; i++) {
            listado.add("Palabra " + i);
        }
        return listado;
    }

}