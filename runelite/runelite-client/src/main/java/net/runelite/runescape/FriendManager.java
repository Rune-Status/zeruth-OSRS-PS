package net.runelite.runescape;

import net.runelite.api.events.RemovedFriend;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.api.RSFriendContainer;
import net.runelite.rs.api.RSFriendManager;
import net.runelite.rs.api.RSIgnoreContainer;
import net.runelite.rs.api.RSName;

@ObfuscatedName("bh")
@Implements("FriendManager")
public class FriendManager implements RSFriendManager {
    @ObfuscatedName("s")
    @ObfuscatedGetter(
            intValue = 615739369
    )
    public static int canvasWidth;
    @ObfuscatedName("l")
    @ObfuscatedSignature(
            signature = "Lkb;"
    )
    public final class215 ignoreContainer;
    @ObfuscatedName("q")
    @ObfuscatedSignature(
            signature = "Llq;"
    )
    final JagexLoginType jagexLoginType;
    @ObfuscatedName("b")
    @ObfuscatedGetter(
            intValue = -2048075613
    )
    int state;
    @ObfuscatedName("c")
    @ObfuscatedSignature(
            signature = "Lkl;"
    )
    public final FriendContainer friendContainer;

    @ObfuscatedSignature(
            signature = "(Llq;)V"
    )
    FriendManager(JagexLoginType var1) {
        this.state = 0;
        this.jagexLoginType = var1;
        this.friendContainer = new FriendContainer(var1);
        this.ignoreContainer = new class215(var1);
    }

    @ObfuscatedName("f")
    @ObfuscatedSignature(
            signature = "(I)Z",
            garbageValue = "-831196560"
    )
    final boolean method52() {
        return this.friendContainer.method5226() || this.friendContainer.method5225() >= 200 && client.field761 != 1;
    }

    @ObfuscatedName("r")
    @ObfuscatedSignature(
            signature = "(S)V",
            garbageValue = "22193"
    )
    final void method97() {
        this.state = 1;
    }

    @ObfuscatedName("e")
    @ObfuscatedSignature(
            signature = "(Lgl;IB)V",
            garbageValue = "2"
    )
    final void method46(Packet var1, int var2) {
        this.friendContainer.method2422(var1, var2);
        this.state = 2;
        IndexStoreActionHandler.method5750();
    }

    @ObfuscatedName("af")
    @ObfuscatedSignature(
            signature = "(Lkg;B)Z",
            garbageValue = "-26"
    )
    final boolean method57(Name var1) {
        Friend var2 = (Friend) this.friendContainer.method5228(var1);
        return var2 != null && var2.method797();
    }

    @ObfuscatedName("q")
    @ObfuscatedSignature(
            signature = "(I)V",
            garbageValue = "337164100"
    )
    final void method116() {
        for (class309 var1 = (class309) this.friendContainer.field3717.method3624(); var1 != null; var1 = (class309) this.friendContainer.field3717.method3625()) {
            if ((long) var1.field3736 < Tile.method4297() / 1000L - 5L) {
                if (var1.field3735 > 0) {
                    ChatLine.method5672(5, "", var1.field3734 + " has logged in.");
                }

                if (var1.field3735 == 0) {
                    ChatLine.method5672(5, "", var1.field3734 + " has logged out.");
                }

                var1.method2692();
            }
        }

    }

    @ObfuscatedName("m")
    @ObfuscatedSignature(
            signature = "(Ljava/lang/String;B)V",
            garbageValue = "-49"
    )
    final void method51(String var1) {
        if (var1 != null) {
            Name var2 = new Name(var1, this.jagexLoginType);
            if (var2.method4714()) {
                if (this.method52()) {
                    class112.method1958();
                } else if (class4.localPlayer.name.equals(var2)) {
                    class196.method4010();
                } else if (this.method69(var2, false)) {
                    WorldMapType1.method2464(var1);
                } else if (this.method96(var2)) {
                    class115.method2002("Please remove " + var1 + " from your ignore list first");
                } else {
                    class204.method4095(var1);
                }
            }
        }
    }

