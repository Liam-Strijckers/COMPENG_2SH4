#include <stdio.h>
#include <stdlib.h>

int main()
{
    /*question 4*/
    double studAvg;
    printf("Please enter the students average:\n");
    scanf("%lf", &studAvg);//takes the students average
    while(studAvg>100 || studAvg<0){
        printf("Please enter the students averge(should be bewteen 100-0):\n"); //checks to see if the students average is between 0-100
        scanf("%lf",&studAvg);
    }if(studAvg>=90){//the coresponding number are giving based on the student average
        printf("4");
    }else if(studAvg>=80){
        printf("3");
    }else if(studAvg>=70){
        printf("2");
    }else if(studAvg>=60){
        printf("1");
    }else{
        printf("0");
    }
    return 0;
}
