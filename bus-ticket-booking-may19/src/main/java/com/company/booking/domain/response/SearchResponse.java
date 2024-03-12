package com.company.booking.domain.response;

import com.company.booking.domain.vehicle.Bus;

import java.util.Date;
import java.util.List;

/**
 * search response formate
 */
public class SearchResponse {
    private String fromStation;
    private String toStation;
    private Date journeyDate;
    private List<Bus> busList;

    public String getFromStation() {
        return fromStation;
    }

    public void setFromStation(String fromStation) {
        this.fromStation = fromStation;
    }

    public String getToStation() {
        return toStation;
    }

    public void setToStation(String toStation) {
        this.toStation = toStation;
    }

    public Date getJourneyDate() {
        return journeyDate;
    }

    public void setJourneyDate(Date journeyDate) {
        this.journeyDate = journeyDate;
    }

    public List<Bus> getBusList() {
        return busList;
    }

    public void setBusList(List<Bus> busList) {
        this.busList = busList;
    }
}
