package org.chemid.molecularDescriptor;

import org.chemid.molecularDescriptor.common.MolecularDescriptorService;

import java.io.*;

/**
 * Created by tharinda on 7/12/16.
 */
public class test {

    public static void main(String[] args) {

        File file = new File("structures.sdf");
        if (!file.exists())
            throw new IllegalArgumentException("file not found: " + "protonated_2D.sdf");

        MolecularDescriptorService molecularDescriptorService = new MolecularDescriptorService();
        try {
            writeToFile(molecularDescriptorService.getDescriptorCSV(new FileInputStream(file), "").toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeToFile(String content) {
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter("output.csv"));
            out.write(content);
            out.close();
        }
        catch (IOException e) {
            System.out.println("Exception ");
        }

    }
}
