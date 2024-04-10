BigInteger class Inplemention 


        1. The class keeps values by String variable, that you can set by constructor or method setValue(String s).
                BigInt bigInt = new BigInt("123456789");
                
        2. The class has 4 method for adding, subtraction, multiplying, 
                add method:
                
                        BigInt bigInt1 = new BigInt("123");
                        BigInt bigInt2 = new BigInt("321");
                        bigInt1.add(bigInt2);
                        bigInt.getValue => String s = "444";
                        
                minus method:
                
                        BigInt bigInt1 = new BigInt("123");
                        BigInt bigInt2 = new BigInt("321");
                        bigInt1.minus(bigInt2);
                        bigInt.getValue => String s = "-198";
                        
                multiply method:
                
                        BigInt bigInt1 = new BigInt("123");
                        BigInt bigInt2 = new BigInt("321");
                        bigInt1.multiply(bigInt2);
                        bigInt.getValue => String s = "39483";
                        
                divide method: 
                  This method return only integer part of number yet)
                  
                        BigInt bigInt1 = new BigInt("28");
                        BigInt bigInt2 = new BigInt("7");
                        bigInt1.divide(bigInt2);
                        bigInt.getValue => String s = "4";
                        
        Also class has method greaterValue() that allows to compare BigInt values
                greaterValue method:
                
                        BigInt bigInt1 = new BigInt("2");
                        BigInt bigInt2 = new BigInt("1");
                        bigInt1.greaterValue(bigInt1,bigInt2) => int a = 1;
                        ///////////////////////////////////////////////////
                        BigInt bigInt1 = new BigInt("1");
                        BigInt bigInt2 = new BigInt("2");
                        bigInt1.greaterValue(bigInt1,bigInt2) => int a = 2;
                        ///////////////////////////////////////////////////
                        BigInt bigInt1 = new BigInt("2");
                        BigInt bigInt2 = new BigInt("2");
                        bigInt1.greaterValue(bigInt1,bigInt2) => int a = 0;
                        
        3. Class does adding and subtraction by parsing a part of number into a long value and after some additional manipulation return a part
        of final number
           Multiplying makes by digitization number and adding them by ranks
           Dividing makes by adding a divide number while it is less that target, after each adding count increase. Dividing also using a
           "rank-friendly" pattern to increase speed.
           
        4. Class allows inputs with spaces like 
                BigInt bigInt = new BigInt("100 000 000");
