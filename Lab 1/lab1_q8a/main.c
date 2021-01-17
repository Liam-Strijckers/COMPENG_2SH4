#include <stdio.h>
#include <stdlib.h>

int main()
{
    //question 8a
    int sevenDNum,remainder,reverse=0;
    printf("Please enter a seven digit number: \n");
    scanf("%d",&sevenDNum);//gets the seven digit number
    while(sevenDNum/1000000 < 1 || sevenDNum/1000000 >10){
        printf("Please enter a seven digit number; \n");//checks that the number inputted is a seven digit number
        scanf("%d",&sevenDNum);
    }
    if ((sevenDNum>999999 && sevenDNum<10000000) || (sevenDNum<-999999 && sevenDNum>-10000000)){
        while(sevenDNum!=0){
            remainder=sevenDNum%10;//takes the last digit of the number and stores it as the first number of the remainder
            reverse=reverse*10+remainder;//move the digits over a space and add the last digit from the number above
            sevenDNum /=10;//strips the last digit opf the seven digit number465
        }
    }
    if(reverse==0) {
            printf("that is not at seven digit number");
    }else{
        printf("The reverse is %d", reverse);
    }
    return 0;
}
