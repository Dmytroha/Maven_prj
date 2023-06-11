package org.example;
import org.example.dto.FullName;
import com.google.gson.Gson;
import org.apache.log4j.BasicConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);
    public static void main(String[] args) {

        BasicConfigurator.configure();
        String jsonFullName = (new Gson()).toJson(new FullName("Dmytro", "Milovanov"));
        LOGGER.info("{}",jsonFullName);

    }
}