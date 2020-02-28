package com.example.estudentkrosno.ui.oceny;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.estudentkrosno.R;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;

public class OcenaAdapter extends FirestoreRecyclerAdapter<OcenaModel, OcenaAdapter.OcenaHolder> {

    public OcenaAdapter(FirestoreRecyclerOptions<OcenaModel> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(OcenaHolder ocenaHolder, int i, OcenaModel ocenaModel) {
        ocenaHolder.textViewSubject.setText(ocenaModel.getPrzedmiot());
        ocenaHolder.textViewDegree.setText(ocenaModel.getOcena());
    }

    @NonNull
    @Override
    public OcenaHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.ocena_item, parent, false);
        return new OcenaHolder(v);
    }

    class OcenaHolder extends RecyclerView.ViewHolder{

        private TextView textViewSubject;
        private TextView textViewDegree;

        public OcenaHolder(View itemView){
            super(itemView);
            textViewSubject = itemView.findViewById(R.id.textFieldPrzedmiot);
            textViewDegree = itemView.findViewById(R.id.textFieldOcena);

        }
    }
}
