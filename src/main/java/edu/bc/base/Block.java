package edu.bc.base;

import java.io.Serializable;

public class Block implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public int height;
	public String prevHash;
	public String data;
	
	
	public long nonce = 0;
	public String blockHash;
	
	public Block(int height, String prevHash, String data) {
		super();
		this.height = height;
		this.prevHash = prevHash;
		this.data = data;
	}

	@Override
	public String toString() {
		return "Block [height=" + height + ", prevHash=" + prevHash + ", data=" + data + ", nonce=" + nonce
				+ ", blockHash=" + blockHash + "]";
	}


	
	

}
