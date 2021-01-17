#include <stdio.h>
#include <stdlib.h>
#include <string.h>
char *my_strcat( const char *const str1, const char *const str2);
int main()
{
    char string1[100], string2[100];
    printf("Please enter the first string: ");
    scanf("%s",&string1);
    printf("Please enter the second string: ");
    scanf("%s",&string2);
    //printf("%s\n%s\n",string1,string2);
    printf("%s\n", my_strcat(string1,string2));
    return 0;
}

char *my_strcat( const char *const str1, const char *const str2){
    int length1=0, length2=0;
    char *p1 = NULL;
    length1 = strlen(str1);
    length2 = strlen(str2);
    p1 = malloc((length1+length2+1)*sizeof(char));//need to fix the malloc statement
    for(int i=0; i<=length1;i++){
        p1[i]=str1[i];
    }
    for (int i = 0;i<=length2;i++){
        p1[i+length1]=str2[i];
    }
    p1[length1 + length2] = '\0';
    return p1;
}
