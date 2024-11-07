package com.example.locations;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView locationRecyclerView;
    private Adapter adapter;
    private DBHandler dbHandler;
    private EditText searchBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize database handler and RecyclerView
        dbHandler = new DBHandler(this);
        locationRecyclerView = findViewById(R.id.location_recycler_view);
        searchBar = findViewById(R.id.search_bar);
        locationRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Load and display locations in RecyclerView
        loadLocations();

        // Set up search bar to filter locations
        searchBar.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                filterLocations(s.toString());
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void afterTextChanged(Editable s) {}
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        loadLocations(); // Reload locations when returning to MainActivity
    }

    private void loadLocations() {
        // Retrieve all locations from the database
        List<Location> locationList = dbHandler.getAllLocations();

        // Initialize the adapter with the list and context for the dialog
        adapter = new Adapter(locationList, this);
        locationRecyclerView.setAdapter(adapter);
    }

    private void filterLocations(String query) {
        // Filter locations by address and update the RecyclerView
        List<Location> filteredList = dbHandler.searchLocationByAddress(query);
        adapter.updateData(filteredList);
    }

    public void openAddLocationActivity(View view) {
        // Open activity to add a new location
        Intent intent = new Intent(this, EditActivity.class);
        startActivity(intent);
    }


}
