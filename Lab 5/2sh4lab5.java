/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lab5;

/**
 *
 * @author Liam Strijckers
 */
public class SLLSet {//itializes the first node in the matrix and the size of the set
    private int sizeOfSet;
    private SLLNode first;
    
    public SLLSet(){//sets the size to 0 and the first node to null
        sizeOfSet = 0;
        first = null;
    }
    
    public SLLSet(int[] sortedArray){
        if(sortedArray.length == 0){//if the array is empty it makes the size 0 and the first node 0
            sizeOfSet = 0;
            first = null;
            return;
        }else{//else assigns the length of the matrix to size and defines the first node as the first element in the array
            sizeOfSet = sortedArray.length;
            first = new SLLNode(sortedArray[0],null);
            SLLNode placeholder = first;//creates a placeholder
            for(int i=1;i<sizeOfSet;i++){//loops through from 1 to the end since the first first and element are already assigned
                placeholder.next= new SLLNode(sortedArray[i],null);//assigns the element in the matrix to the linked list
                placeholder  = placeholder.next;//moves to the next node
            }   
        }
    }
    
    public int getSize(){return sizeOfSet;}//returns the size of the matrix
    
    public SLLSet copy(){
        SLLSet temp =new SLLSet();//creates a temporary/copy set set
        SLLNode place = first;//creates placeholder for the first node
        while(place!=null){//loops while the node isn't null
            temp.add(place.value);//adds the node to the temporary set
            place = place.next;//moves to the next node
        }return temp;
    }
    
    public boolean isIn(int v){
        SLLNode placeholder = first;//creates placeholder for the first node
        while(placeholder != null){//loops while the node isn't null
            if(placeholder.value == v){return true;}//if the node value is the same as v return true 
            else if (placeholder.value>v){return false;}//if the node value is greater than the inputted value return value  
            placeholder = placeholder.next;//moves to the next node
        }return false;
    }
    
    public void add(int v){
        if(sizeOfSet == 0){//if the size is zero make the size is increased to 1, the value v is assigned to the created first node in the set
            //and the first node becomes the placeholder
            sizeOfSet++;
            SLLNode placeholder = new SLLNode(v,null);
            first = placeholder;
        }SLLNode placeholder = first;//assigns placeholder to the first node
        if(placeholder.value>v){//if the first node value is greater than the v value then is becomes the node in the linked lsit
            sizeOfSet++;
            placeholder = new SLLNode(v,placeholder);
            first = placeholder;
            return;
        }else if(placeholder.value == v){return;}//if the first ndoe is equal to v then ignore
        while (placeholder.next != null){//loops while the node isn't equal to null
            if(placeholder.value == v){//if the node equals the value v then ignore
                return;
            }else if (placeholder.next.value>v){//if the value v is less than the node increase the size to fit v in it and add v before the node it is at
                sizeOfSet++;
                placeholder.next = new SLLNode(v,placeholder.next);
                return;
            }placeholder = placeholder.next;
        }sizeOfSet++;
        placeholder.next = new SLLNode(v,null);
    }
    
    public void remove(int v){
        SLLNode place = this.first;//assigns palce to the first node
        if (first == null){return;}//if the list is empty more on
        if (place.value == v){//if  the first value equals value v, v is removed
            sizeOfSet--;
            first = place.next;
            return;
        }if (place.value > v){return;} //if the first ndoe is greater than v more on
        while (place.next != null && place.next.value != v) {//loops while the node isn't null nad the next value isn't v
            if (place.next.value > v){return;} //if node value is greater than v move on
            place = place.next;//moves to the next node
        }if (place.next == null){return;}//if the next value is null move on
        place.next = place.next.next;
        sizeOfSet--;
    }
    
    public SLLSet union(SLLSet s){
        SLLSet uns = s.copy();//creates a copy of the set
        SLLNode placeholder2 = this.first;//set a placeholder for the first node
        if(s.first == null){//if the first node form the inputted set is null return a copy of the set(null/nothing)
            SLLSet temp = this.copy();
            return temp;
        }if(this.first == null){//if the first node is null return a copy of the set(null/nothing)
            SLLSet temp = s.copy();
            return temp;
        }for(int i=0; i<this.sizeOfSet;i++){
            if(s.isIn(placeholder2.value) == false){//checks to see if the node value is in the inputted set
                uns.add(placeholder2.value);//if isn't it adds the value to the set
            }placeholder2 = placeholder2.next;//moves to the next node
        }return uns;
    }
    
    public SLLSet intersection(SLLSet s){
        SLLSet itsn = new SLLSet();//creates a new set for intersection
        SLLNode placeholder2 = first;//creates a placeholder for the first node
        if(s.first == null){//if the first node form the inputted set is null returns itsn(blank)
            return itsn;
        }if(this.first == null){//if the first node is null returns itsn(blank) 
            return itsn;
        }for(int i=0;i<sizeOfSet;i++){
            if(s.isIn(placeholder2.value) == true){//checks if the inputted set in the given set
                itsn.add(placeholder2.value);//if so, the node is added to itsn
            }placeholder2 = placeholder2.next;//moves to the next node
        }return itsn;
    }
    
    public SLLSet difference(SLLSet set){
        SLLSet diff = new SLLSet();//creates a new set for difference
        if (this.first == null){return diff;}//if the first node is null returns a blank set of difference
        else if (set.first == null){//if the first node in the inputted set is null returns a blank set of difference
            diff = this.copy();
            return diff;
        }else{
            SLLNode temp = this.first;//creates a temp node for the first node
            for(int i =0;i<this.sizeOfSet;i++){
                if(set.isIn(temp.value) == false){//checks to see if the value of the node is in the inputted set
                    diff.add(temp.value);//adds the value if it isn't
                }temp = temp.next;
            }return diff;
        }
    }
    
    public static SLLSet union(SLLSet[] sArray){
        SLLSet un = sArray[0];//creates a set for the first value in the array
        for(int i=1;i<sArray.length;i++){un.union(sArray[i]);}//goes through every value in the array and runs it though the unionm method 
        return un;
    }
    
    public String toString(){
        SLLNode placeholder = first;//creates a palceholder node for the first 
        String space = new String(" ");//creates a new empty string
        if(first == null){return "";}//if first is null hte return nothing
        while(placeholder.next != null){//checks to see if the node isn't null
            space = space + placeholder.value + " ";//adds the node value to what will be printed
            placeholder = placeholder.next;//moves to the next node
        }space = space+placeholder.value;
        return space;
    }
}
