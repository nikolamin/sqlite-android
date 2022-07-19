package io.requery.android.database.sqlite;

import androidx.annotation.NonNull;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;

public abstract class SQLiteOpenHelperProxyCallback extends SupportSQLiteOpenHelper.Callback {
    SupportSQLiteOpenHelper.Callback callback;

    /**
     * Creates a new Callback to get database lifecycle events.
     *
     * @param version The version for the database instance. See {@link #version}.
     */
    public SQLiteOpenHelperProxyCallback(SupportSQLiteOpenHelper.Callback callback) {
        super(callback.version);
        this.callback = callback;
    }

    @Override
    public void onConfigure(@NonNull SupportSQLiteDatabase db) {
        callback.onConfigure(db);
    }

    @Override
    public void onCreate(@NonNull SupportSQLiteDatabase db) {
        callback.onCreate(db);
    }

    @Override
    public void onUpgrade(@NonNull SupportSQLiteDatabase db, int oldVersion, int newVersion) {
        callback.onUpgrade(db,oldVersion,newVersion);
    }

    @Override
    public void onDowngrade(@NonNull SupportSQLiteDatabase db, int oldVersion, int newVersion) {
        callback.onDowngrade(db, oldVersion, newVersion);
    }

    @Override
    public void onOpen(SupportSQLiteDatabase db) {
        callback.onOpen(db);
    }

    @Override
    public void onCorruption(@NonNull SupportSQLiteDatabase db) {
        callback.onCorruption(db);
    }
}