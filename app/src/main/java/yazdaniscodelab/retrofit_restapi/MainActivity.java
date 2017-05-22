package yazdaniscodelab.retrofit_restapi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    private RestManager mrestManager;

    private FlowerAdapter mFlowerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CreateView();

        mrestManager =new RestManager();

        Call<List<Flower>>listCall=mrestManager.getmFlowerService().getallFlower();

        listCall.enqueue(new Callback<List<Flower>>() {
            @Override
            public void onResponse(Call<List<Flower>> call, Response<List<Flower>> response) {

                if (response.isSuccessful()){

                    List<Flower> flowers=response.body();

                    for (int i=0;i<flowers.size();i++){
                        Flower mflower=flowers.get(i);
                        mFlowerAdapter.addFlower(mflower);
                    }
                }
            }

            @Override
            public void onFailure(Call<List<Flower>> call, Throwable t) {

            }
        });
    }


    public void CreateView(){

        recyclerView=(RecyclerView)findViewById(R.id.recycler_xml);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false));
        mFlowerAdapter=new FlowerAdapter();
        recyclerView.setAdapter(mFlowerAdapter);
    }
}
