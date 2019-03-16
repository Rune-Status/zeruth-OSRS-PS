package net.runelite.runescape;

import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.io.IOException;
import java.net.Socket;

@ObfuscatedName("bl")
@Implements("PendingSpawn")
public final class PendingSpawn extends Node {
    @ObfuscatedName("l")
    @ObfuscatedGetter(
            intValue = -415095377
    )
    int field935;
    @ObfuscatedName("r")
    @ObfuscatedGetter(
            intValue = 1356360457
    )
    int type;
    @ObfuscatedName("e")
    @ObfuscatedGetter(
            intValue = 1473904323
    )
    int x;
    @ObfuscatedName("w")
    @ObfuscatedGetter(
            intValue = -1710743389
    )
    int id;
    @ObfuscatedName("q")
    @ObfuscatedGetter(
            intValue = -1920385997
    )
    int y;
    @ObfuscatedName("m")
    @ObfuscatedGetter(
            intValue = -841286093
    )
    int hitpoints;
    @ObfuscatedName("p")
    @ObfuscatedGetter(
            intValue = -1284652045
    )
    int delay;
    @ObfuscatedName("b")
    @ObfuscatedGetter(
            intValue = -1965909109
    )
    int field924;
    @ObfuscatedName("n")
    @ObfuscatedGetter(
            intValue = -96414903
    )
    int orientation;
    @ObfuscatedName("c")
    @ObfuscatedGetter(
            intValue = -1115768889
    )
    int field923;
    @ObfuscatedName("i")
    @ObfuscatedGetter(
            intValue = -1158428137
    )
    int field931;
    @ObfuscatedName("g")
    @ObfuscatedGetter(
            intValue = -1360644167
    )
    int level;

    PendingSpawn() {
        this.delay = 0;
        this.hitpoints = -1;
    }

    @ObfuscatedName("t")
    @ObfuscatedSignature(
            signature = "(ILcx;ZI)I",
            garbageValue = "1607736663"
    )
    static int method5556(int var0, class106 var1, boolean var2) {
        ComponentType var3 = var2 ? class113.field75 : class48.field1080;
        if (var0 == 1800) {
            class48.intStack[++class228.intStackSize - 1] = class192.method3781(class101.method1704(var3));
            return 1;
        } else if (var0 != 1801) {
            if (var0 == 1802) {
                if (var3.opBase == null) {
                    class48.scriptStringStack[++class48.scriptStringStackSize - 1] = "";
                } else {
                    class48.scriptStringStack[++class48.scriptStringStackSize - 1] = var3.opBase;
                }

                return 1;
            } else {
                return 2;
            }
        } else {
            int var4 = class48.intStack[--class228.intStackSize];
            --var4;
            if (var3.ops != null && var4 < var3.ops.length && var3.ops[var4] != null) {
                class48.scriptStringStack[++class48.scriptStringStackSize - 1] = var3.ops[var4];
            } else {
                class48.scriptStringStack[++class48.scriptStringStackSize - 1] = "";
            }

            return 1;
        }
    }

    @ObfuscatedName("g")
    @ObfuscatedSignature(
            signature = "(I)[Lfz;",
            garbageValue = "816105871"
    )
    public static ServerProt[] method5554() {
        return new ServerProt[]{ServerProt.STATIC_REGION, ServerProt.LOGOUT, ServerProt.CAM_RESET, ServerProt.MESSAGE_GAME, ServerProt.VARP_LARGE, ServerProt.field2122, ServerProt.LOC_ADD_CHANGE, ServerProt.UPDATE_INV_CLEAR, ServerProt.MAP_ANIM, ServerProt.IF_CLOSESUB, ServerProt.MESSAGE_PRIVATE, ServerProt.MAP_PROJANIM, ServerProt.SOUND_AREA, ServerProt.LOC_DEL, ServerProt.OBJ_DEL, ServerProt.OBJ_COUNT, ServerProt.field2133, ServerProt.UPDATE_ZONE_PARTIAL_ENCLOSED, ServerProt.field2169, ServerProt.IF_SETTEXT, ServerProt.IF_SETOBJECT, ServerProt.IF_SETHIDE, ServerProt.UPDATE_STAT, ServerProt.PLAY_SONG, ServerProt.IF_SETCOLOUR, ServerProt.UPDATE_ZONE_FULL_FOLLOWS, ServerProt.OBJ_ADD, ServerProt.field2181, ServerProt.RESET_ANIMS, ServerProt.FRIENDLIST_LOADED, ServerProt.IF_SETPLAYERHEAD, ServerProt.IF_SETMODEL, ServerProt.UPDATE_IGNORELIST, ServerProt.NPC_INFO_SMALL, ServerProt.field2144, ServerProt.IF_SETNPCHEAD, ServerProt.HINT_ARROW, ServerProt.UPDATE_SITESETTINGS, ServerProt.MESSAGE_PRIVATE_ECHO, ServerProt.CAM_SHAKE, ServerProt.MIDI_JINGLE, ServerProt.field2158, ServerProt.field2203, ServerProt.UPDATE_FRIENDCHAT_CHANNEL_FULL, ServerProt.UPDATE_INV_PARTIAL, ServerProt.UPDATE_FRIENDCHAT_CHANNEL_SINGLEUSER, ServerProt.UPDATE_INV_STOP_TRANSMIT, ServerProt.LOGOUT_TRANSFER, ServerProt.IF_SETTARGETPARAM, ServerProt.LOC_CUSTOMISE, ServerProt.IF_SETANGLE, ServerProt.REBUILD_REGION, ServerProt.TRIGGER_ONDIALOGABORT, ServerProt.REFLECTION_CHECKER, ServerProt.MESSAGE_FRIENDCHANNEL, ServerProt.UPDATE_GRANDEXCHANGE_OFFER, ServerProt.field2173, ServerProt.UPDATE_UID192, ServerProt.UPDATE_FRIENDLIST, ServerProt.IF_SETPOSITION, ServerProt.UPDATE_RUNENERGY, ServerProt.IF_SETANIM, ServerProt.RUNCLIENTSCRIPT, ServerProt.VARP_SMALL, ServerProt.UPDATE_ZONE_PARTIAL_FOLLOWS, ServerProt.SYNTH_SOUND, ServerProt.SET_PLAYER_OP, ServerProt.SET_MAP_FLAG, ServerProt.CHAT_FILTER_SETTINGS_PRIVATECHAT, ServerProt.PING_STATISTICS_REQUEST, ServerProt.UPDATE_INV_FULL, ServerProt.UPDATE_RUNWEIGHT, ServerProt.UPDATE_REBOOT_TIMER, ServerProt.SYNC_CLIENT_VARCACHE, ServerProt.MINIMAP_TOGGLE, ServerProt.CAM_LOOKAT, ServerProt.IF_SETSCROLLPOS, ServerProt.IF_OPEN_SUB, ServerProt.RESET_CLIENT_VARCACHE, ServerProt.UPDATE_PLAYER, ServerProt.CHAT_FILTER_SETTINGS, ServerProt.NPC_INFO_LARGE, ServerProt.IF_MOVESUB, ServerProt.CAM_ANGLE, ServerProt.IF_OPEN_TOP};
    }

    @ObfuscatedName("g")
    @ObfuscatedSignature(
            signature = "(Ljava/net/Socket;III)Lfh;",
            garbageValue = "-1134752844"
    )
    public static class19 method5555(Socket var0, int var1, int var2) throws IOException {
        return new class139(var0, var1, var2);
    }
}
