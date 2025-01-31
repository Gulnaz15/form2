package com.example.form;

import android.app.ComponentCaller;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.form.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    public static final int CODE = 0;
    public static final String USER = "USER";
    Intent i;
    public Form user;
    public String name;

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(data != null){
            if(requestCode == CODE && resultCode == RESULT_OK){
                binding.btnSee.setVisibility(View.VISIBLE);
                binding.btnAdd.setVisibility(View.INVISIBLE);
                Bundle args = getIntent().getExtras();
                if(args != null){
                    user = (Form) args.getSerializable(Form.class.getSimpleName());
                    assert user != null;
                    String name = user.getName();
                    String surname = user.getSurname();
                    String address = user.getAddress();
                    String site = user.getSite();
                    int phone = user.getPhone();
                    user = new Form(name,surname,phone,site,address);
                }
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.btnSee.setVisibility(View.INVISIBLE);
        binding.btnAdd.setOnClickListener(v -> {
            i = new Intent(getApplicationContext(), UserForm.class);
            startActivityForResult(i,CODE);
        });

        binding.btnSee.setOnClickListener(view -> {
            //i = new Intent(getApplicationContext(),UserForm.class);
            i = new Intent();
            i.putExtra(USER,user);
            //startActivity(i);
            setResult(RESULT_OK,i);
            finish();
        });
    }
}