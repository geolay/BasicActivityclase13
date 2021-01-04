package com.example.basicactivityclase13;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.basicactivityclase13.databinding.WordItemListBinding;


import java.util.List;
// 3.- Extender de Recycler.Adapter pasando el ViewHolder que creamos
// 4.- Implementar los métodos
public class WordsAdapter extends RecyclerView.Adapter<WordsAdapter.WordViewHolder> {

    //1.- Añadimos listado de String que contendrá los datos
    private List<String> mWordList;
    // referencia a interface
    private PasarElemento pasarElemento;

    // 8.- Creamos un constructor para pasar el listado de datos al instanciar
    public WordsAdapter(List<String> mWordList, PasarElemento pasarElemento) {
        this.mWordList = mWordList;
        this.pasarElemento = pasarElemento;
    }

    @NonNull
    @Override
    public WordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Instanciamos WiewBinding para retornar ViewHolder
        WordItemListBinding mBinding = WordItemListBinding
                .inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new WordViewHolder(mBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull WordViewHolder holder, int position) {
        // 7- Creamos una variable para referencia objeto por posicion y
        // lo asignamos a la vista ViewHolder
         String word = mWordList.get(position);
         holder.textView.setText(word);
    }

    @Override
    public int getItemCount() {
        // 5. Indicar que retorna el tamaño del listado
        return mWordList.size();
    }


    // 2.- Crear una clase interna, xxx ViewHolder. la puedo crear afuera y hacer referencia a ella
    public class WordViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView textView;
        public WordViewHolder(@NonNull WordItemListBinding mBinding) {
            super(mBinding.getRoot());
            textView = mBinding.textView;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int position = getLayoutPosition();
            String element = mWordList.get(position);
          //  Toast.makeText(v.getContext(),element, Toast.LENGTH_SHORT).show();
            mWordList.set(position,element + " CLICK");
            notifyDataSetChanged();

            pasarElemento.passElement(element);
        }
    }
    // Interface con metodo recibe palabra y pasa al primer fragmento
    public interface PasarElemento{
        void passElement(String elemento);
    }
}
