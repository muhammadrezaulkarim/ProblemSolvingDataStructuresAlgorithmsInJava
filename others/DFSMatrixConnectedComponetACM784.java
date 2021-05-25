import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.Scanner;


public class DFSMatrixConnectedComponetACM784 {
	
	boolean flag[][]=null;
	int nodecount=0;
	StringBuilder sb=new StringBuilder();

	
	int addRow[]={-1,-1,-1,0,0,1,1,1};
	int addCol[]={-1,0,1,-1,1,-1,0,1};
	int p=0;
  StringBuilder[] a=null;
	public void processInput()
	{
		//Scanner sc=new Scanner(System.in);
	  Scanner sc=null;
	  
/*		try {
			sc = new Scanner(new File("input.txt"));
			//Scanner sc=new Scanner(System.in);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		
		int count=0;
		int testCase=	sc.nextInt();
		String[] temp=null;
		int cas=0,i=0,j=0;
		String x=null;
		sc.nextLine();
		
		while (cas<testCase)
		{
			cas++;
			count++;
			sb.delete(0, sb.length());
		p=0;
			while(true)
			{
			  x=sc.nextLine();
			  
			
			  sb.append(x);
			  sb.append("#");
			  p++;
			  
			  if(x.charAt(0)=='_')
				  break;
			
			}
			
			temp=sb.toString().split("#");
			
			a=new StringBuilder[temp.length];
			
			for(i=0;i<a.length;i++)
				a[i]=new StringBuilder(temp[i]);
			

			int eagleCount=0,level=0;
			int rowStart=0,colStart=0;
			
		//	p--;

			// find the start room location that is marked with the character *
			for(i=0;i<p;i++)
			{
				for(j=0;j<a[i].length();j++)
				{
					level=0;
					nodecount=0;
					if(a[i].charAt(j)=='*')
					{
					
										
						rowStart=i;
						colStart=j;
				        a[i].setCharAt(colStart,' ');
						break;
						
					}
					
				}
			}
			
			// start DFS traversal
			DFS(rowStart,colStart,level);
			
			
			
			for(i=0;i<p;i++)
			{
				System.out.println(a[i].toString());
			}
			
			//System.out.printf("Image number %d contains %d war eagles.\n",count,eagleCount);
		}
			
	}
	
	public void DFS(int row,int col,int level)
	{
		int nextCol=0,nextRow=0;
	
		
	//	flag[row][col]=true;
		//paint the room by setting character #
		a[row].setCharAt(col,'#');
		
		level++;
			nodecount++;
			
		for(int i=0;i<8;i++)
		{
			nextRow=row+addRow[i];
			nextCol=col+addCol[i];
			
			if(nextRow>=0 && nextRow<p )
			{
				if(nextCol>=0 && nextCol<a[nextRow].length() )
				{
				    // ' ' indicates unpainted neighbor
					
					if( a[nextRow].charAt(nextCol)==' ')
					{
						DFS(nextRow,nextCol,level);
					}
				}
			}
		}

	}
	
	
	
	
	public static void main(String args[])
	{
		DFSMatrixConnectedComponetACM784  ob =new DFSMatrixConnectedComponetACM784();
		ob.processInput();
	}

}


/*
 * Link: https://uva.onlinejudge.org/index.php?option=onlinejudge&page=show_problem&problem=725
 * 
 A maze of rectangular rooms is represented on a two dimensional grid as illustrated in figure 1a.
Each point of the grid is represented by a character. The points of room walls are marked by the
same character which can be any printable character different than ‘*’, ‘ ’ and space. In figure 1 this
character is ‘X’. All the other points of the grid are marked by spaces.


figure not readable here

Figure 1. Mazes of rectangular rooms


All rooms of the maze are equal sized with all walls 3 points wide and 1 point thick as illustrated
in figure 2. In addition, a wall is shared on its full length by the separated rooms. The rooms can
communicate through doors, which are positioned in the middle of walls. There are no outdoor doors.

door
|
XX XX
X . X measured from within the room
door - ...-- walls are 3 points wide
X . X__
XXXXX |
|___ walls are one point thick
Figure 2. A room with 3 doors



Your problem is to paint all rooms of a maze which can be visited starting from a given room, called
the ‘start room’ which is marked by a star (‘*’) positioned in the middle of the room. A room can be
visited from another room if there is a door on the wall which separates the rooms. By convention, a
room is painted if its entire surface, including the doors, is marked by the character ‘#’ as shown in
figure 1b.


Input
The program input is a text file structured as follows:
1. The first line contains a positive integer which shows the number of mazes to be painted.
2. The rest of the file contains the mazes.
The lines of the input file can be of different length. The text which represents a maze is terminated
by a separation line full of underscores (‘ ’). There are at most 30 lines and at most 80 characters in a
line for each maze. The program reads the mazes from the standard input.


Output
The output text of a painted maze has the same format as that which has been read for that maze,
including the separation lines. The program writes the painted mazes on the standard output.


Sample Input
2
XXXXXXXXX
X X X
X * X
X X X
XXXXXXXXX
X X
X X
X X
XXXXX
_____
XXXXX
X X
X * X
X X
XXXXX
_____

Sample Output
XXXXXXXXX
X###X###X
X#######X
X###X###X
XXXXXXXXX
X X
X X
X X
XXXXX
_____
XXXXX
X###X
X###X
X###X
XXXXX
_____
 * */
