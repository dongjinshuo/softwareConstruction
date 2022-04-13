package com.chen.threeTwo;

import java.util.Random;

abstract class BinaryOperation_3_2 {
    static final int UPPER = 100;
    static final int lower = 0;
    private int left_operand = 0,right_operand = 0;
    private char operator = '+';
    private int value = 0;

    protected void generateBinaryOperation(char anOperator){
        int left, right, result;
        Random random = new Random();
        left = random.nextInt(UPPER+1);
        do{
            right = random.nextInt(UPPER+1);
            result = calculate(left, right);
        } while (!(checkingCalculation(result)));
        left_operand = left;
        right_operand = right;
        operator = anOperator;
        value = result;
    }

    abstract boolean checkingCalculation(int anInteger);
    //检查是否符合算式标准
    abstract int calculate(int left, int right);
    //计算算式结果

    // getXX 返回需要访问的数字和符号
    public char getOperator(){
        return operator;
    }
    public int getLeft_operand(){
        return left_operand;
    }

    public int getRight_operand(){
        return right_operand;
    }

    public int getvalue() {
        return value;
    }


    public boolean equals(BinaryOperation_3_2 anOperation){
        //方法将该对象的数字符号与另一个对象的数字符号做比较，起到检查是否重复的作用
        return operator==anOperation.getOperator()&&
                right_operand==anOperation.getRight_operand()&&
                left_operand==anOperation.getLeft_operand();
    }

    static class AdditionOperation extends BinaryOperation_3_2{
        AdditionOperation(){
            generateBinaryOperation('+');
        }
        public boolean checkingCalculation(int anInteger){
            //方法重写，使该类的算式符合规定的加法算式标准
            return anInteger <= UPPER;
        }
        int calculate(int left,int right){
            return left + right;
        }
    }

    class SubstractOperation extends BinaryOperation_3_2{
        SubstractOperation(){
            generateBinaryOperation('-');
        }
        public boolean checkingCalculation(int anInteger){
            //方法重写，使该类的算式符合规定的减法算式标准
            return anInteger >= lower;
        }
        int calculate(int left,int right){
            return left - right;
        }
    }

    public static void main(String[] args) {
        BinaryOperation_3_2 bop;
        for (int i=0; i<10; i++){
            bop = new AdditionOperation();
            System.out.println(bop);
        }
    }
}
