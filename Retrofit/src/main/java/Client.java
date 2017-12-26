import retrofit2.*;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.*;

import java.io.IOException;
import java.util.Arrays;

public class Client
{
    public static void main(String[] args) throws IOException
    {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://localhost:8080/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Service service = retrofit.create(Service.class);
        Response<String[]> response;

        response = service.get().execute();
        if (response.isSuccessful())
        {
            System.out.println("response:");
            Arrays.stream(response.body()).reduce(String::concat).ifPresent(System.out::println);
        }

        response = service.post(new String[]{"1", "2", "3"}).execute();
        if (response.isSuccessful())
        {
            System.out.println("post:");
            Arrays.stream(response.body()).reduce(String::concat).ifPresent(System.out::println);
        }

        response = service.redirect().execute();
        if (response.isSuccessful())
        {
            System.out.println("redirect:");
            Arrays.stream(response.body()).reduce(String::concat).ifPresent(System.out::println);
        }
    }

    public interface Service
    {
        @GET("get")
        Call<String[]> get();

        @POST("post")
        @FormUrlEncoded
        Call<String[]> post(@Field("strings") String[] strings);

        @GET("redirect")
        Call<String[]> redirect();
    }
}
