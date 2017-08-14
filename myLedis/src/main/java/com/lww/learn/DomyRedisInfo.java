package com.lww.learn;

import java.util.Date;

public class DomyRedisInfo {
    private Integer id;

    private String pingIp;

    private Date pingTime;

    private Integer blockedClients;

    private Integer rejectedConnections;

    private Integer connectedClients;

    private Integer usedMemory;

    private Integer usedMemoryPeak;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPingIp() {
        return pingIp;
    }

    public void setPingIp(String pingIp) {
        this.pingIp = pingIp == null ? null : pingIp.trim();
    }

    public Date getPingTime() {
        return pingTime;
    }

    public void setPingTime(Date pingTime) {
        this.pingTime = pingTime;
    }

    public Integer getBlockedClients() {
        return blockedClients;
    }

    public void setBlockedClients(Integer blockedClients) {
        this.blockedClients = blockedClients;
    }

    public Integer getRejectedConnections() {
        return rejectedConnections;
    }

    public void setRejectedConnections(Integer rejectedConnections) {
        this.rejectedConnections = rejectedConnections;
    }

    public Integer getConnectedClients() {
        return connectedClients;
    }

    public void setConnectedClients(Integer connectedClients) {
        this.connectedClients = connectedClients;
    }

    public Integer getUsedMemory() {
        return usedMemory;
    }

    public void setUsedMemory(Integer usedMemory) {
        this.usedMemory = usedMemory;
    }

    public Integer getUsedMemoryPeak() {
        return usedMemoryPeak;
    }

    public void setUsedMemoryPeak(Integer usedMemoryPeak) {
        this.usedMemoryPeak = usedMemoryPeak;
    }
}