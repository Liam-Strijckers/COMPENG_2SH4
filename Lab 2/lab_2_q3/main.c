#include <stdio.h>
#include <stdlib.h>
#define N 4
int printMatrixDiagonally (int mat [][N]);
int main()
{
    int matrix[N][N] ;
    double value=0;
    for (int i=1;i<N+1;i++){
        for (int j=1;j<N+1;j++){
            printf("Please print the vector in row %d in column %d (%d,%d): \n",i,j,i-1,j-1);
            scanf("%lf",&value);
            matrix[i-1][j-1]= value;
        }
    }
    printMatrixDiagonally(matrix);

    return 0;
}
int printMatrixDiagonally(int mat[][N]){
    for(int i=0; i<N; i++){//starts at the first row and goes down one row every iteration
        int k;
        k=i;//sets k=i so i doesn't get changed
        int j=0;
        while (k>=0){//checks to see if k is greater than zero to know if should continue since k will be lowered until it is at the first row again
            printf("%d,", mat[k][j]);//prints the vector
            k--;//moves diagonally across the matrix going up the rows by lowering k by one and to the of the column right by adding one to j
            j++;
        }
    }
    for(int i=1; i<N; i++){//starts at the second column and moves one column over every iteration
        int a,b;
        a=N-1;
        b=i;//sets b=i so i doesn't get changed
        while(b<N){//checks to see if b is greater than zero to know if should continue since b will be lowered until it is at the first row again
            printf("%d,", mat[a][b]);//prints the vector
            a--;//moves diagonally across the matrix going up the rows by lowering a by one and to the right of the column by adding one to b
            b++;
        }
    }
}
