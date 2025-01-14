// Time Complexity : Worst Case: O(n^2), Best Case and Average Case: O(n logn) 
// Space Complexity : O(log n)
class IterativeQuickSort { 
    void swap(int arr[], int i, int j) 
	{ 
		//Try swapping without extra variable 
		if(i != j) {
			arr[i] = arr[i] ^ arr[j];
			arr[j] = arr[i] ^ arr[j]; 
			arr[i] = arr[i] ^ arr[j];	
		}	
	} 

	/* This function is same in both iterative and 
       recursive*/
	int partition(int arr[], int l, int h) 
	{ 
		//Compare elements and swap.
		int top = arr[h];
		int index = (l - 1);
		for (int i = l; i <= h - 1; i++) {
			if (arr[i] <= top) {
				index++;
				swap(arr, index, i);
			}
		}

		int tmp = arr[index + 1];
		arr[index + 1] = arr[h];
		arr[h] = tmp;

		return index + 1;
	} 

	// Sorts arr[l..h] using iterative QuickSort 
	void QuickSort(int arr[], int l, int h) 
	{ 
		//Try using Stack Data Structure to remove recursion.
		Stack<Integer> st = new Stack<>();
        st.push(l);
        st.push(h);
        while (!st.isEmpty()) {
            int high = st.pop();
            int low = st.pop();
            int index = partition(arr, low, high);

            if (index - 1 > low) {
                st.push(low);
                st.push(index - 1);
            }

            if (index + 1 < high) {
                st.push(index + 1);
                st.push(high);
            }

        }
	} 
  
    // A utility function to print contents of arr 
    void printArr(int arr[], int n) 
    { 
        int i; 
        for (i = 0; i < n; ++i) 
            System.out.print(arr[i] + " "); 
    } 
  
    // Driver code to test above 
    public static void main(String args[]) 
    { 
        IterativeQuickSort ob = new IterativeQuickSort(); 
        int arr[] = { 4, 3, 5, 2, 1, 3, 2, 3 }; 
        ob.QuickSort(arr, 0, arr.length - 1); 
        ob.printArr(arr, arr.length); 
    } 
} 