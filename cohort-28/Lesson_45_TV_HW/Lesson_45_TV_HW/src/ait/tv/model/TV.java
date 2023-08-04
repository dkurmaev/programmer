package ait.tv.model;

import java.util.List;

public class TV {
    private List<Channel> channels;
    private boolean isOn;
    private int currentChannel;
    public TV(List<Channel> channels) {
        this.channels = channels;
        isOn = false;
        currentChannel = 0;
    }
    public List<Channel> getChannels() {
        return channels;
    }
    public boolean isOn() {
        return isOn;
    }
    public void turnOn() {
        isOn = true;
        System.out.println("Turning TV on");
    }
    public void turnOff() {
        isOn = false;
        System.out.println("Turning TV off");
    }
    public void changeChannel(int channelNumber) {
        if (isOn && channelNumber >= 0 && channelNumber < channels.size()) {
            Channel currentChannel = channels.get(channelNumber);
            System.out.println("Switched to channel: " + currentChannel.getName());
            currentChannel.showRandomProgram();
        } else {
            System.out.println("Invalid channel number or TV is off.");
        }
    }
}