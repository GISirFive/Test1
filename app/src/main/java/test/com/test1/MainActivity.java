package test.com.test1;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {


    @Bind(R.id.textview1)
    TextView textview1;
    @Bind(R.id.button1)
    Button button1;
    @Bind(R.id.textview2)
    TextView textview2;
    @Bind(R.id.button2)
    Button button2;
    @Bind(R.id.textview3)
    TextView textview3;
    @Bind(R.id.button3)
    Button button3;
    @Bind(R.id.textview4)
    TextView textview4;
    @Bind(R.id.button4)
    Button button4;

    private ContentResolver mContentResolver;
    private Uri mUri = Uri.parse("content://com.telchina.gisirfive/");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mContentResolver = getContentResolver();

    }

    @OnClick({R.id.button1, R.id.button2, R.id.button3, R.id.button4})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button1:
                query();;
                break;
            case R.id.button2:
                insert();
                break;
            case R.id.button3:
                update();
                break;
            case R.id.button4:
                delete();
                break;
        }
    }

    private void query() {
        Cursor cursor = mContentResolver.query(mUri, null, null, null, null);
        Toast.makeText(this, "远程ContentProvider返回的Cursor为" + cursor, Toast.LENGTH_SHORT).show();
    }

    private void insert() {
        ContentValues values = new ContentValues();
        values.put("key1", "value1");
        Uri uri = mContentResolver.insert(mUri, values);
        Toast.makeText(this, "远程ContentProvider返回的uri为" + uri, Toast.LENGTH_SHORT).show();
    }

    private void update() {
        ContentValues values = new ContentValues();
        values.put("key1", "value1");
        int count = mContentResolver.update(mUri, values, null, null);
        Toast.makeText(this, "远程ContentProvider返回的uri为" + count, Toast.LENGTH_SHORT).show();

    }

    private void delete() {
        int count = mContentResolver.delete(mUri, null, null);
        Toast.makeText(this, "远程ContentProvider返回的uri为" + count, Toast.LENGTH_SHORT).show();

    }
}
