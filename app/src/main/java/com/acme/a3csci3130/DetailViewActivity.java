package com.acme.a3csci3130;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

/**
 * This class contains code for creating, updating, and deleting business data in the app
 * This code was originally provided by the professor by has been edited by Noah Sealy, B00726289 in order to fit the code in the context of a business creation
 */
public class DetailViewActivity extends Activity {

    private EditText busNumField, nameField, primBusField, addField, provField;
    Business receivedBusinessInfo;
    private MyApplicationData state; //added

    /**
     * This method will save data entered in the business creation UI and save it in the database as a business object
     */
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

    /**
     * This method will be called upon clicking the update business button within the data display UI
      * It will update the database with any new information entered, to act as a replacement for the old data
     */
    public void updateBusiness(View v) {

        receivedBusinessInfo.businessNumber = busNumField.getText().toString();
        receivedBusinessInfo.name = nameField.getText().toString();
        receivedBusinessInfo.primaryBusiness = primBusField.getText().toString();
        receivedBusinessInfo.address = addField.getText().toString();
        receivedBusinessInfo.province = provField.getText().toString();


        state.firebaseReference.child(receivedBusinessInfo.businessID).setValue(receivedBusinessInfo);

        finish();

    }

    /**
     * This method will delete a selected business from the database
     * This deletion will also negate its display in the list on the UI
     */
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