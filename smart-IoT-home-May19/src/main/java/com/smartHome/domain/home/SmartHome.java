package com.smartHome.domain.home;

import com.smartHome.domain.room.Room;
import com.smartHome.domain.smartHomeDevices.SmartHomeDevice;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SmartHome implements Home {
    private List<SmartHomeDevice> smartHomeDevices;
    private List<Room> rooms;
    private Map<SmartHomeDevice, List<Room>> smartHomeDeviceToRoomMap;

    public SmartHome() {
        this.smartHomeDevices = new ArrayList<>();
        this.rooms = new ArrayList<>();
        this.smartHomeDeviceToRoomMap = new HashMap<>();
    }

    public List<SmartHomeDevice> getSmartHomeDevices() {
        return smartHomeDevices;
    }

    public void setSmartHomeDevices(SmartHomeDevice smartHomeDevice) {
        smartHomeDevices.add(smartHomeDevice);
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(Room room) {
        this.rooms.add(room);
    }

    public Map<SmartHomeDevice, List<Room>> getSmartHomeDeviceToRoomMap() {
        return smartHomeDeviceToRoomMap;
    }

    public List<Room> getSmartHomeDeviceToRoomMapRoomList(SmartHomeDevice smartHomeDevice) {
        return smartHomeDeviceToRoomMap.get(smartHomeDevice);
    }

    public void setSmartHomeDeviceToRoomMap(SmartHomeDevice smartHomeDevice, Room room) {
        List<Room> rooms = smartHomeDeviceToRoomMap.get(smartHomeDevice);
        if(room != null) {
            rooms.add(room);
            smartHomeDeviceToRoomMap.put(smartHomeDevice, rooms);
        } else {
            List<Room> roomList = new ArrayList<>();
            roomList.add(room);
            smartHomeDeviceToRoomMap.put(smartHomeDevice, roomList);
        }
    }
}