    @ObfuscatedName("p")
    @ObfuscatedSignature(
            signature = "(Lkg;I)Z",
            garbageValue = "1440386847"
    )
    final boolean method96(Name var1) {
        return var1 == null ? false : this.ignoreContainer.method5247(var1);
    }

    @ObfuscatedName("a")
    @ObfuscatedSignature(
            signature = "(Ljava/lang/String;I)V",
            garbageValue = "1778002338"
    )
    final void method53(String var1) {
        if (var1 != null) {
            Name var2 = new Name(var1, this.jagexLoginType);
            if (var2.method4714()) {
                if (this.method54()) {
                    class115.method2002("Your ignore list is full. Max of 100 for free users, and 400 for members");
                } else if (class4.localPlayer.name.equals(var2)) {
                    class115.method2002("You can\'t add yourself to your own ignore list");
                } else if (this.method96(var2)) {
                    LoginProt.method872(var1);
                } else if (this.method69(var2, false)) {
                    WorldMapData.method1055(var1);
                } else {
                    TcpConnectionMessage var3 = FaceNormal.method5726(ClientProt.IGNORELIST_ADD, client.serverConnection.isaac);
                    var3.packetBuffer.putByte(AbstractSoundSystem.method338(var1));
                    var3.packetBuffer.method6198(var1);
                    client.serverConnection.method5881(var3);
                }
            }
        }
    }

    @ObfuscatedName("c")
    @ObfuscatedSignature(
            signature = "(I)V",
            garbageValue = "-1601565488"
    )
    final void method48() {
        this.state = 0;
        this.friendContainer.method5224();
        this.ignoreContainer.method5224();
    }

    public void rl$removeFriend(String var1) {
        RemovedFriend var2 = new RemovedFriend(var1);
        class166.clientInstance.getCallbacks().post(var2);
    }

    public RSFriendContainer getFriendContainer() {
        return this.friendContainer;
    }

    public RSIgnoreContainer getIgnoreContainer() {
        return this.ignoreContainer;
    }

    public boolean isFriended(RSName var1, boolean var2) {
        return this.method69((Name) var1, var2);
    }

    @ObfuscatedName("i")
    @ObfuscatedSignature(
            signature = "(Lkg;ZB)Z",
            garbageValue = "3"
    )
    final boolean method69(Name var1, boolean var2) {
        return var1 == null ? false : (var1.equals(class4.localPlayer.name) ? true : this.friendContainer.method2421(var1, var2));
    }

    @ObfuscatedName("y")
    @ObfuscatedSignature(
            signature = "(Ljava/lang/String;I)V",
            garbageValue = "-781698198"
    )
    final void method55(String var1) {
        this.rl$removeFriend(var1);
        if (var1 != null) {
            Name var2 = new Name(var1, this.jagexLoginType);
            if (var2.method4714()) {
                if (this.friendContainer.method5231(var2)) {
                    client.lastFriendTransmit = client.cycleCntr;
                    TcpConnectionMessage var3 = FaceNormal.method5726(ClientProt.FRIENDLIST_DEL, client.serverConnection.isaac);
                    var3.packetBuffer.putByte(AbstractSoundSystem.method338(var1));
                    var3.packetBuffer.method6198(var1);
                    client.serverConnection.method5881(var3);
                }

                IndexStoreActionHandler.method5750();
            }
        }
    }

    @ObfuscatedName("s")
    @ObfuscatedSignature(
            signature = "(B)Z",
            garbageValue = "114"
    )
    final boolean method54() {
        return this.ignoreContainer.method5226() || this.ignoreContainer.method5225() >= 100 && client.field761 != 1;
    }

