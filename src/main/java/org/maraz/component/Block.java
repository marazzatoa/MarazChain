package org.maraz.component;

import org.apache.commons.codec.digest.DigestUtils;
import java.util.Date;

public class Block{

    private long index;
    private Date date;
    private Payload payload;
    private String previousHash;
    private String hash;

    public Block(long index, Date date, Payload payload, String previousHash) {
        this.index = index;
        this.date = date;
        this.payload = payload;
        this.previousHash = previousHash;
        this.hash = generateSha256Hash();
    }

    public String generateSha256Hash(){
        return DigestUtils.sha256Hex(String.valueOf(getIndex())+getDate().toString()+getPayload().toString()+getPreviousHash());
    }

    public long getIndex() {
        return index;
    }

    public void setIndex(long index) {
        this.index = index;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Payload getPayload() {
        return payload;
    }

    public void setPayload(Payload payload) {
        this.payload = payload;
    }

    public String getPreviousHash() {
        return previousHash;
    }

    public void setPreviousHash(String previousHash) {
        this.previousHash = previousHash;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    @Override
    public String toString() {
        return "Block{" +
                "index=" + index +
                ", date=" + date +
                ", payload=" + payload +
                ", previousHash='" + previousHash + '\'' +
                ", hash='" + hash + '\'' +
                '}';
    }
}