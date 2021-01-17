#include <stdio.h>
#include <stdlib.h>
void efficient (const int source[], int val[],int pos[],int size);
void reconstruct(int source[],int m, const int val[], const int pos[],int n);
int main()
{
    int numOfNonZero;//number of non-zero values
    int length;//length of the source
    printf("Please enter the length of the vector: \n");
    scanf("%d",&length);
    int x[length];
    for(int i=0;i<length;i++){
        printf("Please input component %d of the vector: \n",i);
        scanf("%d",&x[i]);
    }
    int value[length];
    int position[length];
    efficient(x,value,position,length);
    reconstruct(x,length,value,position,numOfNonZero);
    return 0;
}
void efficient (const int source[],int val[],int pos[],int size){
    int numOfNonZero=0;
    for (int i=0;i<size;i++) { //make sure that all values of pos is zeroed
        pos[i]=0;
        val[i]=0;
    }
    int numOfTimes=0;
    for(int i=0;i<size;i++){
        if (source[i]==0){//checks to see if the value is zero
            printf("%d\n", source[i]);
            continue;//continues past the statments if it is zero
        }
        printf("%d\n", source[i]);
        val[numOfTimes]=source[i];//if it isn't a zero the source value is assigned to the val array
        pos[numOfTimes]=i;//the position of it is assigned to where the value is in the arry
        numOfTimes++;
        numOfNonZero++;
        printf("%d\n", numOfNonZero);
    }printf("The value vectors are [");
    for(int a=0;a<numOfNonZero;a++){
        printf("%d ", val[a]);//prints the non-zero elements of the array
    }printf("]\n");
    printf("The position vectors are [");
    for(int j=0;j<numOfNonZero;j++){
        printf("%d ", pos[j]);//prints the postition of the non-zero in refernce to it's source array
    }printf("]\n");
}
reconstruct(int source[],int m, const int val[], const int pos[],int n){
    int number=0;
    for(int i=0;i<m;i++){
        if (pos[number]==i){//if the position and i are the same then at that spot it is a non-zero value
            source[i]= val[number];//assigns the non-zero value to the position it was orignally in
            number++;
        }else{
            source[i]=0;//assigns zeros where the position array doesn't specify a non-zero
        }
    }printf("The source array is [");
    for (int k=0;k<m;k++){
        printf("%d ",source[k]);//prints the source array
    }printf("]");
}
