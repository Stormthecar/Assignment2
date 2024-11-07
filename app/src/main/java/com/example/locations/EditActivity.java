package com.example.locations;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class EditActivity extends AppCompatActivity {

    private EditText addressInput;
    private EditText latitudeInput;
    private EditText longitudeInput;
    private DBHandler dbHandler;
    private int locationId = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        addressInput = findViewById(R.id.address_input);
        latitudeInput = findViewById(R.id.latitude_input);
        longitudeInput = findViewById(R.id.longitude_input);
        dbHandler = new DBHandler(this);

        // Check if editing an existing location
        if (getIntent().hasExtra("location_id")) {
            locationId = getIntent().getIntExtra("location_id", -1);
            loadLocationData(locationId);
        }
    }

    private void loadLocationData(int id) {
        Location location = dbHandler.getLocationById(id);
        if (location != null) {
            addressInput.setText(location.getAddress());
            latitudeInput.setText(String.valueOf(location.getLatitude()));
            longitudeInput.setText(String.valueOf(location.getLongitude()));
        }
    }

    public void saveLocation(View view) {
        String address = addressInput.getText().toString();
        double latitude;
        double longitude;
        try {
            latitude = Double.parseDouble(latitudeInput.getText().toString());
            longitude = Double.parseDouble(longitudeInput.getText().toString());
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Please enter valid numbers for latitude and longitude.", Toast.LENGTH_SHORT).show();
            return;
        }

        boolean success;
        if (locationId == -1) {
            success = dbHandler.addLocation(address, latitude, longitude);
        } else {
            success = dbHandler.updateLocation(locationId, address, latitude, longitude);
        }

        Toast.makeText(this, success ? "Location saved!" : "Failed to save location", Toast.LENGTH_SHORT).show();
        if (success) {
            finish();
        }
    }

    public void deleteLocation(View view) {
        if (locationId != -1) {
            boolean success = dbHandler.deleteLocation(locationId);
            Toast.makeText(this, success ? "Location deleted!" : "Failed to delete location", Toast.LENGTH_SHORT).show();
            if (success) {
                finish();
            }
        } else {
            Toast.makeText(this, "No location to delete", Toast.LENGTH_SHORT).show();
        }
    }
}
