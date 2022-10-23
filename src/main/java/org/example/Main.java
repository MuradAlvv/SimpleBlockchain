package org.example;


import org.apache.commons.codec.digest.DigestUtils;

public class Main {
    public static void main(String[] args) {

        Blockchain blockchain = new Blockchain();

        blockchain.addTransaction("Account1","Account2",1000);
        blockchain.addTransaction("Account2","Account3",2300);
        blockchain.addTransaction("Account3","Account2",200);
        blockchain.addTransaction("Account3","Account1",500);
        blockchain.addTransaction("Account2","Account4",1200);

        System.out.println("Before:");
        System.out.println(blockchain);

        blockchain.validateBlockchain();


        //Change the components of transaction manually:
        blockchain.getBlocks().get(1).setAmount(1000.01);
        System.out.println("After: ");
        System.out.println(blockchain);
        //Validating
        blockchain.validateBlockchain();

    }
}