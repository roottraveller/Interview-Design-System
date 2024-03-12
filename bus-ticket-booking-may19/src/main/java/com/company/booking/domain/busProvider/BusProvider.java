package com.company.booking.domain.busProvider;

import com.company.booking.services.SourceEndPoint;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 *  Hold details of which bus belong to which bus provider
 *  (sourceEndPoint defined provider API class )
 */
public class BusProvider {
    private Map<Long, SourceEndPoint> busProviderMap;

    public BusProvider() {
        this.busProviderMap = new LinkedHashMap<>();
    }

    public boolean addNewBusProvider(Long busId, SourceEndPoint sourceEndPoint) {
        busProviderMap.put(busId, sourceEndPoint);
        return true;
    }

    public SourceEndPoint getBusProvider(long busId) {
        return busProviderMap.get(busId);
    }

    public Map<Long, SourceEndPoint> getBusProviderMap() {
        return busProviderMap;
    }

    public void setBusProviderMap(Map<Long, SourceEndPoint> busProviderMap) {
        this.busProviderMap = busProviderMap;
    }
}
