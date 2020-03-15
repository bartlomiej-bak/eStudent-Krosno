package com.example.estudentkrosno.ui.aktualnosci;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.estudentkrosno.R;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.DocumentSnapshot;

public class AktualnosciAdapter extends FirestoreRecyclerAdapter<AktualnosciModel, AktualnosciAdapter.AktualnosciHolder> {

    private OnItemClickListener listener;

    public AktualnosciAdapter(FirestoreRecyclerOptions<AktualnosciModel> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(AktualnosciHolder aktualnosciHolder, int i, AktualnosciModel aktualnosciModel) {
        aktualnosciHolder.textViewUzytkownik.setText(aktualnosciModel.getUzytkownik());
        aktualnosciHolder.textViewZawartosc.setText(aktualnosciModel.getZawartosc());
        aktualnosciHolder.textViewData.setText(aktualnosciModel.getData());

    }

    @NonNull
    @Override
    public AktualnosciHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.aktualnosci_item, parent, false);

        return new AktualnosciHolder(v);
    }

    class AktualnosciHolder extends RecyclerView.ViewHolder{

        private final TextView textViewUzytkownik;
        private final TextView textViewZawartosc;
        private final TextView textViewData;

        private AktualnosciHolder(View itemView){
            super(itemView);
            textViewUzytkownik = itemView.findViewById(R.id.textViewUzytkownik);
            textViewZawartosc = itemView.findViewById(R.id.textViewZawartosc);
            textViewData = itemView.findViewById(R.id.textViewData);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d("Klik","Klik");
                }
            });
        }
    }

    public interface OnItemClickListener{
        void onItemClick(DocumentSnapshot documentSnapshot, int position);
    }

    private void setOnItemClickListener(OnItemClickListener listener){
        this.listener = listener;
    }
}
