
import java.util.ArrayList;
import java.util.List;

public class BigInt {

    private String value;
    private boolean rankChange = false;


    public BigInt(String value) {
        value = value.replace(" ", "");
        this.value = value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public boolean isMirror(BigInt value1, BigInt value2) {
        String copyValue1 = value1.value, copyValue2 = value2.value;
        if (copyValue1.charAt(0) == '-') {
            copyValue1 = copyValue1.substring(1);
        }
        if (copyValue2.charAt(0) == '-') {
            copyValue2 = copyValue2.substring(1);
        }

        if (copyValue1.length() == copyValue2.length()) {
            for (int i = 0; i < copyValue1.length(); i++) {
                if (copyValue1.charAt(i) != copyValue2.charAt(i)) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public boolean isMirror(String value1, String value2) {
        value1 = value1.replace(" ", "");
        value2 = value2.replace(" ", "");
        String copyValue1 = value1, copyValue2 = value2;
        if (copyValue1.charAt(0) == '-') {
            copyValue1 = copyValue1.substring(1);
        }
        if (copyValue2.charAt(0) == '-') {
            copyValue2 = copyValue2.substring(1);
        }

        if (copyValue1.length() == copyValue2.length()) {
            for (int i = 0; i < copyValue1.length(); i++) {
                if (copyValue1.charAt(i) != copyValue2.charAt(i)) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public void minus(String value) {
        value = value.replace(" ", "");

        if ((this.greaterValue(value, this.value) == 1 || this.greaterValue(value, this.value) == 2) && isMirror(value, this.value)) {
            this.value = "0";
            return;

        }


        String minusValue = value;
        String currentValue = this.value;
        StringBuilder sub;

        boolean negativeMark;

        long tempMinusValue, tempCurrentValue;

        if (this.value.charAt(0) != '-' && value.charAt(0) != '-') {

            negativeMark = this.greaterValue(this.value, value) != 1;
        } else {

            if (minusValue.charAt(0) == '-') {
                negativeMark = true;
                minusValue = minusValue.substring(1);
            } else {
                negativeMark = false;
                currentValue = currentValue.substring(1);
            }
        }

        if (greaterValue(currentValue, minusValue) == 1) {
            currentValue = minusValue;
            minusValue = this.value;
            negativeMark = false;
        }


        StringBuilder sB = new StringBuilder();
        StringBuilder sBTool;
        boolean rankAdd = false;


        while (currentValue.length() >= 18) {
            sBTool = new StringBuilder();
            if (minusValue.charAt(minusValue.length() - 17) == '0') {

                sBTool.append(minusValue.substring(minusValue.length() - 17));
                sBTool.insert(0, '1');
                tempMinusValue = Long.parseLong(sBTool.toString());
                int i;
                sBTool.delete(0, sBTool.length());
                sBTool.append(minusValue, 0, minusValue.length() - 17);
                i = sBTool.length() - 1;
                while (minusValue.charAt(i) == '0') {
                    sBTool.deleteCharAt(i);
                    sBTool.append('9');
                    i--;
                }
                int temp = Integer.parseInt(sBTool.substring(i, i + 1));
                temp--;
                sBTool.deleteCharAt(i);
                sBTool.insert(i, temp);
                minusValue = sBTool.toString();


            } else {

                if (minusValue.charAt(minusValue.length() - 17) < currentValue.charAt(currentValue.length() - 17)) {
                    tempMinusValue = Long.parseLong(minusValue.substring(minusValue.length() - 18));
                    if (rankAdd) {
                        tempMinusValue--;

                    }
                    rankAdd = true;
                } else {
                    tempMinusValue = Long.parseLong(minusValue.substring(minusValue.length() - 17));
                    if (rankAdd) {
                        tempMinusValue--;
                        rankAdd = false;
                    }
                }

            }
            tempCurrentValue = Long.parseLong(currentValue.substring(currentValue.length() - 17));
            sub = new StringBuilder(String.valueOf(tempMinusValue - tempCurrentValue));

            sB.insert(0, sub);
            if (rankAdd) {
                sB.deleteCharAt(0);
            }
            while (sub.length() < String.valueOf(tempCurrentValue).length()) {
                sB.insert(0, "0");
                sub.append("0");
            }
            if (sBTool.length() == 0) {
                minusValue = minusValue.substring(0, minusValue.length() - 17);
            } else {


                minusValue = sBTool.toString();
            }
            currentValue = currentValue.substring(0, currentValue.length() - 17);


        }


        /////////////////////////////////////////////
        ////////////////////////////////////////////////

        sBTool = new StringBuilder();
        if (minusValue.charAt(minusValue.length() - currentValue.length()) == '0') {

            sBTool.append(minusValue.substring(minusValue.length() - currentValue.length()));
            sBTool.insert(0, '1');
            tempMinusValue = Long.parseLong(sBTool.toString());
            int i;
            sBTool.delete(0, sBTool.length());
            sBTool.append(minusValue, 0, minusValue.length() - currentValue.length());
            i = sBTool.length() - 1;
            while (minusValue.charAt(i) == '0') {
                sBTool.deleteCharAt(i);
                sBTool.append('9');
                i--;
            }
            int temp = Integer.parseInt(sBTool.substring(i, i + 1));
            temp--;
            sBTool.deleteCharAt(i);
            sBTool.insert(i, temp);
            minusValue = sBTool.toString();
        } else {
            if (minusValue.charAt(minusValue.length() - currentValue.length()) < currentValue.charAt(0)) {
                tempMinusValue = Long.parseLong(minusValue.substring(minusValue.length() - currentValue.length() - 1));

                if (rankAdd) {
                    tempMinusValue--;

                }
                rankAdd = true;
            } else {
                tempMinusValue = Long.parseLong(minusValue.substring(minusValue.length() - currentValue.length()));

                if (rankAdd) {
                    tempMinusValue--;
                    rankAdd = false;
                }
            }
            minusValue = minusValue.substring(0, minusValue.length() - currentValue.length());
        }
        tempCurrentValue = Long.parseLong(currentValue);
        sub = new StringBuilder(String.valueOf(tempMinusValue - tempCurrentValue));
        sB.insert(0, sub);
        while (sub.toString().length() < String.valueOf(tempCurrentValue).length()) {
            sB.insert(0, "0");
            sub.append("0");
        }
        if (rankAdd) {
            sB.deleteCharAt(0);
        }
        ///////////////////////////////////////////////
        //////////////////////////////////////////////

        while (minusValue.length() >= 18) {
            tempMinusValue = Long.parseLong(minusValue.substring(minusValue.length() - 18));

            if (rankAdd) {
                tempMinusValue--;
                rankAdd = false;
            }


            sB.insert(0, tempMinusValue);
            minusValue = minusValue.substring(0, minusValue.length() - 18);

        }
        if (minusValue.length() != 0) {
            tempMinusValue = Long.parseLong(minusValue);
            if (rankAdd) {
                tempMinusValue--;
            }
            sB.insert(0, tempMinusValue);
        }

        if (negativeMark) {
            sB.insert(0, '-');
        }
        this.value = sB.toString();


    }

    public void minus(BigInt value) {
        if ((this.greaterValue(value, this) == 1 || this.greaterValue(value, this) == 2) && isMirror(value, this)) {
            this.value = "0";
            return;

        }


        String minusValue = value.getValue();
        String currentValue = this.value;
        StringBuilder sub;

        int valueLength = 0;
        boolean negativeMark;
        boolean deleteMark;

        long tempMinusValue, tempCurrentValue;

        if (this.value.charAt(0) != '-' && value.getValue().charAt(0) != '-') {

            negativeMark = this.greaterValue(this.value, value.getValue()) != 1;
        } else {

            if (minusValue.charAt(0) == '-') {
                negativeMark = true;
                minusValue = minusValue.substring(1);
            } else {
                negativeMark = false;
                currentValue = currentValue.substring(1);
            }
        }

        if (greaterValue(currentValue, minusValue) == 1) {
            currentValue = minusValue;
            minusValue = this.value;
            negativeMark = false;
        }


        StringBuilder sB = new StringBuilder();
        StringBuilder sBTool;
        boolean rankAdd = false;


        while (currentValue.length() >= 18) {
            sBTool = new StringBuilder();
            deleteMark = false;

            if (minusValue.charAt(minusValue.length() - 18) == currentValue.charAt(currentValue.length() - 18)) {
                sBTool.append(minusValue.substring(minusValue.length() - 18));
                sBTool.insert(0, '1');
                valueLength = sBTool.length();
                tempMinusValue = Long.parseLong(sBTool.toString());

                if (rankAdd) {
                    tempMinusValue--;
                    rankAdd = false;
                }


            } else {

                if ((minusValue.charAt(minusValue.length() - 18) < currentValue.charAt(currentValue.length() - 18))) {


                    sBTool.append(minusValue.substring(minusValue.length() - 18));
                    sBTool.insert(0, '1');
                    valueLength = sBTool.length();
                    tempMinusValue = Long.parseLong(sBTool.toString());

                    if (rankAdd) {
                        tempMinusValue--;

                    }
                    rankAdd = true;
                } else {
                    tempMinusValue = Long.parseLong(minusValue.substring(minusValue.length() - 18));
                    if (rankAdd) {
                        tempMinusValue--;
                        rankAdd = false;
                    }
                    deleteMark = true;
                }
            }


            tempCurrentValue = Long.parseLong(currentValue.substring(currentValue.length() - 18));

            sub = new StringBuilder(String.valueOf(tempMinusValue - tempCurrentValue));

            if (valueLength == sub.length()) {
                sub.deleteCharAt(0);

            }

            sB.insert(0, sub);

            if (deleteMark) {
                while (sub.length() < 18) {
                    sB.insert(0, "0");
                    sub.insert(0, "0");
                }
            } else {
                while (sub.length() < 17) {
                    sB.insert(0, "0");
                    sub.insert(0, "0");
                }
            }
            sub.setLength(0);

            minusValue = minusValue.substring(0, minusValue.length() - 18);
            currentValue = currentValue.substring(0, currentValue.length() - 18);


        }


        /////////////////////////////////////////////
        ////////////////////////////////////////////////
        sBTool = new StringBuilder();
        deleteMark = false;

        if (minusValue.charAt(minusValue.length() - currentValue.length()) == currentValue.charAt(0)) {
            sBTool.append(minusValue.substring(minusValue.length() - currentValue.length()));
            sBTool.insert(0, '1');
            valueLength = sBTool.length();
            tempMinusValue = Long.parseLong(sBTool.toString());
            if (rankAdd) {
                tempMinusValue--;
                rankAdd = false;
            }
        } else {

            if (minusValue.charAt(minusValue.length() - currentValue.length()) < currentValue.charAt(0)) {


                sBTool.append(minusValue.substring(minusValue.length() - currentValue.length()));
                sBTool.insert(0, '1');
                valueLength = sBTool.length();
                tempMinusValue = Long.parseLong(sBTool.toString());



                if (rankAdd) {
                    tempMinusValue--;

                }
                rankAdd = true;
            } else {
                tempMinusValue = Long.parseLong(minusValue.substring(minusValue.length() - currentValue.length()));

                if (rankAdd) {
                    tempMinusValue--;
                    rankAdd = false;
                }
                deleteMark = true;
            }
        }
        minusValue = minusValue.substring(0, minusValue.length() - currentValue.length());

        tempCurrentValue = Long.parseLong(currentValue);

        sub = new StringBuilder(String.valueOf(tempMinusValue - tempCurrentValue));

        if (valueLength == sub.length()) {
            sub.deleteCharAt(0);

        }

        sB.insert(0, sub);

        if (deleteMark) {
            while (sub.toString().length() < String.valueOf(tempMinusValue).length()) {
                sB.insert(0, "0");
                sub.insert(0, "0");
            }
        } else {
            while (sub.toString().length() < String.valueOf(tempMinusValue).length() - 1) {
                sB.insert(0, "0");
                sub.insert(0, "0");
            }
        }
        sub.setLength(0);


        ///////////////////////////////////////////////
        //////////////////////////////////////////////

        while (minusValue.length() >= 18) {
            tempMinusValue = Long.parseLong(minusValue.substring(minusValue.length() - 18));

            if (rankAdd) {
                tempMinusValue--;
                rankAdd = false;
            }


            sB.insert(0, tempMinusValue);

            minusValue = minusValue.substring(0, minusValue.length() - 18);

        }
        if (minusValue.length() != 0) {
            tempMinusValue = Long.parseLong(minusValue);
            if (rankAdd) {
                tempMinusValue--;
            }
            sB.insert(0, tempMinusValue);
        }

        if (negativeMark) {
            sB.insert(0, '-');
        }
        this.value = sB.toString();


    }

    public void add(String value) {

        if (value.equals("0")) {
            return;
        }
        if (this.value.equals("0")) {
            this.value = value;
            return;
        }

        value = value.replace(" ", "");
        if (value.charAt(0) == '-' || this.value.charAt(0) == '-') {
            minus(value);
            return;
        }
        String addValue, currentValue;

        if (greaterValue(this.value, value) == 1) {
            addValue = this.value;
            currentValue = value;
        } else {
            addValue = value;
            currentValue = this.value;

        }


        long result;
        String resultS;
        StringBuilder sB = new StringBuilder();

        while (currentValue.length() >= 18) {

            result = operateAndSub(addValue, currentValue, '+', 18, 18);
            if (rankChange) {
                result++;
                rankChange = false;
            }
            resultS = String.valueOf(result);
            if (resultS.length() > 18) {
                resultS = resultS.substring(1);
                rankChange = true;
            }


            sB.insert(0, resultS);
            if (resultS.length() < 18) {
                for (int i = 0; i < 18 - resultS.length(); i++) {
                    sB.insert(0, "0");
                }
            }


            addValue = addValue.substring(0, addValue.length() - 18);
            currentValue = currentValue.substring(0, currentValue.length() - 18);
        }

        ///////////////////////////////////////////////
        ///////////////////////////////////////////////
        if (currentValue.length() != 0) {
            if (addValue.length() < 18) {

                result = operateAndSub(addValue, currentValue, '+', addValue.length(), currentValue.length());

                if (rankChange) {
                    result++;
                    rankChange = false;
                }
                sB.insert(0, result);
                this.value = sB.toString();
                return;
            } else {

                result = operateAndSub(addValue, currentValue, '+', 18, currentValue.length());
            }


            if (rankChange) {
                result++;
                rankChange = false;
            }

            resultS = String.valueOf(result);

            if (resultS.length() > 18) {
                resultS = resultS.substring(1);
                rankChange = true;
            }


            sB.insert(0, resultS);
            if (resultS.length() < 18) {
                for (int i = 0; i < 18 - resultS.length(); i++) {
                    sB.insert(0, "0");
                }
            }

            addValue = addValue.substring(0, addValue.length() - 18);
        }
        ///////////////////////////////////////////////
        ///////////////////////////////////////////////

        while (addValue.length() >= 18) {

            result = Long.parseLong(addValue.substring(addValue.length() - 18));

            if (rankChange) {
                result++;
                rankChange = false;
            }

            resultS = String.valueOf(result);

            if (resultS.length() > 18) {
                resultS = resultS.substring(1);
                rankChange = true;
            }

            sB.insert(0, resultS);

            if (resultS.length() < 18) {
                for (int i = 0; i < 18 - resultS.length(); i++) {
                    sB.insert(0, "0");
                }
            }
            addValue = addValue.substring(0, addValue.length() - 18);
        }
        if (addValue.length() != 0) {
            result = Long.parseLong(addValue);
        } else {
            result = 0;
        }

        if (rankChange) {
            result++;
            rankChange = false;
        }
        sB.insert(0, result);


        this.value = sB.toString();

        while (this.value.charAt(0) == '0' && this.value.length() > 1) {
            this.value = this.value.substring(1);

        }

    }

    public void add(BigInt value) {

        if (value.value.equals("0")) {
            return;
        }
        if (this.value.equals("0")) {
            this.value = value.value;
            return;
        }

        if (value.getValue().charAt(0) == '-' || this.value.charAt(0) == '-') {
            minus(value);
            return;
        }
        String addValue, currentValue;

        if (greaterValue(this, value) == 1) {
            addValue = this.value;
            currentValue = value.getValue();
        } else {
            addValue = value.getValue();
            currentValue = this.value;

        }


        long result;
        String resultS;
        StringBuilder sB = new StringBuilder();

        while (currentValue.length() >= 18) {

            result = operateAndSub(addValue, currentValue, '+', 18, 18);
            if (rankChange) {
                result++;
                rankChange = false;
            }
            resultS = String.valueOf(result);
            if (resultS.length() > 18) {
                resultS = resultS.substring(1);
                rankChange = true;
            }


            sB.insert(0, resultS);
            if (resultS.length() < 18) {
                for (int i = 0; i < 18 - resultS.length(); i++) {
                    sB.insert(0, "0");
                }
            }


            addValue = addValue.substring(0, addValue.length() - 18);
            currentValue = currentValue.substring(0, currentValue.length() - 18);
        }

        ///////////////////////////////////////////////
        ///////////////////////////////////////////////
        if (currentValue.length() != 0) {
            if (addValue.length() < 18) {

                result = operateAndSub(addValue, currentValue, '+', addValue.length(), currentValue.length());

                if (rankChange) {
                    result++;
                    rankChange = false;
                }
                sB.insert(0, result);
                this.value = sB.toString();
                return;
            } else {

                result = operateAndSub(addValue, currentValue, '+', 18, currentValue.length());
            }


            if (rankChange) {
                result++;
                rankChange = false;
            }

            resultS = String.valueOf(result);

            if (resultS.length() > 18) {
                resultS = resultS.substring(1);
                rankChange = true;
            }


            sB.insert(0, resultS);
            if (resultS.length() < 18) {
                for (int i = 0; i < 18 - resultS.length(); i++) {
                    sB.insert(0, "0");
                }
            }

            addValue = addValue.substring(0, addValue.length() - 18);
        }
        ///////////////////////////////////////////////
        ///////////////////////////////////////////////

        while (addValue.length() >= 18) {
            result = Long.parseLong(addValue.substring(addValue.length() - 18));

            if (rankChange) {
                result++;
                rankChange = false;
            }

            resultS = String.valueOf(result);

            if (resultS.length() > 18) {
                resultS = resultS.substring(1);
                rankChange = true;
            }

            sB.insert(0, resultS);

            if (resultS.length() < 18) {
                for (int i = 0; i < 18 - resultS.length(); i++) {
                    sB.insert(0, "0");
                }
            }

            addValue = addValue.substring(0, addValue.length() - 18);
        }
        if (addValue.length() != 0) {
            result = Long.parseLong(addValue);
        } else {
            result = 0;
        }

        if (rankChange) {
            result++;
            rankChange = false;
        }
        sB.insert(0, result);


        this.value = sB.toString();

        while (this.value.charAt(0) == '0' && this.value.length() > 1) {
            this.value = this.value.substring(1);

        }

    }

    public void multiply(BigInt bigInt) {
        boolean negativeMark = false;
        String currentValue, multiplyValue;

        currentValue = bigInt.value;
        multiplyValue = this.value;

        if (bigInt.value.charAt(0) == '-') {
            negativeMark = true;
            currentValue = bigInt.value.substring(1);
        }
        if (this.value.charAt(0) == '-') {
            negativeMark = true;
            multiplyValue = this.value.substring(1);
        }
        if ((bigInt.value.charAt(0) == '-' && this.value.charAt(0) == '-')) {
            currentValue = bigInt.value.substring(1);
            multiplyValue = this.value.substring(1);
            negativeMark = false;
        }


        List<String> currentValueDig, multiplyValueDig, result;
        currentValueDig = new ArrayList<>(this.digitization(multiplyValue));
        multiplyValueDig = new ArrayList<>(this.digitization(currentValue));
        result = new ArrayList<>();

        StringBuilder sB = new StringBuilder();

        for (String currentNum : currentValueDig) {
            for (String multiplyNum : multiplyValueDig) {
                sB.append(String.valueOf(currentNum), 1, currentNum.length());
                sB.append(String.valueOf(multiplyNum), 1, multiplyNum.length());




                sB.insert(0, Character.getNumericValue(currentNum.charAt(0)) * Character.getNumericValue(multiplyNum.charAt(0)));
                result.add(sB.toString());
                sB.setLength(0);
            }

        }
        this.value = "0";
        for (String num : result) {
            this.add(num);

        }
        if (negativeMark) {
            sB.setLength(0);
            sB.append(this.value);
            sB.insert(0, '-');
            this.value = sB.toString();
        }
    }

    public void multiply(String bigInt) {
        boolean negativeMark = false;
        String currentValue, multiplyValue;

        currentValue = bigInt;
        multiplyValue = this.value;

        if (bigInt.charAt(0) == '-') {
            negativeMark = true;
            currentValue = bigInt.substring(1);
        }
        if (this.value.charAt(0) == '-') {
            negativeMark = true;
            multiplyValue = this.value.substring(1);
        }
        if ((bigInt.charAt(0) == '-' && this.value.charAt(0) == '-')) {
            currentValue = bigInt.substring(1);
            multiplyValue = this.value.substring(1);
            negativeMark = false;
        }


        List<String> currentValueDig, multiplyValueDig, result;
        currentValueDig = new ArrayList<>(this.digitization(multiplyValue));
        multiplyValueDig = new ArrayList<>(this.digitization(currentValue));
        result = new ArrayList<>();

        StringBuilder sB = new StringBuilder();

        for (String currentNum : currentValueDig) {
            for (String multiplyNum : multiplyValueDig) {
                sB.append(String.valueOf(currentNum), 1, currentNum.length());
                sB.append(String.valueOf(multiplyNum), 1, multiplyNum.length());




                sB.insert(0, Character.getNumericValue(currentNum.charAt(0)) * Character.getNumericValue(multiplyNum.charAt(0)));
                result.add(sB.toString());
                sB.setLength(0);
            }

        }
        this.value = "0";
        for (String num : result) {
            this.add(num);

        }
        if (negativeMark) {
            sB.setLength(0);
            sB.append(this.value);
            sB.insert(0, '-');
            this.value = sB.toString();
        }
    }

    public void divide(BigInt bigInt) {

        boolean negativeMark = false;
        BigInt divideValue = new BigInt(bigInt.value);
        BigInt currentValue = new BigInt("0");
        BigInt wholeCount = new BigInt("0");
        BigInt target = new BigInt(this.value);

        if (bigInt.value.charAt(0) == '-') {
            negativeMark = true;
            divideValue = new BigInt(bigInt.value.substring(1));
        }
        if (target.value.charAt(0) == '-') {
            negativeMark = true;
            target = new BigInt(target.value.substring(1));
        }
        if (bigInt.value.charAt(0) == '-' && target.value.charAt(0) == '-') {
            negativeMark = false;
            divideValue = new BigInt(bigInt.value.substring(1));
            target = new BigInt(target.value.substring(1));
        }


        BigInt divideValue10 = new BigInt(divideValue.value);
        divideValue10.multiply("10");

        BigInt divideValue100 = new BigInt(divideValue.value);
        divideValue100.multiply("100");

        BigInt divideValue1000 = new BigInt(divideValue.value);
        divideValue1000.multiply("1000");

        BigInt divideValue10000 = new BigInt(divideValue.value);
        divideValue10000.multiply("10000");

        BigInt currentTemp = new BigInt("0");

        while (currentValue.greaterValue(target.value, currentValue.value) == 1) {
            currentTemp.setValue(currentValue.getValue());
            currentValue.add(divideValue10000);

            if (currentValue.greaterValue(target.value, currentValue.value) == 1) {
                wholeCount.add("10000");
            } else {
                currentValue.setValue(currentTemp.getValue());
                break;
            }
        }
        currentTemp = new BigInt("0");

        while (currentValue.greaterValue(target.value, currentValue.value) == 1) {
            currentTemp.setValue(currentValue.getValue());
            currentValue.add(divideValue1000);

            if (currentValue.greaterValue(target.value, currentValue.value) == 1) {
                wholeCount.add("1000");
            } else {
                currentValue.setValue(currentTemp.getValue());
                break;
            }
        }


        while (currentValue.greaterValue(target.value, currentValue.value) == 1) {
            currentTemp.setValue(currentValue.getValue());
            currentValue.add(divideValue100);

            if (currentValue.greaterValue(target.value, currentValue.value) == 1) {
                wholeCount.add("100");
            } else {
                currentValue.setValue(currentTemp.getValue());
                break;
            }
        }


        while (currentValue.greaterValue(target.value, currentValue.value) == 1) {
            currentTemp.setValue(currentValue.getValue());
            currentValue.add(divideValue10);

            if (currentValue.greaterValue(target.value, currentValue.value) == 1) {
                wholeCount.add("10");
            } else {
                currentValue.setValue(currentTemp.getValue());
                break;
            }
        }


        while (currentValue.greaterValue(target.value, currentValue.value) == 1) {
            currentTemp.setValue(currentValue.getValue());
            currentValue.add(divideValue);

            if (currentValue.greaterValue(target.value, currentValue.value) == 1 || currentValue.greaterValue(target.value, currentValue.value) == 0) {
                wholeCount.add("1");
            } else {
                currentValue.setValue(currentTemp.getValue());
                break;
            }
        }
        if (negativeMark) {
            StringBuilder sB = new StringBuilder();
            sB.append(wholeCount.value);
            sB.insert(0, '-');
            wholeCount.setValue(sB.toString());
        }

        this.value = wholeCount.value;
    }

    public List<String> digitization(String bigInt) {
        char zero = '0';
        StringBuilder sB = new StringBuilder();
        List<String> result = new ArrayList<>();
        for (int i = 0; i < bigInt.length(); i++) {
            if (bigInt.charAt(i) != '0') {
                sB.append(String.valueOf(zero).repeat(bigInt.length() - i - 1));
                sB.insert(0, bigInt.charAt(i));
                result.add(sB.toString());
                sB.setLength(0);
            }
        }
        return result;

    }

    public String getValue() {
        return this.value;
    }

    public int greaterValue(BigInt bigInt1, BigInt bigInt2) {
        boolean negativeMark = false;

        if (bigInt1.value.charAt(0) == '-' && bigInt2.value.charAt(0) != '-') {
            return 2;
        }
        if (bigInt1.value.charAt(0) != '-' && bigInt2.value.charAt(0) == '-') {
            return 1;
        }
        if (bigInt1.value.charAt(0) == '-' && bigInt2.value.charAt(0) == '-') {
            negativeMark = true;
        }

        if (bigInt1.value.length() == bigInt2.value.length()) {
            for (int i = 0; i < bigInt1.value.length(); i++) {

                if (bigInt1.value.charAt(i) == bigInt2.value.charAt(i)) {

                } else {
                    if (bigInt1.value.charAt(i) > bigInt2.value.charAt(i)) {
                        if (negativeMark) {
                            return 2;
                        }
                        return 1;

                    } else {
                        if (negativeMark) {
                            return 1;
                        }
                        return 2;
                    }
                }

            }
            return 0;

        } else {
            if (bigInt1.value.length() > bigInt2.value.length()) {
                if (negativeMark) {
                    return 2;
                }
                return 1;

            } else {
                if (negativeMark) {
                    return 1;
                }
                return 2;
            }

        }

    }

    public int greaterValue(String bigInt1, String bigInt2) {

        boolean negativeMark = false;

        if (bigInt1.charAt(0) == '-' && bigInt2.charAt(0) != '-') {
            return 2;
        }
        if (bigInt1.charAt(0) != '-' && bigInt2.charAt(0) == '-') {
            return 1;
        }
        if (bigInt1.charAt(0) == '-' && bigInt2.charAt(0) == '-') {
            negativeMark = true;
        }

        if (bigInt1.length() == bigInt2.length()) {
            for (int i = 0; i < bigInt1.length(); i++) {

                if (bigInt1.charAt(i) == bigInt2.charAt(i)) {

                } else {
                    if (bigInt1.charAt(i) > bigInt2.charAt(i)) {
                        if (negativeMark) {
                            return 2;
                        }
                        return 1;

                    } else {
                        if (negativeMark) {
                            return 1;
                        }
                        return 2;
                    }
                }

            }
            return 0;

        } else {
            if (bigInt1.length() > bigInt2.length()) {
                if (negativeMark) {
                    return 2;
                }
                return 1;

            } else {
                if (negativeMark) {
                    return 1;
                }
                return 2;
            }

        }

    }

    public long operateAndSub(String value1, String value2, char operation, int subRate1, int subRate2) {
        long firstValue, secondValue;

        if (value1.length() == 0) {
            firstValue = 0;
        } else {
            firstValue = Long.parseLong(value1.substring(value1.length() - subRate1));
        }
        if (value2.length() == 0) {
            secondValue = 0;
        } else {
            secondValue = Long.parseLong(value2.substring(value2.length() - subRate2));
        }


        switch (operation) {

            case '+':
                return firstValue + secondValue;


            case '-':
                return firstValue - secondValue;
        }
        return 0;

    }


}
