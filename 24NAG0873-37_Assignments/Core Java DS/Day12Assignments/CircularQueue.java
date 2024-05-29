package Day12Assignments;


public class CircularQueue {

public static int searchElement(int [] arr, int target) {
	int left=0;

int right=arr.length-1;

while(left<=right) {

int mid=left+(right-left)/2;

if(arr[mid]==target) {

return mid;

}
if(arr[left]<=arr[mid]) {

if(arr[left]<=target && target<arr[mid]) {

right=mid-1;

}else {

left=mid+1;

}

}else {

if(arr[mid]<target &&target<=arr[right]) {

left=mid+1;

}else {

right=mid-1;
}
}
}
return -1;
}
public static void main(String[] args) {

int[] arr= {4,7,8,2,0,9,5};

int target=8;

int result=searchElement(arr, target);

if(result!= -1) {

System.out.println(result);

}
}

}

