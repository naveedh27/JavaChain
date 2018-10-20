package edu.bc.spring;

import java.util.Stack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.bc.base.Block;
import edu.bc.base.BlockChain;
import edu.bc.base.CoreApp;
import edu.bc.base.Transaction;

@RestController
public class AppController {

	@Autowired
	CoreApp core;

	@RequestMapping(value = "/getAllBlocks")
	public Stack<Block> allBlocksinXML() {
		return BlockChain.chain;
	}
	
	
	@RequestMapping(value = "/addTransaction", method = RequestMethod.POST)
	public Transaction addTransaction(Transaction tran) {
		core.updateTransactionList(tran);
		return tran;
	}
	
	@RequestMapping("/")
	public String check() {
		return "Up and running";
	}
}