package com.example.estudentkrosno.ui.materialy;

import android.app.DownloadManager;
import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.estudentkrosno.R;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;

import static android.os.Environment.DIRECTORY_DOWNLOADS;

public class MaterialAdapter extends FirestoreRecyclerAdapter<MaterialModel, MaterialAdapter.MaterialHolder> {

    public MaterialAdapter (FirestoreRecyclerOptions<MaterialModel> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(final MaterialHolder materialHolder, int i, final MaterialModel materialModel) {
        materialHolder.textViewNazwa.setText(materialModel.getNazwa());
        //materialHolder.textViewSciezka.setText( materialModel.getSciezka());
        materialHolder.buttonPobierz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(materialHolder.textViewNazwa.getContext(),"Pobieranie: "+materialModel.getNazwa(),Toast.LENGTH_SHORT).show();
                downloadFiles(materialHolder.textViewNazwa.getContext(), materialModel.getNazwa(), ".pdf", DIRECTORY_DOWNLOADS, materialModel.getSciezka());
            }
        });
        materialHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(materialHolder.itemView.getContext(),"Caly element",Toast.LENGTH_SHORT).show();

            }
        });
    }

    @NonNull
    @Override
    public MaterialHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.material_item, parent, false);
        return new MaterialHolder(v);
    }

    class MaterialHolder extends RecyclerView.ViewHolder{

        private TextView textViewNazwa;
        private TextView textViewSciezka;
        private Button buttonPobierz;

        public MaterialHolder(View itemView){
            super(itemView);
            textViewNazwa = itemView.findViewById(R.id.materialNazwa);
            textViewSciezka = itemView.findViewById(R.id.materialSciezka);
            buttonPobierz = itemView.findViewById(R.id.buttonPobierz);
        }
    }

    public void downloadFiles(Context context, String fileName, String fileExtension, String destinationDirectory, String url){
        DownloadManager downloadManager = (DownloadManager) context.
                getSystemService(Context.DOWNLOAD_SERVICE);
        Uri uri = Uri.parse(url);
        DownloadManager.Request request = new DownloadManager.Request(uri);
        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
        request.setDestinationInExternalFilesDir(context,destinationDirectory,fileName + fileExtension);
        downloadManager.enqueue(request);
    }
}
