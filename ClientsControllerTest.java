package com.example.example;

public class ClientsControllerTest {
    @Test
    public void testAddClient() {
        ClientsController clientsController = new ClientsController();
        Client client = new Client("John Doe", "johndoe@example.com");
        assertTrue(clientsController.addClient(client));
    }
    @Test
    public void testRemoveClient() {
        ClientsController clientsController = new ClientsController();
        Client client = new Client("Jane Smith", "janesmith@example.com");
        clientsController.addClient(client);
        assertTrue(clientsController.removeClient(client));
    }
    @Test
    public void testFindClientByEmail() {
        ClientsController clientsController = new ClientsController();
        Client client = new Client("Alice Brown",
                "alicebrown@example.com");
        clientsController.addClient(client);
        assertEquals(client,
                clientsController.findClientByEmail("alicebrown@example.com"));
    }
    @Test
    public void testUpdateClientEmail() {
        ClientsController clientsController = new ClientsController();
        Client client = new Client("Bob Green", "bobgreen@example.com");
        clientsController.addClient(client);

        assertTrue(clientsController.updateClientEmail("bobgreen@example.com",
                "bobgreen_new@example.com"));
        assertEquals("bobgreen_new@example.com", client.getEmail());
    }
}
