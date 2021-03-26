package org.maraz.component;

import org.apache.commons.codec.digest.DigestUtils;
import java.util.Date;

public class Block{

    private long index;
    private Date date;
    private Payload payload;
    private String previousHash;
    private String hash;
    private Integer nonce;

    public Block(long index, Date date, Payload payload, String previousHash) {
        this.index = index;
        this.date = date;
        this.payload = payload;
        this.previousHash = previousHash;
        this.hash = generateSha256Hash();
        this.nonce = 0;
    }

    public String generateSha256Hash(){
        return DigestUtils.sha256Hex(String.valueOf(getIndex())+getDate().toString()+getPayload().toString()+getPreviousHash()+getNonce());
    }

    public void mining(int difficulty){
        while(!this.hash.substring(0, difficulty).equals("000")){
            this.nonce++;
            this.hash = generateSha256Hash();
        }
        System.out.printf("Block mined %s%n", this.hash);
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

    public Integer getNonce() {
        return nonce;
    }

    public void setNonce(Integer nonce) {
        this.nonce = nonce;
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