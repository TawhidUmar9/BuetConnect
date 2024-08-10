package com.example.buet;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    SharedPreferences sharedPreferences;
    Button departmentWebsiteButton;
    Button biisWebsiteButton;
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        biisWebsiteButton = findViewById(R.id.biis_webiste_button);
        departmentWebsiteButton = findViewById(R.id.department_website_button);

        sharedPreferences = getSharedPreferences("user_department", Context.MODE_PRIVATE);
        String userDepartmentURL = sharedPreferences.getString("userDepartmentUrl", "www.google.com");

        departmentWebsiteButton.setText("Visit: " + userDepartmentURL);
        biisWebsiteButton.setText("Visit: https://biis.buet.ac.bd");

        departmentWebsiteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callWebView(userDepartmentURL);
            }
        });
        biisWebsiteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callWebView("https://biis.buet.ac.bd/BIIS_WEB/CheckValidity.do");
            }
        });

    }
    private void callWebView(String requestURL){
        Intent intent = new Intent(MainActivity.this, WebviewActivity.class);
        intent.putExtra("request_url", requestURL);
        startActivity(intent);

    }
}