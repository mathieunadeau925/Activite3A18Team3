package com.team3.models;

import com.sun.jna.platform.win32.Sspi;

public class TimeZone {
    private Localisation localisation;
    private Sspi.TimeStamp epoch ;

    public TimeZone() {
    }

    public TimeZone(Localisation localisation, Sspi.TimeStamp epoch) {
        this.localisation = localisation;
        this.epoch = epoch;
    }

    public Localisation getLocalisation() {
        return localisation;
    }

    public void setLocalisation(Localisation localisation) {
        this.localisation = localisation;
    }

    public Sspi.TimeStamp getEpoch() {
        return epoch;
    }

    public void setEpoch(Sspi.TimeStamp epoch) {
        this.epoch = epoch;
    }
    
}
