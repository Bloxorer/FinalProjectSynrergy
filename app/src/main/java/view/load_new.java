package view;

import static android.content.Intent.FLAG_ACTIVITY_CLEAR_TOP;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.finalprojectsynrergy.R;
import com.google.android.material.snackbar.Snackbar;

import java.io.FileNotFoundException;
import java.io.InputStream;


import viewmodel.DatabaseHelper;

public class load_new extends AppCompatActivity {
    private ImageButton back;
    private EditText name_edit;
    private ImageButton yep;
    private EditText edit_number;
    private String name;
    private String number;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load_new);
        back = findViewById(R.id.back_load_new);
        name_edit = findViewById(R.id.editname);
        yep = findViewById(R.id.yep);
        edit_number = findViewById(R.id.edit_number);

        name = name_edit.getText().toString();
        number = edit_number.getText().toString();

        back.setOnClickListener(backlist);

        yep.setOnClickListener(yep_listen);
    }
    private View.OnClickListener yep_listen = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (!TextUtils.isEmpty(name_edit.getText().toString()) && !TextUtils.isEmpty(edit_number.getText().toString())){

                DatabaseHelper database = new DatabaseHelper(load_new.this); // создание объекта БД в текущей активности
                database.addNotes(name_edit.getText().toString(), edit_number.getText().toString()); // создание записи в БД

                // создание намерения переключения активности
                Intent intent = new Intent(load_new.this, list_of_bottles.class); // переключение обратно в активность демонстрации всех записей
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK); // установления флага экономии ресурсов
                startActivity(intent);

                finish(); // при нажатии на кнопку назад действие уничтожается и проиходит переход в активность SecondActivity

            } else { // иначе просто тост об отсутствии изменений
                Toast.makeText(load_new.this, "Необходимо заполнить оба поля", Toast.LENGTH_SHORT).show();
            }
    }};
    private View.OnClickListener backlist = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            Intent back_intent = new Intent(getApplicationContext(), MainActivity.class);
            back_intent.addFlags(FLAG_ACTIVITY_CLEAR_TOP);

            startActivity(back_intent);

        }
    };


}
