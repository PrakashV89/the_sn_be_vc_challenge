package com.vc.jivox.hackathon.algo;

import java.util.Set;

public interface SearchAlgo<IC, C> {
	Set<C> search(IC contactsBase, Set<C> contacts);
}
