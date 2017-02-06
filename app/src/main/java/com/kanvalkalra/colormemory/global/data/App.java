package com.kanvalkalra.colormemory.global.data;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

import com.kanvalkalra.colormemory.db.DaoMaster;
import com.kanvalkalra.colormemory.db.DaoSession;

/**
 * Created by kanvalkalra on 6/2/17.
 */

public class App extends Application {

    private DaoSession daoSession;

    @Override
    public void onCreate() {
        super.onCreate();
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, "score-board.db", null);
        SQLiteDatabase sqLiteDatabase = helper.getWritableDatabase();
        daoSession = new DaoMaster(sqLiteDatabase).newSession();
    }

    public DaoSession getDaoSession() {
        return daoSession;
    }
}
