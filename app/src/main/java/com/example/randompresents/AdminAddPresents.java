package com.example.randompresents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

public class AdminAddPresents extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Spinner spinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_add_presents);
        spinner.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String item = (String) parent.getSelectedItem();
        switch (item){
            case "Тост":
                Intent intent = new Intent(this,AdminAddToct.class);
                startActivity(intent);
                break;
            case "Поздравление":
                intent = new Intent(this,AdminAddCongratulation.class);
                startActivity(intent);
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }


}