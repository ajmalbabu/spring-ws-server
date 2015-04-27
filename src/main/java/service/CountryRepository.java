package service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

import io.spring.guides.gs_producing_web_service.Country;
import io.spring.guides.gs_producing_web_service.Currency;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

@Component
public class CountryRepository {
    private static final List<Country> countries = new ArrayList<Country>();

    @PostConstruct
    public void initData() {
        Country spain = new Country();
        spain.setName("Spain");
        spain.setCapital("Madrid");
        spain.setCurrency(Currency.EUR);
        spain.setPopulation(46704314);
        spain.setInfo(CountryInfo.getCountryInfo("Spain"));

        countries.add(spain);

        Country poland = new Country();
        poland.setName("Poland");
        poland.setCapital("Warsaw");
        poland.setCurrency(Currency.PLN);
        poland.setPopulation(38186860);
        poland.setInfo(CountryInfo.getCountryInfo("Poland"));

        countries.add(poland);

        Country uk = new Country();
        uk.setName("United Kingdom");
        uk.setCapital("London");
        uk.setCurrency(Currency.GBP);
        uk.setPopulation(63705000);
        uk.setInfo(CountryInfo.getCountryInfo("United Kingdom"));

        countries.add(uk);
    }


    public List<Country> findCountries(String name,int count) {

        Country country = findCountry(name);
        List result = new ArrayList();
        for(int i = 0 ; i < count; i++) {
            Country newCountry = new Country();
            newCountry.setName(country.getName() + "-" + i);
            newCountry.setCapital("Madrid-" + i);
            newCountry.setCurrency(country.getCurrency());
            newCountry.setPopulation(63705000 + i);
            newCountry.setInfo(CountryInfo.getCountryInfo(name));
            result.add(newCountry);
        }
        return result;

    }




    public Country findCountry(String name) {

        Assert.notNull(name);

        Country result = null;

        System.out.println("Requesting for country name: " + name);

        for (Country country : countries) {
            if (name.equals(country.getName())) {
                System.out.println("Found result.");
                result = country;
            }
        }

        return result;
    }
}
