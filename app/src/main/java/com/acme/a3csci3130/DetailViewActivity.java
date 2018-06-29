package com.acme.a3csci3130;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class DetailViewActivity extends Activity {

    private EditText busNumField, nameField, primBusField, addField, provField;
    Business receivedBusinessInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_view);
        receivedBusinessInfo = (Business)getIntent().getSerializableExtra("Business");

        busNumField = (EditText) findViewById(R.id.businessNumber);
        nameField = (EditText) findViewById(R.id.businessName);
        primBusField = (EditText) findViewById(R.id.primaryBusiness);
        addField = (EditText) findViewById(R.id.address);
        provField = (EditText) findViewById(R.id.province);

        if(receivedBusinessInfo != null){
            busNumField.setText(receivedBusinessInfo.businessNumber);
            nameField.setText(receivedBusinessInfo.name);
            primBusField.setText(receivedBusinessInfo.primaryBusiness);
            addField.setText(receivedBusinessInfo.address);
            provField.setText(receivedBusinessInfo.province);

        }
    }

    public void updateContact(View v){
        //TODO: Update contact funcionality




    }

    public void eraseContact(View v)
    {
        //TODO: Erase contact functionality
    }
}
