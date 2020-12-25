package com.example.architectureexample.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.architectureexample.R;

public class AddEditNoteActivity extends AppCompatActivity {

    public static final String EXTRA_ID =
            "com.example.architectureexample.EXTRA_ID";
    public static final String EXTRA_TITLE =
            "com.example.architectureexample.EXTRA_TITLE";
    public static final String EXTRA_DESCRIPTION =
            "com.example.architectureexample.EXTRA_DESCRIPTION";
    public static final String EXTRA_PRIORITY =
            "com.example.architectureexample.EXTRA_PRIORITY";
    public static final String EXTRA_IS_COMPOSITION =
            "com.example.architectureexample.EXTRA_IS_COMPOSITION";
    public static final String EXTRA_IS_SINGLE =
            "com.example.architectureexample.EXTRA_IS_SINGLE";
    public static final String EXTRA_ALBUM_ID =
            "com.example.architectureexample.ALBUM_ID";
    public static final String EXTRA_DURATION =
            "com.example.architectureexample.EXTRA_DURATION";
    public static final String EXTRA_GENRE =
            "com.example.architectureexample.EXTRA_GENRE";
    public static final String EXTRA_GROUP =
            "com.example.architectureexample.EXTRA_GROUP";
    public static final String EXTRA_MUSICIAN =
            "com.example.architectureexample.EXTRA_MUSICIAN";
    public static final String EXTRA_PUBLIC =
            "com.example.architectureexample.EXTRA_PUBLIC";

    private EditText editTextTitle;
    private EditText editTextDescription;
    private NumberPicker numberPickerPriority;
    private EditText editTextGroup;
    private EditText editTextGenre;
    private EditText editTextMusician;
    private EditText editTextTypeOfPublic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);

        editTextTitle = findViewById(R.id.edit_text_title);
        editTextDescription = findViewById(R.id.edit_text_description);
        numberPickerPriority = findViewById(R.id.number_picker_priority);
        editTextGroup = findViewById(R.id.edit_text_group);
        editTextGenre = findViewById(R.id.edit_text_genre);
        editTextMusician = findViewById(R.id.edit_text_musician);
        editTextTypeOfPublic = findViewById(R.id.edit_text_public);

        numberPickerPriority.setMinValue(1);
        numberPickerPriority.setMaxValue(20);

        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_close);

        Intent intent = getIntent();

        if(intent.hasExtra(EXTRA_ID)) {
            setTitle("Edit Note");
            editTextTitle.setText(intent.getStringExtra(EXTRA_TITLE));
            editTextDescription.setText(intent.getStringExtra(EXTRA_DESCRIPTION));
            numberPickerPriority.setValue(intent.getIntExtra(EXTRA_PRIORITY, 1));
            editTextGroup.setText(intent.getStringExtra(EXTRA_GROUP));
            editTextGenre.setText(intent.getStringExtra(EXTRA_GENRE));
            editTextMusician.setText(intent.getStringExtra(EXTRA_MUSICIAN));
            editTextTypeOfPublic.setText(intent.getStringExtra(EXTRA_PUBLIC));
        } else {
            setTitle("Add Note");
        }

        setTitle("Add Note");
    }

    private void saveNote() {
        String title = editTextTitle.getText().toString();
        String description = editTextDescription.getText().toString();
        int priority = numberPickerPriority.getValue();
        String group = editTextGroup.getText().toString();
        String genre = editTextGenre.getText().toString();
        String musician = editTextMusician.getText().toString();
        String type_of_public = editTextTypeOfPublic.getText().toString();

        if(title.trim().isEmpty() || description.trim().isEmpty()) {
            Toast.makeText(this, "Please insert a title and description", Toast.LENGTH_SHORT).show();
            return;
        }

        Intent data = new Intent();
        data.putExtra(EXTRA_TITLE, title);
        data.putExtra(EXTRA_DESCRIPTION, description);
        data.putExtra(EXTRA_PRIORITY, priority);
        data.putExtra(EXTRA_GENRE, genre);
        data.putExtra(EXTRA_GROUP, group);
        data.putExtra(EXTRA_MUSICIAN, musician);
        data.putExtra(EXTRA_PUBLIC, type_of_public);

        int id = getIntent().getIntExtra(EXTRA_ID, -1);
        if(id != -1) {
            data.putExtra(EXTRA_ID, id);
        }

        setResult(RESULT_OK, data);
        finish();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.add_note_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.save_note:
                saveNote();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
