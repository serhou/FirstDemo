package com.bestlove.collection;

import java.util.AbstractCollection;
import java.util.Iterator;

/**
 * 在本例中可以看到，如果你实现Collection，就必须实现iterator()，
 * 并且只拿实现iterator()与继承AbstractCollection相比，花费的代价只有
 * 略微减少。但是，如果你的类已经继承了其他的类，那么你就不能再继承
 * AbstractCollection了。在这种情况下，要实现Collection，就必须实现
 * 该接口中的所有方法。此时，继承并提供创建迭代器的能力就会显得容易得多了
 * 
 * @author think
 *
 */

public class CollectionSequence extends AbstractCollection<Pet>{

	private Pet[] pets = Pets.createArray(3);
	
	@Override
	public Iterator<Pet> iterator() {
		return new Iterator<Pet>() {
			private int index = 0;
			@Override
			public boolean hasNext() {
				return index < pets.length;
			}

			@Override
			public Pet next() {
				return pets[index++];
			}
			
			public void remove() {
				throw new UnsupportedOperationException();
			}
		};
	}

	@Override
	public int size() {
		return pets.length;
	}

	
	public static void main(String[] args) {
		
		CollectionSequence cs = new CollectionSequence();
		InterfaceVsIterator.display(cs);
		InterfaceVsIterator.display(cs.iterator());
		
	}
	
	
	
}
