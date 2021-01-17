#include <stdio.h>
#include <stdlib.h>

int main()
{
    /*question 1 using a while loop*/
    int i=0, num=30,sum=0;
    while(i<1000-30){
        if(num%4==0){//checks if the number is divisible by 4
            sum =sum +num;//add the number to the sum
            printf("This is the sum %d\n", sum);
        }
        num = num +1;//checks to see if the next number is divisible by 4
        i = i+1;
    }
    printf("This is the final sum %d\n", sum);
    return 0;
}
