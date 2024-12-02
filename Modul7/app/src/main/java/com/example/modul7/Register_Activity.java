package com.example.modul7;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.modul7.databinding.ActivityRegisterBinding;
import com.example.modul7.utils.DatabaseHelper;

public class Register_Activity extends AppCompatActivity {
    private ActivityRegisterBinding binding;
    private DatabaseHelper databaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRegisterBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        databaseHelper = new DatabaseHelper(this);
        binding.btnLogin.setOnClickListener(view -> {
            Intent LoginIntent =
                    new Intent(Register_Activity.this, MainActivity.class);
            startActivity(LoginIntent);
        });

        binding.btnRegister.setOnClickListener(view -> {
            String username = binding.edtUsername.getText().toString().trim();
            String password = binding.edtPassword.getText().toString().trim();
            String confPass = binding.edtConfirm.getText().toString().trim();

            if (password.equals(confPass)){
                long pal = databaseHelper.addUser(username, password);
                if (pal > 0){
                    Toast.makeText(Register_Activity.this, "Anda Berhasil Registrasi",
                            Toast.LENGTH_SHORT).show();
                    Intent moveTologin =
                            new Intent(Register_Activity.this, MainActivity.class);
                    startActivity(moveTologin);
                }
            }else {
                Toast.makeText(Register_Activity.this, "Password Anda Tidak Cocok",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}