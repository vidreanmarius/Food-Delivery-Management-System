package datalayer;

import bll.BaseProduct;
import bll.DeliveryService;
import bll.MenuItem;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Serializator {
/*
alta varianta de citit cu stream
 String fileName = "D:\\PT2022_30422_Vidrean_Marius_Assignment_4\\src\\main\\resources\\products (1).csv";
       try(InputStream fis = new FileInputStream(fileName);
           InputStreamReader isr = new InputStreamReader(fis, StandardCharsets.UTF_8);
           BufferedReader br = new BufferedReader(isr)){
           br.lines().skip(1).forEach(System.out::println);
       }
 */



    public List<BaseProduct> getData() throws IOException {
        Path path  =Path.of( "D:\\PT2022_30422_Vidrean_Marius_Assignment_4\\src\\main\\resources\\products (1).csv");

        List<BaseProduct> productsList = Files.lines(path)
                .skip(1)
                .map(Serializator::getProduct)
                .distinct()
                .collect(Collectors.toList());


        //System.out.println(productsList.get(3).getTitle());
        return productsList;
    }

    public void serialize(DeliveryService o) throws IOException {
        FileOutputStream fileOutputStream
                = new FileOutputStream("data.txt");
        ObjectOutputStream objectOutputStream
                = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(o);
        objectOutputStream.flush();
        objectOutputStream.close();
    }

    public DeliveryService deserialize() throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream
                = new FileInputStream("data.txt");
        ObjectInputStream objectInputStream
                = new ObjectInputStream(fileInputStream);
        DeliveryService deliveryService = (DeliveryService) objectInputStream.readObject();
        objectInputStream.close();
        return deliveryService;
    }


    private static BaseProduct getProduct(String line){
        String[] fields = line.split(",");
        return new BaseProduct(fields[0], Double.parseDouble(fields[1]), Integer.parseInt(fields[2]), Double.parseDouble(fields[3]), Double.parseDouble(fields[4]),
                Double.parseDouble(fields[5]), Double.parseDouble(fields[6]));
    }
}
