package com.infoshareacademy.restcountries;

import com.infoshareacademy.restcountries.dto.RestCountryResponse;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class RestCountriesClient {

    private final static String API_URL = "https://restcountries.eu/rest/v2/";

    public List<RestCountryResponse> findByCurrency(String currency) {
        throw new NotImplementedException();
    }

    public List<String> findStateNeighbours(String countryName) {
        return new ArrayList<>();
    }

    public List<String> findCommonStateNeighbours(String countryName, String otherCountryName) {
        return null;
    }

    String generateUrl(String apiEndpoint, String endpointParam, Map<String, String> queryParams) {
        return API_URL;
    }
}
