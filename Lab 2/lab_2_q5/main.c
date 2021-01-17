#include <stdio.h>
#include <stdlib.h>
void string_copy (const char source[], char destination[], int n);
int main()
{
    int num=4;
    char x[]="programming";
    /*printf("please enter the number of character you want displayed: \n");
    scanf("%d",&num);
    char x[100];
    printf("Please enter a string without spaces: \n");
    scanf("%s",&x);*/
    char gohere[num];
    string_copy(x,gohere,num);
    return 0;
}
void string_copy (const char source[], char destination[], int n){
    int length=0;
    for (int i=0; source[i] != '\0';i++){//checks the length of the string
        length++;
    }
    if(length>n){
        for(int i=0; i<n;i++){
            destination[i] = source[i];//assigns the values of source to destination for the entire string
        }destination[n]='\0';//adds the null character at the end of the string
        printf("%s\n", destination);
    }
    else if (length<=n){
        for (int i=0;i<length;i++){
            destination[i] = source[i];//assigns the values of source to destination for n times
        }destination[length]='\0';//adds the null character at the end of the string
        printf("%s",destination);
    }
}
