package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Blockchain {

    private List<Block> blocks=new ArrayList<>(List.of(new Block("", "", 0)));

    public void addTransaction(String accountFrom, String accountTo, double amount){
        if(blocks.get(0).getProof()==0){
            blocks.get(0).setProof(mineProofOfWork(blocks.get(0)));

        }
        Block prevBlock = blocks.get(blocks.size()-1);

        String prevHash = prevBlock.hashData();
        Block addBlock = new Block(accountFrom,accountTo,amount,prevHash);
        int proof=mineProofOfWork(addBlock);
        addBlock.setProof(proof);
        blocks.add(addBlock);



    }
    
    public void validateBlockchain(){
        for (int i = 0; i < blocks.size()-1; i++) {
            String expectedHash = blocks.get(i).hashData();
            String actualHash = blocks.get(i+1).getPrevHash();
            if(!actualHash.equals(expectedHash)){
                System.out.printf("Blockchain is invalid, expected %s ,actual %s",expectedHash,actualHash+"\n");
            }else{
                System.out.printf("Valid hash %s",actualHash+"\n");
            }
        }
    }

    
    //Mining proof of work
    private int mineProofOfWork(Block block){
        int proof = 0;
        while(!isValidProof(block,proof)){
            proof++;
        }

        return proof;
    }

    private boolean isValidProof(Block block, int proof) {
        block.setProof(proof);
        return block.hashData().startsWith("0000");
    }

    public List<Block> getBlocks() {
        return blocks;
    }

    public void setBlocks(List<Block> blocks) {
        this.blocks = blocks;
    }

    @Override
    public String toString() {
        return "Blockchain{" +
                "blocks=" + blocks +
                '}';
    }
}
