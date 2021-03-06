package server_thread.run_only;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.voltdb.client.Client;
import org.voltdb.client.ClientFactory;
import org.voltdb.client.ClientResponse;
import org.voltdb.client.ProcCallException;
import server_thread.ServerThreadHelper;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

/**
 * JVM parameter: -Djava.library.path=libs
 *
 * @author yablokov a.
 */
public class Insert {
    private static Client client;

    @BeforeClass
    public static void beforeClass() throws Exception {
        int port = ServerThreadHelper.runServer(MyTableInsertProcedure.class);
        client = ClientFactory.createClient();
        client.createConnection("localhost", port);
    }

    /**
     * С помощью системной хранимой процедуры @AdHoc.
     */
    @Test
    public void adHoc() throws IOException, ProcCallException {
        ClientResponse response = client.callProcedure("@AdHoc", "insert into my_table (id, number, text) values (1, 33, 'message');");
        assertEquals(ClientResponse.SUCCESS, response.getStatus());
    }

    /**
     * С помощью автоматически генерируемой хранимой процедуры для таблицы (default procedure).
     */
    @Test
    public void defaultProcedure() throws IOException, ProcCallException {
        ClientResponse response = client.callProcedure("MY_TABLE.insert", 2, 44, "insert message");
        assertEquals(ClientResponse.SUCCESS, response.getStatus());
    }

    /**
     * С помощью самописной хранимой процедуры.
     */
    @Test
    public void customProcedure() throws IOException, ProcCallException {
        ClientResponse response = client.callProcedure("MyTableInsertProcedure", 3, 55, "insert message");
        assertEquals(ClientResponse.SUCCESS, response.getStatus());
    }

    @AfterClass
    public static void tearDown() {
        ServerThreadHelper.stopServer();
    }
}
