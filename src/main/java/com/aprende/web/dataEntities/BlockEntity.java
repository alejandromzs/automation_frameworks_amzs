package com.aprende.web.dataEntities;

public class BlockEntity {
    private String hash;
    private String prev_block;

    public BlockEntity(String prev_block, String hash) {
        this.prev_block=prev_block;
        this.hash=hash;
    }

    public String getHash() {
        return hash;
    }

    public String getPrev_block() {
        return prev_block;
    }

    @Override
    public String toString() {
        return "BlockEntity{" +
                "hash='" + hash + '\'' +
                ", prev_block='" + prev_block + '\'' +
                '}';
    }
}
