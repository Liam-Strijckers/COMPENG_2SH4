/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Liam Strijckers
 */
import java.util.Arrays;
public class Matrix {
    private int numOfRows;//sets up the instances
    private int numOfCols;
    private int [][] matrixEl;
    //first part
    public Matrix (int row, int col){
        numOfRows = row <= 0?3:row;//if the number of rows  and columns 
        //is less than or equal to 0 it is set to 3 and if not it set to the input
        numOfCols = col <= 0?3:col;
        /*if (row<=0){
            numOfRows=3;
        }
        else{
            numOfRows=row;
        }
        if (col<=0){
            numOfCols=3;
        }
        else{
            numOfCols=col;
        }*/
        matrixEl = new int [numOfRows][numOfCols];//allocates memory for the matrix
        for(int i=0;i<numOfRows;i++){
            for(int j=0;j<numOfCols;j++){
                matrixEl[i][j]=0;//sets every element of the matrix to zero
            }
        }
           
    }
    //second part 
    public Matrix(int [][] table){
        numOfRows = table.length;//sets the value of number of rows to the length of the first row
        numOfCols = table[0].length;//sets the value of number of columns to the length of the first column
        matrixEl = new int[numOfRows][numOfCols];//allocates memory for the matrix
        for(int i=0;i<numOfRows;i++){
            for(int j=0;j<numOfCols;j++){
                matrixEl[i][j]=table[i][j];//sets the matrix elements to the values from the inputted table
            }
        }
                
    }
    // part 1 int get Element (int i, int j)
    public int getnumOfCols(){return numOfCols;}
    
    public int getnumOfRows(){return numOfRows;}
    
    /*public boolean elementValid(int i ,int j){
        if(i<numOfRows && i>=0 && j>=0 && j<numOfCols){return true;}
        else{return false;}
    }*/
    
    public int getElement( int i, int j)throws IndexOutOfBoundsException{
        if(i<numOfRows && i>=0 && j>=0 && j<numOfCols){return matrixEl[i][j];}//checks to see if it with in the bounds of the matrix and returns the requested input if true
        else{throw new IndexOutOfBoundsException("Invalid indexes.");}//else reuturns an error
    }
    //part 2
    public boolean setElement(int x, int i, int j){
        if(i<numOfRows && i>=0 && j>=0 && j<numOfCols){//checks to see if it with in the bounds of the matrix
            matrixEl[i][j]=x;//sets the x value to the inputted location of the matrix
            return true;
        }
        else{return false;}
    }
    //part 3
    public Matrix copy(){
        return new Matrix(numOfRows,numOfCols);//returns a newly accolated matrix
    }
    //part4
    public void addTo(Matrix m) throws ArithmeticException{
        if ((numOfRows == m.numOfRows)&&(numOfCols == m.numOfCols)){
            for(int i=0; i<numOfRows;i++){
                for( int j=0; j<numOfCols;j++){
                    matrixEl[i][j] +=  m.getElement(i, j);//adds the value from the m matrix by using the getElement method to get the value at that specific position 
                    //to the value of the already existing matrix
                }
            }
        }
        else{
            throw new ArithmeticException("Invalid operation; matrices can only be added if they have same number of rows and columns");//else throws an error
        }
    }
    //part 5
    public Matrix subMatrix(int i, int j) throws ArithmeticException{
        Matrix subMatrix = new Matrix(i,j);
         if(i<numOfRows && i>=0 && j>=0 && j<numOfCols){//checks to see if it with in the bounds of the matrix
             for(int a=0;a<i;a++){
                 for(int b=0;b<j;b++){
                     subMatrix.matrixEl[a][b] = this.matrixEl[a][b];//grabs the values of the already existing matrix, for only the values it asked for
                 }
             }
             return subMatrix;
         }
         else{throw new ArithmeticException("Submatrix not defined");}
    }
    //part 6
   public boolean isUpperTr(){
        for (int i = 0; i < this.numOfRows; i++) {
            for (int j = 0; j < i; j++) {//uppper triangular elements are only in the matrix where i is larger than j and checks it 
                 if (this.matrixEl[i][j] != 0){//if the value of an element in the lower part of the matrix is non-zero 
                     //is it not an upper triangular matrix and returns false
                    return false;
                }
            }   
        }
        return true;//else it is an upper triangular matrix and returns true
    }
    //part 7 
    public static Matrix sum(Matrix[] matArray) throws ArithmeticException{//fix
       if(matArray.length>0){//checks that the inputted matrix length is longer than 
           Matrix sumMatrix = new Matrix(matArray[0].numOfRows, matArray[0].numOfCols);//creates and allocates new matrix for the adding 
            for(int i=0;i<matArray.length;i++){sumMatrix.addTo(matArray[i]);}//uses the addTo method to add the matrixes together
            return sumMatrix;//returns the matrix
       }
       else  { 
           throw new ArithmeticException("Invalid operation; adding matrices can only be done if same number of rows and columns");
       }
    }
    //part 8
    public String toString(){
        String s = new String();//allocates memory for the new string
        for(int i=0;i<numOfRows;i++){
            for(int j=0; j<numOfCols;j++){//goes through every element in the matrix
                s += matrixEl[i][j]+ " ";//adds each element in the matrix to the string and a space inbetween at of them
            }
            s += "\n";//adds a new line in the string for every row in the matrix
        }
        return s;
    }
}

