import static org.testng.AssertJUnit.*;

public class CrudTest {
    private final ClientCrudService clientCrudService;
    private final PlanetCrudService planetCrudService;

    public CrudTest() {
        clientCrudService = new ClientCrudService();
        planetCrudService = new PlanetCrudService();
    }

    public void testClientCrudService() {

        Client client = new Client();
        client.setName("Johnny");
        clientCrudService.create(client);

        Client savedClient = clientCrudService.read(1L);
        System.out.println(savedClient);

        clientCrudService.delete(11L);

        assertNull(clientCrudService.read(11L));
    }

    public void testPlanetCrudService() {


        Planet planet = new Planet();
        planet.setId("NEP");
        planet.setName("Neptune");
        planetCrudService.create(planet);

        Planet savedPlanet = planetCrudService.read("NEP");
        System.out.println(savedPlanet);

        planetCrudService.delete("NEP");
    }

    public static void main(String[] args) {
        CrudTest crudTest = new CrudTest();
        crudTest.testClientCrudService();
        crudTest.testPlanetCrudService();
        HibernateUtil.getInstance().close();
    }
}
