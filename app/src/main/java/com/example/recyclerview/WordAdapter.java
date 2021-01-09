package com.example.recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerview.databinding.WordItemListBinding;

import java.util.List;
// 3. Extender de Recycler.Adaptern pasar el ViewHolder
// 4. implemetar los metodos
public class WordAdapter extends RecyclerView.Adapter<WordAdapter.WordViewHolder> {

    //1. Añadir una representacion de los datos
    private List<String> mWordList;
    //No olvidar crear constructor para pasar el listado de datos al instanciar el adapter
    public WordAdapter(List<String> mWordList) {
        this.mWordList = mWordList;
    }

    @NonNull
    @Override
    public WordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //Instanciamos ViewBinding para retornar nuestro ViewHolder con esa dependencia
        WordItemListBinding mBinding = WordItemListBinding
                .inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new WordViewHolder(mBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull WordViewHolder holder, int position) {
        //Creamos una variabkle de referencia del listado y lo asignamos al elemnto
        String element = mWordList.get(position);
        holder.textView.setText(element);

    }

    @Override
    public int getItemCount() {
        //Indica cantida de datos a mostrar
        return mWordList.size();
    }

    //2. Crear clase interna ViewHolder
    public class WordViewHolder extends RecyclerView.ViewHolder {
        private TextView textView;

        public WordViewHolder(@NonNull WordItemListBinding mBinding) {
            super(mBinding.getRoot());
            textView = mBinding.textView;
        }
    }


}
