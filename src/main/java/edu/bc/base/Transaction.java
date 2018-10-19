package edu.bc.base;

public class Transaction {
	
	public String fromAddr;
	public String data;
	
	
	public Transaction(String fromAddr, String data) {
		super();
		this.fromAddr = fromAddr;
		this.data = data;
	}
	
	public String getFromAddr() {
		return fromAddr;
	}
	public void setFromAddr(String fromAddr) {
		this.fromAddr = fromAddr;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "Transaction [fromAddr=" + fromAddr + ", data=" + data + "]";
	}
	
	
	
	
}
