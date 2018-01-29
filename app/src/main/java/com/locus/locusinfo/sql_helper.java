package com.locus.locusinfo;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by pi on 1/28/18.
 */

public class sql_helper extends SQLiteOpenHelper {

    public String _dbname;
    public String _path;
    private Context context;


//    Table for the information
    public String TABLE_INFORMATION="_stall_info";

//    COLUMNS of TABLE
    public String COLUMN_STALL_ID="_id";
    public String COLUMN_STALL_NAME="_name";
    public String COLUMN_STALL_INFORMATION="_info";


    public sql_helper(Context context, String dbname) {
        super(context, dbname, null, 1);
        this.context=context;
        this._dbname=dbname;
        this._path= "/data/data/" + context.getPackageName() + "/databases/";
        try
        {
            importDatbase();
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public void onCreate(SQLiteDatabase db) {


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

//    Importing our existing database to system data folder.
    public void importDatbase() throws Exception
    {
        boolean _is_db=checkExist();
        if(_is_db==false)
        {
            getReadableDatabase();
            try
            {
                InputStream is=context.getAssets().open(_dbname);
                OutputStream _os=new FileOutputStream(_path+_dbname);
                byte[] buffer=new byte[4096];
                int length;
                while((length=is.read(buffer))>0)
                {
                    _os.write(buffer,0, length);
                }
                _os.flush();
                _os.close();
                is.close();
                this.close();
            }catch (Exception e)
            {
                throw new Error("Error copying Datbase");
            }

        }
    }

//    Check Existing database
    public boolean checkExist()
    {

        File dbFile = context.getDatabasePath(_dbname);
        return dbFile.exists();

    }


//    Query to get a database
    public stall_obj get_stall_info(String id)
    {
//        Crating a raw query to find a data
        String query="Select * from "+TABLE_INFORMATION+" where "+COLUMN_STALL_ID+"= \""+id+"\"";
        SQLiteDatabase db=getWritableDatabase();
        Cursor cursor=db.rawQuery(query,null);

        stall_obj _stall_obj=new stall_obj();
        if(cursor.moveToFirst())
        {
            cursor.moveToFirst();
            _stall_obj.set_id(cursor.getInt(0));
            _stall_obj.set_name(cursor.getString(1));
            _stall_obj.set_information(cursor.getString(2));
            cursor.close();

        }
        else
            _stall_obj=null;

        db.close();
        return _stall_obj;
    }

}
