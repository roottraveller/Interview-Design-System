package com.smartHome;

import com.smartHome.domain.State;
import com.smartHome.domain.devices.Fan;
import com.smartHome.domain.devices.Light;
import com.smartHome.domain.devices.SmartCharger;
import com.smartHome.domain.home.SmartHome;
import com.smartHome.domain.room.DrawingRoom;
import com.smartHome.domain.room.LivingRoom;
import com.smartHome.domain.room.Room;
import com.smartHome.domain.smartHomeDevices.Alexa;
import com.smartHome.domain.smartHomeDevices.GoogleHome;
import com.smartHome.domain.smartHomeDevices.SmartHomeDevice;
import java.util.List;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Starting .... \n");

        new Main().init();
    }

    private void init() {
        SmartHome smartHome = new SmartHome();
        System.out.println("Google Home, Activated by Ok Google");
        SmartHomeDevice googleHome = new GoogleHome();
        System.out.println("Alexa, Activated by Alexa");
        SmartHomeDevice alexa = new Alexa();

        smartHome.setSmartHomeDevices(googleHome);
        smartHome.setSmartHomeDevices(alexa);

        System.out.println("Drawing Room light connect to Alexa");
        Room drawingRoom1 = new DrawingRoom(new Light());
        smartHome.setRooms(drawingRoom1);
        smartHome.setSmartHomeDeviceToRoomMap(alexa, drawingRoom1);

        System.out.println("Living room fan connect to Google Home");
        Room livingRoom2 = new LivingRoom(new Fan());
        smartHome.setRooms(livingRoom2);
        smartHome.setSmartHomeDeviceToRoomMap(googleHome, livingRoom2);

        System.out.println("Smart Charger connect to Alexa");
        ((Alexa) alexa).setSmartCharger(new SmartCharger());


        System.out.println("Alexa turn on Drawing room light");
        List<Room> roomList = smartHome.getSmartHomeDeviceToRoomMapRoomList(alexa);
        for (Room room : roomList) {
            try {
                DrawingRoom drawingRoom = ((DrawingRoom) room);
                if (drawingRoom.getLight() != null) {
                    ((Light) drawingRoom.getLight()).setState(State.ON);
                    System.out.println("-> Ok Drawing room light turned ON");
                }
            } catch (Exception e) {

            }
        }

        System.out.println("Ok Google turn on Living room fan");
        List<Room> roomList1 = smartHome.getSmartHomeDeviceToRoomMapRoomList(googleHome);
        for (Room room : roomList1) {
            try {
                LivingRoom livingRoom = ((LivingRoom) room);
                if (livingRoom.getFan() != null) {
                    ((Fan) livingRoom.getFan()).setState(State.ON);
                    System.out.println("-> Ok Living room light fan ON");
                }
            } catch (Exception e) {

            }
        }

        System.out.println("Ok Google set Living room fan speed to 5");
        List<Room> roomList2 = smartHome.getSmartHomeDeviceToRoomMapRoomList(googleHome);
        for (Room room : roomList2) {
            try {
                LivingRoom livingRoom = ((LivingRoom) room);
                if (livingRoom.getFan() != null) {
                    ((Fan) livingRoom.getFan()).setSpeed(5);
                    System.out.println("-> Ok Living room fan speed set to 5");
                }
            } catch (Exception e) {

            }
        }

        System.out.println("Ok Google set Living room fan speed to 7");
        List<Room> roomList3 = smartHome.getSmartHomeDeviceToRoomMapRoomList(googleHome);
        for (Room room : roomList3) {
            try {
                LivingRoom livingRoom = ((LivingRoom) room);
                if (livingRoom.getFan() != null) {
                    Fan fan = ((Fan) livingRoom.getFan());
                    if (7 < fan.getMaxSpeedLevel()) {
                        ((Fan) livingRoom.getFan()).setSpeed(7);
                        System.out.println("-> Ok Living room fan speed set to 5");
                    } else {
                        System.out.println("-> Sorry can not set Living room fan speed to 7 (Max 5)");
                    }

                }
            } catch (Exception e) {

            }
        }

        System.out.println("Alexa set Drawing room light brightness to 8");
        List<Room> roomList4 = smartHome.getSmartHomeDeviceToRoomMapRoomList(alexa);
        for (Room room : roomList4) {
            try {
                DrawingRoom drawingRoom = ((DrawingRoom) room);
                if (drawingRoom.getLight() != null) {
                    ((Light) drawingRoom.getLight()).setBrightnessLevel(8);
                    System.out.println("-> Ok Drawing room light brightness set to 8");
                }
            } catch (Exception e) {

            }
        }


        System.out.println("Alexa tun on the smart charger");
        SmartCharger smartCharger = (SmartCharger) ((Alexa) alexa).getSmartCharger();
        smartCharger.setState(State.ON);
        System.out.println(" -> ok smart charger turned on");


        System.out.println("Alexa tun of the smart charger");
        SmartCharger smartCharger2 = (SmartCharger) ((Alexa) alexa).getSmartCharger();
        smartCharger2.setState(State.OFF);
        System.out.println(" -> ok smart charger turned off");


        System.out.println("Ok Google turn off Living room fan");
        List<Room> roomList5 = smartHome.getSmartHomeDeviceToRoomMapRoomList(googleHome);
        for (Room room : roomList5) {
            try {
                LivingRoom livingRoom = ((LivingRoom) room);
                if (livingRoom.getFan() != null) {
                    Fan fan = ((Fan) livingRoom.getFan());
                    fan.setState(State.OFF);
                }
            } catch (Exception e) {

            }
        }

        System.out.println("Ok Google set Living room fan speed to 3");
        List<Room> roomList6 = smartHome.getSmartHomeDeviceToRoomMapRoomList(googleHome);
        for (Room room : roomList6) {
            try {
                LivingRoom livingRoom = ((LivingRoom) room);
                if (livingRoom.getFan() != null) {
                    Fan fan = ((Fan) livingRoom.getFan());
                    if (fan.getState() != State.ON) {
                        System.out.println(" -> Ok Living room fan is not turn on");
                    } else {
                        fan.setSpeed(3);
                    }
                }
            } catch (Exception e) {

            }
        }

        System.out.println("print connected devices (Google Home)");
        printConnectDevice(smartHome.getSmartHomeDeviceToRoomMapRoomList(googleHome));

        System.out.println("print connected devices (Alexa)");
        printConnectDevice(smartHome.getSmartHomeDeviceToRoomMapRoomList(alexa));
        if (((Alexa) alexa).getSmartCharger() != null) {
            SmartCharger smartCharger1 = (SmartCharger) ((Alexa) alexa).getSmartCharger();
            System.out.println(smartCharger1.getSmartChargerId() + "Generic" + "Smart charger" + smartCharger1.getState());
        }


    }


    private void printConnectDevice(List<Room> roomList) {
        for (Room room : roomList) {
            try {
                if (room instanceof LivingRoom) {
                    LivingRoom livingRoom = (LivingRoom) room;
                    if (livingRoom.getFan() != null) {
                        Fan fan = (Fan) livingRoom.getFan();
                        System.out.print(fan.getFanId() + " Living Room Fan " + fan.getState() + "[" + fan.getSpeed() + "]");
                    }
                    if (livingRoom.getLight() != null) {
                        Light light = (Light) livingRoom.getLight();
                        System.out.print(light.getLightId() + " Living Room Light " + light.getState() + "[" + light.getBrightnessLevel() + "]");
                    }
                } else if (room instanceof DrawingRoom) {
                    DrawingRoom drawingRoom = (DrawingRoom) room;
                    if (drawingRoom.getFan() != null) {
                        Fan fan = (Fan) drawingRoom.getFan();
                        System.out.print(fan.getFanId() + " Drawing Room Fan " + fan.getState() + "[" + fan.getSpeed() + "]");
                    }
                    if (drawingRoom.getLight() != null) {
                        Light light = (Light) drawingRoom.getLight();
                        System.out.print(light.getLightId() + " Drawing Room Light " + light.getState() + "[" + light.getBrightnessLevel() + "]");
                    }
                }
            } catch (Exception e) {

            }

        }

    }
}
