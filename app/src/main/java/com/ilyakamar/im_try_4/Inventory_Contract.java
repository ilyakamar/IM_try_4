package com.ilyakamar.im_try_4;

import android.provider.BaseColumns;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;

public class Inventory_Contract {// Inventory_Contract





    public Inventory_Contract() {// empty constructor
    }

    public static final class StockEntry implements BaseColumns {// StockEntry



        public static  final String TABLE_NAME = "stock";

        // COLUMNS
        public static final String _ID = BaseColumns._ID;
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_PRICE = "price";
        public static final String COLUMN_QUANTITY = "quantity";
        public static final String COLUMN_SUPPLIER_NAME = "supplier_name";
        public static final String COLUMN_SUPPLIER_PHONE = "supplier_phone";
        public static final String COLUMN_SUPPLIER_EMAIL = "supplier_email";
        public static final String COLUMN_IMAGE = "image";


        // CREATE TABLE
        public static final String CREATE_TABLE_STOCK = "CREATE TABLE " +
                Inventory_Contract.StockEntry.TABLE_NAME + "(" +
                Inventory_Contract.StockEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                Inventory_Contract.StockEntry.COLUMN_NAME + " TEXT NOT NULL," +
                Inventory_Contract.StockEntry.COLUMN_PRICE + " TEXT NOT NULL," +
                Inventory_Contract.StockEntry.COLUMN_QUANTITY + " INTEGER NOT NULL DEFAULT 0," +
                Inventory_Contract.StockEntry.COLUMN_SUPPLIER_NAME + " TEXT NOT NULL," +
                Inventory_Contract.StockEntry.COLUMN_SUPPLIER_PHONE + " TEXT NOT NULL," +
                Inventory_Contract.StockEntry.COLUMN_SUPPLIER_EMAIL + " TEXT NOT NULL," +
                StockEntry.COLUMN_IMAGE + " TEXT NOT NULL" + ");";
    }// end StockEntry
}// END
