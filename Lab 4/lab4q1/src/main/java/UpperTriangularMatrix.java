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
//new class
public class UpperTriangularMatrix {
    private int matsize;
    private int[] matrixElem;
    public UpperTriangularMatrix(int n){
        matsize= n<=0?1:n;//sets matsize to 1 if the inputted n is less than or equal to zero and sets matsize if it above zero 
        /*if(n<0){n=1;}
        matsize = n;*/
        int siz = ((matsize*(matsize+1))/2);//index for the matrix is n*(n*+1)/2
        matrixElem = new int[siz];
    }
    public UpperTriangularMatrix(Matrix upTriM) throws IllegalArgumentException{
        int count = 0;
        if(upTriM.isUpperTr()){//checks to see if the inputted matrix is upper triangular
           //fills array with upper triangular values
            int num = upTriM.getnumOfRows();//gets the number of rows for matrix size and the index of the matrix
            matsize = num;
            int siz = matsize*(matsize+1)/2;//index = n*(n+1)/2
            matrixElem = new int[siz];//allocates memory for the matrix
            for(int i = 0; i<upTriM.getnumOfRows(); i++){
                for(int j = i; j<upTriM.getnumOfCols(); j++){
                    matrixElem[count] = upTriM.getElement(i, j);//fills in the matrix with the inputted values using the getElements method
                    count++;
                }
            }
        }
        else{throw new IllegalArgumentException("Invalid argument.");}//if it is upper triangular throws error
    }
    
    public int getDim(){return matsize;}
    
    public int getElement(int i, int j) throws IndexOutOfBoundsException{
        if (i <= this.matsize && j <= this.matsize){
                if(j >= i){//check if it is in the upper part of the matrix 
                    int count = 0;
                    for(int a = 0; a < i;a++){count += (this.matsize - a) ;} //counts all elements in rows until it gets to the row inputed
                    for(int b=i;b < j; b++){count++;}//counts up till it hits the index before j 
                    return this.matrixElem[count];}//returns the matrix
                else{return 0;}
            }
            else{throw new IndexOutOfBoundsException("Invalid index");}
       
    }
    public void setElement(int x, int i, int j) throws IndexOutOfBoundsException, IllegalArgumentException{
        //checks to make sure that only values in the upper triangle are changed
        if(j>=i){
            int ind = getDim()* i + j - (i*(i+1))/2;
            //checks if the index is within the range of the matrix
            if(ind < matrixElem.length){matrixElem[ind] = x;}//checks to see if the requested index is inside the matrix and if true assigns x to the requested index
            else{throw new IndexOutOfBoundsException("Invalid index");}//throws error if the requested index is outside the matrix
        }
        else{throw new IllegalArgumentException("Incorrect Arguement");}//throws error if it is not in the upper part of the matrix
    }
    
    public Matrix fullMatrix(){
        Matrix FM = new Matrix(matsize,matsize);//allocates memory for the matrix
        for(int i = 0; i < getDim(); i++){
            for(int j = 0; j < getDim(); j++){//goes through every element
                if(j>=i){//checks to see if it is in the upper part of the matrix
                    //int index = getDim()* i + j - (i*(i+1))/2;//creates the index
                    int t = matrixElem[getDim()* i + j - (i*(i+1))/2];//assigns temp to the value of the matrix element at the index of the inputted value
                    FM.setElement(t, i, j);//sets the temp  value to its position in the matrix based on the inputs using the setElement method
                }
                else{FM.setElement(0, i, j);}//if it isn't in the in the upper part of the marix sets it to zero using the setElement method
            }
        }
        return FM;//returns fullMatrix
    }
    //prints out 1D array that holds all the values in the upper triangle
    public void print1DArray(){
        String s = new String();//creates and allocates memory for a new string
        for(int i = 0; i < matrixElem.length; i++){s += matrixElem[i] + "  ";}//adds the matrix elements to the sting and adds two spaces between each number
        s += "\n";//adds a line at the end of the string
        System.out.println(s);//prints the string of numbers
    }
    //prints out the full Matrix of the upper triangle
    public String toString(){
        Matrix t= this.fullMatrix();//
        String s = new String(); // creates an empty string
       	for(int i = 0; i < t.getnumOfRows(); i++){
            for(int j = 0; j < t.getnumOfCols(); j++){//goes through every element in the matrix
                s += t.getElement(i,j) + "  ";//adds the element using getElement to the string and adds to spaces
            }
       	s += "\n";
        }
       	return s;
    }
    
    //returns the determinant of the matrix
    public int getDet(){
        int determinate = 1;
        for(int i = 0; i < getDim(); i++){//goes through the array
            int index = getDim()* i + i - (i*(i+1))/2;//assigns the index
            determinate = determinate*matrixElem[index];//multiplys the determinate by the indexed
        }
        return determinate;
    }
    
    //solves x in A*x = b where A is a Upper Triangular Matrix and b is a given array
    public double[] effSolve(double[] b) throws IllegalArgumentException{
        double[] temp;
        //checks to make sure a solution is possible
        if(this.getDet()!=0 && b.length == matsize){//checks is the determinate isn't zero and the length of b is in the matrix
            temp = new double[matsize];//creates new matrix
            for(int i = matsize-1; i >= 0; i--){//start for the bottom of the matrix and work up
                double t = b[i];//assign t to be b at i
                for(int j = i; j < matsize; j++){//loops through each column
                    if(j>i){//checks to see if it is in the uppper part of the matrix
                        t -=  temp[j]*matrixElem[matsize * i + j - (i*(i+1))/2];//solves
                    }
                }
                int index = matsize * i + i - (i*(i+1))/2;
                temp[i] = t/matrixElem[index];
            }return temp;}
        else{throw new IllegalArgumentException("Invalid argument");}
    }
} 
