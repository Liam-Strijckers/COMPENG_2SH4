#include <stdio.h>
#include <stdlib.h>

int main()
{
    //question 8b
    int num,remainder,reverse=0;
    printf("Please enter a number above zero: \n");
    scanf("%d",&num);
    while(num<0 || num>1000000000){
        printf("Please enter a number above zero \n");
        scanf("%Ld",&num);
    }if(num>0){
        while(num!=0){
            remainder=(num%10);//takes the last digit of the number and stores it as the first number of the remainder
            reverse=(reverse*10)+remainder;//move the digits over a space and add the last digit from the number above
            num /=10;//strips the last digit opf the number
        }
    }
    printf("The reverse is %d", reverse);
    return 0;
}
