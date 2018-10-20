package be.bzk.boerzoektklant.data.remote;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import be.bzk.boerzoektklant.data.models.Business;
import io.reactivex.Single;

@Singleton
public class ApiManager {

    private HnbApiService apiService;

    @Inject
    public ApiManager(HnbApiService apiService) {
        this.apiService = apiService;
    }

    public Single<List<Business>> getCurrencyRates() {
        return apiService.getBusinesses();
    }
}
