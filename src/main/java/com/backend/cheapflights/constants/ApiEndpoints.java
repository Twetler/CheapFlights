package com.backend.cheapflights.constants;

public class ApiEndpoints {
    public static final String base_url = "https://www.ryanair.com/api";

    public static class Airports {
        public static final String listAllUrl = base_url + "/views/locate/5/airports/en/active";
    }

    public static class Flights {
        // %s - Origin and Destination respectively
        public static final String getDates = "https://www.ryanair.com/api/farfnd/v4/oneWayFares/%s/%s/availabilities";
    }
}
