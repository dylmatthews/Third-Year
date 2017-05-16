package a15009851.dylanmatthews.lockstockbarrel;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

public class DbAdapter {
    public static final String KEY_TICKETID = "_id";
    public static final String KEY_NAME = "name";
    public static final String KEY_REPAIR = "repair";
    public static final String KEY_REPAIR_OTHER = "repair_other";
    public static final String KEY_NUMBER_ITEMS= "number_items";
    public static final String KEY_CELLPHONE = "num";
    public static final String KEY_DATE = "da";
 public static final String KEY_PRICE = "price";
    public static final String TAG = "DBAdapter";
    public final static String DATABASE_NAME = "repairs";
    public final static String DATABASE_TABLE = "tbl_repairs";
    public final static int DATABASE_VERSION = 1;

    public static  final String DATABASE_CREATE = "create table tbl_repairs(_id integer primary key autoincrement,da text not null, name text not null, " +
            "repair text not null, repair_other text not null, number_items text not null, num text not null, price text not null);";

    final Context context;
    DatabaseHelper DBHelper;
    SQLiteDatabase db;

    public DbAdapter(Context context) {
        this.context = context;
        DBHelper = new DatabaseHelper(context);
    }

    //Inner class for DB Helper
    private static class DatabaseHelper extends SQLiteOpenHelper
    {
        //Constructor
        DatabaseHelper(Context context)
        {
            super(context,DATABASE_NAME,null,DATABASE_VERSION);
        }
        //On Create method
        @Override
        public void onCreate(SQLiteDatabase db)
        { Log.i("shit ", "before db create "  );
            try
            {
                db.execSQL(DATABASE_CREATE);
                Log.i("shit ", "db create "  );
            }
            catch (SQLException e)
            {
                e.printStackTrace();
                Log.i("shit ", "catch db create "  );
            }
            Log.i("shit ", "after db create "  );
        }
        // Upgrade Method
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
        {
            Log.w(TAG,"Upgrading DB from version : "+ oldVersion+" to : "+newVersion+" Which will destroy all data on it ");
            db.execSQL("DROP TABLE IF EXISTS tbl_repairs");
            onCreate(db);
        }
    }
    // Open DB Connection
    public DbAdapter open ()throws SQLException
    {
        db = DBHelper.getWritableDatabase();
        return this;
    }
    //Close Connection
    public void close()
    {
        DBHelper.close();
    }

    public long insertRepair(String name, String repair, String repairOther, int numItems, String cellphone, String date ,String price )
    {
        Log.i("shit ", "before db create "  );
        try
        {
            db.execSQL(DATABASE_CREATE);
            Log.i("shit ", "db create "  );
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            Log.i("shit ", "catch db create "  );
        }
        Log.i("shit ", "after db create "  );
        ContentValues initialValues = new ContentValues();
        initialValues.put(KEY_NAME, name);
        initialValues.put(KEY_REPAIR,repair);
        initialValues.put(KEY_REPAIR_OTHER,repairOther);
        initialValues.put(KEY_NUMBER_ITEMS, numItems);
        initialValues.put(KEY_CELLPHONE, cellphone);
        initialValues.put(KEY_DATE, date);
        initialValues.put(KEY_PRICE,price);
        return db.insert(DATABASE_TABLE,null,initialValues);
    }

    public boolean deleteRepair(long rowId)
    {
        return db.delete(DATABASE_TABLE,KEY_TICKETID+"="+rowId,null)>0;
    }

    public Cursor getAllRepairs()
    {
        return db.query(DATABASE_TABLE,new String[] {KEY_TICKETID,KEY_NAME,KEY_REPAIR,KEY_REPAIR_OTHER,
                KEY_NUMBER_ITEMS,KEY_CELLPHONE, KEY_DATE,KEY_PRICE},null,null,null,null,null);
    }
    public Cursor getRepairDate(String date) throws SQLException
    {
        Cursor mCursor = db.query(DATABASE_TABLE,new String[] {KEY_TICKETID,KEY_NAME,KEY_REPAIR,KEY_REPAIR_OTHER,
                KEY_NUMBER_ITEMS,KEY_CELLPHONE, KEY_DATE,KEY_PRICE},  KEY_DATE+ "=" + "'"+ date+"'",null,null,null,null,null);



        if (mCursor!= null)
        {
            mCursor.moveToFirst();
        }
        return  mCursor;
    }

    public Cursor getRepairName(String name) throws SQLException
    {
        name = "'%" + name+ "%'";
        Cursor mCursor = db.query(DATABASE_TABLE,new String[] {KEY_TICKETID,KEY_NAME,KEY_REPAIR,KEY_REPAIR_OTHER,
                KEY_NUMBER_ITEMS,KEY_CELLPHONE, KEY_DATE,KEY_PRICE},  KEY_NAME+ " LIKE "+ name
                ,null,null,null,null,null);



        if (mCursor!= null)
        {
            mCursor.moveToFirst();
        }
        return  mCursor;
    }

    public Cursor getRepairTicket(long ticket) throws SQLException
    {
        Cursor mCursor = db.query(DATABASE_TABLE,new String[] {KEY_TICKETID,KEY_NAME,KEY_REPAIR,KEY_REPAIR_OTHER,
                        KEY_NUMBER_ITEMS,KEY_CELLPHONE, KEY_DATE,KEY_PRICE},  KEY_TICKETID+ " = "+ ticket
                ,null,null,null,null,null);



        if (mCursor!= null)
        {
            mCursor.moveToFirst();
        }
        return  mCursor;
    }
    public Cursor getRepairCellphoneNumber(String cellNum) throws SQLException
    {
        cellNum = "'%" + cellNum+ "%'";
        Cursor mCursor = db.query(DATABASE_TABLE,new String[] {KEY_TICKETID,KEY_NAME,KEY_REPAIR,KEY_REPAIR_OTHER,
                        KEY_NUMBER_ITEMS,KEY_CELLPHONE, KEY_DATE,KEY_PRICE},  KEY_CELLPHONE+ " LIKE "+ cellNum
                ,null,null,null,null,null);



        if (mCursor!= null)
        {
            mCursor.moveToFirst();
        }
        return  mCursor;
    }

    public boolean updateRepair(long RepairId, String name, String repair, String repairOther, String numItems, String cellphone, String date ,String price)
    {

        ContentValues initialValues = new ContentValues();
        initialValues.put(KEY_NAME, name);
        initialValues.put(KEY_REPAIR,repair);
        initialValues.put(KEY_REPAIR_OTHER,repairOther);
        initialValues.put(KEY_NUMBER_ITEMS, numItems);
        initialValues.put(KEY_CELLPHONE, cellphone);
        initialValues.put(KEY_DATE, date);
        initialValues.put(KEY_PRICE,price);
        return db.update(DATABASE_TABLE,initialValues,KEY_TICKETID+"="+RepairId,null)>0;
    }
}