package org.maraz.component;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Blockchain {
    private List<Block> chain = new ArrayList<>();
    private int difficulty;

    public Blockchain(){
        chain.add(createGenesisBlock());
        setDifficulty(3);
    }

    private Block createGenesisBlock(){
        Payload payload = new Payload("Genesis Block", 0.0);
        Calendar cal = Calendar.getInstance();
        cal.set(2021, Calendar.JANUARY, 1);
        Date date = cal.getTime();
        Block block = new Block(0, date, payload, "0");
        return block;
    }

    public Block getLatestBlock(){
        return chain.get(chain.size()-1);
    }

    public void addBlock(Block newBlock){
        newBlock.setPreviousHash(getLatestBlock().getHash());
        newBlock.mining(getDifficulty());
        chain.add(newBlock);
    }

    public boolean isChainValid(){
        for(int i=1;i< chain.size();i++){
            Block currentBlock = chain.get(i);
            Block previousBlock = chain.get(i-1);
            if(!currentBlock.getHash().equals(currentBlock.generateSha256Hash())){
                return false;
            }
            if(!currentBlock.getPreviousHash().equals(previousBlock.getHash())){
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        return "Blockchain{" +
                "chain=" + chain +
                '}';
    }

    public void print(){
        chain.stream().forEach(System.out::println);
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }
}
