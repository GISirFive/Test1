package test.com;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by Administrator on 2016-3-10.
 */
public class FirstProvider extends ContentProvider{

    @Override
    public boolean onCreate() {
        Log.d("FirstProvider", "onCreate");
        return false;
    }

    @Nullable
    @Override
    public Cursor query(Uri uri, String[] strings, String s, String[] strings1, String s1) {
        Log.d("FirstProvider", "query");
        return null;
    }

    @Nullable
    @Override
    public String getType(Uri uri) {
        Log.d("FirstProvider", "getType");
        return null;
    }

    @Nullable
    @Override
    public Uri insert(Uri uri, ContentValues contentValues) {
        Log.d("FirsProvider", "insert");
        return null;
    }

    @Override
    public int delete(Uri uri, String s, String[] strings) {
        Log.d("FirstProvider", "delete");
        return 0;
    }

    @Override
    public int update(Uri uri, ContentValues contentValues, String s, String[] strings) {
        Log.d("FirstProvider", "update");
        return 0;
    }
}
