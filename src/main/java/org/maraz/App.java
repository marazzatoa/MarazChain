package org.maraz;

import org.maraz.component.Block;
import org.maraz.component.Blockchain;
import org.maraz.component.Payload;

import java.util.Calendar;
import java.util.Date;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Maraz Blockchain" );
        Blockchain marazChain = new Blockchain();
        //
        Payload payload = new Payload("amount", 10.0);
        Calendar cal = Calendar.getInstance();
        cal.set(2021, Calendar.MARCH, 1);
        Date date = cal.getTime();
        Block block = new Block(1, date, payload, null);
        marazChain.addBlock(block);

        payload = new Payload("amount", 15.0);
        cal.set(2021, Calendar.MARCH, 10);
        date = cal.getTime();
        block = new Block(2, date, payload, null);
        marazChain.addBlock(block);

        payload = new Payload("amount", 25.0);
        cal.set(2021, Calendar.MARCH, 15);
        date = cal.getTime();
        block = new Block(3, date, payload, null);
        marazChain.addBlock(block);

        marazChain.print();

        System.out.printf("is marazChain valid? %b", marazChain.isChainValid());
    }
}
