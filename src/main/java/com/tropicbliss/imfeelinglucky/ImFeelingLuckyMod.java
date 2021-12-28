package com.tropicbliss.imfeelinglucky;

import com.tropicbliss.imfeelinglucky.config.Config;
import com.tropicbliss.imfeelinglucky.events.handler.LootTableLoadingHandler;
import net.fabricmc.api.ClientModInitializer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ImFeelingLuckyMod implements ClientModInitializer {

  public static final String MOD_ID = "imfeelinglucky";
  public static final Logger LOGGER = LogManager.getLogger(MOD_ID);

  @Override
  public void onInitializeClient() {
    Config.init();
    LootTableLoadingHandler.init();
    LOGGER.info("Hello, world!");
  }
}
