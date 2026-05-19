package CustomException;

import ExceptionDeclaration.Parent;

public class Main {

    public static void main(String[] args) throws AgeNotValidException{
        int age = 10;
        if (age<18){
            throw new AgeNotValidException("Age is not valid to vote");
        }



    }
}
