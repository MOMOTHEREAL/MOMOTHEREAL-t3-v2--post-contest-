package com.tenjava.entries.MOMOTHEREAL.t3.timing;

import org.bukkit.Material;
import org.bukkit.block.Block;

/**
 * Copyright MOMOTHEREAL (c) 2014.
 */
public class HailDisappear implements Runnable{
    private Block hail;

    public HailDisappear(Block hail) {
        this.hail = hail;
    }


    @Override
    public void run() {
        hail.setType(Material.AIR);
    }
}
