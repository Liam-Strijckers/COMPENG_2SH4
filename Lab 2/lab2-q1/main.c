#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#define N 5
void print_vector(double array[], int size);
void add_vectors( double vector1[],double vector2[],double vector3[], int n);
double scalar_prod( double vector1[],double vector2[], int n);
double norm2(double vector1[], int n);

int main()
{
    double v1[N] = {3,0,4,5,-1};
    double v2[N] = {6,1,-1,8,2};
    double v3[N];
    int size = N;
    printf("\nPrint vectors (part1): \n");
    printf("The vector 1 is: ");
    print_vector(v1, size);//printing vector 1
    printf("\nThe vector 2 is: ");
    print_vector(v2, size);//printing vector 2
    printf("\n\nAdding vectors together (part2): \n");
    add_vectors(v1,v2,v3,size);//adding v1 and v2 to get v3
    printf("The vector 3,sum of vector 1 and 2, is: ");
    print_vector(v3, size);//printing vector 3
    printf("\n\nThe scalar product (part 3)");
    printf("\nthe scalar product is: %f\n",scalar_prod(v1,v2,size));//printing the scalar product of vector 1 and vector 2
    printf("\nThe L2 norm (part 4)\n");
    printf("the L2 norm is: %f\n",norm2(v1, size));//print the L2 norm

    return 0;
}
void print_vector(double array[], int size){
    for(int i = 0; i<size; i++){
        if(i==size-1){
            printf("%f", array[i]);//prints the vector out
        }else{
            printf("%f, ",array[i]);
        }
    }
}
void add_vectors( double vector1[],double vector2[],double vector3[], int n){
    //adds the components of vector 1 and 2 together.
    for(int i = 0; i < n; i++){
        vector3[i] = vector1[i] + vector2[i];//adds to vectors together
    }
}
double scalar_prod( double vector1[],double vector2[], int n){
    double scalarProd = 0;
    for(int i = 0; i<n; i++){
        scalarProd += vector1[i]*vector2[i];//multiples the vectors and adds them together
    }
    return scalarProd;
}
double norm2(double vector1[], int n){
    double Norm = 0;
    Norm = sqrt(scalar_prod(vector1, vector1, n));//square roots a scalar product to form the l2 norm
    return Norm;
}

