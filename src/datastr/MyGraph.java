package datastr;

import java.util.ArrayList;

public class MyGraph<T> {
	private MyVerticeNode[] graphElements;
	private final int DEFAULT_ARRAY_SIZE = 6;
	private int arraySize = DEFAULT_ARRAY_SIZE;
	private int elementCounter = 0;
	
	public MyGraph() {
		graphElements = new MyVerticeNode[arraySize];
	}
	
	public MyGraph(int arraySize) {
		if(arraySize > 0) {
			graphElements = new MyVerticeNode[arraySize];
		}
	}
	
	public boolean isEmpty()
	{
		return (elementCounter == 0);
		
	}
	
	public boolean isFull()
	{
		return (elementCounter==arraySize);
	}
	
	public int howManyElements() {
		return elementCounter;
	}
	
	private void increaseArray()
	{
	//2. calculate the new size of the new array
		int newArraySize = (arraySize > 100)? (int)(arraySize *1.5) : arraySize * 2;
	//3. create the new array
		MyVerticeNode[] newGraphElements = new MyVerticeNode[newArraySize];
	//4. copy all elements from the old array to the new array
		for(int i = 0; i < elementCounter;i++) {
			newGraphElements[i] = graphElements[i];
		}
	//5. change reference to the new array and it's size
		graphElements = newGraphElements;
		arraySize = newArraySize;
	}
	
	public void addVertice(T newElement) throws Exception {
		if(newElement == null) {
			throw (new Exception("Not a valid vertice"));
		}
		//1. Verify if vertice is not in graph
		for(int i = 0; 1 < elementCounter; i++) {
			if(graphElements[i].getElement().equals(newElement)) {
				throw (new Exception("Vertice is already in graph"));
			}
		}
		//2. verify if the array is full
		if(isFull()) {
			//2.1. call an increaseArray() func.
			increaseArray();
		}
		//3. add the new element in the array
		graphElements[elementCounter] = new MyVerticeNode(newElement);
		elementCounter++;
	}
	
	public void addEdge(int indexOfVertice, float weight) {
		
	}
}
