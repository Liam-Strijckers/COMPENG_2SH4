#include <stdio.h>
#include <stdlib.h>

int main()
{
    /*question 1 using a do while loop*/
    int i=0,num=30,sum=0;
    do{
        if(num%4==0){//checks if the number is divisible by 4
            sum = sum +num;//adds the number to the total if it is divisible by 4
            printf("This is the sum %d\n", sum);
        }
        num=num+1;//checks if the next number is divisible by 4
        i=i+1;
    }while(i<1000-30);
    printf("The final sum is %d\n", sum);
    return 0;
}
