package com.example.estudentkrosno.ui.aktualnosci;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.estudentkrosno.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;

public class AktualnosciFragment extends Fragment {

    FirebaseFirestore db = FirebaseFirestore.getInstance();
    View v;
    private RecyclerView myRecyclerView;
    private List<Post> listPost;

    public AktualnosciFragment(){}

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_aktualnosci, container, false);
        myRecyclerView = root.findViewById(R.id.recyclerView);
        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(getContext(), listPost);
        myRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        myRecyclerView.setAdapter(recyclerViewAdapter);
        return root;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        listPost = new ArrayList<>();


        listPost.add(new Post("Państwowa Wyższa Szkoła Zawodowa", "im. Stanisława Pigonia w Krośnie", R.drawable.news));
        listPost.add(new Post("Państwowa Wyższa Szkoła Zawodow", "im. Stanisława Pigonia w Krośnie", R.drawable.news));

    }
}