#include <stdio.h>
#include <stdlib.h>

int main()
{
    // question 7
    int num,i,j,x;

    printf("please input a number greater than one: \n");
    scanf("%d",&num);//gets the integer
    while(num<=1){
        printf("please input a number greater than one: \n");//checks if the number is greter than one
        scanf("%d",&num);
    }
    for(i=1;i<=num;i++){//check every number below the input as well as the input
        int sum=0;
        for(j=1;j<i;j++){
            x=i%j;//divides the number by all possible numbers
            if (x==0){//checks if the division above has a whole number as an output and adds it to the sum
                sum=sum+j;
            }
        }
        if(sum==i){//checks if the added whole numbers above is equal to the i value and if so it is a perfect number
            printf("%d is a perfect number\n", i);
        }
    }
    return 0;
}
