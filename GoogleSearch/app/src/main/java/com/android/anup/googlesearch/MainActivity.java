package com.android.anup.googlesearch;

import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText searchtxt;
    Button searchbutn;
    String usertext;
    Intent sintent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        searchbutn = (Button)findViewById(R.id.button);
         searchtxt= (EditText)findViewById(R.id.editText);
        searchbutn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                usertext = searchtxt.getText().toString();
                if (searchtxt.getText().toString().length() == 0) {

                    searchtxt.setError("Enter search keyword to begin search");
                    Toast.makeText(MainActivity.this, "Search field is empty, enter search keyword", Toast.LENGTH_SHORT).show();
                } else {
                    sintent = new Intent(Intent.ACTION_WEB_SEARCH);
                    sintent.putExtra(SearchManager.QUERY, usertext);
                    startActivity(sintent);
                    }
                }
        });
    }
}
