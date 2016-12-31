package like.sirvan.se.myjson;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.BaseAdapter;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Dateget> dategets = new ArrayList<>();
    private RecyclerView recyclerView;
    private Adapter adapter;
    private LinearLayoutManager llm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dategets.add(new Dateget("Id", "Locate"));

        recyclerView = (RecyclerView) findViewById(R.id.recycleView);
        llm = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(llm);
        recyclerView.setHasFixedSize(true);

        adapter = new Adapter(dategets);
        recyclerView.setAdapter(adapter);

        new getJson(this).execute();
    }

    public class getJson extends AsyncTask<Void, Void, String> {

        private Context context;
        private ProgressDialog progressDialog;

        public getJson(Context context) {
            this.context = context;
        }

        @Override
        protected void onPreExecute() {
           progressDialog = new ProgressDialog(MainActivity.this);
            progressDialog.setTitle("Please waite...");
            progressDialog.setCancelable(false);
            progressDialog.show();
        }

        @Override
        protected String doInBackground(Void... voids) {

            String Address = "http://likeco.ir/locatetest/toJson.php";
            return Utils.getData(Address);
        }

        @Override
        protected void onPostExecute(String jsonStr) {

            if (jsonStr != null) {


                try {

                    JSONArray jsonArray = new JSONArray(jsonStr);

                    for(int i=0; i<jsonArray.length();i++)
                    {

                        JSONObject c = jsonArray.getJSONObject(i);

                        String Id = c.getString("id_number");
                        String Locate = c.getString("Location");

                        dategets.add(new Dateget(Id, Locate));

                    }

                    adapter.addItem(dategets);


                } catch (Exception e) {
                    e.printStackTrace();
                    Toast.makeText(context, "dont run", Toast.LENGTH_LONG).show();
                }


            } else Toast.makeText(context, "Null Data", Toast.LENGTH_LONG).show();

                progressDialog.dismiss();
        }
    }
}
