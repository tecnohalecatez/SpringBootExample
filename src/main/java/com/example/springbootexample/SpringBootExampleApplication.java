package com.example.springbootexample;

import com.example.springbootexample.model.Client;
import com.example.springbootexample.repository.ClientRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class SpringBootExampleApplication {

    private static final Logger log = LoggerFactory.getLogger(SpringBootExampleApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(SpringBootExampleApplication.class, args);
    }

    @Bean
    public CommandLineRunner example(ClientRepository clientRepository) {
        return args -> {
            clientRepository.save(new Client("John", "Doe"));
            clientRepository.save(new Client("Jane", "Doe"));
            clientRepository.save(new Client("Jim", "Beam"));
            clientRepository.save(new Client("Jack", "Daniels"));
            clientRepository.save(new Client("Johnny", "Walker"));
            clientRepository.save(new Client("James", "Bond"));

            log.info("All clients saved");
            clientRepository.findAll().forEach(Client -> {
                log.info(Client.toString());
            });
            log.info("");

            log.info("Client with ID 1");
            Client client = clientRepository.findById(1L).orElse(null);
            log.info(Optional.ofNullable(client).map(Object::toString)
                    .orElse("Client not found"));
            log.info("");

            log.info("Clients with last name 'Doe'");
            List<Client> clients = clientRepository.findByLastName("Doe");
            clients.forEach(Client -> {
                log.info(Client.toString());
            });

        };
    }

}
