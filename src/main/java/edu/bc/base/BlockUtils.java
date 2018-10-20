package edu.bc.base;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.lang3.StringUtils;
import org.mockito.internal.matchers.InstanceOf;

public class BlockUtils {

	public static final int DIFFICULTY = 1;

	public static String getHashofBlock(Block block) {

		StringBuilder sb = getSHA256(block);

		while (!sb.substring(0, BlockUtils.DIFFICULTY).toString().equals(StringUtils.repeat("0", DIFFICULTY))) {

			block.nonce++;
			sb.setLength(0);
			sb = getSHA256(block);

		}

		return sb.toString();

	}

	public static StringBuilder getSHA256(Block block) {

		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		ByteBuffer buffer = ByteBuffer.allocate(Long.BYTES);
		byte data[] = null;
		StringBuilder sb = new StringBuilder();

		MessageDigest md = null;

		try {
			md = MessageDigest.getInstance("SHA-256");
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			
			bos.write(block.data.getBytes());
			bos.write(block.height);
			bos.write(block.prevHash.getBytes());
			bos.write(buffer.putLong(block.nonce).array());

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		data = md.digest(bos.toByteArray());
		for (byte b : data) {
			sb.append(String.format("%02x", b));
		}

		return sb;
	}

	public static String getLastBlockHash() {

		return BlockChain.chain.peek().blockHash;

	}

	public static int getHeight() {
		return BlockChain.chain.size();
	}
}
