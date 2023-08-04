package ait.tv;

import ait.tv.model.Channel;
import ait.tv.model.RemoteController;
import ait.tv.model.TV;
import ait.tv.model.TVProgram;

import java.util.ArrayList;
import java.util.List;

public class TvAppl {
    public static void main(String[] args) {
        List<TVProgram> programList1 = new ArrayList<>();
        programList1.add(new TVProgram("News"));
        programList1.add(new TVProgram("Movie"));
        programList1.add(new TVProgram("Sports"));
        List<TVProgram> programList2 = new ArrayList<>();
        programList2.add(new TVProgram("Documentary"));
        programList2.add(new TVProgram("Cartoon"));
        programList2.add(new TVProgram("Cooking Show"));
        Channel channel1 = new Channel("Channel 1", 1, programList1);
        Channel channel2 = new Channel("Channel 2", 2, programList2);
        List<Channel> channels = new ArrayList<>();
        channels.add(channel1);
        channels.add(channel2);
        TV tv = new TV(channels);
        RemoteController remote = new RemoteController(tv);
        remote.turnTVOn();
        remote.switchChannel(1);
        remote.switchChannel(2);
        remote.turnTVOff();
    }
}