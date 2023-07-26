package org.example;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        Config config = ConfigFactory.load("application.conf");

        // Create the actor system
        ActorSystem system = ActorSystem.create("ReceiverSystem", config);

        // Create the receiver actor
        ActorRef receiver = system.actorOf(Props.create(Actor2.class), "receiver");

        System.out.println("You can write 0 to quit anytime");
        Scanner scan = new Scanner(System.in);
        String input = scan.next();
        while (!input.equals("0")){
            input = scan.next();
        }
        system.terminate();
    }
}
