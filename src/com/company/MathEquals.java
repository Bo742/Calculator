package com.company;

import java.text.DecimalFormat;
import java.util.function.DoubleBinaryOperator;

public class MathEquals {
    private String answer ="";
    private String[] masString;
    private String[] answerStack;
    private String[] str1;
    private int numberElement=0;

    public MathEquals(String str){
        masString = new String[str.length()];
        str1 = str.split("");
    }

    public void push(String value){
        answerStack[numberElement]=value;
        numberElement++;
    }

    public String pop(){
        --numberElement;
        return answerStack[numberElement];

    }

    public String getAnswer(){
        DecimalFormat df = new DecimalFormat("#############.#######");
        //Заполняем массив , в котором храним нашу строку по числам и знакам
        String string="";
        int count=0;
        for (int i = 0; i < str1.length; i++) {
            if(str1[i].equals("+") || str1[i].equals("-") || str1[i].equals("*") || str1[i].equals("/") ){
                if(!string.isEmpty()){
                    masString[count]=string;
                    count++;
                }
                string=str1[i];
                masString[count]=string;
                count++;
                string="";
            }
            else{
                string = string+str1[i];
            }
        }
        masString[count]=string;
        for (int i = 0; i < masString.length; i++) {
            if(masString[i]!=null){
                if(masString[i].contains(",")){
                    String s[] = masString[i].split(",");
                    masString[i]=s[0]+"." +s[1];
                }
            }

        }
        answerStack = new String[masString.length];

        push(masString[0]);

        for (int i = 1; i < masString.length ; i++) {
            if(masString[i]!=null){
                if(masString[i-1].equals("*")){
                    String bStr = masString[i];
                    pop();
                    String aStr = pop();

                    double a = Double.parseDouble(aStr);
                    double b = Double.parseDouble(bStr);

                    double c = a*b;
                    if(c%1==0){
                        answer = (long)c+"";
                    }
                    else{
                        answer = c+"";
                    }
                }
                else{
                    if(masString[i-1].equals("/")){
                        String bStr = masString[i];
                        pop();
                        String aStr = pop();

                        double a = Double.parseDouble(aStr);
                        double b = Double.parseDouble(bStr);

                        double c = a/b;
                        if(c%1==0){
                            answer = (long)c+"";
                        }
                        else{
                            answer = df.format(c)+"";
                        }
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
        return answer;
    }
}
