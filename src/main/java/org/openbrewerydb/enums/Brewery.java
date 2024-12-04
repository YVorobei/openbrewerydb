package org.openbrewerydb.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Brewery {
    DEADWOOD_BREWERY("Deadwood Brewery / Boston Bowl", "United State","Boston"),
    LEGNICKI_BROWAR("Legnicki Browar Książęcy", "Poland", "Legnica"),
    NO_MATCHING_BREWERY("no matching breweries","country", "city");

    private final String name;
    private final String country;
    private final String city;
}
