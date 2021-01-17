#include <stdio.h>
#include <stdlib.h>

int main()
{
    /*question 2*/
    int num=0,newNum=0,count=0;
    while(count<=0){
        printf("Please enter the number of positive integers\n");//asks for the number of positive integer and checks if it is a positive integer
        scanf("%d",&count);//asks until the user enters a positive integer
    }
    while(num<=0){
        printf("Please enter the first positive integer \n");//asks for a positive integer and checks if it is a positive integer
        scanf("%d", &num);//
    }
    count = count -1;//since the first number is asked above one is removed from the counter
    while(count>0){
        printf("Please print the next positive integer: \n");
        scanf("%d",&newNum);
        while(newNum<=0){
            printf("Please print the next positive integer: \n");//asks for a positive integer if the initial input is negative
            scanf("%d",&newNum);
    }
        if(newNum<num){
            num=newNum;//if the new number is smaller than the first number then it replaces it
        }
        count = count -1;

    }
    printf("The lowest number is: %d",num);
    return 0;
}
