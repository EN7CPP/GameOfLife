
public class Pattern {
	private String name;
	private String author;
	private int width;
	private int height;
	private int startCol;
	private int startRow;
	private String cells;
	private String[]arr;
	private String []This;
	public String getName() {
		return name;
	}
	public Pattern(String format) {
		 arr=format.split(":");
		 This=arr[6].split(" ");
		 startRow=Integer.parseInt(arr[5]);
		 startCol=Integer.parseInt(arr[4]);
		 width=Integer.parseInt(arr[2]);
		 height=Integer.parseInt(arr[3]);
		 cells=arr[6];
		 name=arr[0];
		 author=arr[1];

	}
	public String getAuthor(){return author;}
	public int getStartCol(){return startCol;}
	public int getStartRow(){return startRow;}

	public String getCells() {
		return cells;
	}

	public int getWidth(){return width;}
	public int getHeight(){return height;}

	public void initialise(boolean[][] world) {
		for(int i=0;i<This.length;i++){
			for(int z=0;z<This[i].length();z++){
				if(This[i].charAt((z))=='0')world[startRow][startCol++]=false;
				else if(This[i].charAt((z))=='1')world[startRow][startCol++]=true;
			}
			startRow++;
			startCol=startCol-This[i].length();
		}
	}
	public static void main(String []args){
		Pattern PATTERN=new Pattern(args[0]);
		System.out.println("Name: "+PATTERN.getName());
		System.out.println("Author: "+PATTERN.getAuthor());
		System.out.println("Width: "+PATTERN.getWidth());
		System.out.println("Height: "+PATTERN.getHeight());
		System.out.println("StartCol: "+PATTERN.getStartCol());
		System.out.println("StartRow: "+PATTERN.getStartRow());
		System.out.println("Pattern: "+PATTERN.getCells());
	}
}

	

