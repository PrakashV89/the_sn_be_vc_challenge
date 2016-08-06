package com.vc.jivox.hackathon.algo;

import java.util.Map;
import java.util.Set;

public interface SearchAlgo<IC, C> {
	Set<C> search(IC contactsBase, Set<C> contacts);
	Map<C, Set<C>> searchMultiple(Set<IC> contactsBase, Set<C> contacts);
}
