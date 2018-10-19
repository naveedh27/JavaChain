package edu.bc.base;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class BlockUtils {

	public static String getHashofBlock(Block block) {

		MessageDigest md = null;
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		try {
			md = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			bos.write(block.data.getBytes());
			bos.write(block.height);
			bos.write(block.prevHash.getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//// byte data [] = md.digest(SerializationUtils.serialize(block));
		byte data[] = md.digest(bos.toByteArray());

		StringBuilder sb = new StringBuilder();
		for (byte b : data) {
			sb.append(String.format("%02x", b));
		}

		return sb.toString();

	}

	public static String getLastBlockHash() {

		return BlockChain.chain.peek().blockHash;

	}

	public static int getHeight() {
		return BlockChain.chain.size();
	}
}