    @ObfuscatedName("u")
    @ObfuscatedSignature(
            signature = "(Ljava/lang/String;B)V",
            garbageValue = "1"
    )
    final void method73(String var1) {
        if (var1 != null) {
            Name var2 = new Name(var1, this.jagexLoginType);
            if (var2.method4714()) {
                if (this.ignoreContainer.method5231(var2)) {
                    client.lastFriendTransmit = client.cycleCntr;
                    TcpConnectionMessage var3 = FaceNormal.method5726(ClientProt.IGNORELIST_DEL, client.serverConnection.isaac);
                    var3.packetBuffer.putByte(AbstractSoundSystem.method338(var1));
                    var3.packetBuffer.method6198(var1);
                    client.serverConnection.method5881(var3);
                }

                GrandExchangeEvent.method808();
            }
        }
    }

    @ObfuscatedName("g")
    @ObfuscatedSignature(
            signature = "(I)Z",
            garbageValue = "-1806746806"
    )
    boolean method44() {
        return this.state == 2;
    }

    @ObfuscatedName("gw")
    @ObfuscatedSignature(
            signature = "(Lbc;IIIIII)V"
    )
    static final void method121(PathingEntity var0, int var1, int var2, int var3, int var4, int var5, int var6) {
        if (SceneManager.shouldDraw(var0, true)) {
            SceneManager.copy$draw2DExtras(var0, var1, var2, var3, var4, var5, var6);
        }

    }

    @ObfuscatedName("r")
    @ObfuscatedSignature(
            signature = "(I)V",
            garbageValue = "777647557"
    )
    static void method119() {
        WorldMapRegion.field235.method5738();
        WorldMapRegion.field232.method5738();
    }

    @ObfuscatedName("c")
    @ObfuscatedSignature(
            signature = "(Liu;II)Lli;",
            garbageValue = "11017437"
    )
    public static IndexedSprite method56(Js5Index var0, int var1) {
        byte[] var3 = var0.method1520(var1);
        boolean var2;
        if (var3 == null) {
            var2 = false;
        } else {
            SceneTilePaint.method667(var3);
            var2 = true;
        }

        return !var2 ? null : Overlay.method405();
    }

    @ObfuscatedName("j")
    @ObfuscatedSignature(
            signature = "(Lhn;IIII)V",
            garbageValue = "-1773077018"
    )
    static final void method91(ComponentType var0, int var1, int var2, int var3) {
        if (var0.opKeyRates == null) {
            throw new RuntimeException();
        } else {
            var0.opKeyRates[var1] = var2;
            var0.field2745[var1] = var3;
        }
    }

    @ObfuscatedName("g")
    @ObfuscatedSignature(
            signature = "(I[BLfp;I)V",
            garbageValue = "-1064325267"
    )
    static void method120(int var0, byte[] var1, IndexFile var2) {
        FileSystem var3 = new FileSystem();
        var3.type = 0;
        var3.hash = (long) var0;
        var3.field3212 = var1;
        var3.index = var2;
        Deque var4 = IndexStoreActionHandler.IndexStoreActionHandler_requestQueue;
        synchronized (IndexStoreActionHandler.IndexStoreActionHandler_requestQueue) {
            IndexStoreActionHandler.IndexStoreActionHandler_requestQueue.method4351(var3);
        }

        Object var9 = IndexStoreActionHandler.IndexStoreActionHandler_lock;
        synchronized (IndexStoreActionHandler.IndexStoreActionHandler_lock) {
            if (IndexStoreActionHandler.field3243 == 0) {
                IndexStoreActionHandler.IndexStoreActionHandler_thread = new Thread(new IndexStoreActionHandler());
                IndexStoreActionHandler.IndexStoreActionHandler_thread.setDaemon(true);
                IndexStoreActionHandler.IndexStoreActionHandler_thread.start();
                IndexStoreActionHandler.IndexStoreActionHandler_thread.setPriority(5);
            }

            IndexStoreActionHandler.field3243 = 600;
        }
    }
}
