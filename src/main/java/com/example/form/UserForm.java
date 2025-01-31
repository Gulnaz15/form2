package com.example.form;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.form.databinding.ActivityUserFormBinding;

public class UserForm extends AppCompatActivity {
    ActivityUserFormBinding binding;
    public Form user;
    public static final String INFO = "INFO";
    public static final int CODEUSER = 1;
    Intent intent;

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(data != null){
            if(requestCode == CODEUSER && resultCode == RESULT_OK){
                Bundle args = getIntent().getExtras();
                if(args != null && user != null){
                    user = (Form) args.getSerializable(MainActivity.USER);
                    binding.name.setText(user.getName());
                    binding.surname.setText(user.getSurname());
                    binding.phone.setText(String.valueOf(user.getPhone()));
                    binding.site.setText(user.getSite());
                    binding.address.setText(user.getAddress());
                }
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = ActivityUserFormBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

//        Bundle args = getIntent().getExtras();
//        if(args != null && user != null){
//            user = (Form) args.getSerializable(MainActivity.USER);
//            binding.name.setText(user.getName());
//            binding.surname.setText(user.getSurname());
//            binding.phone.setText(String.valueOf(user.getPhone()));
//            binding.site.setText(user.getSite());
//            binding.address.setText(user.getAddress());
//        }

        binding.btnSubmit.setOnClickListener(v -> {
            String name = binding.name.getText().toString();
            String surname = binding.surname.getText().toString();
            String address = binding.address.getText().toString();
            String site = binding.site.getText().toString();
            int phone = Integer.parseInt(binding.phone.getText().toString());

            user = new Form(name,surname,phone,site,address);

            intent = new Intent(getApplicationContext(),MainActivity.class);
            //intent.putExtra(Form.class.getSimpleName(), user);
            intent.putExtra(INFO,user);
            setResult(RESULT_OK,intent);
            startActivityForResult(intent,CODEUSER);
            finish();
        });
    }
}