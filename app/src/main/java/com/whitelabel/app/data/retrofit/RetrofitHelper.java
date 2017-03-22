package com.whitelabel.app.data.retrofit;
import android.text.TextUtils;
import com.whitelabel.app.GlobalData;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import okhttp3.Credentials;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Route;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
/**
 * Created by Administrator on 2017/1/3.
 */
public class RetrofitHelper {
    public static Retrofit  getDefaultRetrofit(){
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(GlobalData.serviceRequestUrl)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(getOkHttpClient())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit;
    }
    private static OkHttpClient  getOkHttpClient(){
        final OkHttpClient.Builder builder = new OkHttpClient.Builder();
            HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            builder.addInterceptor(loggingInterceptor);
//        builder.addInterceptor(new BaseInterceptor());
        if(!TextUtils.isEmpty(GlobalData.authName)&&!TextUtils.isEmpty(GlobalData.authPwd)){
            builder.authenticator(new okhttp3.Authenticator() {
                @Override
                public Request authenticate(Route route, okhttp3.Response response) throws IOException {
                    String credential = Credentials.basic(GlobalData.authName, GlobalData.authPwd);
                    return response.request().newBuilder().header("Authorization", credential).build();
                }
            });
        }
        builder.connectTimeout(30, TimeUnit.SECONDS);
        builder.readTimeout(30, TimeUnit.SECONDS);
        builder.writeTimeout(30, TimeUnit.SECONDS);
        builder.retryOnConnectionFailure(true);
        OkHttpClient mOkHttpClient=builder.build();
        return mOkHttpClient;
    }

}