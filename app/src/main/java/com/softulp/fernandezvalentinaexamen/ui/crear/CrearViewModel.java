package com.softulp.fernandezvalentinaexamen.ui.crear;

import android.app.Application;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.softulp.fernandezvalentinaexamen.MainActivity;
import com.softulp.fernandezvalentinaexamen.modelos.Producto;

import java.util.List;

public class CrearViewModel extends AndroidViewModel {

    private List<Producto> productoList = MainActivity.productosLista;

    public CrearViewModel(@NonNull Application application) {
        super(application);
    }

    private boolean isInList(int code){
        for (Producto p: productoList){
            if (p.getCode() == code){
                return true;
            }
        }
        return false;
    }

    public void addNewProduct(String code, String desc, String price, String stock) {
        if (code.trim().isEmpty() || desc.trim().isEmpty() || price.trim().isEmpty() || stock.trim().isEmpty()) {
            Toast.makeText(getApplication(), "¡Debe llenar todos los campos!", Toast.LENGTH_LONG).show();
        } else {
            try {
                int codeInt = Integer.parseInt(code);
                double priceDouble = Double.parseDouble(price);
                int stockInt = Integer.parseInt(stock);
                Producto nuevoP = new Producto(codeInt, desc, priceDouble, stockInt);
                if (isInList(codeInt)){
                    Toast.makeText(getApplication(), "El producto con el código " + codeInt + " ya existe", Toast.LENGTH_SHORT).show();
                } else {
                    if (productoList.add(nuevoP)) {
                        Toast.makeText(getApplication(), "¡Producto agregado con éxito!", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(getApplication(), "Ocurrio un error al agregar el producto a la lista..", Toast.LENGTH_LONG).show();
                    }
                }
            } catch (NumberFormatException ex){
                Toast.makeText(getApplication(), "¡Debe ingresar valores válidos!", Toast.LENGTH_LONG).show();
            }
        }
    }
}