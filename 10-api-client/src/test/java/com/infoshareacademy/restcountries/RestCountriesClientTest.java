package com.infoshareacademy.restcountries;

import com.infoshareacademy.restcountries.exception.CountryNotFoundException;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class RestCountriesClientTest {

    private RestCountriesClient restCountries;
    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Before
    public void setUp() {
        restCountries = new RestCountriesClient();
    }

    @Test
    public void shouldHandleFailure() {
        expectedException.expect(CountryNotFoundException.class);
        expectedException.expectMessage("Not found country for given parameter.");

        final String notExistingCurrency = "TMP";
        restCountries.findByCurrency(notExistingCurrency);
    }

    @Test
    public void shouldGenerateUrl() {
        String apiEndpoint = "currency";
        String apiParam = "JPY";
        Map<String, String> queryParams = new HashMap<>();
        queryParams.put("fields", "name;capital;borders");

        String expectedUrl = "https://restcountries.eu/rest/v2/currency/JPY?fields=name;capital;borders";

        String url = restCountries.generateUrl(apiEndpoint, apiParam, queryParams);
        assertThat(url, is(expectedUrl));
    }
}
