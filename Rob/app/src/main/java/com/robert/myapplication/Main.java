package com.robert.myapplication;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SearchView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.robert.myapplication.adapter.ItemAdapter;
import com.robert.myapplication.item.RfidItem;
import com.robert.myapplication.network.Request;
import com.robert.myapplication.network.VolleyRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Robert
 * @date 20-Apr-15.
 */
public class Main extends ActionBarActivity implements ItemListFragment.Callbacks {
    private boolean mTwoPane;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_list);
        if (findViewById(R.id.item_detail_container) != null) {
            // The detail container view will be present only in the
            // large-screen layouts (res/values-large and
            // res/values-sw600dp). If this view is present, then the
            // activity should be in two-pane mode.
            mTwoPane = true;

            // In two-pane mode, list items should be given the
            // 'activated' state when touched.
            ((ItemListFragment) getSupportFragmentManager()
                    .findFragmentById(R.id.item_list))
                    .setActivateOnItemClick(true);
        }
        fragment = ((ItemListFragment) getSupportFragmentManager().findFragmentById(R.id.item_list));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);

        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView = (SearchView) menu.findItem(R.id.search_field).getActionView();
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        searchView.setIconifiedByDefault(false);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                itemListFragmentRefresh(RfidItem.RequestType.Query, query);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

        return true;
    }

    private void refresh(List<RfidItem> items) {
        fragment.setListAdapter(new ItemAdapter(this, R.layout.item, items));
        ((ItemAdapter)fragment.getListAdapter()).notifyDataSetChanged();
    }

    private ItemListFragment fragment;

    private void itemListFragmentRefresh(RfidItem.RequestType type, String query) {
        ItemListFragment.Query = query;
        ItemListFragment.RequestType = type;
        String address;

        if (!query.equals("")) {
            address = Request.createAddress(query);
        } else {
            address = Request.createAddress(type);
        }

        JsonObjectRequest request = new JsonObjectRequest(
                com.android.volley.Request.Method.GET,
                address,
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            RfidItem.Item_Map.clear();
                            JSONArray upcDescriptions = response.getJSONArray("upc_descriptions");
                            for(int i = 0; i < upcDescriptions.length(); i++) {
                                RfidItem rfidItem = new RfidItem(upcDescriptions.getJSONObject(i));
                                RfidItem.Item_Map.put("item_id" + Integer.toString(i), rfidItem);
                            }
                            List<RfidItem> items = new ArrayList<>(RfidItem.Item_Map.values());
                            refresh(items);
                        }
                        catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        error.printStackTrace();
                    }
                }
        );
        VolleyRequest.getInstance(this).addToRequestQueue(request);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        switch (item.getItemId()) {
            case R.id.search_field:
                //search();
            case R.id.action_settings:
                return true;
            case R.id.Featured:
                itemListFragmentRefresh(RfidItem.RequestType.Featured, "");
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemSelected(String id) {
        if (mTwoPane) {
            // In two-pane mode, show the detail view in this activity by
            // adding or replacing the detail fragment using a
            // fragment transaction.
            Bundle arguments = new Bundle();
            arguments.putString(ItemDetailFragment.ARG_ITEM_ID, id);
            ItemDetailFragment fragment = new ItemDetailFragment();
            fragment.setArguments(arguments);
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.item_detail_container, fragment)
                    .commit();

        } else {
            // In single-pane mode, simply start the detail activity
            // for the selected item ID.
            Intent detailIntent = new Intent(this, ItemDetailActivity.class);
            detailIntent.putExtra(ItemDetailFragment.ARG_ITEM_ID, id);
            startActivity(detailIntent);
        }
    }
}
