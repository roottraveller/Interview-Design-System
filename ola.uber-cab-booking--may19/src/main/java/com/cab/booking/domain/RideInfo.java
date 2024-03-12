package com.cab.booking.domain;

import java.util.List;

public class RideInfo {
    private long riderCount;
    private List<DestinationNode> destinationNodeList;

    public RideInfo(long riderCount, List<DestinationNode> destinationNodeList) {
        this.riderCount = riderCount;
        this.destinationNodeList = destinationNodeList;
    }

    public long getRiderCount() {
        return riderCount;
    }

    public void setRiderCount(long riderCount) {
        this.riderCount = riderCount;
    }

    public List<DestinationNode> getDestinationNodeList() {
        return destinationNodeList;
    }

    public void setDestinationNodeList(List<DestinationNode> destinationNodeList) {
        this.destinationNodeList = destinationNodeList;
    }
}
