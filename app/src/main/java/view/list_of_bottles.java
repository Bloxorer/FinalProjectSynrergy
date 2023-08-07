package view;

import static android.content.Intent.FLAG_ACTIVITY_CLEAR_TOP;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.helper.widget.Carousel;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ImageButton;

import com.example.finalprojectsynrergy.R;

import java.util.ArrayList;
import java.util.List;

import model.Bottles;
import viewmodel.BottleAdapter;
import view.load_new;
import viewmodel.DatabaseHelper;

public class list_of_bottles extends AppCompatActivity {
    private ImageButton back;
    private RecyclerView recyclerView;
    private Bottles bottles;
    List<Bottles> bottles_list = new ArrayList<Bottles>();

    DatabaseHelper database;
    private BottleAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_of_bottles);
        back = findViewById(R.id.backlist);
        recyclerView = findViewById(R.id.listBottles);
        database = new DatabaseHelper(this);
        allBottles();
        back.setOnClickListener(backlist);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new BottleAdapter(this, bottles_list);
        recyclerView.setAdapter(adapter);

    }
    private View.OnClickListener backlist = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent back_intent = new Intent(getApplicationContext(), MainActivity.class);
            back_intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(back_intent);


        }
    };

    public void allBottles(){

        Cursor cursor = database.readNotes();

        while (cursor.moveToNext()){
            bottles_list.add(new Bottles(cursor.getString(1), cursor.getString(2)));
        }
    }


}