package net.runelite.runescape;

import net.runelite.api.ChatMessageType;
import net.runelite.api.events.SetMessage;
import net.runelite.mapping.*;
import net.runelite.rs.api.RSMessageNode;

@ObfuscatedName("bw")
@Implements("ChatLine")
public class ChatLine extends CacheableNode implements RSMessageNode {
    @ObfuscatedName("sl")
    @ObfuscatedSignature(
            signature = "Lr;"
    )
    @Export("tradingPost")
    static TradingPost tradingPost;
    @ObfuscatedName("ca")
    @ObfuscatedGetter(
            intValue = -1482801989
    )
    @Export("currentPressedKey")
    public static int currentPressedKey;
    @ObfuscatedName("l")
    @ObfuscatedSignature(
            signature = "Lkj;"
    )
    class132 friendState;
    @ObfuscatedName("r")
    @ObfuscatedGetter(
            intValue = -1217933647
    )
    @Export("tick")
    int tick;
    @ObfuscatedName("e")
    @ObfuscatedGetter(
            intValue = 183819129
    )
    @Export("type")
    int type;
    @ObfuscatedName("w")
    @Export("clan")
    String clan;
    @ObfuscatedName("q")
    @Export("name")
    String name;
    @ObfuscatedName("b")
    @ObfuscatedSignature(
            signature = "Lkj;"
    )
    @Export("ignoreStats")
    class132 ignoreState;
    @ObfuscatedName("n")
    @Export("value")
    String value;
    @ObfuscatedName("c")
    @ObfuscatedSignature(
            signature = "Lkg;"
    )
    Name field592;
    public String runeLiteFormatMessage;
    public int rl$timestamp;
    @ObfuscatedName("g")
    @ObfuscatedGetter(
            intValue = 418727015
    )
    int id;

    ChatLine(int var1, String var2, String var3, String var4) {
        this.friendState = class132.UNSET;
        this.ignoreState = class132.UNSET;
        int var5 = ++class202.field1246 - 1;
        this.id = var5;
        this.tick = client.gameCycle;
        this.type = var1;
        this.name = var2;
        this.method5650();
        this.clan = var3;
        this.value = var4;
        this.rl$$init();
    }

    @ObfuscatedName("r")
    @ObfuscatedSignature(
            signature = "(S)V",
            garbageValue = "27658"
    )
    void method5652() {
        this.friendState = class132.UNSET;
    }

    @ObfuscatedName("e")
    @ObfuscatedSignature(
            signature = "(I)Z",
            garbageValue = "-1029850765"
    )
    final boolean method5645() {
        if (this.friendState == class132.UNSET) {
            this.method5646();
        }

        return this.friendState == class132.CONTAINS;
    }

    @ObfuscatedName("q")
    @ObfuscatedSignature(
            signature = "(B)V",
            garbageValue = "114"
    )
    void method5646() {
        this.friendState = ServerProt.friendManager.friendContainer.method5247(this.field592) ? class132.CONTAINS : class132.NOT_CONTAINS;
    }

    @ObfuscatedName("m")
    @ObfuscatedSignature(
            signature = "(I)V",
            garbageValue = "-1866478842"
    )
    final void method5650() {
        if (this.name != null) {
            this.field592 = new Name(class202.method4069(this.name), client.loginType);
        } else {
            this.field592 = null;
        }

    }

    @ObfuscatedName("p")
    @ObfuscatedSignature(
            signature = "(I)V",
            garbageValue = "5682924"
    )
    void method5649() {
        this.ignoreState = ServerProt.friendManager.ignoreContainer.method5247(this.field592) ? class132.CONTAINS : class132.NOT_CONTAINS;
    }

    @ObfuscatedName("c")
    @ObfuscatedSignature(
            signature = "(B)V",
            garbageValue = "-16"
    )
    void method5647() {
        this.ignoreState = class132.UNSET;
    }

    public int getRSType() {
        return this.type;
    }

