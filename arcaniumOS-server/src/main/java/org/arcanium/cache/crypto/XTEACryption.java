package org.arcanium.cache.crypto;

import java.nio.ByteBuffer;

/**
 * Holds XTEA cryption methods.
 * @author ?
 * @author Emperor
 */
public final class XTEACryption {

	/**
	 * The delta value
	 */
	private static final int DELTA = -1640531527;

	/**
	 * The sum.
	 */
	private static final int SUM = -957401312;

	/**
	 * The amount of "cryption cycles".
	 */
	private static final int NUM_ROUNDS = 32;

	/**
	 * Constructs a new {@code XTEACryption}.
	 */
	private XTEACryption() {
		/*
		 * empty.
		 */
	}

	/**
	 * Decrypts the contents of the buffer.
	 * @param keys The cryption keys.
	 * @param buffer The buffer.
	 */
	public static ByteBuffer decrypt(int[] keys, ByteBuffer buffer) {
		return decrypt(keys, buffer, buffer.position(), buffer.limit());
	}

	/**
	 * Decrypts the buffer data.
	 * @param keys The keys.
	 * @param buffer The buffer to decrypt.
	 * @param offset The offset of the data to decrypt.
	 * @param length The length.
	 * @return The decrypted data.
	 */
	public static ByteBuffer decrypt(int[] keys, ByteBuffer buffer, int offset, int length) {
		int numBlocks = (length - offset) / 8;
		int[] block = new int[2];
		for (int i = 0; i < numBlocks; i++) {
			int index = i * 8 + offset;
			block[0] = buffer.getInt(index);
			block[1] = buffer.getInt(index + 4);
			decipher(keys, block);
			buffer.putInt(index, block[0]);
			buffer.putInt(index + 4, block[1]);
		}
		return buffer;
	}

	public static ByteBuffer decrypt(ByteBuffer buffer, int[] keys) {
		byte[] readable = new byte[buffer.remaining()];

		buffer.get(readable);

		ByteBuffer xtea_buffer = ByteBuffer.wrap(readable);

		decrypt(keys, readable, 0, readable.length);

		return xtea_buffer;
	}

	private static final int DELTA1 = -0x61c88647;
	private static final int SUM1 = -0x61c88647 * 32;

	public static byte[] decrypt(int[] cryption, byte[] data, int offset, int length) {
		int numBlocks = length / 8;
		int[] dataBlock = new int[2];

		for (int i = 0; i < numBlocks; i++) {
			dataBlock[0] = readInt((i * 8) + offset, data);
			dataBlock[1] = readInt((i * 8) + offset + 4, data);

			long sum = SUM1;
			int round = 0;

			do {
				dataBlock[1] -= (cryption[(int) ((sum & 0x1933) >>> 11)] + sum ^ dataBlock[0] + (dataBlock[0] << 4 ^ dataBlock[0] >>> 5));
				sum -= DELTA1;
				dataBlock[0] -= ((dataBlock[1] << 4 ^ dataBlock[1] >>> 5) + dataBlock[1] ^ cryption[(int) (sum & 0x3)] + sum);
				round++;
			} while(round < 32);

			writeInt(dataBlock[0], (i * 8) + offset, data);
			writeInt(dataBlock[1], (i * 8) + offset + 4, data);
		}
		return data;
	}

	public static void writeInt(int val, int index, byte[] buffer) {
		buffer[index++] = (byte) (val >> 24);
		buffer[index++] = (byte) (val >> 16);
		buffer[index++] = (byte) (val >> 8);
		buffer[index++] = (byte) val;
	}

	public static int readInt(int index, byte[] buffer) {
		return ((buffer[index++] & 0xff) << 24)
				| ((buffer[index++] & 0xff) << 16)
				| ((buffer[index++] & 0xff) << 8) | (buffer[index++] & 0xff);
	}

	/**
	 * Deciphers the values.
	 * @param keys The cryption key.
	 * @param block The values to decipher.
	 */
	private static void decipher(int[] keys, int[] block) {
		long sum = SUM;
		for (int i = 0; i < NUM_ROUNDS; i++) {
			block[1] -= (keys[(int) ((sum & 0x1933) >>> 11)] + sum ^ block[0] + (block[0] << 4 ^ block[0] >>> 5));
			sum -= DELTA;
			block[0] -= ((block[1] << 4 ^ block[1] >>> 5) + block[1] ^ keys[(int) (sum & 0x3)] + sum);
		}
	}

	/**
	 * Encrypts the contents of the byte buffer.
	 * @param keys The cryption keys.
	 * @param buffer The buffer to encrypt.
	 */
	public static void encrypt(int[] keys, ByteBuffer buffer) {
		encrypt(keys, buffer, buffer.position(), buffer.limit());
	}

	/**
	 * Encrypts the buffer data.
	 * @param keys The keys.
	 * @param buffer The buffer to encrypt.
	 * @param offset The offset of the data to encrypt.
	 * @param length The length.
	 * @return The encrypted data.
	 */
	public static void encrypt(int[] keys, ByteBuffer buffer, int offset, int length) {
		int numBlocks = (length - offset) / 8;
		int[] block = new int[2];
		for (int i = 0; i < numBlocks; i++) {
			int index = i * 8 + offset;
			block[0] = buffer.getInt(index);
			block[1] = buffer.getInt(index + 4);
			encipher(keys, block);
			buffer.putInt(index, block[0]);
			buffer.putInt(index + 4, block[1]);
		}
	}

	/**
	 * Enciphers the values of the block.
	 * @param keys The cryption keys.
	 * @param block The block to encipher.
	 */
	private static void encipher(int[] keys, int[] block) {
		long sum = 0;
		for (int i = 0; i < NUM_ROUNDS; i++) {
			block[0] += ((block[1] << 4 ^ block[1] >>> 5) + block[1] ^ keys[(int) (sum & 0x3)] + sum);
			sum += DELTA;
			block[1] += (keys[(int) ((sum & 0x1933) >>> 11)] + sum ^ block[0] + (block[0] << 4 ^ block[0] >>> 5));
		}
	}
}