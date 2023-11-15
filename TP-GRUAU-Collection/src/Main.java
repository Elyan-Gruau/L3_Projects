public class Main {
    public static void main(String[] args) {


        String[] exps = {
                "5 12 +",
                "10 2 /",
                "70 89 -",
                "-13 12 +",
                "6 7 * ",
                "5 12 4 + 3 - x",
                "12 4 + 5 3 - x"
            };
        //todo not good for  "5 12 4 + 3 - x",

        for (String exp : exps) {
            int result = InvertedPolishCalculator.evaluate(exp);
            System.out.println(exp+" = "+result);
        }



    }


}