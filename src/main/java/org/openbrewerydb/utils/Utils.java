package org.openbrewerydb.utils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import io.restassured.response.Response;
import org.openbrewerydb.dto.BreweryResponse;
import org.openbrewerydb.enums.Brewery;

import java.lang.reflect.Type;
import java.util.List;

public class Utils {

    public static List<BreweryResponse> convertResponseToObject(Response response) {
        Gson gson = new Gson();
        Type listType = new TypeToken<List<BreweryResponse>>() {}.getType();

        return gson.fromJson(response.asString(), listType);
    }

    public static BreweryResponse buildBrewery(Brewery name) {
        return BreweryResponse.builder()
                .id("d2f3c749-faf4-4551-a912-c207ccbc141a")
                .name(name.getName())
                .breweryType("brewpub")
                .address1("820 William T Morrissey Blvd")
                .city("Boston")
                .stateProvince("Massachusetts")
                .postalCode("02122-3404")
                .country("United States")
                .longitude("-71.04799748")
                .latitude("42.29485605")
                .phone("6177401440")
                .websiteUrl("http://www.deadwoodbrewery.com")
                .state("Massachusetts")
                .street("820 William T Morrissey Blvd")
                .build();
    }
}
