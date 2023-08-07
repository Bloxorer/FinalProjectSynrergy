package view;

import static android.app.PendingIntent.getActivity;
import static android.content.Intent.FLAG_ACTIVITY_REORDER_TO_FRONT;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.net.Uri;

import com.example.finalprojectsynrergy.R;

import viewmodel.DatabaseHelper;


public class MainActivity extends AppCompatActivity {
    //Созддаем переменные кнопок
    private Button close;
    private Button listbottles;
    private Button loadnew;
    private Button mapofshops;
    private Button clear;
    DatabaseHelper database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // определяем кнопки
        close = findViewById(R.id.close);
        listbottles = findViewById(R.id.list_of_bottles);
        loadnew = findViewById(R.id.load_new);
        mapofshops = findViewById(R.id.map_of_shops);
        clear = findViewById(R.id.clear);
        //устанавливаем листенеры
        close.setOnClickListener(close_button);
        listbottles.setOnClickListener(list_of_bottles);
        loadnew.setOnClickListener(load_new);
        mapofshops.setOnClickListener(map_of_shops);
        clear.setOnClickListener(clear_listener);
    }
    // создаем листенеры
    private View.OnClickListener close_button = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            finish();
        }
    };
    private View.OnClickListener list_of_bottles = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent list_of_bottles_intent = new Intent(getApplicationContext(), list_of_bottles.class);
            list_of_bottles_intent.addFlags(FLAG_ACTIVITY_REORDER_TO_FRONT);
            startActivity(list_of_bottles_intent);
        }
    };
    private View.OnClickListener load_new = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent load_new_intent = new Intent(getApplicationContext(), load_new.class);
            load_new_intent.addFlags(FLAG_ACTIVITY_REORDER_TO_FRONT);
            startActivity(load_new_intent);
        }
    };
    private View.OnClickListener map_of_shops = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent myWebLink = new Intent(android.content.Intent.ACTION_VIEW);
            myWebLink.setData(Uri.parse("https://yandex.ru/maps/213/moscow/category/alcoholic_beverage_store/184107899/?ll=37.713732%2C55.724401&sctx=ZAAAAAgBEAAaKAoSCZFigEQTCENAEfhSeNDs1ktAEhIJGw%2B22O1TBkARczCbAMPy7z8iBgABAgMEBSgKOABAAUgBYhJsZXRvX3ZfZ29yb2RlPXRydWVqAnJ1nQHNzEw9oAEAqAEAvQFGWixpwgGNAfv1jbmGAsvoroeVBevi06wFkPDTz%2BgDr927yKEEtZ%2BP2Ab5r83ujAf62uv3Bf68yb37BbK0hoQEtKPey%2F4F0NDMwwb2%2F9DU%2FAHYwJmSBIG1%2B%2FESgqmynsQF6p%2BExOMClfi7zwTLqN2n2Ab9zLjMhwSu8MWj9gTk9o60J82r07fTBpPQ3dSRBvPor5zzA%2BoBAPIBAPgBAIICGygoY2F0ZWdvcnlfaWQ6KDE4NDEwNzg5OSkpKYoCCTE4NDEwNzg5OZICAJoCDGRlc2t0b3AtbWFwc6oC5wEyMjE4ODQ4MzYxNSwxOTI2MTc2NDY2NjQsNDc3MjE0ODk0NjEsMzc0Njg0NzI5OCw2OTUxODk1NzY2MSw2ODE0MjA4MDAzNCw2MDAzNDY5LDI2MDM0ODYwNDQsMjg2MDM3NzI3MiwxMDQyNzU5Mjk0NzUsNTQ5NzU1NDkyODYsODU1ODg3MDMyODMsMTQxOTc5OTE4MDI0LDIzMzgyOTcyNDUzMiw2MDAzMjA2LDEzODYwNTA3MTc3OCw2OTMzMTk1NTUxOSw4NzA3NjgxMDA1LDY3OTQ4MTg0MjAxLDM2MzQ1NTA0MTE%3D&sll=37.713732%2C55.724401&source=serp_navig&sspn=0.986761%2C0.352567&z=10.55"));
            startActivity(myWebLink);
        }
    };
    private View.OnClickListener clear_listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            database = new DatabaseHelper(MainActivity.this);
            database.deleteAllNotes();
        }
    };
}