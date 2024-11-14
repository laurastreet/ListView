package edu.gmu.cs477.listview1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText elem;
    ListView listView;
    ArrayAdapter myAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.mylist);

        // Param1 - context
        // Param2 - layout for the row

        myAdapter = new ArrayAdapter<String>(this, R.layout.line);

        listView.setAdapter(myAdapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), "Item " + ((TextView) view).getText(), Toast.LENGTH_SHORT).show();
            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
                                                public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                                                    Toast.makeText(getApplicationContext(), "Removing " + ((TextView) view).getText(), Toast.LENGTH_SHORT).show();
                                                    myAdapter.remove(myAdapter.getItem(position));
                                                    return true;
                                                }
                                            }
        );
        elem =  (EditText)findViewById(R.id.input);

    }

    public void clearEdit(View v) {
        myAdapter.clear();
    }

    public void addElem(View v) {
        String input = elem.getText().toString();
        myAdapter.add(input);
        Toast.makeText(getApplicationContext(), "Adding " + input, Toast.LENGTH_SHORT).show();
        elem.setText("");

    }
}
