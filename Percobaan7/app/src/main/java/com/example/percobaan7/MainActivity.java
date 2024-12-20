package com.example.percobaan7;

import android.os.Bundle;
import androidx.activity.enableEdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

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
        String password = binding.edtPassword.getText().toString().trim();

        boolean res = databaseHelper.checkUser(username, password);

        if (res) {
            Toast.makeText(MainActivity.this, "Successfully Logged In", Toast.LENGTH_SHORT).show();
            Intent contentIntent = new Intent(MainActivity.this, ContentActivity.class);
            startActivity(contentIntent);
        } else {
            Toast.makeText(MainActivity.this, "Username atau Password Anda Salah", Toast.LENGTH_SHORT).show();
        }
    });

    binding.btnRegister.setOnClickListener(view -> {
        Intent registerIntent = new Intent(MainActivity.this, RegisterActivity.class);
        startActivity(registerIntent);
    });
}