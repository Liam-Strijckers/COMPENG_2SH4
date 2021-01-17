#include <stdio.h>
#include <stdlib.h>

int main()
{
    /*question 6*/
    int firSide,secSide,thirdSide, numOfPT=0;
    double hype;
    for(firSide=1;firSide<401;firSide++){
        for(secSide=1;secSide<401;secSide++){
            for(thirdSide=1;thirdSide<401;thirdSide++){
                hype= (firSide*firSide)+(secSide*secSide);//a^2+b^2=c^2
                if(firSide<=secSide && (float)(thirdSide*thirdSide)==hype ){//checks to see if the second side is bigger than the first one
                    printf("%d %d %d\n",firSide,secSide,thirdSide);//and that the third side/the hypotenuse is less than or equal to 400
                    numOfPT = numOfPT + 1;
                }
            }
        }
    }printf("The number of Pythagoran triangles are: %d",numOfPT);
    return 0;
}
