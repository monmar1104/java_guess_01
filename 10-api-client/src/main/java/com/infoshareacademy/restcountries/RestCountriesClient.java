package com.infoshareacademy.restcountries;

import com.infoshareacademy.restcountries.dto.RestCountryResponse;
import com.infoshareacademy.restcountries.exception.CountryNotFoundException;


import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toList;

public class RestCountriesClient {

    private final static String API_URL = "https://restcountries.eu/rest/v2/";

    public List<RestCountryResponse> findByCurrency(String currency) {
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(API_URL + "currency/" + currency);
        Response response = target.request().get();
        if (response.getStatus() == 404) {
            throw new CountryNotFoundException("Not found country for given parameter.");
        } else {
            List<RestCountryResponse> countries = response.readEntity(new GenericType<List<RestCountryResponse>>() {
            });
            response.close();
            return countries;
        }
    }

    public List<String> findStateNeighbours(String countryName) {
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(API_URL + "name/" + countryName);
        Response response = target.request().get();
        List<RestCountryResponse> countries = response.readEntity(new GenericType<List<RestCountryResponse>>() {
        });
        List<String> bordersList = countries.get(0).getBorders();
        return bordersList;
    }

    public List<String> findCommonStateNeighbours(String countryName, String otherCountryName) {
        List<String> bordersFirstCountry = findStateNeighbours(countryName);
        List<String> bordersSecondCountry = findStateNeighbours(otherCountryName);
        return bordersFirstCountry.stream().filter(bordersSecondCountry::contains).collect(toList());
    }

    String generateUrl(String apiEndpoint, String endpointParam, Map<String, String> queryParams) {

        String key = queryParams.keySet().stream().findFirst().orElse("none");
        return API_URL + apiEndpoint + "/" + endpointParam + "?" + key + "=" + queryParams.get(key);
    }
}
