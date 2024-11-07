package com.example.locations;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;

public class DBHandler extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "TouristLocationsDB";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_LOCATIONS = "Locations";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_ADDRESS = "address";
    private static final String COLUMN_LATITUDE = "latitude";
    private static final String COLUMN_LONGITUDE = "longitude";

    public DBHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_LOCATIONS_TABLE = "CREATE TABLE " + TABLE_LOCATIONS + "("
                + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COLUMN_ADDRESS + " TEXT,"
                + COLUMN_LATITUDE + " REAL,"
                + COLUMN_LONGITUDE + " REAL" + ")";
        db.execSQL(CREATE_LOCATIONS_TABLE);

        insertInitialLocations(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_LOCATIONS);
        onCreate(db);
    }

    private void insertInitialLocations(SQLiteDatabase db) {
        insertLocation(db, "Eiffel Tower, Paris", 48.8584, 2.2945);
        insertLocation(db, "Great Wall, China", 40.4319, 116.5704);
        insertLocation(db, "Colosseum, Rome", 41.8902, 12.4922);
        insertLocation(db, "Statue of Liberty, New York", 40.6892, -74.0445);
        insertLocation(db, "Machu Picchu, Peru", -13.1631, -72.5450);
        insertLocation(db, "Christ the Redeemer, Rio de Janeiro", -22.9519, -43.2105);
        insertLocation(db, "Taj Mahal, India", 27.1751, 78.0421);
        insertLocation(db, "Pyramids of Giza, Egypt", 29.9792, 31.1342);
        insertLocation(db, "Sydney Opera House, Australia", -33.8568, 151.2153);
        insertLocation(db, "Stonehenge, England", 51.1789, -1.8262);
        insertLocation(db, "Golden Gate Bridge, San Francisco", 37.8199, -122.4783);
        insertLocation(db, "Mount Everest, Nepal", 27.9881, 86.9250);
        insertLocation(db, "Angkor Wat, Cambodia", 13.4125, 103.8666);
        insertLocation(db, "Banff National Park, Canada", 51.4968, -115.9281);
        insertLocation(db, "Grand Canyon, USA", 36.1069, -112.1129);
        insertLocation(db, "Petra, Jordan", 30.3285, 35.4444);
        insertLocation(db, "Santorini, Greece", 36.3932, 25.4615);
        insertLocation(db, "Dubai Burj Khalifa, UAE", 25.1972, 55.2744);
        insertLocation(db, "Niagara Falls, Canada/USA", 43.0962, -79.0377);
        insertLocation(db, "Acropolis of Athens, Greece", 37.9715, 23.7257);
        insertLocation(db, "Hagia Sophia, Istanbul", 41.0085, 28.9802);
        insertLocation(db, "Blue Mosque, Istanbul", 41.0055, 28.9768);
        insertLocation(db, "Victoria Falls, Zambia/Zimbabwe", -17.9243, 25.8572);
        insertLocation(db, "Chichen Itza, Mexico", 20.6843, -88.5678);
        insertLocation(db, "Sagrada Familia, Barcelona", 41.4036, 2.1744);
        insertLocation(db, "Palace of Versailles, France", 48.8049, 2.1204);
        insertLocation(db, "Mount Fuji, Japan", 35.3606, 138.7274);
        insertLocation(db, "Alhambra, Spain", 37.1760, -3.5881);
        insertLocation(db, "Buckingham Palace, London", 51.5014, -0.1419);
        insertLocation(db, "Neuschwanstein Castle, Germany", 47.5576, 10.7498);
        insertLocation(db, "Temple of the Emerald Buddha, Thailand", 13.7500, 100.4913);
        insertLocation(db, "Forbidden City, Beijing", 39.9163, 116.3972);
        insertLocation(db, "Mount Kilimanjaro, Tanzania", -3.0674, 37.3556);
        insertLocation(db, "Blue Lagoon, Iceland", 63.8804, -22.4495);
        insertLocation(db, "Hawaii Volcanoes National Park, Hawaii", 19.4194, -155.2886);
        insertLocation(db, "Mont Saint-Michel, France", 48.6361, -1.5115);
        insertLocation(db, "Table Mountain, South Africa", -33.9628, 18.4098);
        insertLocation(db, "Louvre Museum, Paris", 48.8606, 2.3376);
        insertLocation(db, "Tower of London, England", 51.5081, -0.0759);
        insertLocation(db, "Gyeongbokgung Palace, South Korea", 37.5796, 126.9770);
        insertLocation(db, "Red Square, Moscow", 55.7539, 37.6208);
        insertLocation(db, "Mecca, Saudi Arabia", 21.4225, 39.8262);
        insertLocation(db, "Times Square, New York", 40.7580, -73.9855);
        insertLocation(db, "Central Park, New York", 40.7851, -73.9683);
        insertLocation(db, "Hollywood Sign, Los Angeles", 34.1341, -118.3215);
        insertLocation(db, "Las Vegas Strip, USA", 36.1147, -115.1728);
        insertLocation(db, "Bali, Indonesia", -8.3405, 115.0920);
        insertLocation(db, "Matterhorn, Switzerland", 45.9763, 7.6586);
        insertLocation(db, "Great Barrier Reef, Australia", -18.2871, 147.6992);
        insertLocation(db, "Plitvice Lakes National Park, Croatia", 44.8654, 15.5820);
        insertLocation(db, "Cliffs of Moher, Ireland", 52.9715, -9.4309);
        insertLocation(db, "Salar de Uyuni, Bolivia", -20.1338, -67.4891);
        insertLocation(db, "Lake Louise, Canada", 51.4254, -116.1773);
        insertLocation(db, "Auschwitz-Birkenau, Poland", 50.0356, 19.1784);
        insertLocation(db, "Mount Rushmore, USA", 43.8791, -103.4591);
        insertLocation(db, "Yosemite National Park, USA", 37.8651, -119.5383);
        insertLocation(db, "Galápagos Islands, Ecuador", -0.9538, -90.9656);
        insertLocation(db, "Lake Baikal, Russia", 53.5587, 108.1650);
        insertLocation(db, "Swiss Alps, Switzerland", 46.8876, 9.6577);
        insertLocation(db, "Medina, Saudi Arabia", 24.5247, 39.5692);
        insertLocation(db, "Dead Sea, Israel/Jordan", 31.5590, 35.4732);
        insertLocation(db, "Tulum, Mexico", 20.2115, -87.4657);
        insertLocation(db, "St. Peter's Basilica, Vatican City", 41.9022, 12.4539);
        insertLocation(db, "Keukenhof Gardens, Netherlands", 52.2717, 4.5466);
        insertLocation(db, "Luxor Temple, Egypt", 25.6969, 32.6396);
        insertLocation(db, "Ban Gioc Waterfall, Vietnam", 22.8544, 106.7138);
        insertLocation(db, "Isle of Skye, Scotland", 57.5359, -6.2263);
        insertLocation(db, "Pamukkale, Turkey", 37.9165, 29.1187);
        insertLocation(db, "Mount Etna, Italy", 37.7510, 14.9934);
        insertLocation(db, "Pena Palace, Portugal", 38.7875, -9.3908);
        insertLocation(db, "Lake Bled, Slovenia", 46.3636, 14.0936);
        insertLocation(db, "Great Blue Hole, Belize", 17.3156, -87.5349);
        insertLocation(db, "Prague Castle, Czech Republic", 50.0909, 14.4005);
        insertLocation(db, "Cinque Terre, Italy", 44.1236, 9.7108);
        insertLocation(db, "Ha Long Bay, Vietnam", 20.9101, 107.1839);
        insertLocation(db, "Tokyo Tower, Japan", 35.6586, 139.7454);
        insertLocation(db, "Mosque-Cathedral of Córdoba, Spain", 37.8796, -4.7798);
        insertLocation(db, "Gullfoss, Iceland", 64.3275, -20.1218);
        insertLocation(db, "Mount Cook, New Zealand", -43.5950, 170.1410);
        insertLocation(db, "Tianmen Mountain, China", 29.0683, 110.4800);
        insertLocation(db, "Annapurna, Nepal", 28.5962, 83.8203);
        insertLocation(db, "Uluru, Australia", -25.3444, 131.0369);
        insertLocation(db, "Mount Roraima, Venezuela", 5.1430, -60.7630);
        insertLocation(db, "Himalayas, Asia", 27.9878, 86.9250);
        insertLocation(db, "Serengeti National Park, Tanzania", -2.3333, 34.8333);
        insertLocation(db, "Lake Titicaca, Peru/Bolivia", -15.7654, -69.5299);
        insertLocation(db, "Burj Al Arab, Dubai", 25.1412, 55.1853);
        insertLocation(db, "Old Faithful, Yellowstone, USA", 44.4605, -110.8281);
    }


    private void insertLocation(SQLiteDatabase db, String address, double latitude, double longitude) {
        ContentValues values = new ContentValues();
        values.put(COLUMN_ADDRESS, address);
        values.put(COLUMN_LATITUDE, latitude);
        values.put(COLUMN_LONGITUDE, longitude);
        db.insert(TABLE_LOCATIONS, null, values);
    }

    public boolean addLocation(String address, double latitude, double longitude) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ADDRESS, address);
        values.put(COLUMN_LATITUDE, latitude);
        values.put(COLUMN_LONGITUDE, longitude);

        long result = db.insert(TABLE_LOCATIONS, null, values);
        db.close();
        return result != -1;
    }

    public boolean updateLocation(int id, String address, double latitude, double longitude) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ADDRESS, address);
        values.put(COLUMN_LATITUDE, latitude);
        values.put(COLUMN_LONGITUDE, longitude);

        int rowsUpdated = db.update(TABLE_LOCATIONS, values, COLUMN_ID + "=?", new String[]{String.valueOf(id)});
        db.close();
        return rowsUpdated > 0;
    }

    public boolean deleteLocation(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        int rowsDeleted = db.delete(TABLE_LOCATIONS, COLUMN_ID + "=?", new String[]{String.valueOf(id)});
        db.close();
        return rowsDeleted > 0;
    }

    public Location getLocationById(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_LOCATIONS,
                new String[]{COLUMN_ID, COLUMN_ADDRESS, COLUMN_LATITUDE, COLUMN_LONGITUDE},
                COLUMN_ID + "=?",
                new String[]{String.valueOf(id)},
                null, null, null);

        if (cursor != null && cursor.moveToFirst()) {
            String address = cursor.getString(cursor.getColumnIndex(COLUMN_ADDRESS));
            double latitude = cursor.getDouble(cursor.getColumnIndex(COLUMN_LATITUDE));
            double longitude = cursor.getDouble(cursor.getColumnIndex(COLUMN_LONGITUDE));
            cursor.close();
            return new Location(id, address, latitude, longitude);
        } else {
            return null;
        }
    }

    public List<Location> getAllLocations() {
        List<Location> locations = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_LOCATIONS, null);

        if (cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(cursor.getColumnIndex(COLUMN_ID));
                String address = cursor.getString(cursor.getColumnIndex(COLUMN_ADDRESS));
                double latitude = cursor.getDouble(cursor.getColumnIndex(COLUMN_LATITUDE));
                double longitude = cursor.getDouble(cursor.getColumnIndex(COLUMN_LONGITUDE));
                locations.add(new Location(id, address, latitude, longitude));
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return locations;
    }

    public List<Location> searchLocationByAddress(String query) {
        List<Location> locations = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_LOCATIONS,
                new String[]{COLUMN_ID, COLUMN_ADDRESS, COLUMN_LATITUDE, COLUMN_LONGITUDE},
                COLUMN_ADDRESS + " LIKE ?",
                new String[]{"%" + query + "%"},
                null, null, null);

        if (cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(cursor.getColumnIndex(COLUMN_ID));
                String address = cursor.getString(cursor.getColumnIndex(COLUMN_ADDRESS));
                double latitude = cursor.getDouble(cursor.getColumnIndex(COLUMN_LATITUDE));
                double longitude = cursor.getDouble(cursor.getColumnIndex(COLUMN_LONGITUDE));
                locations.add(new Location(id, address, latitude, longitude));
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return locations;
    }
}
