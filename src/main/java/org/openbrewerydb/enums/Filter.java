package org.openbrewerydb.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Filter {
    CITY("city"),
    COUNTRY("country"),
    NAME("name");

    private final String name;

}
