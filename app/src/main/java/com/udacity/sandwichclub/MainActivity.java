package com.udacity.sandwichclub;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    //Itt állítom be, hogy activity_main.xml kapcsolódjon ehhez az osztályhoz.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
        * Egy új sandwiches elnevezésűt String tömböt hozok létre, melyhez hozzárendelem a sandwiches_names
        * array-t a strings xml-ből.
        * Egy új ArrayAdaptert hozok létre, majd feltöltöm a sandwiches adatait a ListView-ba, és hozzákapcsolom
        * az adaptert.
        * */
        String[] sandwiches = getResources().getStringArray(R.array.sandwich_names);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, sandwiches);

        // Simplification: Using a ListView instead of a RecyclerView
        ListView listView = findViewById(R.id.sandwiches_listview);
        listView.setAdapter(adapter);

        /*Beállítok egy onclicklistenert, mely az egyes elemekre kattintva elindítja
        * a detail activityt.
        * Rákattintáskor az onItemClick beveszi a "position"-t, amit aztán a launchDetailActivity
        * paraméterként bevesz, majd. az intent.putExtra-val átadja a DetailActivity-nek.
        * */

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                launchDetailActivity(position);
            }
        });
    }

    private void launchDetailActivity(int position) {
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra(DetailActivity.EXTRA_POSITION, position);
        startActivity(intent);
    }
}
