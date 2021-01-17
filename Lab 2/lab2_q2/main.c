#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#define N 4
int is_diag_dom(int mat[][N]);
int main()
{
    int x[N][N]={0};
    double value=0;
    for (int i=1;i<N+1;i++){
        for (int j=1;j<N+1;j++){
            printf("Please print the vector in row %d in column %d (%d,%d): \n",i,j,i-1,j-1);
            scanf("%lf",&value);
            x[i-1][j-1]= value;
        }
    }
    if(is_diag_dom(x)){//prints the matrix is diagonally dominant if the function returns 1
        printf("The matrix is diagonally dominant, 1");
        return 0;
    }else{//prints the matrix is not diagonally dominant if the function returns 0
        printf("The matrix is not diagonally dominant, 0");
        return 0;
    }
}
int is_diag_dom(int mat[][N]){
    int compare = 0;
    for(int i = 0; i<N; i++){
        int compare = fabs(mat[i][i]);//sets the vector that is being compared to compare
        int row = 0;
        for(int j = 0; j < N; j++){
            if(j!=i){
                row = row + fabs(mat[i][j]);//adds the non-compare vectors of the row together
            }
        }
        if (compare < row){//checks if the row added together is larger than the compare vector and if true returns the value 0 to the function
            return 0;
        }
    }
    return 1;//if compare is larger than the sum of the rest of the row then it return the value 1 to the function
}
