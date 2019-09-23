package Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "UserInfo.db";

    public DBHelper(Context context) {
        super(context,DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String SQL_CREATE_TABLE = "CREATE TABLE "+
                UsersMaster.Users.TABLE_NAME+" ("+
                UsersMaster.Users._ID+" INTEGER PRIMARY KEY,"+
                UsersMaster.Users.COLUMN_NAME_USERNAME+ " TEXT,"+
                UsersMaster.Users.COLUMN_NAME_PASSWORD+ " TEXT);";
        db.execSQL(SQL_CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public boolean addInfo(String userName, String password){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(UsersMaster.Users.COLUMN_NAME_USERNAME,userName);
        values.put(UsersMaster.Users.COLUMN_NAME_PASSWORD,password);

        long result = db.insert(UsersMaster.Users.TABLE_NAME,null,values);

        if (result > 0){
            return true;
        }else{
            return false;
        }
    }
}
