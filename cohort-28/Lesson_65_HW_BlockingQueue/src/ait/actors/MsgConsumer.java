package ait.actors;

import ait.mediation.BlkQueue;

public class MsgConsumer extends Thread{
    BlkQueue<String> blkQueue;
    int msgHandlingTimeMillis;

    public MsgConsumer(BlkQueue<String> blkQueue, int msgHandlingTimeMillis) {
        super();
        this.blkQueue = blkQueue;
        this.msgHandlingTimeMillis = msgHandlingTimeMillis;
        setDaemon(true);
    }

    @Override
    public void run() {
        while (true) {
            String message = blkQueue.pop();
            System.out.printf("%s ==> consumer %d\n", message, getId());
            try { // simulate message handling
                Thread.sleep(msgHandlingTimeMillis);
            } catch (InterruptedException e) {
                // noop
            }
        }
    }
}

