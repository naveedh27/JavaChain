package edu.bc.base;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = "singleton")
public class CoreApp {

	private List<Transaction> tranList;

	public CoreApp() {
		System.out.println("Core App Object Creation");
		tranList = new ArrayList<>();
	}

	public void setupGenesis() {
		Block genesis = new Block(0, "0", "Genesis");
		genesis.blockHash = BlockUtils.getHashofBlock(genesis);
		BlockChain.chain.add(genesis);
	}

	public void addBlock() {
		
		if(tranList.size()==0)
			return;
		
		Block b = new Block(BlockUtils.getHeight() + 1, BlockUtils.getLastBlockHash(), tranList.toString());
		b.blockHash = BlockUtils.getHashofBlock(b);
		BlockChain.chain.add(b);
		tranList.clear();
		
	}

	public void updateTransactionList(Transaction tran) {
		tranList.add(tran);
	}

}
