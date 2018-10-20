package be.bzk.boerzoektklant.data;

import java.util.List;

import javax.inject.Inject;

import be.bzk.boerzoektklant.data.models.Business;
import be.bzk.boerzoektklant.data.remote.ApiManager;
import io.reactivex.Single;
import retrofit2.Converter;

public class DataRepositoryImpl implements DataRepository {

    private ApiManager apiManager;

    @Inject
    public DataRepositoryImpl(ApiManager apiManager) {
        this.apiManager = apiManager;
    }

    @Override
    public Single<List<Business>> getBusinessesRemote() {
        return apiManager.getCurrencyRates()
                .map(currencies -> {
                    currencies.add(0, new Business());
                    return currencies;
                });
    }

    @Override
    public Single<List<Business>> getBusinessesLocal() {
        return null;
    }

    @Override
    public void saveBusiness(Business business) {

    }
}
