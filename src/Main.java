import blockConstructorChallenge.BlockConstructor;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        BlockConstructor blockConstructor = new BlockConstructor();

        System.out.println("============Extracting Transactions==========");
        ArrayList<String> txIDs = blockConstructor.readCsv("mempool.csv - Sheet1.csv");
        ArrayList<String> eligible = blockConstructor.buildBlock(txIDs);
        System.out.println("============Writing To File==========");
        blockConstructor.writeToTextFile(eligible);
        System.out.println("============Done==========");

    }
}