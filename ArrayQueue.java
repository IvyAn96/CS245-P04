package P4;


public class ArrayQueue implements Queue {
	
	
	private int head;
	private int tail;
	private Object[] arr = new Object[10];

	public  ArrayQueue() {
		head = 0;
		tail = 0;
	}
	
	@Override
	public Object dequeue() {
		if(empty()){
			return null;
		}
		Object item = arr[head];
		head++;
		if(head >= arr.length){
			head = 0;
		}
		return item;
	}

	@Override
	public void enqueue(Object item) {
		if(isFull()){
			grow_queue();
		}
		arr[tail] = item;
		tail++;
		if(tail >= arr.length){
			tail = 0;
		}
	}

	@Override
	public boolean empty() {
		if(head == tail){
			return true;
		}
		return false;
	}
	
	private boolean isFull(){
		if((tail + 1) % arr.length == head){
		return true;
		}
	
		return false;
		
	}
	
	private void grow_queue() {
		Object[] new_arr = new Object[arr.length * 2];
		if(head < tail){
			System.arraycopy(arr, 0, new_arr, 0, arr.length);
			arr = new_arr;
		}
		else if(head > tail){
			int count = arr.length - head;
			int arr_index = arr.length - 1;
			int index = 0;
			int j;
			for(j = new_arr.length - 1; j > new_arr.length - count - 1; j--){
				new_arr[j] = arr[arr_index];
				arr_index--; 
			}
			head += arr.length;
			for(int k = 0; k < tail; k++){
				new_arr[k] = arr[index];
				index++;
			}

		}
		arr = new_arr;
	}

}
