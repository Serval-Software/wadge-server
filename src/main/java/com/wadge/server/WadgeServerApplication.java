package com.wadge.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WadgeServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(WadgeServerApplication.class, args);
		System.out.println("""
                 _          _
                ( )   ()   ( )
                (  )  ()  (  )
                 (  ) () (  )
                  (        )
                   (      ) ___      ___      ___ 
                    (____)  \\  \\    /   \\    /  /_____       __
                   /      \\  \\  \\  /     \\  /  /|____ \\  ___|  | ___ __  ____
                  |        |  \\  \\/   _   \\/  / /  _   |/  _   |/  _`  |/ __ \\
                  |  |  |  |   \\     / \\     / |  (_|  |  (_|  |  (_|  |  ___/
                  |  |  |  |    \\___/   \\___/   \\____,_|\\____,_|\\___,  |\\____|
                   \\/ \\/ \\/                                      |____/""");
	}
}
