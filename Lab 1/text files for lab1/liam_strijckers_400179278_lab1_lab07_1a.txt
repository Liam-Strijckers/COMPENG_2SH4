#include <stdio.h>
#include <stdlib.h>

int main()
{
    //question 1 using a for loop
    int i,num=30,sum=0;
    for (i=0;i<1000-30;i++){
        if(num%4==0){//checks if number is divisable
            sum = sum+num;//adds the number if it is divisable to the total
            printf("This is the sum %d\n", sum);
        }
        num = num +1; //moves up to check the next number
    }
    printf("This is the final sum %d\n", sum);

    return 0;
}
