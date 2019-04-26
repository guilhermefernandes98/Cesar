import com.es2.blackboxpartitioning.ArrayUtils;
import com.es2.blackboxpartitioning.Die;
import com.es2.blackboxpartitioning.End;
import org.junit.jupiter.api.*;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertThrows;

class TestBlackBoxPartitioning
{
    @BeforeAll
    public static void setUpBeforeAllTests(){
    }

    @BeforeEach
    public void setUpBefore(){
    }

    @AfterAll
    static public void tearDown(){
        End e = new End();
    }

    @AfterEach
    public void setUpAfter(){
    }

    @Test
    public void teste_Construtor_single()
    {
        Die die = new Die();
        Assertions.assertEquals(6, die.getNumSides());
        Assertions.assertEquals(1,die.getResult());
    }
    @Test
    public void teste_Construtor_oneparameters()
    {
        Die die = new Die(6);
        Assertions.assertEquals(6,die.getNumSides());
        Assertions.assertEquals(1,die.getResult());
        Assertions.assertThrows(AssertionError.class, () -> {
            new Die(1);
        });
        Assertions.assertThrows(AssertionError.class, () -> {
            new Die(7);
        });
    }
    @Test
    public void teste_Construtor_twoparameters()
    {
        Die die = new Die(6,1);
        Assertions.assertEquals(6,die.getNumSides());
        Assertions.assertEquals(1,die.getResult());
        Assertions.assertThrows(AssertionError.class, () -> {
            new Die(4, 5);
        });
        Assertions.assertThrows(AssertionError.class, () -> {
            new Die(4, 0);
        });
    }
    @Test
    void testDieRoll() { //Bem
        Die d = new Die(2);

        int i;
        for(i = 0; i < 10000; ++i) {
            d.roll();
            Assertions.assertTrue(d.getResult() >= 1 && d.getResult() <= 6);
        }

        d = new Die(6);

        for(i = 0; i < 10000; ++i) {
            d.roll();
            Assertions.assertTrue(d.getResult() >= 1 && d.getResult() <= 6);
        }

    }
    @Test
    void testDieToString() { //Bem
        Die d = new Die(2, 1);
        Assertions.assertEquals("Numero lados 2 Resultado 1", d.toString());
    }
    @Test
    void testArrayUtilsFindMin() { //Bem
        int[] lst = new int[20];

        for(int i = 0; i < 20; ++i) {
            lst[i] = 20 - i;
        }

        Assertions.assertEquals(19, ArrayUtils.findMin(lst));
        int[] lst2 = new int[0];
        Assertions.assertThrows(AssertionError.class, () -> {
            ArrayUtils.findMin(lst2);
        });
    }

    @Test
    void testArrayUtilsResize() { //Bem
        int[] lst = new int[20];

        for(int i = 0; i < 5; ++i) {
            lst[i] = 20 - i;
        }

        Assertions.assertThrows(AssertionError.class, () -> {
            ArrayUtils.goodResize(lst, -1);
        });
        Assertions.assertTrue(Arrays.equals(new int[]{20, 19}, ArrayUtils.goodResize(lst, 2)));
        Assertions.assertTrue(ArrayUtils.goodResize(lst, 22).length == 22);
    }
    @Test
    void testisAscending()
    {
        int[] listaascendente = {1,2,3,4,5};
        int[] listanaoascendente = {5,4,3,2,1};
        Assertions.assertFalse(ArrayUtils.isAscending(listanaoascendente));
        Assertions.assertTrue(ArrayUtils.isAscending(listaascendente));
    }
    @Test
    void testbubblesort()
    {
        int[] listavazia = null;
        int[] listaascendente = {1,2,3,4,5};
        int[] listanaoascendente = {5,4,3,2,1};

        Assertions.assertThrows(AssertionError.class, () -> {
            ArrayUtils.bubblesort(listavazia);
        });


    }

}
