# I'm Feeling Lucky

This is a Fabric mod that multiplies the rolls of vanilla loot tables by a specified amount, meaning that mobs now drop more loot, Hoglins give you more stuff, and more items will be generated in loot chests.

Requires Fabric API.

## Config

By default, the multiplier is set to a value of 1, which means that the loot tables will be essentially unmodified.

To modify the default values:

1. Open Minecraft with the mod loaded at least once.
2. In your `.minecraft` directory, navigate to `config` and open `imfeelingluckyconfig.properties`.
3. In there, you can modify the default values. The higher the `lootMultiplier` field, the greater the amount of loots generated.
4. Below that field are fields that control whether the mod modifies a particular category of loot tables. For instance, `entities` is generally responsible for mob drops, and `gameplay` is primarily responsible for miscellaneous loot tables, such as Piglin trading. Feel free to mess around with the values to get a feel as to which loot table types control which aspects of Minecraft.
5. Take note that you'll have to relaunch Minecraft each time you modify the config for the changes to take effect.

## Why?

Boredom.

To add on to that, this mod could potentially help speedrunners increase their loot chances such that they get a chance to practice the later stages of the game without having to waste their time grinding for loot drops.
