import com.es2.blackboxpartitioning.ArrayUtils;
import com.es2.blackboxpartitioning.Die;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.util.Date;
import java.sql.Timestamp;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class TestBlackBoxPartitioning {

    private final static ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @AfterAll
    static void tearDownAfterClass() throws Exception
    {
        new End();
    }

    @BeforeAll
    public static void setUpStreams()
    {
        System.setOut(new PrintStream(outContent));
    }

    @Test //secret catcher -> corrigido
    void teste1dado1()
    {
       Die d = new Die(7);
        Assertions.assertEquals(7,d.getNumSides());
    }

    @Test // free ride -> coloquei a segunda linha em comentário porque teriamos dois testes
    void teste2dado1()
    {
        assertThrows(AssertionError.class, () -> new Die(0));
        //assertThrows(AssertionError.class, () -> new Die(0,0));
    }

    @Test // enumerator -> TesteConstrutor
    void teste1dado2()
    {
        assertThrows(AssertionError.class, () -> new Die(0,0));
    }

    @Test
    void teste2dado2()
    {
        assertThrows(AssertionError.class, () -> new Die(6,7));
    }

    @Test
    void teste3dado2()
    {
        assertThrows(AssertionError.class, () -> new Die(6,0));
    }

    @Test
    void teste1roll()
    {
        Die dado = new Die();
        for(int i = 0; i < 6; i++)
        {
            int result = dado.roll();
            assertTrue(dado.getNumSides() >= result && 0 < result);
        }
    }

    @Test // Loudmouth-> pôr em comentário o que não importa
    void teste1findmin()
    {
        int[] Lista = null;
        assertThrows(AssertionError.class, () -> ArrayUtils.findMin(Lista));
        System.out.println("teste error not found");
     //   Date data = new Date();
      //  System.out.println("Tempo: " + data);
    }

    @Test
    void teste2findmin()
    {
        int[] Lista = {};
        assertThrows(AssertionError.class, () -> ArrayUtils.findMin(Lista));
    }

    @Test
    void teste3findmin()
    {
        int[] Lista = {2,3,4,1,12};
        assertEquals(3, ArrayUtils.findMin(Lista));
    }

    @Test
    void teste1GoodRezise()
    {
        assertThrows(AssertionError.class, () -> ArrayUtils.goodResize(null,3));
    }

    @Test
    void teste2GoodRezise()
    {
        int[] Lista = {3,2};
        assertThrows(AssertionError.class, () -> ArrayUtils.goodResize(Lista,-1));
    }


    @Test
    void teste3GoodRezise()
    {
        int[] Lista = {3,2};
        assertEquals(3,ArrayUtils.goodResize(Lista,3).length);
    }

    @Test
    void teste4GoodRezise()
    {
        int[] Lista = {3,2};
        assertEquals(0,ArrayUtils.goodResize(Lista,0).length);
    }

    @Test
    void teste1findpair()
    {
        assertThrows(AssertionError.class, () -> ArrayUtils.findAndPrintPairs(null,3));
    }

    @Test
    void teste2findpair()
    {
        int[] lista = {1,2,3};
        assertThrows(AssertionError.class, () -> ArrayUtils.findAndPrintPairs(lista,0));
    }

    @Test
    void teste3findpair()
    {
        int[] lista = {1,2,3};
        ArrayUtils.findAndPrintPairs(lista,3);
        assertTrue(outContent.toString().contains("The two elements at indices 0 and 1 are 1 and 2 add up to 3"));
    }

    @Test
    void teste1showList()
    {
        int[] lista = {1,2,3};
        ArrayUtils.showList(lista);
        assertTrue(outContent.toString().contains("1 2 3 "));
    }

    @Test
    void teste2showList()
    {
        int[] lista = {};
        ArrayUtils.showList(lista);
        assertTrue(outContent.toString().contains(""));
    }



    @AfterAll
    public static void restoreStreams()
    {
        System.setOut(System.out);
    }

}