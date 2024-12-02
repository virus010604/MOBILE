package com.example.firebasejuan;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.firebase.FirebaseApp;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private EditText mMainText, mMainText2;
    private FirebaseFirestore mFirestore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mMainText=findViewById(R.id.mainText);
        mMainText2 = findViewById(R.id.mainText2);
        Button mSaveBtn = findViewById(R.id.saveBtn);
        TextView mListText = findViewById(R.id.textView1);
        ProgressBar progressBar = findViewById(R.id.progress_bar);

        FirebaseApp.initializeApp(this);
        mFirestore = FirebaseFirestore.getInstance();

        mSaveBtn.setOnClickListener(v -> {
            String username = mMainText.getText().toString();
            String stambuk = mMainText2.getText().toString();

            if (!username.isEmpty() && !stambuk.isEmpty()) {
                // Create a HashMap to store user data
                Map<String, String> userMap = new HashMap<>();
                userMap.put("username", username);
                userMap.put("stambuk", stambuk);

                // Show progress bar
                progressBar.setVisibility(View.VISIBLE);

                // Add user data to Firestore
                mFirestore.collection("pengguna")
                        .add(userMap)
                        .addOnSuccessListener(documentReference -> {
                            // Data added successfully
                            Toast.makeText(MainActivity.this, "Pengguna Ditambahkan di Firestore", Toast.LENGTH_SHORT).show();
                            mMainText.setText("");
                            mMainText2.setText("");
                            progressBar.setVisibility(View.GONE);
                        })
                        .addOnFailureListener(e -> {
                            // Error adding data
                            Toast.makeText(MainActivity.this, "Error: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                            progressBar.setVisibility(View.GONE);
                        });
            } else {
                Toast.makeText(MainActivity.this, "Username dan Stambuk tidak boleh kosong", Toast.LENGTH_SHORT).show();
            }
        });
    mListText.setOnClickListener(v -> {
        Intent registerIntent = new Intent(MainActivity.this, ListActivity.class);
        startActivity(registerIntent);
        Toast.makeText(MainActivity.this, "Buka Activity Yang Menampilkan List", Toast.LENGTH_SHORT).show();
    });
    }


}
