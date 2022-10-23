package org.example;

import org.apache.commons.codec.digest.DigestUtils;


import java.util.HashMap;

public class Block {
    private HashMap<String,Object> blockMap = new HashMap<>();
    private String accountFrom;
    private String accountTo;
    private double amount;

    private String prevHash;

    private int proof;

    public Block(String accountFrom, String accountTo, double amount,String prevHash) {
        this(accountFrom,accountTo,amount);
        this.prevHash=prevHash;
        blockMap.put("prevHash",prevHash);
    }
    public Block(String accountFrom, String accountTo, double amount) {
        this.accountFrom = accountFrom;
        this.accountTo = accountTo;
        this.amount = amount;
        blockMap.put("accountFrom",accountFrom);
        blockMap.put("accountTo",accountTo);
        blockMap.put("amount",amount);

    }



    public int getProof() {
        return proof;
    }

    public void setProof(int proof) {
        this.proof = proof;
        blockMap.put("proof",proof);
    }

    public String getPrevHash() {
        return prevHash;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
        blockMap.put("amount",amount);
    }

    public String hashData(){
        String data = blockMap.toString();
        return DigestUtils.sha256Hex(data).substring(0,10);
    }

    @Override
    public String toString() {
        return "Block{" +
                "blockMap=" + blockMap +
                '}';
    }
}
