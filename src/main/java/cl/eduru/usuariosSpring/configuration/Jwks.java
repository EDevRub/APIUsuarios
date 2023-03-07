package cl.eduru.usuariosSpring.configuration;

import com.nimbusds.jose.jwk.RSAKey;
import lombok.AllArgsConstructor;

import java.security.KeyPair;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.UUID;

@AllArgsConstructor
public class Jwks {

    public static RSAKey generateRsa(){
        KeyPair keyPair = KeyGeneratorUtils.generateRsaKey();
        RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
        RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();
        System.out.println("Llave publica: "+publicKey);
        System.out.println("Llave privada: "+privateKey);

        return new RSAKey.Builder(publicKey).privateKey(privateKey).keyID(UUID.randomUUID().toString()).build();
    }
}
