package com.example.myapi;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.myapi.databinding.ActivityMainBinding;
import com.example.myapi.model.Model;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    Model model;
    ActivityMainBinding mainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

         mainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main);

         model = new Model("   Id : 1", "   Body : Ware are you", "   Title : Welcome");

         mainBinding.getData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                loccontry();




            }
        });


    }




    public void loccontry() {



        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create()).build();
        ApiInterface apiinterface = retrofit.create(ApiInterface.class);

        Call<Model> call = apiinterface.setpost(model);
        call.enqueue(new Callback<Model>() {
            @Override
            public void onResponse(Call<Model> call, Response<Model> response) {
               mainBinding.title.setText(response.body().getTitle());
               mainBinding.id.setText(response.body().getUserId());
                mainBinding.body.setText(response.body().getBody());



            }

            @Override
            public void onFailure(Call<Model> call, Throwable t) {
                mainBinding.title.setText("Error");

            }
        });
    }

}