    public ChatMessageType getType() {
        return ChatMessageType.of(this.getRSType());
    }

    public String getName() {
        return this.name;
    }

    public String getSender() {
        return this.clan;
    }

    public String getValue() {
        return this.value;
    }

    public void setMessage(int var1, String var2, String var3, String var4) {
        this.runeLiteFormatMessage = null;
        this.rl$timestamp = (int) (System.currentTimeMillis() / 1000L);
        SetMessage var5 = new SetMessage();
        var5.setMessageNode(this);
        var5.setType(ChatMessageType.of(var1));
        var5.setName(var2);
        var5.setSender(var3);
        var5.setValue(var4);
        var5.setTimestamp(this.rl$timestamp);
        class166.clientInstance.getCallbacks().post(var5);
    }

    private void rl$$init() {
        this.rl$timestamp = (int) (System.currentTimeMillis() / 1000L);
        SetMessage var1 = new SetMessage();
        var1.setMessageNode(this);
        var1.setType(this.getType());
        var1.setName(this.getName());
        var1.setSender(this.getSender());
        var1.setValue(this.getValue());
        var1.setTimestamp(this.rl$timestamp);
        class166.clientInstance.getCallbacks().post(var1);
    }

    public String getRuneLiteFormatMessage() {
        return this.runeLiteFormatMessage;
    }

    public void setRuneLiteFormatMessage(String var1) {
        this.runeLiteFormatMessage = var1;
    }

    public int getTimestamp() {
        return this.rl$timestamp;
    }

    public void setTimestamp(int var1) {
        this.rl$timestamp = var1;
    }

    public int getId() {
        return this.id;
    }

    public void setName(String var1) {
        this.name = var1;
    }

    public void setSender(String var1) {
        this.clan = var1;
    }

    public void setValue(String var1) {
        this.value = var1;
    }

    @ObfuscatedName("i")
    @ObfuscatedSignature(
            signature = "(B)Z",
            garbageValue = "40"
    )
    final boolean method5642() {
        if (this.ignoreState == class132.UNSET) {
            this.method5649();
        }

        return this.ignoreState == class132.CONTAINS;
    }

    @ObfuscatedName("g")
    @ObfuscatedSignature(
            signature = "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V",
            garbageValue = "-1677696048"
    )
    void method5643(int var1, String var2, String var3, String var4) {
        int var5 = ++class202.field1246 - 1;
        this.id = var5;
        this.tick = client.gameCycle;
        this.type = var1;
        this.name = var2;
        this.method5650();
        this.clan = var3;
        this.value = var4;
        this.setMessage(var1, var2, var3, var4);
    }

    @ObfuscatedName("ik")
    @ObfuscatedSignature(
            signature = "(I)Z",
            garbageValue = "16748608"
    )
    static boolean method5673() {
        return client.field790;
    }

    @ObfuscatedName("a")
    @ObfuscatedSignature(
            signature = "(ILcx;ZI)I",
            garbageValue = "1702001840"
    )
    static int method5653(int var0, class106 var1, boolean var2) {
        ComponentType var3 = var2 ? class113.field75 : class48.field1080;
        if (var0 == 1700) {
            class48.intStack[++class228.intStackSize - 1] = var3.linkObjType;
            return 1;
        } else if (var0 == 1701) {
            if (var3.linkObjType != -1) {
                class48.intStack[++class228.intStackSize - 1] = var3.linkObjCount;
            } else {
                class48.intStack[++class228.intStackSize - 1] = 0;
            }

            return 1;
        } else if (var0 == 1702) {
            class48.intStack[++class228.intStackSize - 1] = var3.index;
            return 1;
        } else {
            return 2;
        }
    }

    @ObfuscatedName("g")
    @ObfuscatedSignature(
            signature = "(ILjava/lang/String;Ljava/lang/String;I)V",
            garbageValue = "-1483885983"
    )
    static void method5672(int var0, String var1, String var2) {
        class192.method3787(var0, var1, var2, (String) null);
    }
}
