package blockConstructorChallenge;

import java.io.*;
import java.util.*;

public class BlockConstructor {

    public ArrayList<String> readCsv(String fileName){
        ArrayList<String> listOfTransactionId = new ArrayList<>();

        String line;
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            while ((line = br.readLine()) != null) {
                listOfTransactionId.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return listOfTransactionId;
    }

    public ArrayList<String> buildBlock(List<String> listOfTxIds){
        Set<String> blockList = new LinkedHashSet<>();

        final int MAXIMUM_WEIGHT = 4_000_000;
        int totalWeight = 0;


        for(String tx : listOfTxIds){
            if(totalWeight >= MAXIMUM_WEIGHT){
                break;
            }
            String newTx = tx.replaceAll("\""," ");
            String[] components = newTx.trim().split(",");

            if(components.length == 3 && !blockList.contains(components[0])){
                blockList.add(components[0]);
            } else if (components.length == 4) {
                String[] parentTrxnIDs = components[3].split(";");
                int count = 0;
                for(String parent : parentTrxnIDs){
                    if(blockList.contains(parent)){
                        count++;
                    }
                }

                if(count == parentTrxnIDs.length && !blockList.contains(components[0])){
                    blockList.add(components[0]);
                }
            }
            totalWeight +=Integer.parseInt(components[2]);
        }

        return new ArrayList<>(blockList);
    }

    public void writeToTextFile(ArrayList<String> transactionsInBlock){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"))){
            for (String transactionIds: transactionsInBlock){
                writer.write(transactionIds);
                writer.newLine();
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
