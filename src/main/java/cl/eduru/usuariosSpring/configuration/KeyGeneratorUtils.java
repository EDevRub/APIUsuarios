package cl.eduru.usuariosSpring.configuration;

import lombok.AllArgsConstructor;

import java.security.KeyPair;
import java.security.KeyPairGenerator;

@AllArgsConstructor
public class KeyGeneratorUtils {

    static KeyPair generateRsaKey(){
        KeyPair keyPair;
        try {
            KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA");
            generator.initialize(2048);
            keyPair = generator.generateKeyPair();
        }catch (Exception e){
            throw new IllegalStateException(e);
        }
        return keyPair;
    }

}
