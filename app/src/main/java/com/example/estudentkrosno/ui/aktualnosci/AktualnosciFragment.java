package com.example.estudentkrosno.ui.aktualnosci;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.estudentkrosno.R;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.HashMap;

public class AktualnosciFragment extends Fragment {

    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    FirebaseAuth mAuth;
    private AktualnosciAdapter aktualnosciAdapter;
    private RecyclerView recyclerViewAktualnosci;
    private Button buttonSendNews;
    private EditText editTextNews;


    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_aktualnosci, container, false);
        recyclerViewAktualnosci = root.findViewById(R.id.recyclerViewAktualnosci);
        buttonSendNews = root.findViewById(R.id.buttonSendNews);
        editTextNews = root.findViewById(R.id.editTextNews);
        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setUpRecyclerView();

        buttonSendNews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAuth = FirebaseAuth.getInstance();
                FirebaseUser currentUser = mAuth.getCurrentUser();
                String actualUser = currentUser.getDisplayName();
                String newsValue = editTextNews.getText().toString();
                Calendar calendar = Calendar.getInstance();
                String currentTime = DateFormat.getDateTimeInstance().format(calendar.getTime());

                HashMap<String, Object> user = new HashMap<>();
                user.put("uzytkownik", actualUser);
                user.put("zawartosc", newsValue);
                user.put("data", currentTime);

                if(!newsValue.equals("")){
                    db.collection("Aktualnosci")
                            .add(user)
                            .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                                @Override
                                public void onSuccess(DocumentReference documentReference) {
                                    Toast.makeText(getContext(), "Dodano nowy post", Toast.LENGTH_SHORT).show();
                                    editTextNews.setText("");
                                }
                            })
                            .addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Toast.makeText(getContext(), "Błąd. Spróbuj ponownie później", Toast.LENGTH_SHORT).show();
                                }
                            });
                }else {
                    Toast.makeText(getContext(), "Wpisz zawartość posta", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    private void setUpRecyclerView(){
        Query query = db.collection("Aktualnosci").orderBy("data", Query.Direction.DESCENDING);
        FirestoreRecyclerOptions<AktualnosciModel> options = new FirestoreRecyclerOptions.Builder<AktualnosciModel>()
                .setQuery(query, AktualnosciModel.class)
                .build();

        aktualnosciAdapter = new AktualnosciAdapter(options);
        recyclerViewAktualnosci.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerViewAktualnosci.setAdapter(aktualnosciAdapter);
    }

    @Override
    public void onStart(){
        super.onStart();
        aktualnosciAdapter.startListening();
    }

    @Override
    public void onStop() {
        super.onStop();
        aktualnosciAdapter.stopListening();
    }
}