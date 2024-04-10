import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BigIntTest {

    @org.junit.jupiter.api.Test
    void minus() {
        BigInt num1 = new BigInt("1");
        BigInt num2 = new BigInt("-99999999999999999999999999");
        BigInt expectedSum1 = new BigInt("-99999999999999999999999998");
        num1.minus(num2);
        assertEquals(expectedSum1.getValue(), num1.getValue());

        num1 = new BigInt("1");
        num2 = new BigInt("99999999999999999999999999");
        expectedSum1 = new BigInt("-99999999999999999999999998");
        num1.minus(num2);
        assertEquals(expectedSum1.getValue(), num1.getValue());

        num1 = new BigInt("-1");
        num2 = new BigInt("99999999999999999999999999");
        expectedSum1 = new BigInt("99999999999999999999999998");
        num1.minus(num2);
        assertEquals(expectedSum1.getValue(), num1.getValue());

        num1 = new BigInt("567654896852418987525329847685");
        num2 = new BigInt("76125453528659647706457850397698584956725878427896347");
        expectedSum1 = new BigInt("-76125453528659647706457282742801732537738353098048662");
        num1.minus(num2);
        assertEquals(expectedSum1.getValue(), num1.getValue());

        num1 = new BigInt("986765774697325632724854774968758352638");
        num2 = new BigInt("35463483972646325167167834679345634784758204989841713498750");
        expectedSum1 = new BigInt("-35463483972646325166181068904648309152033350214872955146112");
        num1.minus(num2);
        assertEquals(expectedSum1.getValue(), num1.getValue());

        num1 = new BigInt("836457364837124325786324658872");
        num2 = new BigInt("83475632687462914782987718727592784952432873247");
        expectedSum1 = new BigInt("-83475632687462913946530353890468459166108214375");
        num1.minus(num2);
        assertEquals(expectedSum1.getValue(), num1.getValue());



        num1 = new BigInt("0");
        num2 = new BigInt("83475632687462914782987718727592784952432873247");
        expectedSum1 = new BigInt("-83475632687462914782987718727592784952432873247");
        num1.minus(num2);
        assertEquals(expectedSum1.getValue(), num1.getValue());

        num1 = new BigInt("4687 000 000 000 000 000 000 000 000 000 000 572 68546 286");
        num2 = new BigInt("8347 56326 87462 91478 29877 18727 59278 495 24328 732 47");
        expectedSum1 = new BigInt("-83006932687462914782987718727592784895164326961");
        num1.minus(num2);
        assertEquals(expectedSum1.getValue(), num1.getValue());

        num1 = new BigInt("4687 000 000 000 000 000 000 000 000 000 000 572 68546 286");
        expectedSum1 = new BigInt("-83006932687462914782987718727592784895164326961");
        num1.minus("8347 56326 87462 91478 29877 18727 59278 495 24328 732 47");
        assertEquals(expectedSum1.getValue(), num1.getValue());

        num1 = new BigInt("4687000000000000000000000000000000000000000000057268546286");
        num2 = new BigInt("83475632687462914782987718727592784952432873247");
        expectedSum1 = new BigInt("4686999999916524367312537085217012281272407215104835673039");
        num1.minus(num2);
        assertEquals(expectedSum1.getValue(), num1.getValue());

        num1 = new BigInt("400000000000000000000000000000000000000000000000006");
        num2 = new BigInt("200000000000000000000000000000000000000000000000001");
        expectedSum1 = new BigInt("200000000000000000000000000000000000000000000000005");
        num1.minus(num2);
        assertEquals(expectedSum1.getValue(), num1.getValue());


        num1 = new BigInt("400000540000043500005445300000034543500000004353540000543354000000345345000005433540000006");
        num2 = new BigInt("20054300003455400000500000500000006600050000543000004530006000001");
        expectedSum1 = new BigInt("400000540000043500005445279945734540044600003853539500543347399950344802000000903534000005");
        num1.minus(num2);
        assertEquals(expectedSum1.getValue(), num1.getValue());


        num1 = new BigInt("6874895782768982374678237534658732743289");
        num2 = new BigInt("-6874895782768982374678237534658732743289");
        expectedSum1 = new BigInt("0");
        num1.minus(num2);
        assertEquals(expectedSum1.getValue(), num1.getValue());

        num1 = new BigInt("6874895782768982374678237534658732743289");
        expectedSum1 = new BigInt("0");
        num1.minus("-6874895782768982374678237534658732743289");
        assertEquals(expectedSum1.getValue(), num1.getValue());

        num1 = new BigInt("0");
        num2 = new BigInt("1");
        expectedSum1 = new BigInt("-1");
        num1.minus(num2);
        assertEquals(expectedSum1.getValue(), num1.getValue());

        num1 = new BigInt("0");

        expectedSum1 = new BigInt("-1");
        num1.minus("1");
        assertEquals(expectedSum1.getValue(), num1.getValue());
    }

    @org.junit.jupiter.api.Test
    void add() {


        BigInt num1 = new BigInt("1402528017984744463936819252200000000000000");
        BigInt num2 = new BigInt("480000000000000000");
        BigInt expectedSum1 = new BigInt("1402528017984744463936819732200000000000000");
        num1.add(num2);
        assertEquals(expectedSum1.getValue(), num1.getValue());

        num1 = new BigInt("1");
        num2 = new BigInt("99999999999999999999999999");
        expectedSum1 = new BigInt("100000000000000000000000000");
        num1.add(num2);
        assertEquals(expectedSum1.getValue(), num1.getValue());

        num1 = new BigInt("6874895782768982374678237534658732743289");
        num2 = new BigInt("-6874895782768982374678237534658732743289");
        expectedSum1 = new BigInt("0");
        num1.add(num2);
        assertEquals(expectedSum1.getValue(), num1.getValue());

        num1 = new BigInt("0");
        num2 = new BigInt("1");
        expectedSum1 = new BigInt("1");
        num1.add(num2);
        assertEquals(expectedSum1.getValue(), num1.getValue());


        num1 = new BigInt("3786847356347568734765932487342979832");
        num2 = new BigInt("82375678345687324657632454548732465846563241856324138756847");
        expectedSum1 = new BigInt("82375678345687324657636241396088813415298007788811481736679");
        num1.add(num2);
        assertEquals(expectedSum1.getValue(), num1.getValue());

        num1 = new BigInt("3786847356347568734765932487342979832");
        expectedSum1 = new BigInt("82375678345687324657636241396088813415298007788811481736679");
        num1.add("82375678345687324657632454548732465846563241856324138756847");
        assertEquals(expectedSum1.getValue(), num1.getValue());

        num1 = new BigInt("1000000000000000000000000000");
        num2 = new BigInt("1347883754687");
        expectedSum1 = new BigInt("1000000000000001347883754687");
        num1.add(num2);
        assertEquals(expectedSum1.getValue(), num1.getValue());

        num1 = new BigInt("1000000000000000000000000000");
        expectedSum1 = new BigInt("1000000000000001347883754687");
        num1.add("1347883754687");
        assertEquals(expectedSum1.getValue(), num1.getValue());

        num1 = new BigInt("1000000010000001000001001000");
        num2 = new BigInt("13478837");
        expectedSum1 = new BigInt("1000000010000001000014479837");
        num1.add(num2);
        assertEquals(expectedSum1.getValue(), num1.getValue());

        num1 = new BigInt("480000000000000000000000000000000000000000000000000000");
        num2 = new BigInt("40000000000000000000000000000000000000000000000000000");
        expectedSum1 = new BigInt("520000000000000000000000000000000000000000000000000000");
        num1.add(num2);
        assertEquals(expectedSum1.getValue(), num1.getValue());

        num1 = new BigInt("480000000000000000000000000000000000000000000000000000");
        num2 = new BigInt("0");
        expectedSum1 = new BigInt("480000000000000000000000000000000000000000000000000000");
        num1.add(num2);
        assertEquals(expectedSum1.getValue(), num1.getValue());

        num1 = new BigInt("56508748095137821850747714986574432407432000000000000");
        num2 = new BigInt("360000000000000000000000000000000000000000000");
        expectedSum1 = new BigInt("56508748455137821850747714986574432407432000000000000");
        num1.add(num2);
        assertEquals(expectedSum1.getValue(), num1.getValue());

        num1 = new BigInt("56508748487215465771203006880170973649480800000000000");
        num2 = new BigInt("48000000000000000000000000000000000000000000");
        expectedSum1 = new BigInt("56508748535215465771203006880170973649480800000000000");
        num1.add(num2);
        assertEquals(expectedSum1.getValue(), num1.getValue());

        num1 = new BigInt("56508748539492484960597045799317179148420640000000000");
        num2 = new BigInt("2400000000000000000000000000000000000000000");
        expectedSum1 = new BigInt("56508748541892484960597045799317179148420640000000000");
        num1.add(num2);
        assertEquals(expectedSum1.getValue(), num1.getValue());



    }

    @org.junit.jupiter.api.Test
    void graterValue() {
        BigInt num1 = new BigInt("1");
        BigInt num2 = new BigInt("99999999999999999999999999");
        assertEquals(2, num1.graterValue(num1,num2));

        num1 = new BigInt("-1");
        num2 = new BigInt("99999999999999999999999999");
        assertEquals(2, num1.graterValue(num1,num2));

        num1 = new BigInt("1");
        num2 = new BigInt("-99999999999999999999999999");
        assertEquals(1, num1.graterValue(num1,num2));

        num1 = new BigInt("-1");
        num2 = new BigInt("-99999999999999999999999999");
        assertEquals(1, num1.graterValue(num1,num2));

        num1 = new BigInt("1");
        num2 = new BigInt("1");
        assertEquals(0, num1.graterValue(num1,num2));

        num1 = new BigInt("-1");
        num2 = new BigInt("-1");
        assertEquals(0, num1.graterValue(num1,num2));

        num1 = new BigInt("8679549836875975384789235798234");
        num2 = new BigInt("98537348935479834985987");
        assertEquals(1, num1.graterValue(num1,num2));

        num1 = new BigInt("8679549836875975384789235798234");
        num2 = new BigInt("8679549836875975384789235798234");
        assertEquals(0, num1.graterValue(num1,num2));

        num1 = new BigInt("8679549836875975384789235798234");
        num2 = new BigInt("8679549836875975384789235798234");
        assertEquals(2, num1.graterValue("1","2"));

        num1 = new BigInt("8679549836875975384789235798234");
        num2 = new BigInt("0");
        assertEquals(1, num1.graterValue(num1,num2));

        num1 = new BigInt("0");
        num2 = new BigInt("8679549836875975384789235798234");
        assertEquals(2, num1.graterValue(num1,num2));
    }


    @Test
    void multiply(){
        BigInt num1 = new BigInt("1");
        BigInt num2 = new BigInt("99999999999999999999999999");
        BigInt expectedSum1 = new BigInt("99999999999999999999999999");
        num1.multiply(num2);
        assertEquals(expectedSum1.getValue(), num1.getValue());

        num1 = new BigInt("864758534684797395729");
        num2 = new BigInt("653462739867425486489327568736748");
        expectedSum1 = new BigInt("565087481398867800517897670854426826430760268780549292");
        num1.multiply(num2);
        assertEquals(expectedSum1.getValue(), num1.getValue());

        num1 = new BigInt("757289279423892");
        num2 = new BigInt("24524554");
        expectedSum1 = new BigInt("18572181826852328244168");
        num1.multiply(num2);
        assertEquals(expectedSum1.getValue(), num1.getValue());

        num1 = new BigInt("8093484900093279982409");
        num2 = new BigInt("5643019130400000000001");
        expectedSum1 = new BigInt("45671690122829911685225455962033693279982409");
        num1.multiply(num2);
        assertEquals(expectedSum1.getValue(), num1.getValue());

        num1 = new BigInt("5984799098806970");
        num2 = new BigInt("234536457856980679588096958");
        expectedSum1 = new BigInt("1403653581619836869599117384782150486197260");
        num1.multiply(num2);
        assertEquals(expectedSum1.getValue(), num1.getValue());

        num1 = new BigInt("5984799098806970");
        num2 = new BigInt("-234536457856980679588096958");
        expectedSum1 = new BigInt("-1403653581619836869599117384782150486197260");
        num1.multiply(num2);
        assertEquals(expectedSum1.getValue(), num1.getValue());

        num1 = new BigInt("5984799098806970");
        num2 = new BigInt("-1");
        expectedSum1 = new BigInt("-5984799098806970");
        num1.multiply(num2);
        assertEquals(expectedSum1.getValue(), num1.getValue());

        num1 = new BigInt("-5984799098806970");
        num2 = new BigInt("-1");
        expectedSum1 = new BigInt("5984799098806970");
        num1.multiply(num2);
        assertEquals(expectedSum1.getValue(), num1.getValue());

    }
   @Test
    void divide(){
       BigInt num1 = new BigInt("74563634787547");
       BigInt num2 = new BigInt("4756375546737");
       BigInt expectedSum1 = new BigInt("15");
       num1.divide(num2);
       assertEquals(expectedSum1.getValue(),num1.getValue());

       num1 = new BigInt("74563634787547");
       num2 = new BigInt("-4756375546737");
       expectedSum1 = new BigInt("-15");
       num1.divide(num2);
       assertEquals(expectedSum1.getValue(),num1.getValue());

       num1 = new BigInt("-74563634787547");
       num2 = new BigInt("4756375546737");
       expectedSum1 = new BigInt("-15");
       num1.divide(num2);
       assertEquals(expectedSum1.getValue(),num1.getValue());

       num1 = new BigInt("6544565");
       num2 = new BigInt("6544565");
       expectedSum1 = new BigInt("1");
       num1.divide(num2);
       assertEquals(expectedSum1.getValue(),num1.getValue());

       num1 = new BigInt("765676567654567");
       num2 = new BigInt("676567567676");
       expectedSum1 = new BigInt("1131");
       num1.divide(num2);
       assertEquals(expectedSum1.getValue(),num1.getValue());

       num1 = new BigInt("53070074940546063548606358");
       num2 = new BigInt("4530000003658437900054");
       expectedSum1 = new BigInt("11715");
       num1.divide(num2);
       assertEquals(expectedSum1.getValue(),num1.getValue());

       num1 = new BigInt("53070074940546063548606358");
       num2 = new BigInt("-53070074940546063548606358");
       expectedSum1 = new BigInt("-1");
       num1.divide(num2);
       assertEquals(expectedSum1.getValue(),num1.getValue());

       num1 = new BigInt("6859746493536534936534956");
       num2 = new BigInt("5423655346545463");
       expectedSum1 = new BigInt("1264782891");
       num1.divide(num2);
       assertEquals(expectedSum1.getValue(),num1.getValue());


    }
}