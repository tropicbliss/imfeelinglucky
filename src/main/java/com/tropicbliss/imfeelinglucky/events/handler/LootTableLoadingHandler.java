package com.tropicbliss.imfeelinglucky.events.handler;

import com.tropicbliss.imfeelinglucky.config.Config;
import java.util.List;
import net.fabricmc.fabric.api.loot.v1.FabricLootPool;
import net.fabricmc.fabric.api.loot.v1.FabricLootPoolBuilder;
import net.fabricmc.fabric.api.loot.v1.FabricLootSupplier;
import net.fabricmc.fabric.api.loot.v1.FabricLootSupplierBuilder;
import net.fabricmc.fabric.api.loot.v1.event.LootTableLoadingCallback;
import net.minecraft.loot.ConstantLootTableRange;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.LootTableRange;
import net.minecraft.loot.context.LootContextType;
import net.minecraft.loot.function.LootFunction;
import net.minecraft.util.Identifier;

public class LootTableLoadingHandler {

  public static void init() {
    LootTableLoadingCallback.EVENT.register((resourceManager, manager, id, supplier, setter) -> {
      if (matchingPredicate(id)) {
        LootTable table = supplier.build();
        if (table instanceof FabricLootSupplier) {
          LootContextType contextType = ((FabricLootSupplier) table).getType();
          List<LootPool> pools = ((FabricLootSupplier) table).getPools();
          List<LootFunction> functions = ((FabricLootSupplier) table).getFunctions();
          FabricLootSupplierBuilder replacement = FabricLootSupplierBuilder.builder();
          replacement.type(contextType);
          for (LootPool pool : pools) {
            FabricLootPool originalPool = (FabricLootPool) pool;
            LootTableRange originalRoll = originalPool.getRolls();
            FabricLootPoolBuilder modifiablePool = FabricLootPoolBuilder.of(pool);
            if (originalRoll instanceof ConstantLootTableRange) {
              ConstantLootTableRange roll = (ConstantLootTableRange) originalRoll;
              int val = roll.next(null);
              ConstantLootTableRange newRoll = ConstantLootTableRange.create(
                  val * Config.getDropMultiplier());
              modifiablePool.rolls(newRoll);
            }
            replacement.withPool(modifiablePool.build());
          }
          replacement.withFunctions(functions);
          setter.set(replacement.build());
        }
      }
    });
  }

  private static boolean matchingPredicate(Identifier id) {
    if (Config.isBlocks()) {
      if (id.toString().startsWith("minecraft:blocks")) {
        return true;
      }
    }
    if (Config.isChests()) {
      if (id.toString().startsWith("minecraft:chests")) {
        return true;
      }
    }
    if (Config.isEntities()) {
      if (id.toString().startsWith("minecraft:entities")) {
        return true;
      }
    }
    if (Config.isGameplay()) {
      return id.toString().startsWith("minecraft:gameplay");
    }
    return false;
  }
}
