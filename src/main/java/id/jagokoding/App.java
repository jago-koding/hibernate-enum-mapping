package id.jagokoding;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class App {

	public static void main(String[] args) {
		Session session = null;
		Transaction transaction = null;
		try {
			
			 session = HibernateUtil.getSessionFactory().openSession();
	         transaction = session.getTransaction();
	         transaction.begin();

	         Address address = new Address();
	         address.setId(1l);
	         address.setCity("Bekasi");
	         address.setState("Perum Villa Indah 2");
	         address.setAddressType(AddressType.HOME);
	         address.setPhone("082320795975");
	         address.setPhoneType(PhoneType.MOBILE);
	         
	         session.save(address);
	         transaction.commit();
	         
	         System.out.println("Address is added successfully.");
	         
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}

		HibernateUtil.shutdown();
	}
}
