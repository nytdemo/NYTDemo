package nytimes.siddarth.com.nytimes.network;

import java.io.IOException;

import nytimes.siddarth.com.nytimes.BuildConfig;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class ConnectionFactory {

    private static Retrofit.Builder retrofitBuilder = new Retrofit.Builder().baseUrl("http://api.nytimes.com/svc/mostpopular/v2/mostviewed/all-sections/")
            .addConverterFactory(JacksonConverterFactory.create());


    public static ApiService getHttpConnection() {


        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addNetworkInterceptor(new Interceptor() {
            @Override
            public Response intercept(Interceptor.Chain chain) throws IOException {
                Request request = chain.request().newBuilder()
                        .build();
                return chain.proceed(request);
            }
        });


        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();

        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        httpClient.interceptors().add(logging);


        Retrofit retrofit = retrofitBuilder.client(httpClient.build()).build();

        return retrofit.create(ApiService.class);
    }


}
