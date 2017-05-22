package yazdaniscodelab.retrofit_restapi;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Yazdani on 5/22/2017.
 */

public interface FlowerService {

    @GET("/feeds/flowers.json")
    Call<List<Flower>> getallFlower();


}
