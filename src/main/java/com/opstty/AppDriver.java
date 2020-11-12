package com.opstty;

import com.opstty.job.*;
import org.apache.hadoop.util.ProgramDriver;

public class AppDriver {
    public static void main(String argv[]) {
        int exitCode = -1;
        ProgramDriver programDriver = new ProgramDriver();

        try {
            programDriver.addClass("wordcount", WordCount.class,
                    "A map/reduce program that counts the words in the input files.");
            programDriver.addClass("District_containing_trees", District_containing_trees.class,
                    "A map/reduce program that display the discrict containing trees");
            programDriver.addClass("existing_species", existing_species.class,
                    "A map/reduce program that display the existing species");
            programDriver.addClass("nb_trees_species", nb_trees_species.class,
                    "A map/reduce program that count the number of trees by species");
            programDriver.addClass("max_height_trees_species", max_height_trees_species.class,
                    "A map/reduce program that display trees max height by species");
            programDriver.addClass("sort_trees_small_to_height", sort_trees_small_to_height.class,
                    "A map/reduce program that sort trees from smallest to heighest");
            programDriver.addClass("district_oldest_tree", district_oldest_tree.class,
                    "A map/reduce program that display the district wich contain the oldest tree");
            
            exitCode = programDriver.run(argv);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

        System.exit(exitCode);
    }
}
