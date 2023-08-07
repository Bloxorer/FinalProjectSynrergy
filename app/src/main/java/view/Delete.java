package view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.finalprojectsynrergy.R;

import viewmodel.DatabaseHelper;

public class Delete extends AppCompatActivity {
    private EditText id_edit;
    private Button OK;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);
        OK = findViewById(R.id.OK);
        id_edit = findViewById(R.id.id_edit);

        OK.setOnClickListener(ok_listener);

    }

    View.OnClickListener ok_listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            DatabaseHelper databaseHelper = new DatabaseHelper(Delete.this);
            databaseHelper.deleteSingleItem(id_edit.getText().toString());
            Intent intent = new Intent(getApplicationContext(), list_of_bottles.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }
    };

}