package com.acme.a3csci3130;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * This class contains code for the creation of a business activity as well as the submit information button
 * Essentially this class will create the creation screen for a business as well as a submit button to send that business to the firebase
 * This code was originally provided by the professor by has been edited by Noah Sealy, B00726289 in order to fit the code in the context of a business creation
 */

public class CreateBusinessAcitivity extends Activity {

    private Button submitButton;
    private EditText busNum, name, primBus, add, pt;
    private MyApplicationData appState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_business_acitivity);
        //Get the app wide shared variables
        appState = ((MyApplicationData) getApplicationContext());

        submitButton = (Button) findViewById(R.id.submitButton);
        busNum = (EditText) findViewById(R.id.businessNumber);
        name = (EditText) findViewById(R.id.businessName);
        primBus = (EditText) findViewById(R.id.primaryBusiness);
        add = (EditText) findViewById(R.id.address);
        pt = (EditText) findViewById(R.id.province);
    }

    /**
     * This method will save the information of a business object onto the firebase
     * This function will occur whenever the user clicks submit with information that passes the firebase rules
     */
    public void submitInfoButton(View v) {
        //each entry needs a unique ID
        String businessID = appState.firebaseReference.push().getKey();
        String businessNumber = busNum.getText().toString();
        String businessName = name.getText().toString();
        String business = primBus.getText().toString();
        String address = add.getText().toString();
        String province = pt.getText().toString();
        Business busi = new Business(businessID, businessNumber, businessName, business, address, province);

        appState.firebaseReference.child(businessID).setValue(busi);

        finish();

    }
}
