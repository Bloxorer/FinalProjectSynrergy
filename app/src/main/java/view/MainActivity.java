package view;

import static android.app.PendingIntent.getActivity;
import static android.content.Intent.FLAG_ACTIVITY_REORDER_TO_FRONT;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.net.Uri;

import com.example.finalprojectsynrergy.R;

public class MainActivity extends AppCompatActivity {
    //Созддаем переменные кнопок
    private Button close;
    private Button listbottles;
    private Button loadnew;
    private Button mapofshops;
    public int kill = 0;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // определяем кнопки
        close = findViewById(R.id.close);
        listbottles = findViewById(R.id.list_of_bottles);
        loadnew = findViewById(R.id.load_new);
        mapofshops = findViewById(R.id.map_of_shops);
        //устанавливаем листенеры
        close.setOnClickListener(close_button);
        listbottles.setOnClickListener(list_of_bottles);
        loadnew.setOnClickListener(load_new);
        mapofshops.setOnClickListener(map_of_shops);
    }
    // создаем листенеры
    private View.OnClickListener close_button = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            kill++;
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
            myWebLink.setData(Uri.parse("https://www.google.ru/maps/@55.7661831,37.729685,9.2z?entry=ttu"));
            startActivity(myWebLink);
        }
    };
}