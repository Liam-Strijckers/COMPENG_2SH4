#include <stdio.h>
#include <stdlib.h>

int main()
{
    /*Question 3*/
    int num;
    while (num !=0){//the software quits when the number entered is zero
        printf("Please input an integer(0 to end): \n");
        scanf("%d", &num); // takes a integer
        if( (num>9999 && num<100000) || (num>-100000 && num<-9999)){//checks if it is a five digit number
            printf("Your input is a five digit number: %d\n",num);
        }
    }printf("Thank you for using my software. Bye!");
    return 0;
}
