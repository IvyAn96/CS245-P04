package P4;


public class ArrayStack implements Stack {
	private int top;
	private Object[]arr;
	private int size;
	 public static final int DEFAULT_INITIAL_SIZE = 10;
	
	public ArrayStack(){
		top = -1;
		arr = new Object[DEFAULT_INITIAL_SIZE];
		size = DEFAULT_INITIAL_SIZE;
		
	}
	
	
	@Override
	public void push(Object item) {
		if(top == size - 1){
			grow_stack();
		}
			arr[++top] = item;
			
		}

	@Override
	public Object pop() {
		if(top >= 0){
			return arr[top--];
		}
		return null;
	}

	@Override
	public Object peek() {
		if(!empty()){
			return arr[top];
		}
		return null;
	}

	@Override
	public boolean empty() {
		if(top == -1){
			return true;
		}
		return false;
	}
	
	private void grow_stack(){
		Object[] newarr = new Object[arr.length * 2];
		System.arraycopy(arr, 0, newarr, 0, arr.length);
		arr = newarr;
		size = size * 2;
	}
}
