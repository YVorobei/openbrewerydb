package org.openbrewerydb.dto;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

/**
 * Brewery model.
 */
@Data
@Builder
public class BreweryResponse {
    String id;
    String name;
    @SerializedName("brewery_type")
    String breweryType;
    @SerializedName("address_1")
    String address1;
    @SerializedName("address_2")
    String address2;
    @SerializedName("address_3")
    String address3;
    String city;
    @SerializedName("state_province")
    String stateProvince;
    @SerializedName("postal_code")
    String postalCode;
    String country;
    String longitude;
    String latitude;
    String phone;
    @SerializedName("website_url")
    String websiteUrl;
    String state;
    String street;
}
