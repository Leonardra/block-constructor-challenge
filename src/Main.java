import blockConstructorChallenge.BlockConstructor;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        BlockConstructor blockConstructor = new BlockConstructor();

        ArrayList<String> txIDs = blockConstructor.readCsv("mempool.csv - Sheet1.csv");
        ArrayList<String> eligible = blockConstructor.buildBlock(txIDs);

        blockConstructor.writeToTextFile(eligible);

    }
}