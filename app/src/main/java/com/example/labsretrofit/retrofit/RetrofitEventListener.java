package com.example.labsretrofit.retrofit;

import retrofit2.Call;

public interface RetrofitEventListener {
     void onSuccess(Call call, Object response);
     void onError(Call call, Throwable t);
}
