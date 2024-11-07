package com.example.locations;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.LocationViewHolder> {

    private List<Location> locations;
    private final DBHandler dbHandler;
    private final Context context;

    public Adapter(List<Location> locations, Context context) {
        this.locations = locations;
        this.context = context;
        this.dbHandler = new DBHandler(context); // Initialize DBHandler
    }

    @NonNull
    @Override
    public LocationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.location_item, parent, false);
        return new LocationViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull LocationViewHolder holder, int position) {
        Location location = locations.get(position);
        holder.addressTextView.setText(location.getAddress());
        holder.latTextView.setText("Latitude: " + location.getLatitude());
        holder.longTextView.setText("Longitude: " + location.getLongitude());

        // Set up a click listener to edit the item
        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, EditActivity.class);
            intent.putExtra("location_id", location.getId()); // Pass location ID to EditActivity
            context.startActivity(intent);
        });

        // Set a long-click listener for deleting an item
        holder.itemView.setOnLongClickListener(v -> {
            new AlertDialog.Builder(context)
                    .setTitle("Delete Location")
                    .setMessage("Are you sure you want to delete this location?")
                    .setPositiveButton("Yes", (dialog, which) -> {
                        deleteItem(position);
                        Toast.makeText(context, "Location deleted", Toast.LENGTH_SHORT).show();
                    })
                    .setNegativeButton("No", null)
                    .show();
            return true;
        });
    }

    @Override
    public int getItemCount() {
        return locations.size();
    }

    // Method to delete an item from the RecyclerView and database
    private void deleteItem(int position) {
        Location location = locations.get(position);
        boolean isDeleted = dbHandler.deleteLocation(location.getId());

        if (isDeleted) {
            locations.remove(position);
            notifyItemRemoved(position);
        } else {
            Toast.makeText(context, "Failed to delete location", Toast.LENGTH_SHORT).show();
        }
    }

    // Method to update the data in the adapter
    public void updateData(List<Location> newLocations) {
        locations = newLocations;
        notifyDataSetChanged();
    }

    static class LocationViewHolder extends RecyclerView.ViewHolder {
        private final TextView addressTextView;
        private final TextView latTextView;
        private final TextView longTextView;

        public LocationViewHolder(@NonNull View itemView) {
            super(itemView);
            addressTextView = itemView.findViewById(R.id.address_text);
            latTextView = itemView.findViewById(R.id.latitude_text);
            longTextView = itemView.findViewById(R.id.longitude_text);
        }
    }
}
