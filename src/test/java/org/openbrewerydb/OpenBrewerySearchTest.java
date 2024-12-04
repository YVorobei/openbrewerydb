package org.openbrewerydb;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openbrewerydb.enums.Filter;

import static org.openbrewerydb.enums.Brewery.*;
import static org.openbrewerydb.steps.BrewerySearchStep.*;
import static org.openbrewerydb.utils.Utils.buildBrewery;

public class OpenBrewerySearchTest {

    @DisplayName("Search brewery by name")
    @Test
    public void searchBreweryByNameTest() {
        var nameBrewery = DEADWOOD_BREWERY.getName();
        var response = makeSearchRequestBy(nameBrewery);
        checkBrewery(response, DEADWOOD_BREWERY, Filter.NAME);
    }

    @DisplayName("Search brewery by city")
    @Test
    public void searchBreweryByCityTest() {
        var cityBrewery = LEGNICKI_BROWAR.getCity();
        var response = makeSearchRequestBy(cityBrewery);
        checkBrewery(response, LEGNICKI_BROWAR, Filter.CITY);
    }

    @DisplayName("Search brewery by country")
    @Test
    public void searchBreweryByCountryTest() {
        var countryBrewery = LEGNICKI_BROWAR.getCountry();
        var response = makeSearchRequestBy(countryBrewery);
        checkBrewery(response, LEGNICKI_BROWAR, Filter.COUNTRY);
    }

    @DisplayName("Check brewery contract")
    @Test
    public void checkBreweryContractTest() {
        var response = makeSearchRequestBy(DEADWOOD_BREWERY.getName());
        var expectedBrewery = buildBrewery(DEADWOOD_BREWERY);
        checkBreweryContract(response, expectedBrewery);
    }

    @DisplayName("Check no matching brewery")
    @Test
    public void checkNoMatchingBreweryTest() {
        var response = makeSearchRequestBy(NO_MATCHING_BREWERY.getName());
        checkNoMatchingBrewery(response);
    }
}