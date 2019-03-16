package net.runelite.runescape;

import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("es")
public class class230 extends class127 {
   @ObfuscatedName("qh")
   @ObfuscatedGetter(
      intValue = 1128588499
   )
   static int field1939;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -550934847
   )
   public static int canvasHeight;
   @ObfuscatedName("g")
   final boolean field1936;

   public class230(boolean var1) {
      this.field1936 = var1;
   }

   public int compare(Object var1, Object var2) {
      return this.method4542((ChatPlayer)var1, (ChatPlayer)var2);
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Lkv;Lkv;I)I",
      garbageValue = "1276746081"
   )
   int method4542(ChatPlayer var1, ChatPlayer var2) {
      if(client.world == var1.world) {
         if(var2.world != client.world) {
            return this.field1936?-1:1;
         }
      } else if(var2.world == client.world) {
         return this.field1936?1:-1;
      }

      return this.method2141(var1, var2);
   }

   @ObfuscatedName("ig")
   @ObfuscatedSignature(
      signature = "(Lbk;IIIB)V",
      garbageValue = "99"
   )
   static final void method4544(PlayerEntity var0, int var1, int var2, int var3) {
      if(class4.localPlayer != var0) {
         if(client.menuOptionCount < 400) {
            String var4;
            int var7;
            if(var0.totalLevel == 0) {
               String var5 = var0.tagFragments[0] + var0.name + var0.tagFragments[1];
               var7 = var0.combatLevel;
               int var8 = class4.localPlayer.combatLevel;
               int var9 = var8 - var7;
               String var6;
               if(var9 < -9) {
                  var6 = class31.method548(16711680);
               } else if(var9 < -6) {
                  var6 = class31.method548(16723968);
               } else if(var9 < -3) {
                  var6 = class31.method548(16740352);
               } else if(var9 < 0) {
                  var6 = class31.method548(16756736);
               } else if(var9 > 9) {
                  var6 = class31.method548(65280);
               } else if(var9 > 6) {
                  var6 = class31.method548(4259584);
               } else if(var9 > 3) {
                  var6 = class31.method548(8453888);
               } else if(var9 > 0) {
                  var6 = class31.method548(12648192);
               } else {
                  var6 = class31.method548(16776960);
               }

               var4 = var5 + var6 + " " + " (" + "level-" + var0.combatLevel + ")" + var0.tagFragments[2];
            } else {
               var4 = var0.tagFragments[0] + var0.name + var0.tagFragments[1] + " " + " (" + "skill-" + var0.totalLevel + ")" + var0.tagFragments[2];
            }

            int var10;
            if(client.itemSelectionState == 1) {
               class316.method5992("Use", client.lastSelectedItemName + " " + "->" + " " + class31.method548(16777215) + var4, 14, var1, var2, var3);
            } else if(client.spellSelected) {
               if((FontName.ifTargetMask & 8) == 8) {
                  class316.method5992(client.targetVerb, client.opBase + " " + "->" + " " + class31.method548(16777215) + var4, 15, var1, var2, var3);
               }
            } else {
               for(var10 = 7; var10 >= 0; --var10) {
                  if(client.playerOptions[var10] != null) {
                     short var11 = 0;
                     if(client.playerOptions[var10].equalsIgnoreCase("Attack")) {
                        if(AttackOpPriority.HIDDEN == client.playerAttackOpPriority) {
                           continue;
                        }

                        if(AttackOpPriority.UNPRIORITISED == client.playerAttackOpPriority || client.playerAttackOpPriority == AttackOpPriority.COMBAT_LEVEL_BASED && var0.combatLevel > class4.localPlayer.combatLevel) {
                           var11 = 2000;
                        }

                        if(class4.localPlayer.team != 0 && var0.team != 0) {
                           if(var0.team == class4.localPlayer.team) {
                              var11 = 2000;
                           } else {
                              var11 = 0;
                           }
                        }
                     } else if(client.playerOptionsPriorities[var10]) {
                        var11 = 2000;
                     }

                     boolean var12 = false;
                     var7 = client.playerMenuTypes[var10] + var11;
                     class316.method5992(client.playerOptions[var10], class31.method548(16777215) + var4, var7, var1, var2, var3);
                  }
               }
            }

            for(var10 = 0; var10 < client.menuOptionCount; ++var10) {
               if(client.menuTypes[var10] == 23) {
                  client.menuTargets[var10] = class31.method548(16777215) + var4;
                  break;
               }
            }

         }
      }
   }
}
