package com.infoshareacademy.restcountries;

import com.infoshareacademy.restcountries.dto.RestCountryResponse;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class RestCountriesClient {

    private final static String API_URL = "https://restcountries.eu/rest/v2/";

    public List<RestCountryResponse> findByCurrency(String currency) {
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(API_URL + "currency/" + currency);
        Response response = target.request().get();


        List<RestCountryResponse> countries = response.readEntity(new GenericType<List<RestCountryResponse>>() {});
        response.close();
        return countries;
        //throw new NotImplementedException();
    }

    public List<String> findStateNeighbours(String countryName) {
        return new ArrayList<>();
    }

    public List<String> findCommonStateNeighbours(String countryName, String otherCountryName) {
        return null;
    }

    String generateUrl(String apiEndpoint, String endpointParam, Map<String, String> queryParams) {

        String key = queryParams.keySet().stream().findFirst().orElse("none");
        return API_URL + apiEndpoint + "/" + endpointParam + "?" + key + "=" + queryParams.get(key);
    }
}
