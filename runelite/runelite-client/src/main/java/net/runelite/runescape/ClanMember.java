package net.runelite.runescape;

import net.runelite.api.ClanMemberRank;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSClanMember;

@ObfuscatedName("jm")
@Implements("ClanMember")
public class ClanMember extends ChatPlayer implements RSClanMember {
    @ObfuscatedName("r")
    @ObfuscatedSignature(
            signature = "Lkj;"
    )
    class132 ignoreState;
    @ObfuscatedName("g")
    @ObfuscatedSignature(
            signature = "Lkj;"
    )
    class132 friendState;

    ClanMember() {
        this.friendState = class132.UNSET;
        this.ignoreState = class132.UNSET;
    }

    @ObfuscatedName("r")
    @ObfuscatedSignature(
            signature = "(I)Z",
            garbageValue = "-1822391492"
    )
    public final boolean method963() {
        if (this.friendState == class132.UNSET) {
            this.method978();
        }

        return this.friendState == class132.CONTAINS;
    }

    @ObfuscatedName("e")
    @ObfuscatedSignature(
            signature = "(I)V",
            garbageValue = "955248941"
    )
    void method978() {
        this.friendState = ServerProt.friendManager.friendContainer.method5247(super.name) ? class132.CONTAINS : class132.NOT_CONTAINS;
    }

    @ObfuscatedName("q")
    @ObfuscatedSignature(
            signature = "(I)V",
            garbageValue = "-134704911"
    )
    void method965() {
        this.ignoreState = class132.UNSET;
    }

    @ObfuscatedName("c")
    @ObfuscatedSignature(
            signature = "(B)Z",
            garbageValue = "16"
    )
    public final boolean method966() {
        if (this.ignoreState == class132.UNSET) {
            this.method976();
        }

        return this.ignoreState == class132.CONTAINS;
    }

    public String getUsername() {
        return this.getRsName().getName();
    }

    public ClanMemberRank getRank() {
        return ClanMemberRank.valueOf(this.getRSRank());
    }

    @ObfuscatedName("i")
    @ObfuscatedSignature(
            signature = "(I)V",
            garbageValue = "478358640"
    )
    void method976() {
        this.ignoreState = ServerProt.friendManager.ignoreContainer.method5247(super.name) ? class132.CONTAINS : class132.NOT_CONTAINS;
    }

    @ObfuscatedName("g")
    @ObfuscatedSignature(
            signature = "(I)V",
            garbageValue = "-1236720127"
    )
    void method962() {
        this.friendState = class132.UNSET;
    }

    @ObfuscatedName("c")
    @ObfuscatedSignature(
            signature = "(I)Z",
            garbageValue = "-206655980"
    )
    public static final boolean method981() {
        KeyFocusListener var0 = KeyFocusListener.keyboard;
        synchronized (KeyFocusListener.keyboard) {
            if (KeyFocusListener.field388 == KeyFocusListener.field390) {
                return false;
            } else {
                ChatLine.currentPressedKey = KeyFocusListener.field369[KeyFocusListener.field388];
                FaceNormal.currentTypedKey = KeyFocusListener.field384[KeyFocusListener.field388];
                KeyFocusListener.field388 = KeyFocusListener.field388 + 1 & 127;
                return true;
            }
        }
    }
}
