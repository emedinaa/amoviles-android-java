package com.emedinaa.myfirstapp.storage.network;

import com.emedinaa.myfirstapp.BuildConfig;
import com.emedinaa.myfirstapp.model.UserEntity;
import com.emedinaa.myfirstapp.storage.network.entity.LogInRaw;
import com.emedinaa.myfirstapp.storage.network.entity.LogInResponse;
import com.emedinaa.myfirstapp.storage.network.entity.NoteRaw;
import com.emedinaa.myfirstapp.storage.network.entity.NoteResponse;
import com.emedinaa.myfirstapp.storage.network.entity.NotesResponse;
import com.emedinaa.myfirstapp.storage.network.entity.UserRaw;
import com.emedinaa.myfirstapp.storage.network.entity.UsersResponse;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;


/**
 * Created by em on 8/06/16.
 */
public class ApiClient {

    private static final String TAG = "ApiClient";
    //private static final String API_BASE_URL="https://obscure-earth-55790.herokuapp.com";

    private static ServicesApiInterface servicesApiInterface;
    private static OkHttpClient.Builder httpClient;


    public static ServicesApiInterface getMyApiClient() {

        if (servicesApiInterface == null) {

            Retrofit.Builder builder =new Retrofit.Builder()
                    .baseUrl(BuildConfig.HOST)//.baseUrl(API_BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create());
            httpClient =new OkHttpClient.Builder();
            httpClient.addInterceptor(interceptor());

            Retrofit retrofit = builder.client(httpClient.build()).build();
            servicesApiInterface = retrofit.create(ServicesApiInterface.class);
        }
        return servicesApiInterface;
    }

    public interface ServicesApiInterface {

        //https://obscure-earth-55790.herokuapp.com/api/login
        @POST("/api/login")
        Call<LogInResponse> login(@Body LogInRaw raw);

        //https://obscure-earth-55790.herokuapp.com/api/users/register
        @POST("/api/users/register")
        Call<UserEntity> register(@Body UserRaw raw);

        //https://obscure-earth-55790.herokuapp.com/api/users
        @GET("/api/users/")
        Call<UsersResponse> users();

        //https://obscure-earth-55790.herokuapp.com/api/notes
        @GET("/api/notes")
        Call<NotesResponse> notes();

        @POST("/api/notes/register")
        Call<NoteResponse> addNote(@Body NoteRaw raw);

        //update
        @PUT("/api/notes/{id}")
        Call<NoteResponse> updateNote(@Path("id") String noteId, @Body NoteRaw raw);

        //delete
        @DELETE("/api/notes/{id}")
        Call<NoteResponse> deleteNote(@Path("id") String noteId);

        /*
        //v1/data/Notes
        @GET("/v1/data/Notes")
        Call<NotesResponse> notes();


        @Headers({
                "Content-Type: application/json",
                "application-id: B9D12B47-6B88-8471-FFAD-2B4FFD1EA100",
                "secret-key: 46C1AEC7-6BA7-D1C7-FF6A-FD9EA95C0C00",
                "application-type: REST"
        })
        @POST("/v1/data/Notes")
        Call<NotesResponse> addNote(@Body NoteRaw raw);*/

    }

    /*private static OkHttpClient.Builder client(){
        if(httpClient==null)httpClient=new OkHttpClient.Builder();
        return httpClient;
    }*/
    private  static  HttpLoggingInterceptor interceptor(){
        HttpLoggingInterceptor httpLoggingInterceptor= new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        //httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.HEADERS);
        return httpLoggingInterceptor;
    }
}
