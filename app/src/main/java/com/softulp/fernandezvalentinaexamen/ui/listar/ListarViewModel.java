package com.softulp.fernandezvalentinaexamen.ui.listar;

import android.app.Application;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.softulp.fernandezvalentinaexamen.MainActivity;
import com.softulp.fernandezvalentinaexamen.modelos.Producto;

import java.util.Collections;
import java.util.Comparator;

public class ListarViewModel extends AndroidViewModel {

    private MutableLiveData<Boolean> listarProductosM;

    public ListarViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<Boolean> getListarProductosM() {
        if (listarProductosM == null){
            listarProductosM = new MutableLiveData<>();
        }
        return listarProductosM;
    }

    public void ordernarListaProductos(){
        if (!MainActivity.productosLista.isEmpty()){
            MainActivity.productosLista.sort((p1, p2) -> Double.compare(p2.getPrice(), p1.getPrice()));
            listarProductosM.setValue(true);
        } else {
            Toast.makeText(getApplication(), "Aún no se han cargado productos", Toast.LENGTH_SHORT).show();
            listarProductosM.setValue(false);
        }
    }
}