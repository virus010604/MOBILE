package com.example.modul7;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.modul7.databinding.ActivityMainBinding;
import com.example.modul7.utils.DatabaseHelper;


public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private DatabaseHelper databaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        databaseHelper = new DatabaseHelper(this);
        binding.btnLogin.setOnClickListener(view -> {
            String username = binding.edtUsername.getText().toString().trim();
            String passworrd = binding.edtPassword.getText().toString().trim();
            boolean res = databaseHelper.checkUser(username, passworrd);

            if (res){
                Toast.makeText(MainActivity.this, "Anda Berhasil Login",
                        Toast.LENGTH_SHORT).show();
                Intent ContentIntent = new Intent(MainActivity.this,
                        Content_Activity.class);
                startActivity(ContentIntent);
            }else {
                Toast.makeText(MainActivity.this, "Username atau Password Anda Salah",
                        Toast.LENGTH_SHORT).show();
            }
        });
        binding.btnRegister.setOnClickListener(view -> {
            Intent registerIntent = new Intent(MainActivity.this, Register_Activity.class);
            startActivity(registerIntent);
        });
    }
}