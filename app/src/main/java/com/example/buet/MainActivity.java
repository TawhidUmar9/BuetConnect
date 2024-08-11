package com.example.buet;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    SharedPreferences sharedPreferences;
    Button departmentWebsiteButton;
    Button biisWebsiteButton;
    Button riseWebsiteButton;
    ImageButton settingsButton;
    int count = 2;

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
        riseWebsiteButton = findViewById(R.id.rise_website_button);
        settingsButton = findViewById(R.id.settings_button);

        sharedPreferences = getSharedPreferences("user_department", Context.MODE_PRIVATE);
        String userDepartmentURL = sharedPreferences.getString("userDepartmentUrl", "www.google.com");

        departmentWebsiteButton.setText("Departmental Webpage");
        biisWebsiteButton.setText("BIIS");
        riseWebsiteButton.setText("RISE-BUET");

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

        riseWebsiteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callWebView("https://rise.buet.ac.bd");
            }
        });

        departmentWebsiteButton.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                Toast.makeText(MainActivity.this, "Visit: " + userDepartmentURL, Toast.LENGTH_SHORT).show();
                return true;
            }
        });

        biisWebsiteButton.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                Toast.makeText(MainActivity.this, "Visit: https://biis.buet.ac.bd", Toast.LENGTH_SHORT).show();
                return true;
            }
        });

        riseWebsiteButton.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                Toast.makeText(MainActivity.this, "Visit: https://rise.buet.ac.bd", Toast.LENGTH_SHORT).show();
                return true;
            }
        });

        settingsButton.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                Toast.makeText(MainActivity.this, "Settings", Toast.LENGTH_SHORT).show();
                return true;
            }
        });

    }

    @Override
    public void onBackPressed() {
        SharedPreferences sharedPreferences = getSharedPreferences("user_department", Context.MODE_PRIVATE);
        if (sharedPreferences.contains("userDepartment")) {
            --count;
            if (count == 1)
                Toast.makeText(this, "Press back again to exit the app.", Toast.LENGTH_SHORT).show();
            if (count == 0) {
                finishAffinity();
                System.exit(0); //
            }
        }
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }

    private void callWebView(String requestURL) {
        Intent intent = new Intent(MainActivity.this, WebviewActivity.class);
        intent.putExtra("request_url", requestURL);
        startActivity(intent);

    }
}