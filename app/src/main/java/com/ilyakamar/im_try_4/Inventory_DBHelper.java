package com.ilyakamar.im_try_4;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;

public class Inventory_DBHelper extends SQLiteOpenHelper {

    // FB
    private FirebaseAuth mAuth;
    private DatabaseReference myRef;

    FirebaseUser user = mAuth.getInstance().getCurrentUser();
    public  String uniq_Key_fromMail = "table1"; // user.getEmail()


    private   String CREATE_TABLE_STOCK = "CREATE TABLE " +
            uniq_Key_fromMail + "(" +
            "_id" + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            "name" + " TEXT NOT NULL," +
            "price" + " TEXT NOT NULL," +
            "quantity" + " INTEGER NOT NULL DEFAULT 0," +
            "supplier_name" + " TEXT NOT NULL," +
            "supplier_phone" + " TEXT NOT NULL," +
            "supplier_email" + " TEXT NOT NULL," +
            "image" + " TEXT NOT NULL" + ");";



    private final static String DB_NAME = "inventory.db";
    private final static int DB_VERSION = 1;
    public final static String LOG_TAG = Inventory_DBHelper.class.getCanonicalName();

    public Inventory_DBHelper(Context context) {// constructor
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {// onCreate
       db.execSQL(Inventory_Contract.StockEntry.CREATE_TABLE_STOCK);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {// onUpgrade

    }// end onUpgrade

    public void insertItem(Inventory_Item item) { // insertItem
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(Inventory_Contract.StockEntry.COLUMN_NAME, item.getProductName());
        values.put(Inventory_Contract.StockEntry.COLUMN_PRICE, item.getPrice());
        values.put(Inventory_Contract.StockEntry.COLUMN_QUANTITY, item.getQuantity());
        values.put(Inventory_Contract.StockEntry.COLUMN_SUPPLIER_NAME, item.getSupplierName());
        values.put(Inventory_Contract.StockEntry.COLUMN_SUPPLIER_PHONE, item.getSupplierPhone());
        values.put(Inventory_Contract.StockEntry.COLUMN_SUPPLIER_EMAIL, item.getSupplierEmail());
        values.put(Inventory_Contract.StockEntry.COLUMN_IMAGE, item.getImage());
       long id = db.insert(Inventory_Contract.StockEntry.TABLE_NAME, null, values);

    }// end insertItem

    public Cursor readStock() {// readStock (f)
        SQLiteDatabase db = getReadableDatabase();

        String[] projection = {
                Inventory_Contract.StockEntry._ID,
                Inventory_Contract.StockEntry.COLUMN_NAME,
                Inventory_Contract.StockEntry.COLUMN_PRICE,
                Inventory_Contract.StockEntry.COLUMN_QUANTITY,
                Inventory_Contract.StockEntry.COLUMN_SUPPLIER_NAME,
                Inventory_Contract.StockEntry.COLUMN_SUPPLIER_PHONE,
                Inventory_Contract.StockEntry.COLUMN_SUPPLIER_EMAIL,
                Inventory_Contract.StockEntry.COLUMN_IMAGE
        };

        Cursor cursor = db.query(
              Inventory_Contract.StockEntry.TABLE_NAME,
                projection,
                null,
                null,
                null,
                null,
                null
        );
        return cursor;
    }// end readStock(F)


    public Cursor readItem(long itemId) {// (F)
        SQLiteDatabase db = getReadableDatabase();

        String[] projection = {
                Inventory_Contract.StockEntry._ID,
                Inventory_Contract.StockEntry.COLUMN_NAME,
                Inventory_Contract.StockEntry.COLUMN_PRICE,
                Inventory_Contract.StockEntry.COLUMN_QUANTITY,
                Inventory_Contract.StockEntry.COLUMN_SUPPLIER_NAME,
                Inventory_Contract.StockEntry.COLUMN_SUPPLIER_PHONE,
                Inventory_Contract.StockEntry.COLUMN_SUPPLIER_EMAIL,
                Inventory_Contract.StockEntry.COLUMN_IMAGE
        };

        String selection = Inventory_Contract.StockEntry._ID + "=?";
        String[] selectionArgs = new String[]{String.valueOf(itemId)};

        Cursor cursor = db.query(
             Inventory_Contract.StockEntry.TABLE_NAME,
                projection,
                selection,
                selectionArgs,
                null,
                null,
                null
        );
        return cursor;
    }// end readItem(f)

    public void updateItem(long currentItemId, int quantity) {// updateItem (f)
        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(Inventory_Contract.StockEntry.COLUMN_QUANTITY, quantity);
        String selection = Inventory_Contract.StockEntry._ID + "=?";
        String[] selectionArgs = new String[]{String.valueOf(currentItemId)};

        db.update(Inventory_Contract.StockEntry.TABLE_NAME,
                values, selection, selectionArgs);
    }// end updateItem(F)

    public void sellOneItem(long itemId, int quantity) {// sellOneItem (f)
        SQLiteDatabase db = getWritableDatabase();
        int newQuantity = 0;
        if (quantity > 0) {
            newQuantity = quantity - 1;
        }
        ContentValues values = new ContentValues();
        values.put(Inventory_Contract.StockEntry.COLUMN_QUANTITY, newQuantity);
        String selection = Inventory_Contract.StockEntry._ID + "=?";
        String[] selectionArgs = new String[]{String.valueOf(itemId)};
       db.update(Inventory_Contract.StockEntry.TABLE_NAME,
                values, selection, selectionArgs);
    }// end sellOneItem
}
