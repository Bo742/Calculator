package com.company;

import java.text.DecimalFormat;
import java.util.function.DoubleBinaryOperator;

public class MathEquals {
    private String answer ="";
    private String[] masString;
    private String[] answerStack;
    private String[] masSymbols;
    private int numberElement=0;

    public MathEquals(String str){
        masString = new String[str.length()];
        masSymbols = str.split("");
    }

    public void push(String value){
        answerStack[numberElement]=value;
        numberElement++;
    }

    public String pop(){
        --numberElement;
        return answerStack[numberElement];

    }

    public void stringConverterInMas(){
        String string="";
        int count=0;
        for (int i = 0; i < masSymbols.length; i++) {
            if(masSymbols[i].equals("+") || masSymbols[i].equals("-") || masSymbols[i].equals("*") || masSymbols[i].equals("/") ){
                if(!string.isEmpty()){
                    masString[count]=string;
                    count++;
                }
                string=masSymbols[i];
                masString[count]=string;
                count++;
                string="";
            }
            else{
                string = string+masSymbols[i];
            }
        }
        masString[count]=string;
    }

    public void doubleConverter(){
        for (int i = 0; i < masString.length; i++) {
            if(masString[i]!=null){
                if(masString[i].contains(",")){
                    String s[] = masString[i].split(",");
                    masString[i]=s[0]+"." +s[1];
                }
            }
        }
    }

    public void multiplication(){
        String bStr =pop();
        pop();
        String aStr = pop();

        double a = Double.parseDouble(aStr);
        double b = Double.parseDouble(bStr);

        double c = a*b;
        if(c%1==0){
            answer = (long)c+"";
            push(answer);
        }
        else{
            answer = c+"";
            push(answer);
        }
    }

    public void division(){
        DecimalFormat df = new DecimalFormat("#############.#######");

        String bStr = pop();
        pop();
        String aStr = pop();

        double a = Double.parseDouble(aStr);
        double b = Double.parseDouble(bStr);

        double c = a/b;
        if(c%1==0){
            answer = (long)c+"";
            push(answer);
        }
        else{
            answer = df.format(c)+"";
            push(answer);
        }
    }

    public void plus(){
        String bStr = pop();
        pop();
        String aStr = pop();

        double a = Double.parseDouble(aStr);
        double b = Double.parseDouble(bStr);

        double c = a+b;
        if(c%1==0){
            answer = (long)c+"";
            push(answer);
        }
        else{
            answer = c+"";
            push(answer);
        }
    }

    public void minus(){
        String bStr = pop();
        pop();
        String aStr = pop();

        double a = Double.parseDouble(aStr);
        double b = Double.parseDouble(bStr);

        double c = a-b;
        if(c%1==0){
            answer = (long)c+"";
            push(answer);
        }
        else{
            answer = c+"";
            push(answer);
        }
    }

    public String getAnswer(){
        //Заполняем массив , в котором храним нашу строку по числам и знакам
        stringConverterInMas();
        //Конвертируем строки  с "," в строки c "."
        doubleConverter();
        answerStack = new String[masString.length];
        push(masString[0]);

        for (int i = 1; i < masString.length ; i++) {
            if(masString[i]!=null){
                if(masString[i-1].equals("*")){
                    push(masString[i]);
                    multiplication();
                }
                else{
                    if(masString[i-1].equals("/")){
                        push(masString[i]);
                        division();
                    }
                    else{
                        push(masString[i]);
                    }
                }
            }
            else{
                break;
            }
        }

        for (int i = answerStack.length-1; i > 0 ; i--) {
            if(answerStack[i]!=null){
                if(answerStack[i].equals("+")){
                    plus();
                }
                else{
                    if(answerStack[i].equals("-")){
                        minus();
                    }
                }
            }
        }
        return answer;
    }
}
