package ait.tv.model;

public class RemoteController {
    private TV tv;
    public RemoteController(TV tv) {
        this.tv = tv;
    }
    public void turnTVOn() {
        if (!tv.isOn()) {
            tv.turnOn();
        } else {
            System.out.println("TV is already on.");
        }
    }
    public void turnTVOff() {
        if (tv.isOn()) {
            tv.turnOff();
        } else {
            System.out.println("TV is already off.");
        }
    }
    public void switchChannel(int channelNumber) {
        tv.changeChannel(channelNumber);
    }
}