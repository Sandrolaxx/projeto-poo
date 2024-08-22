package src.primeirob.primeiraatv;

import java.io.FileWriter;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class JReader {

    public static void main(String[] args) {
        String[] columns = new String[100];

        try {
            int index = 0;

            while (true) {// Falta coisa ainda espertão, mas isso já te ajuda
                Scanner input = new Scanner(System.in);

                System.out.print("Insira " + (index + 1) + "º coluna: ");
                String column = input.next();

                columns[index] = column;
                index++;

                if (index < 3) {
                    continue;
                }

                System.out.print("Deseja inserir mais uma coluna?(S/N)");
                String chose = input.next();

                if (chose.equals("N")) {
                    break;
                }
            }

            File myCSV = new File("exemplo_bala.csv");
            boolean alreadyExistFile = myCSV.exists() && myCSV.canWrite();
            FileWriter writer = null;

            if (alreadyExistFile) {
                writer = new FileWriter(myCSV, true);
            } else {
                writer = new FileWriter("exemplo_bala.csv");
            }

            String content = alreadyExistFile ? "\n\n" : "";

            for (String str : columns) {
                if (str != null) {
                    content = content + str + ";";
                }
            }

            writer.write(content);

            writer.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

}
