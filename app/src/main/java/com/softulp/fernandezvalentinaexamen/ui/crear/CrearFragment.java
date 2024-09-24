package com.softulp.fernandezvalentinaexamen.ui.crear;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.softulp.fernandezvalentinaexamen.databinding.FragmentCrearBinding;

public class CrearFragment extends Fragment {

    private FragmentCrearBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        CrearViewModel crearViewModel =
                new ViewModelProvider(this).get(CrearViewModel.class);

        binding = FragmentCrearBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        binding.btnAgregarProducto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String code = binding.etCode.getText().toString();
                String desc = binding.etDescription.getText().toString();
                String price = binding.etPrice.getText().toString();
                String stock = binding.etStock.getText().toString();
                crearViewModel.addNewProduct(code, desc, price, stock);
            }
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}