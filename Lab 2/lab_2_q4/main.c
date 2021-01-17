#include <stdio.h>
#include <stdlib.h>
void letter_freq(const char word[], int freq[]);
int main()
{
    int freq[26]={0};
    const char word[]="sArazendEhbOoDi";
    /*printf("Please enter a string without spaces: \n");
    scanf("%s",&word);*/
    letter_freq(word,freq);

    return 0;
}
void letter_freq(const char word[], int freq[]){
    int numOfLetters=0;
    int i=0;
    while(word[i]!='\0'){//counts the number of the letters in the strinf=g
        numOfLetters++;
        i++;
    }
    for(int i=0;i<numOfLetters;i++){//sets all freq to zero
        freq[i]=0;
    }
    for(int i=0;i<numOfLetters;i++){
        int letter_value = (int)word[i];//changes the string's chararcter to integer numbers
        if( letter_value>=65 && letter_value<=90){//checks to see if it an upper case letter
            freq[letter_value-65]++;//assigns it the letter's specific array value and then increaments it once
            continue;
        }else if( letter_value>=97 && letter_value<=122){//checks to see if it a lower case capital letter
            freq[letter_value-97]++;//assigns it the letter's specific array value and then increaments it once
            continue;
        }
        numOfLetters--;
    }
    for(int i=0;i<26;i++){
        printf("%c and %c occurs %d times in the string\n", i+97,i+65,freq[i]);//Each letter and the number of times it has be used
    }
}
