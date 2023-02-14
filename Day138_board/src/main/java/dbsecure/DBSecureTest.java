package dbsecure;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;

public class DBSecureTest {
	public static void main(String[] args) {
		StandardPBEStringEncryptor db = new StandardPBEStringEncryptor();
		db.setPassword(System.getenv("DB_PASSWORD"));
		String driver = db.encrypt("org.mariadb.jdbc.Driver");
		String url = db.encrypt("jdbc:mariadb://project-rds.co72iqbvkmha.us-west-1.rds.amazonaws.com:3306/memberdb");
		String account = db.encrypt("project_admin");
		String password = db.encrypt("12345678");
		
		System.out.println(driver);
		System.out.println(url);
		System.out.println(account);
		System.out.println(password);
		// ENC(yp5TLaaenzG2uX72VHZhKYblKtYfvPU4GeydopGRlPM=)
		// ENC(94HX7+fC7QNXWWNRahgC0hZwzlV6sB6kBqUARyCVs3znPsTo0kUARXyk2KlE0Pi8OffK0KhPljQJ7Q174LfqIZ73bJeb9Viz8Ntd5WOlf4Iyit3an9569g+5tn1qODTe)
		// ENC(Gb8/oVWsy3T4G+Dki8u6NeJRghZmg9BH)
		// ENC(8foi9XRvuOLwRjgstfAtNHxlM5uMhgSR)

	}
}
