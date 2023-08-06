package view;

import static android.content.Intent.FLAG_ACTIVITY_CLEAR_TOP;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.finalprojectsynrergy.R;

public class list_of_bottles extends AppCompatActivity {
private ImageButton back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_of_bottles);
        back = findViewById(R.id.backlist);

        back.setOnClickListener(backlist);

    }
    private View.OnClickListener backlist = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent back_intent = new Intent(getApplicationContext(), MainActivity.class);
            back_intent.addFlags(FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(back_intent);
        }
    };

    private void setInitialData(){

    }

}