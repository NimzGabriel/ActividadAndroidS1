package g.gomez.actividadandroids1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

import g.gomez.actividadandroids1.adapters.RecetaAdapter;
import g.gomez.actividadandroids1.classes.RecetaPizza;

public class ListActivity extends AppCompatActivity {

    RecyclerView recycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        recycler = findViewById(R.id.recyclerReceta);
        recycler.setLayoutManager(new LinearLayoutManager(this));
        RecetaAdapter adapter = new RecetaAdapter(FormActivity.recetasArrayList);
        recycler.setAdapter(adapter);
    }


}