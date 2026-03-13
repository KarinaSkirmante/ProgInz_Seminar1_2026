package lv.venta;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import lv.venta.model.Category;
import lv.venta.model.Product;
import lv.venta.repo.IProductRepo;

@SpringBootApplication
public class ProgInzSeminar1Application {

	public static void main(String[] args) {
		SpringApplication.run(ProgInzSeminar1Application.class, args);
	}
	
	@Bean
	public CommandLineRunner saveDataInDB(IProductRepo prodRepo) {
		return new CommandLineRunner() {
			
			@Override
			public void run(String... args) throws Exception {
				Product p1 = new Product("Ābols", 0.99f, "Salds un garšīgs", Category.fruit, 10);
				Product p2 = new Product("Burkāns", 2.84f, "Oranžš", Category.vegetable, 40);
				Product p3 = new Product("Vīnogas", 4.99f, "Violetas", Category.fruit, 3);
				
				prodRepo.save(p1);
				prodRepo.save(p2);
				prodRepo.save(p3);
				
				//https://docs.spring.io/spring-data/commons/docs/current/api/org/springframework/data/repository/CrudRepository.html
				//TODO
				//caur prodRepo atrast produktu, kam id ir 1
				//caur prodRepo, izdzest produktu, kam id ir 1
				//caur prodrepo atrast visus produktus, kas ir tabula
				//caur prodrepo dabut produktu ar id 2 un tam nomainit cenu un ar save saglabat
				
			}
		};
	}
	

}
