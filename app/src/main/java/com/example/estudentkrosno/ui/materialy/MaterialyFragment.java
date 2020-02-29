package com.example.estudentkrosno.ui.materialy;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.estudentkrosno.R;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

public class MaterialyFragment extends Fragment {

    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private MaterialAdapter materialyAdapter;
    RecyclerView recyclerViewMaterialy;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_materialy, container, false);
        recyclerViewMaterialy = root.findViewById(R.id.materialy_recycler);
        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setUpRecyclerView();
    }

    private void setUpRecyclerView(){
        Query query = db.collection("Materialy");
        FirestoreRecyclerOptions<MaterialModel> options = new FirestoreRecyclerOptions.Builder<MaterialModel>()
                .setQuery(query, MaterialModel.class)
                .build();

        materialyAdapter = new MaterialAdapter(options);
        recyclerViewMaterialy.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerViewMaterialy.setAdapter(materialyAdapter);
    }

    @Override
    public void onStart(){
        super.onStart();
        materialyAdapter.startListening();
    }

    @Override
    public void onStop() {
        super.onStop();
        materialyAdapter.stopListening();
    }
}