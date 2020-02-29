package com.example.estudentkrosno.ui.materialy;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.estudentkrosno.R;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;

public class MaterialAdapter extends FirestoreRecyclerAdapter<MaterialModel, MaterialAdapter.MaterialHolder> {

    public MaterialAdapter(FirestoreRecyclerOptions<MaterialModel> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull MaterialHolder holder, int position, @NonNull MaterialModel model) {
        holder.textViewNazwaPliku.setText(model.getNazwa());
        holder.textViewSciezkaPliku.setText(model.getSciezka());
    }

    @NonNull
    @Override
    public MaterialHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.material_item, parent, false);
        return new MaterialHolder(view);
    }

    class MaterialHolder extends RecyclerView.ViewHolder{

        private TextView textViewNazwaPliku;
        private TextView textViewSciezkaPliku;

        public MaterialHolder(View itemView){
            super(itemView);
            textViewNazwaPliku = itemView.findViewById(R.id.textFieldNazwaPliku);
            textViewSciezkaPliku = itemView.findViewById(R.id.textFieldSciezkaPliku);

        }
    }
}
