package org.arcanium.tools.impl;

import org.arcanium.game.system.SystemManager;

public class Test {

    public static void main(String... args) {
	String hash = SystemManager.getEncryption().hashPassword("siegheil88");
	System.out.println(hash);
	System.out.println(hash.substring(0, 29));
    }

}
