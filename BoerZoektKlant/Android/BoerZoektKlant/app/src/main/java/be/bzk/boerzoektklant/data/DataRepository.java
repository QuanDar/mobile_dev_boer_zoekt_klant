package be.bzk.boerzoektklant.data;

import java.util.List;

import be.bzk.boerzoektklant.data.models.Business;
import io.reactivex.Single;

public interface DataRepository {
    Single<List<Business>> getBusinessesRemote();

    Single<List<Business>> getBusinessesLocal();

    void saveBusiness(Business business);

    //String convertCurrency(double quantity, Currency fromCurrency, Currency toCurrency);

}
