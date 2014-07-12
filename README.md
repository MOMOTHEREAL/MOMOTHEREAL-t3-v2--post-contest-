MOMOTHEREAL's ten.java submission
==============================

[![ten.java](https://cdn.mediacru.sh/hu4CJqRD7AiB.svg)](https://tenjava.com/)

This is a submission for the 2014 ten.java contest.

- __Theme:__ What random events can occur in Minecraft?
- __Time:__ Time 3 (7/12/2014 14:00 to 7/13/2014 00:00 UTC)
- __MC Version:__ 1.7.9 (latest Bukkit beta)
- __Stream URL:__ https://twitch.tv/MOMOTHEREAL

<!-- put chosen theme above -->

---------------------------------------

Compilation
-----------

- Download & Install [Maven 3](http://maven.apache.org/download.html)
- Clone the repository: `git clone https://github.com/tenjava/MOMOTHEREAL-t3`
- Compile and create the plugin package using Maven: `mvn`

Maven will download all required dependencies and build a ready-for-use plugin package!

---------------------------------------

Usage
-----

1. Install plugin
2. Wait until the rain comes after you, and you will need a shelter!

You can stop the effects of the plugin with the command: /toggleacidic.

---------------------------------------

Description
-----

__AcidicWeather__ adds more hardcore elements to the normal weather in Minecraft.


Acidic Weather has a 20% chance of happening as soon as the weather changes to snow/rain.

- __Acid Rain__: Brings any player in contact with rain to half a heart in 40 seconds.
- __Black Ice__: Spawns ice spikes around any player in a snowy biome every 2 seconds.
- __Hail__: There is a 20% chance of hail spawning in all generated snow biomes. In total, 5 hail blocks will spawn per chunk, and they will all despawn after a minute.
- __Blizzard__: There is a 20% chance of snowballs falling from the sky in snow biomes. In total,  20 waves (one per second) of 10 snowballs will spawn per chunk (very resource intensive!).

There is also a 10% chance of a __heatstroke__ to start when the weather turns back to sunny in a desert.
The heatstroke puts anyone in a desert on fire and gives them Slowness, Confusion and Blindness for UNTIL they drink a regular water bottle.

The hardcore events occuring on weather downfall will not stop until the weather clears itself (or by using /toggledownfall, obviously).
You can always stop these effects using /toggleacidic

---------------------------------------

Commands
-----

__/toggleacidic (aliases: /tacidic, /toggleacid, /ta, permission: acidic.toggle)__: Toggles the features of the plugin.
__/acidrain (aliases: /acid, permission: acidic.acidrain)__: Starts an acid rain.
__/hail (aliases: /hailstorm, permission: acidic.hail)__: Starts a hail fall.
__/heatstroke (aliases: /heat, permission: acidic.heatstroke)__: Starts a heat stroke.
__/blackice (aliases: none, permission: acidic.blackice)__: Starts a black ice storm.
__/blizzard (aliases: none, permission: acidic.blizzard)__: Starts a blizzard storm.
