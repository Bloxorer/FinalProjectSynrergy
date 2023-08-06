package view;

import static android.content.Intent.FLAG_ACTIVITY_CLEAR_TOP;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.example.finalprojectsynrergy.R;

import java.io.FileNotFoundException;
import java.io.InputStream;

public class load_new extends AppCompatActivity {
    private ImageButton back;
    private EditText name_edit;
    private ImageButton add_image;
    private ImageButton yep;
    private final int Pick_image = 1;
    private ImageView pre_photo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load_new);
        back = findViewById(R.id.back_load_new);
        name_edit = findViewById(R.id.editname);
        add_image = findViewById(R.id.addImage_new);
        yep = findViewById(R.id.yep);
        pre_photo =findViewById(R.id.pre_image);

        back.setOnClickListener(backlist);
        add_image.setOnClickListener(add_Image);
    }
    private View.OnClickListener backlist = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent back_intent = new Intent(getApplicationContext(), MainActivity.class);
            back_intent.addFlags(FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(back_intent);
        }
    };

    private final View.OnClickListener add_Image = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
            photoPickerIntent.setType("image/*");
            startActivityForResult(photoPickerIntent, Pick_image);
        }
    };
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent imageReturnedIntent) {
        super.onActivityResult(requestCode, resultCode, imageReturnedIntent);

        switch(requestCode) {
            case Pick_image:
                if(resultCode == RESULT_OK){
                    try {
                        final Uri imageUri = imageReturnedIntent.getData();
                        final InputStream imageStream = getContentResolver().openInputStream(imageUri);
                        final Bitmap selectedImage = BitmapFactory.decodeStream(imageStream);
                        pre_photo.setImageBitmap(selectedImage);
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
}}}
