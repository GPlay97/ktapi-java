package de._125m125.kt.ktapi_java.retrofit;

import java.io.File;
import java.nio.charset.Charset;
import java.util.Base64;

import com.google.gson.Gson;

import de._125m125.kt.ktapi_java.core.entities.User;
import de._125m125.kt.ktapi_java.core.results.ErrorResponse;
import de._125m125.kt.ktapi_java.retrofitRequester.KtRetrofitRequester;
import de._125m125.kt.ktapi_java.retrofitRequester.builderModifier.CertificatePinnerAdder;
import de._125m125.kt.ktapi_java.retrofitRequester.builderModifier.ClientModifier;
import de._125m125.kt.ktapi_java.retrofitRequester.builderModifier.ConverterFactoryAdder;
import de._125m125.kt.ktapi_java.retrofitRequester.builderModifier.HeaderAdder;
import de._125m125.kt.ktapi_java.retrofitRequester.builderModifier.RetrofitModifier;
import de._125m125.kt.ktapi_java.retrofitUnivocityTsvparser.UnivocityConverterFactory;
import okhttp3.Cache;
import retrofit2.converter.gson.GsonConverterFactory;

public class KtRetrofit {
    public static final String DEFAULT_BASE_URL = "https://kt.125m125.de/api/v2.0/";

    public static KtRetrofitRequester createDefaultRequester(final User user) {
        return createDefaultRequester(user, null);
    }

    public static KtRetrofitRequester createDefaultRequester(final User user, final File cacheDirectory,
            final long maxCacheSize) {
        return createDefaultRequester(user, new Cache(cacheDirectory, maxCacheSize));
    }

    public static KtRetrofitRequester createDefaultRequester(final User user, final Cache cache) {
        return new KtRetrofitRequester(KtRetrofit.DEFAULT_BASE_URL,
                new ClientModifier[] {
                        new HeaderAdder("Authorization",
                                "Basic " + Base64.getEncoder().encodeToString(
                                        (user.getTID() + ":" + user.getTKN()).getBytes(Charset.forName("UTF-8")))),
                        new HeaderAdder("Accept", "text/tsv,application/json"), client -> {
                            if (cache != null) {
                                client.cache(cache);
                            }
                            return client;
                        },
                        CertificatePinnerAdder.builder(true).addAll(CertificatePinnerAdder.DEFAULT_CERTIFICATES)
                                .build() },
                new RetrofitModifier[] { new ConverterFactoryAdder(new UnivocityConverterFactory()),
                        new ConverterFactoryAdder(GsonConverterFactory.create()) },
                value -> new Gson().fromJson(value.charStream(), ErrorResponse.class));
    }
}