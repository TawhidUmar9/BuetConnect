package com.example.buet;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.audiofx.HapticGenerator;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.buet.departments.Data;
import com.example.buet.departments.Department;

public class SelectDepartmentActivity extends AppCompatActivity {
    int count = 2;
    private Department department = null;
    private ListView listViewDepartments;
    private DepartmentAdapter departmentAdapter;
    private Button selectButton;
    private TextView selectedDepartment;

    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_select_department);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        SharedPreferences sharedPreferences = getSharedPreferences("user_department", Context.MODE_PRIVATE);
        if (sharedPreferences.contains("userDepartment")) {
            callMainActivity();
        }
        selectedDepartment = (TextView) findViewById(R.id.selected_department);
        selectButton = (Button) findViewById(R.id.select_department_button);
        listViewDepartments = (ListView) findViewById(R.id.departmentListView);
        departmentAdapter = new DepartmentAdapter(SelectDepartmentActivity.this, Data.getDepartmentList());
        listViewDepartments.setAdapter(departmentAdapter);

        listViewDepartments.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                department = Data.getDepartmentList().get(i);
                String dept = getString(department.getDepartmentAbbreviation());
                selectedDepartment.setText("You selected: " + dept.toUpperCase());

            }
        });

        selectButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences = getSharedPreferences("user_department", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                if(department == null){
                    Toast.makeText(SelectDepartmentActivity.this, "Please select your department", Toast.LENGTH_SHORT).show();
                    return;
                }
                editor.putString("userDepartment", department.getDepartmentName());
                editor.putString("userDepartmentUrl", getString(department.getWebsiteURL()));
                editor.apply();

                callMainActivity();
            }
        });
    }

    private void callMainActivity() {
        Intent intent = new Intent(SelectDepartmentActivity.this, MainActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }

    @Override
    public void onBackPressed() {
        --count;
        if (count == 1)
            Toast.makeText(this, "Press back again to exit the app.", Toast.LENGTH_SHORT).show();
        if (count == 0) {
            finishAffinity();
            System.exit(0); //
        }
    }

}