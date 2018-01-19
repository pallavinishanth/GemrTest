package com.example.pallavinishanth.gemrtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import java.util.ArrayList;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.Response;
import retrofit2.Retrofit;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    final String ENDPOINT = "https://api.gemr.com/";

    private RecyclerView crecyclerView;
    private RecyclerView.Adapter cAdapter;
    private RecyclerView.LayoutManager clayoutManager;
    private final String LOG_TAG = MainActivity.class.getSimpleName();

    private Retrofit movieRetrofit = new Retrofit.Builder().baseUrl(ENDPOINT).
            addConverterFactory(GsonConverterFactory.create()).build();
    ClubRetrofit retrofitAPI = movieRetrofit.create(ClubRetrofit.class);
    ClubList clublist = new ClubList();

    ArrayList<Club> club_names = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

//        Log.v(LOG_TAG, "on create view.. ");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        crecyclerView = (RecyclerView) findViewById(R.id.club_recycler_view);
        crecyclerView.setHasFixedSize(true);
        // use a linear layout manager
        clayoutManager = new LinearLayoutManager(this);
        crecyclerView.setLayoutManager(clayoutManager);
        getClubNames();

    }

    public void getClubNames(){

//        Log.v(LOG_TAG, "Get Club names List");
        Call<ClubList> clubDataCall = retrofitAPI.CLUB_LIST_CALL();

        clubDataCall.enqueue(new Callback<ClubList>() {
            @Override
            public void onResponse(Call<ClubList> call, Response<ClubList> response) {

//                Log.v(LOG_TAG, "Club List Response is " + response.isSuccessful());
                club_names = response.body().getClubs();

//                for(Club cdata : club_names){
//
//                    Log.v(LOG_TAG, "Club Names" + cdata.getName());
//                }

                cAdapter = new ClubAdapter(getBaseContext(), club_names);
                crecyclerView.setAdapter(cAdapter);
            }

            @Override
            public void onFailure(Call<ClubList> call, Throwable t) {

                Log.v(LOG_TAG, "On Failure" + t.toString());
            }
        });
    }
}
