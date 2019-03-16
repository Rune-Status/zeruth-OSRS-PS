package org.arcanium.tools;

import java.math.BigInteger;
import java.security.*;
import java.security.spec.RSAPrivateKeySpec;
import java.security.spec.RSAPublicKeySpec;

/**
 * A class to generate a simple 1024 bit RSA pair
 * @author Nikki
 */
public class RSAKeyGen {

    public static void main(String[] args) {
        try {
            KeyFactory factory = KeyFactory.getInstance("RSA");
            KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
            keyGen.initialize(1024);
            KeyPair keypair = keyGen.genKeyPair();
            PrivateKey privateKey = keypair.getPrivate();
            PublicKey publicKey = keypair.getPublic();

            RSAPrivateKeySpec privSpec = factory.getKeySpec(privateKey, RSAPrivateKeySpec.class);

            writeKey("rsapriv", privSpec.getModulus(), privSpec.getPrivateExponent());


            RSAPublicKeySpec pubSpec = factory.getKeySpec(publicKey, RSAPublicKeySpec.class);

            writeKey("rsapub", pubSpec.getModulus(), pubSpec.getPublicExponent());
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static void writeKey(String file, BigInteger modulus, BigInteger exponent) {
        try {
            System.out.println("modulus: " + modulus);
            System.out.println("exp: " + exponent);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

}
