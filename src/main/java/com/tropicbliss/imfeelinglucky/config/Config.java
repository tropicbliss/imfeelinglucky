package com.tropicbliss.imfeelinglucky.config;

import com.tropicbliss.imfeelinglucky.ImFeelingLuckyMod;

public class Config {

  private static int dropMultiplier;
  private static boolean blocks;
  private static boolean chests;
  private static boolean entities;
  private static boolean gameplay;

  public static void init() {
    SimpleConfig CONFIG = SimpleConfig.of(ImFeelingLuckyMod.MOD_ID + "config")
        .provider(Config::provider).request();
    dropMultiplier = CONFIG.getOrDefault("lootMultiplier", 1);
    blocks = CONFIG.getOrDefault("blocks", false);
    chests = CONFIG.getOrDefault("chests", true);
    entities = CONFIG.getOrDefault("entities", true);
    gameplay = CONFIG.getOrDefault("gameplay", true);
  }

  private static String provider(String filename) {
    return "dropMultiplier=1\n\n# Vanilla loot tables\nblocks=false\nchests=true\nentities=true\ngameplay=true\n";
  }

  public static int getDropMultiplier() {
    return dropMultiplier;
  }

  public static boolean isBlocks() {
    return blocks;
  }

  public static boolean isChests() {
    return chests;
  }

  public static boolean isEntities() {
    return entities;
  }

  public static boolean isGameplay() {
    return gameplay;
  }
}
