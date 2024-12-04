package org.openbrewerydb.steps;

import org.openbrewerydb.dto.BreweryResponse;
import io.restassured.response.Response;
import org.openbrewerydb.enums.Brewery;
import org.openbrewerydb.enums.Filter;

import static org.openbrewerydb.client.OpenBreweryApiClient.searchBreweries;
import static org.openbrewerydb.utils.Utils.convertResponseToObject;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BrewerySearchStep {

    public static Response makeSearchRequestBy(String searchParam) {
        //todo need move to config
        var url = "https://api.openbrewerydb.org/v1/breweries/search?query=" + searchParam;

        return searchBreweries(url);
    }

    public static void checkBrewery(Response response, Brewery expectedBrewery, Filter paramType) {
        var listBreweries = convertResponseToObject(response);
        var actualBrewery = listBreweries.stream().findFirst().orElseThrow();

        var expectedBreweryValue = extractBreweryValue(expectedBrewery, paramType);
        var actualBreweryValue = extractBreweryValue(actualBrewery, paramType);

        assertEquals(expectedBreweryValue, actualBreweryValue,
                "The brewery does not match with expected value");
    }

    private static <T> String extractBreweryValue(T brewery, Filter paramType) {
        if (brewery instanceof Brewery b) {
            return switch (paramType) {
                case NAME -> b.getName();
                case CITY -> b.getCity();
                case COUNTRY -> b.getCountry();
            };
        } else if (brewery instanceof BreweryResponse b) {
            return switch (paramType) {
                case NAME -> b.getName();
                case CITY -> b.getCity();
                case COUNTRY -> b.getCountry();
            };
        }
        throw new IllegalArgumentException("Unsupported brewery type");
    }


    public static void checkBreweryContract(Response response, BreweryResponse expectedBreweryResponse) {
        var breweries = convertResponseToObject(response);
        var actualBrewery = breweries.stream().findFirst().orElseThrow();

        assertEquals(expectedBreweryResponse, actualBrewery,
                "The brewery response structure is wrong!");
    }

    public static void checkNoMatchingBrewery(Response response) {
        var breweries = convertResponseToObject(response);

        assertTrue(breweries.isEmpty());
    }
}