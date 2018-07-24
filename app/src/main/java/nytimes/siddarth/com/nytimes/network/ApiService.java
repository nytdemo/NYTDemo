package nytimes.siddarth.com.nytimes.network;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

    /**
     * @GET declares an HTTP GET request
     */
    @GET("7.json?api-key=6fbe275b04c1468e8b064f1e9353fd25")
    Call<BaseResponse> getUser();
}






