package be.bzk.boerzoektklant.data.remote;

import java.util.List;

import be.bzk.boerzoektklant.data.models.Business;
import be.bzk.boerzoektklant.util.Constants;
import io.reactivex.Single;
import retrofit2.http.GET;

public interface HnbApiService {
    @GET(Constants.API_RATES_ENDPOINT)
    Single<List<Business>> getBusinesses();

}
