package edu.auburn.rfid.rfind;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.SearchView;

import java.util.ArrayList;

public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        searchSetup();
        ArrayList<RfidItem> items = RfidItems.getInstance().getItems(RfidItems.RequestType.Featured, "");
        gridViewSetup(items);
    }

    private void searchSetup() {
        Intent intent = getIntent();
        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
            String query = intent.getStringExtra(SearchManager.QUERY);
            doMySearch(query);
        }
    }

    private void doMySearch(String query) {
        ArrayList<RfidItem> items = RfidItems.getInstance().getItems(RfidItems.RequestType.Query, query);
        gridViewSetup(items);
    }

    private void gridViewSetup(ArrayList<RfidItem> items) {
        GridView upc_description_gridview = (GridView) findViewById(R.id.Upc_Descriptions_Grid);
        upc_description_gridview.setAdapter(new ItemAdapter(this, items));

        upc_description_gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ItemClickBridge.setCurrentItem(parent.getItemAtPosition(position));

                startActivity(new Intent(view.getContext(), DisplayProductActivity.class));
            }
        });
        ViewGroup vg = (ViewGroup) findViewById(R.id.linearLayout);
        vg.invalidate();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);

        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView = (SearchView) menu.findItem(R.id.action_search).getActionView();
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        searchView.setIconifiedByDefault(false);
        searchView.setSubmitButtonEnabled(true);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        if (id == R.id.Featured) {
            ArrayList<RfidItem> items = RfidItems.getInstance().getItems(RfidItems.RequestType.Featured, "");
            gridViewSetup(items);
        }

        return super.onOptionsItemSelected(item);
    }

}
