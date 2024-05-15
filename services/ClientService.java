package com.example.example.services;

import org.springframework.stereotype.Service;

@Service
public class ClientService {

    public Client getClientById(int id) {
        Optional<Client> client = clients.stream().filter(c -> c.getId() == id).findFirst();
        return client.orElse(null);
    }


    public List<Client> searchClientsByName(String name) {
        if (name == null || name.isEmpty()) {
            return new ArrayList<>();
        }
        List<Client> result = new ArrayList<>();
        for (Client client : clients) {
            if (client.getName().equalsIgnoreCase(name)) {
                result.add(client);
            }
        }
        return result;
    }

  
    public void addClient(Client client) {
        clients.add(client);
    }

   
    public void updateClient(int id, Client updatedClient) {
        for (int i = 0; i < clients.size(); i++) {
            Client client = clients.get(i);
            if (client.getId() == id) {
                clients.set(i, updatedClient);
                return;
            }
        }
    }

    public void deleteClient(int id) {
        clients.removeIf(client -> client.getId() == id);
    }
}
}
