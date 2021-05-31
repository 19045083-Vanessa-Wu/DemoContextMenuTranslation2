package sg.edu.rp.c346.id19045083.democontextmenutranslation2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tvTranslatedText;
    TextView tvTranslatedText2;
    String wordClicked = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvTranslatedText = findViewById(R.id.textViewTranslatedText);
        registerForContextMenu(tvTranslatedText);

        tvTranslatedText2 = findViewById(R.id.textViewTranslatedText2);
        registerForContextMenu(tvTranslatedText2);
    }

    @Override
    public void onCreateContextMenu (ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        getMenuInflater().inflate(R.menu.menu_main, menu);

        if (v == tvTranslatedText){
            wordClicked = "hello";
        } else if (v == tvTranslatedText2) {
            wordClicked = "bye";
        }
    }

    @Override
    public boolean onContextItemSelected (MenuItem item) {
        int id = item.getItemId();

        if (wordClicked.equalsIgnoreCase("hello")) {
            if (id == R.id.EnglishSelection) {
                tvTranslatedText.setText(R.string.hello);
                return true;
            } else if (id == R.id.italianSelection) {
                tvTranslatedText.setText(R.string.ciao);
                return true;
            } else {
                tvTranslatedText.setText(R.string.errorTrans);
            }
        } else if (wordClicked.equalsIgnoreCase("bye")) {
            if (id == R.id.EnglishSelection) {
                tvTranslatedText2.setText(R.string.bye);
                return true;
            } else if (id == R.id.italianSelection) {
                tvTranslatedText2.setText(R.string.addio);
                return true;
            } else {
                tvTranslatedText2.setText(R.string.errorTrans);
            }
        }

        return super.onContextItemSelected(item);
    }
}