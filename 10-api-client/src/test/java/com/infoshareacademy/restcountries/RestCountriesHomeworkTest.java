package com.infoshareacademy.restcountries;

import com.infoshareacademy.restcountries.dto.RestCountryResponse;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsCollectionContaining.hasItems;
import static org.junit.Assert.assertThat;

public class RestCountriesHomeworkTest {
    private RestCountriesClient restCountries;

    @Before
    public void setUp() {
        restCountries = new RestCountriesClient();
    }

    @Test
    public void shouldFindSingleCountry() {
        final String currency = "PLN";

        final List<RestCountryResponse> countries = restCountries.findByCurrency(currency);
        assertThat(countries.size(), is(1));
    }

    @Test
    public void shouldFindPolandForPlnCurrency() {
        final String currency = "PLN";

        final List<RestCountryResponse> countries = restCountries.findByCurrency(currency);
//        FIXME: Make this code working and passing test
//        assertThat(countries.get(0).getName(), is("Poland"));
    }

    @Test
    public void shouldFindCountriesByUsdCurrency() {
        final String currency = "USD";

        final List<RestCountryResponse> countries = restCountries.findByCurrency(currency);
        assertThat(countries.size(), is(35));
    }

    @Test
    public void findStateNeighbours() {
        final String countryName = "Lithuania";

        final List<String> neighboursCodes = restCountries.findStateNeighbours(countryName);
        assertThat(neighboursCodes, hasItems("BLR", "LVA", "POL", "RUS"));
    }

    @Test
    public void findCommonStateNeighbours() {
        final String countryName = "Poland";
        final String otherCountryName = "Czech Republic";

        final List<String> neighboursCodes = restCountries.findCommonStateNeighbours(countryName, otherCountryName);
        assertThat(neighboursCodes.size(), is(2));
        assertThat(neighboursCodes, hasItems("GER", "SVK"));
    }
}
