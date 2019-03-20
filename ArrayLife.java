import java.util.*;
public class ArrayLife {
private int width;
private int height;
Pattern pattern;
private boolean [][]world;
Stack <Integer> MyStack=new Stack <Integer>();
public ArrayLife(String Arg) {
	pattern=new Pattern(Arg);
	width=pattern.getWidth();
	height=pattern.getHeight();
	world=new boolean[height][width] ;
	pattern.initialise(world);

}
boolean getCell(int col,int row) {
	if(row<0||row>=height)return false;
	if(col<0||col>=width)return false;
	return world[row][col];}
void setCell(int col,int row,boolean value) {
world[row][col]=value;
}
void print() {
	for(int i=0;i<this.height;i++){
		for(int z=0;z<this.width;z++){
			if(getCell(z,i))System.out.print("#");
			else System.out.print("-");
		}
		System.out.println();
	}
}
int countNeighbours(int col,int row) {
	int number=0;
	for(int i=row-1;i<=row+1;i++){
		for(int z=col-1;z<=col+1;z++){

			if(i!=row||z!=col) {

				if (getCell(z, i)) number++;
			}
		}
	}
	return number;
}

boolean computeCell(int col,int row) {
	int Neighbours=countNeighbours(col,row);
	if(getCell(col,row)==false)
	{
		if(Neighbours==3)
			return true;
		else
			return false;
	}
	else
		{

		if(Neighbours==2||Neighbours==3)return true;
		else
			return false;
		}


}
void NextState(){
	for(int i=0;i<height;i++){
		for(int z=0;z<width;z++){

			if(getCell(z,i)!=computeCell(z,i)){

					if(computeCell(z,i))MyStack.push(1);else MyStack.push(0);
					MyStack.push(i);
					MyStack.push(z);


			}
		}
	}

}
void nextGeneration(){
	NextState();
	while(!MyStack.empty()){
		setCell(MyStack.pop(),MyStack.pop(),MyStack.pop()==1);
	}
}
void play() {
Scanner keyboard=new Scanner(System.in);

while(true){
	System.out.println("Please enter \"s\" to play and \"q\" to quit! : ");
	char Input=keyboard.nextLine().charAt(0);

	if(Input=='s'){
     nextGeneration();
     print();
	}
	else if(Input=='q'){
		System.out.println("Quitting");
		break;
	}
}
}
public static void main(String []args) {
	

	ArrayLife game1=new ArrayLife(args[0]);
	game1.play();
}

}
