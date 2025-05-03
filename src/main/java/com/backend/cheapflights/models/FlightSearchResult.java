package com.backend.cheapflights.models;

import java.util.List;

public class FlightSearchResult {
    private String termsOfUse;
    private String currency;
    private int currPrecision;
    private String routeGroup;
    private String tripType;
    private String upgradeType;
    private List<Trip> trips;
    private String serverTimeUTC;

    public String getTermsOfUse() { return termsOfUse; }
    public String getCurrency() { return currency; }
    public int getCurrPrecision() { return currPrecision; }
    public String getRouteGroup() { return routeGroup; }
    public String getTripType() { return tripType; }
    public String getUpgradeType() { return upgradeType; }
    public List<Trip> getTrips() { return trips; }
    public String getServerTimeUTC() { return serverTimeUTC; }

    public static class Trip {
        private String origin;
        private String originName;
        private String destination;
        private String destinationName;
        private String routeGroup;
        private String tripType;
        private String upgradeType;
        private List<FlightDate> dates;

        public String getOrigin() { return origin; }
        public String getOriginName() { return originName; }
        public String getDestination() { return destination; }
        public String getDestinationName() { return destinationName; }
        public String getRouteGroup() { return routeGroup; }
        public String getTripType() { return tripType; }
        public String getUpgradeType() { return upgradeType; }
        public List<FlightDate> getDates() { return dates; }

        public static class FlightDate {
            private String dateOut;
            private List<Flight> flights;

            public String getDateOut() { return dateOut; }
            public List<Flight> getFlights() { return flights; }

            public static class Flight {
                private Integer faresLeft;
                private String flightKey;
                private Integer infantsLeft;
                private RegularFare regularFare;
                private String operatedBy;
                private List<Segment> segments;
                private String flightNumber;
                private List<String> time;
                private List<String> timeUTC;
                private String duration;

                public Integer getFaresLeft() { return faresLeft; }
                public String getFlightKey() { return flightKey; }
                public Integer getInfantsLeft() { return infantsLeft; }
                public RegularFare getRegularFare() { return regularFare; }
                public String getOperatedBy() { return operatedBy; }
                public List<Segment> getSegments() { return segments; }
                public String getFlightNumber() { return flightNumber; }
                public List<String> getTime() { return time; }
                public List<String> getTimeUTC() { return timeUTC; }
                public String getDuration() { return duration; }

                public static class RegularFare {
                    private String fareKey;
                    private List<Fare> fares;

                    public String getFareKey() { return fareKey; }
                    public List<Fare> getFares() { return fares; }

                    public static class Fare {
                        private String type;
                        private float amount;
                        private int count;
                        private boolean hasDiscount;
                        private float publishedFare;
                        private int discountInPercent;
                        private boolean hasPromoDiscount;
                        private float discountAmount;
                        private boolean hasBogof;
                        private boolean isPrime;

                        public String getType() { return type; }
                        public float getAmount() { return amount; }
                        public int getCount() { return count; }
                        public boolean isHasDiscount() { return hasDiscount; }
                        public float getPublishedFare() { return publishedFare; }
                        public int getDiscountInPercent() { return discountInPercent; }
                        public boolean isHasPromoDiscount() { return hasPromoDiscount; }
                        public float getDiscountAmount() { return discountAmount; }
                        public boolean isHasBogof() { return hasBogof; }
                        public boolean isPrime() { return isPrime; }
                    }
                }

                public static class Segment {
                    private int segmentNr;
                    private String origin;
                    private String destination;
                    private String flightNumber;
                    private List<String> time;
                    private List<String> timeUTC;
                    private String duration;

                    public int getSegmentNr() { return segmentNr; }
                    public String getOrigin() { return origin; }
                    public String getDestination() { return destination; }
                    public String getFlightNumber() { return flightNumber; }
                    public List<String> getTime() { return time; }
                    public List<String> getTimeUTC() { return timeUTC; }
                    public String getDuration() { return duration; }
                }
            }
        }
    }
}
