package example.spatch.act.delacourt;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.InputStream;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listView = (ListView) findViewById(R.id.list);
        final DelacourtMenuAdapter menuAdapter = new DelacourtMenuAdapter();
        listView.setAdapter(menuAdapter);
        List<DelacourtMenu> menus = getMenusFromServer(this);
        menuAdapter.setMenus(menus);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                DelacourtMenu menu = (DelacourtMenu) menuAdapter.getItem(position);
                Intent intent = new Intent(MainActivity.this, DelacourtMenuDetailActivity.class);
                intent.putExtra("item", menu);
                startActivity(intent);
            }
        });
    }

    public List<DelacourtMenu> getMenusFromServer(Context context) {
        return makeMenuListFromJson(context);
    }
    public List<DelacourtMenu> makeMenuListFromJson(Context context) {
        String jsonStr = "";
        try {
            InputStream jsonInputStream = context.getResources().openRawResource(R.raw.jamsilmenu);
            jsonStr = convertStreamToString(jsonInputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Gson gson = new Gson();
        return gson.fromJson(jsonStr, new TypeToken<List<DelacourtMenu>>(){}.getType());
    }

    private String convertStreamToString(final InputStream is) {
        java.util.Scanner s = new java.util.Scanner(is, "utf-8").useDelimiter("\\A");
        return s.hasNext() ? s.next() : "";
    }
}
