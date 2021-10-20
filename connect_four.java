import java.io.*;

import java.util.Scanner;

import java.io.BufferedReader;

import java.io.IOException;

import java.io.InputStreamReader;

 
class connectGame 
{
  
 
int totalMoves = 0;
  
int[][] grid = new int[8][8];	// Grid With 8 Rows and Column
  
 
 
public static void main (String a[]) throws IOException
  {
    


connectGame g = new connectGame ();
    
BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
    
System.out.println ("!!!CONNECT FOUR TWO PLAYER GAME!!!");
    
g.displayGrid ();
    
outer:
while (true)
      
      {
	
int column = 0;
	 

while (true)
	   
	  {
	    
System.out.print ("\n\nPlayer 1 :");                    	//PLAYER ONE INPUT
	    column = Integer.parseInt (br.readLine ());
	    
if (g.isPlayable (column))
	      
	      {
		
if (g.play (column, 1))
		  
		  {
		    
System.out.println ("\n");
		    
g.displayGrid ();
		    
System.out.
		      println ("\n\nPLAYER ONE WINS!!\n GAME OVER!!");
		    
break outer;
		  
}
		 
break;
	      
}
	    
	    else
	      
System.out.println ("COLUMN " + column + " IS FULL !!");
	  
}
	
g.displayGrid ();
	
while (true)
	  {
	    
System.out.print ("\n\nPlayer 2 :");                    	//PLAYER TWO INPUT   
	    column = Integer.parseInt (br.readLine ());
	    
if (g.isPlayable (column))
	      
	      {
		
 
if (g.play (column, 2))
		  {
		    
System.out.println ("\n");
		    
g.displayGrid ();
		    
System.out.
		      println ("\n\nPLAYER TWO WINS!!\n GAME OVER!!");
		    
break outer;
		  
}
		
break;
	      
}
	    
	    else
	      
System.out.println ("Column " + column + " is already full!!");
	  
}
	
g.displayGrid ();
	
if (g.isFull ())
	  {
	    
System.out.print ("Game drawn!! ");
	    
break;
	  
}
      
}
  
}
  
 
public void displayGrid ()                    //Display 8x8 Grid
  {
    
for (int i = 0; i < grid.length; i++)
      
      {
	
for (int j = 0; j < grid[0].length; j++)
	  
	  {
	    
if (grid[i][j] == 0)
	      
System.out.print (".\t");
	    
	    else
	      
System.out.print (grid[i][j] + "\t");
	  
}
	
System.out.println ();
      
}
    
 
System.out.
      print
      ("_______________________________________________________________\n");
    
for (int i = 0; i < 8; i++)
      
System.out.print (i + "\t");
    
System.out.println ();
  
} 
 
public boolean play (int column, int num)        // INSERTS THE PIECE IN THE GIVEN COLUMN PROVIDED BY THE PLAYERS 
  {
    
int i = 0;
    
for (i = 0; i < 8; i++)
      {
	
if (grid[i][column] == 1 || grid[i][column] == 2)
	  {
	    
grid[i - 1][column] = num;
	    
break;
	  
}
      
}
    
if (i == 8)
      
grid[i - 1][column] = num;
    
 
totalMoves++;
    
return isConnected (i - 1, column);             // Check if 4 pieces are in line
  
}
  
 
 
 
 
public boolean isPlayable (int column) 
  {
    
return grid[0][column] == 0;
  
}
  
 
public boolean isConnected (int x, int y)         // Checks 4 pieces form any line
  {
    
int num = grid[x][y];
    
int count = 0;
    
int i = y;
    
 
                                                    
      while (i < 8 && grid[x][i] == num)
      
      {
	
count++;
	
i++;
      
}
    
i = y - 1;                                              
    
while (i >= 0 && grid[x][i] == num)
      
      {
	
count++;
	
i--;
      
}
    
if (count == 4)
      
return true;                            //FOR HORIZONTAL
    
 
      
      count = 0;
    
int j = x;
    
while (j < 8 && grid[j][y] == num)
      {
	
count++;
	
j++;
      
}
    
if (count == 4)
      
return true;                                        //FOR VERTICAL
    
 
     
      count = 0;
    
i = x;
    
j = y;
    
while (i < 8 && j < 8 && grid[i][j] == num)
      {
	
count++;
	
i++;
	
j++;
      
}
    
i = x - 1;
    
j = y - 1;
    
while (i >= 0 && j >= 0 && grid[i][j] == num)
      {
	
count++;
	
i--;
	
j--;
      
}
    
if (count == 4)
      
return true;                                     //NEGATIVE DIAGONAL
    
 
     
      count = 0;
    
i = x;
    
j = y;
    
while (i < 8 && j >= 0 && grid[i][j] == num)
      {
	
count++;
	
i++;
	
j--;
      
}
    
i = x - 1;
    
j = y + 1;
    
while (i >= 0 && j < 8 && grid[i][j] == num)
      {
	
count++;
	
i--;
	
j++;
      
}
    
if (count == 4)
      
return true;                                     //POSITIVE DIAGONAL
    
 
return false;                                   //IF ANY OF THE GIVEN CONDITION IS NOT SATISFIED 
  
}
  
public boolean isFull ()                        // CHECKS IF GRID IS FULL 
  {
    
return totalMoves == 64;
  
}

}
