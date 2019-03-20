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
    public Pattern(String format){
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
    public String getName() {
        return name;
    }
    public String getAuthor(){return author;}
    public int getStartCol(){return startCol;}
    public int getStartRow(){return startRow;}

    public String getCells() {
        return cells;
    }

    public int getWidth(){return width;}
    public int getHeight(){return height;}
    public long initialise(long World) {
		for(int i=0;i<This.length;i++){
			for(int z=0;z<This[i].length();z++){
				if(This[i].charAt((z))=='0') {startCol++;}
				else if(This[i].charAt((z))=='1') {World=World+(1L<<startRow*width+startCol);startCol++;}
			}
			startRow++;
			startCol=startCol-This[i].length();
		}
    	return World;
    	}


}
