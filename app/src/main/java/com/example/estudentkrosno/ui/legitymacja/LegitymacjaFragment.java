package com.example.estudentkrosno.ui.legitymacja;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.estudentkrosno.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.squareup.picasso.Picasso;

import static androidx.constraintlayout.widget.Constraints.TAG;

public class LegitymacjaFragment extends Fragment {

    private Button generateCode;
    private ImageView codeView;
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    private String kod;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View inflate = inflater.inflate(R.layout.fragment_legitymacja, container, false);
        generateCode = inflate.findViewById(R.id.buttonGenerate);
        codeView = inflate.findViewById(R.id.codeView);
        generateCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                codeView.setVisibility(View.VISIBLE);
                db.collection("Kod")
                        .get()
                        .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                            @Override
                            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                                if (task.isSuccessful()) {
                                    for (QueryDocumentSnapshot document : task.getResult()) {
                                        kod = document.getString("kod");
                                        Picasso.get().load(kod).into(codeView);
                                    }
                                } else {
                                    Log.w(TAG, "Bład wczytania kodu", task.getException());
                                    Toast.makeText(getContext(), "Bład wczytania kodu", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
        });
        return inflate;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


    }
}