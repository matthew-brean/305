/****************************************************************************
* Created by: Matthew Brean
* Created on: 10/2016
* Magic square solutions recursively
****************************************************************************/
package magicRecursion;
public class mr {
	public static void magicLineRecursive(int[] box,int start){

		if(checkMagic(box))
		{
			printArray(box);
			System.out.println();
		}
		else{
			//loops through all the elements of an array that will
			//switch with a certain spot
			for(int counter = start; counter < 9; counter ++)
			{
					//swap elements
					box = swapArray(box,start,counter);
					//do it again with a different starting spot
					magicLineRecursive(box,start+1);
					//swap back
					box = swapArray(box,start,counter);
				
			}
		}	
	}
		

	public static void printArray(int[] box){
		//prints array
		System.out.println(box[0]+" "+box[1]+" "+box[2]);
		System.out.println(box[3]+" "+box[4]+" "+box[5]);
		System.out.println(box[6]+" "+box[7]+" "+box[8]);
		
		System.out.println("");
	}

	public static int[] swapArray(int[] array,int start,int end){
		//swaps elements of an array
		int temp = array[end];
		array[end] = array[start];
		array[start] = temp;
		
		
		return array;
	}

	public static boolean checkMagic(int [] square) {
		//Code borrowed from Christopher karpinski
		
		int [] rows = new int[8];
		rows[0] = square[0] + square[1] + square[2];
		rows[1] = square[3] + square[4] + square[5];
		rows[2] = square[6] + square[7] + square[8];
		rows[3] = square[0] + square[3] + square[6];
		rows[4] = square[1] + square[4] + square[7];
		rows[5] = square[2] + square[5] + square[8];
		rows[6] = square[0] + square[4] + square[8];
		rows[7] = square[2] + square[4] + square[6];
		
		
		if (rows[0] == rows[1] && rows[1] == rows[2] && rows[2] == rows[3] && rows[3] == rows[4]
				&& rows[4] == rows[5] && rows[5] == rows[6] && rows[6] == rows[7]) {
			
			return true;
			
		}
		else {
			return false;
		}
		
	}

	
	public static void main(String[] args) {

		int[] numberList = {1,2,3,4,5,6,7,8,9};

		magicLineRecursive(numberList,0);
		System.out.println("done");
	}

}