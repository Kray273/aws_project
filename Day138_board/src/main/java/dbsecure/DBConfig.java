package dbsecure;

import org.jasypt.encryption.StringEncryptor;
import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.SimpleStringPBEConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;

@Configuration // 설정 클래스라는 @
@EnableEncryptableProperties // 현재 정보를 application.properties파일에서 사용 가능하도록 하는 @
public class DBConfig {
	
	@Bean("jasyptEncryptor") //매서드 리턴 객체 주입 @
	public StringEncryptor stringEncriptor(){
		PooledPBEStringEncryptor encryptor = new PooledPBEStringEncryptor();
        SimpleStringPBEConfig config = new SimpleStringPBEConfig();
        config.setPassword(System.getenv("DB_PASSWORD"));
        config.setAlgorithm("PBEWithMD5AndDES"); // 알고리즘
        config.setKeyObtentionIterations("1000");
        config.setPoolSize("1");
        config.setSaltGeneratorClassName("org.jasypt.salt.RandomSaltGenerator");
        config.setStringOutputType("base64");
        encryptor.setConfig(config);
        System.out.println("=======DBConfig 출력");
        System.out.println
        (encryptor.decrypt("yp5TLaaenzG2uX72VHZhKYblKtYfvPU4GeydopGRlPM="));
        System.out.println
        (encryptor.decrypt("94HX7+fC7QNXWWNRahgC0hZwzlV6sB6kBqUARyCVs3znPsTo0kUARXyk2KlE0Pi8OffK0KhPljQJ7Q174LfqIZ73bJeb9Viz8Ntd5WOlf4Iyit3an9569g+5tn1qODTe"));
        System.out.println
        (encryptor.decrypt("Gb8/oVWsy3T4G+Dki8u6NeJRghZmg9BH"));
        System.out.println
        (encryptor.decrypt("8foi9XRvuOLwRjgstfAtNHxlM5uMhgSR"));
  
        return encryptor;
	}
}
