package itdvn;

import java.util.ArrayList;
import java.util.List;

public class FyndWord {
    public static void main(String[] args) {

        String text = "Линейный или позиции последовательный поиск – простейший алгоритм Линейный поиска. " +
                "Он редко используется из-за позиции своей неэффективности. " +
                "По сути, это метод полного позиции перебора, и он уступает другим алгоритмам позиции .";

        String[] t = text.split(" ");


        List<String> elementnumber = new ArrayList<String>();
        List<Integer> intelementnumber = new ArrayList<Integer>();

        for (int i = 0; i < t.length; i++) {
            String word = t[i];

            word = word.toLowerCase();

            if (elementnumber.contains(word)) {
                int position = elementnumber.indexOf(word);
                Integer number = intelementnumber.get(position);
                int numbeint = number.intValue();
                numbeint++;
                number = new Integer(numbeint);
                intelementnumber.set(position, number);
            } else {
                elementnumber.add(word);
                intelementnumber.add(new Integer(1));
            }

        }


        for (int i = 0; i < elementnumber.size(); i++) {
            if (intelementnumber.get(i) > 1) {
                System.out.println(/*i + */" " + elementnumber.get(i) + " " + intelementnumber.get(i));
            }
        }

    }

}

