package com.enset;

import com.enset.dao.ClientRepository;
import com.enset.dao.CompteRepository;
import com.enset.dao.OperationRepository;
import com.enset.entities.*;
import com.enset.metier.IBanqueMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.domain.Page;

import java.util.Date;

@SpringBootApplication
public class GestionCompteApplication implements CommandLineRunner{
	@Autowired
	private ClientRepository clientRepository;
	@Autowired
	private CompteRepository compteRepository;
	@Autowired
	private OperationRepository operationRepository;
	@Autowired
	private IBanqueMetier iBanqueMetier;
	public static void main(String[] args){
		SpringApplication.run(GestionCompteApplication.class, args);




	}

	@Override
	public void run(String... strings) throws Exception {
		/*Client c1=new Client("naoufal","naoufal@gmail.com");
		Client c2=new Client("youness","youness@gmail.com");
		Client c3=new Client("berouain","berouain@gmail.com");

		clientRepository.save(c1);
		clientRepository.save(c2);
		clientRepository.save(c3);

		Compte cp1=new CompteEpargne("CE1",new Date(),1205.0,c1,12.2);
		Compte cp2=new CompteCourant("CC1",new Date(),14478.0,c3,4855);
		Compte cp3=new CompteCourant("CC2",new Date(),69558.0,c2,9965);


		Operation op1=new Retrait(new Date(),1452.0,cp3);
		Operation op2=new Retrait(new Date(),638,cp1);
		Operation op3=new Versement(new Date(),798,cp2);

		clientRepository.save(c1);
		clientRepository.save(c2);
		clientRepository.save(c3);

		compteRepository.save(cp1);
		compteRepository.save(cp2);
		compteRepository.save(cp3);

		operationRepository.save(op1);
		operationRepository.save(op2);
		operationRepository.save(op3);

		iBanqueMetier.verser("CE1",1275);
		Page<Operation> ops=iBanqueMetier.listOperation("CE1",0,10);
		System.out.println(ops.getSize()+"hello world");*/


	}
}
