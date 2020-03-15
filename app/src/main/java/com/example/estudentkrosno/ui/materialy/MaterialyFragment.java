package com.example.estudentkrosno.ui.materialy;

import android.app.DownloadManager;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.estudentkrosno.R;
import com.example.estudentkrosno.ui.oceny.OcenaAdapter;
import com.example.estudentkrosno.ui.oceny.OcenaModel;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;


public class MaterialyFragment extends Fragment {

    private StorageReference mStorageRef;
    private StorageReference fileReference;

    private final FirebaseFirestore db = FirebaseFirestore.getInstance();
    private MaterialAdapter adapter;
    private RecyclerView recyclerView;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_materialy, container, false);
        mStorageRef = FirebaseStorage.getInstance().getReference();
        recyclerView = root.findViewById(R.id.materialy_recycler);
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

        adapter = new MaterialAdapter(options);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onStart(){
        super.onStart();
        adapter.startListening();
    }

    @Override
    public void onStop() {
        super.onStop();
        adapter.stopListening();
    }
}