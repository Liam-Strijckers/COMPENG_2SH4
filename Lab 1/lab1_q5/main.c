#include <stdio.h>
#include <stdlib.h>

int main()
{
    /*question 5*/
    int n;
    double pi=4.0;
    printf("Please print a positive integer: \n");
    scanf("%d",&n);//gets the number of addition and subtractions to get pi
    while(n<0){
        printf("Please print a positive integer: \n");//checks to see if the number enter is positive
        scanf("%d",&n);
    }
    while(n>0){
        if(n%2==1){//checks to see if it is odd
            pi=pi-(4.0/((2*n)+1));//subtracts the odd number
        }else{//checks to see if it even
            pi=pi+(4.0/((2*n)+1));//adds the even numbers
        }n=n-1;

    }
    printf("pi = %lf\n", pi);
    return 0;
}
