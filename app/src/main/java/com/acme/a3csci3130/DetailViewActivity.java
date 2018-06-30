package com.acme.a3csci3130;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;


public class DetailViewActivity extends Activity {

    private EditText busNumField, nameField, primBusField, addField, provField;
    Business receivedBusinessInfo;
    private MyApplicationData state; //added


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_view);
        receivedBusinessInfo = (Business)getIntent().getSerializableExtra("Business");
        state = ((MyApplicationData) getApplicationContext());

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

    public void updateBusiness(View v){
        //TODO: Update contact funcionality

        receivedBusinessInfo.businessNumber = busNumField.getText().toString();
        receivedBusinessInfo.name = nameField.getText().toString();
        receivedBusinessInfo.primaryBusiness = primBusField.getText().toString();
        receivedBusinessInfo.address = addField.getText().toString();
        receivedBusinessInfo.province = provField.getText().toString();


        state.firebaseReference.child(receivedBusinessInfo.businessID).setValue(receivedBusinessInfo);

        finish();

    }

    public void deleteBusiness(View v) {
        //TODO: Erase contact functionality

        String businessID = null;
        String businessNumber = null;
        String businessName = null;
        String primaryBusiness = null;
        String address = null;
        String province = null;

        Business business = new Business(businessID, businessNumber, businessName, primaryBusiness, address, province);

        state.firebaseReference.child(receivedBusinessInfo.businessID).setValue(business);

        finish();
    }
}