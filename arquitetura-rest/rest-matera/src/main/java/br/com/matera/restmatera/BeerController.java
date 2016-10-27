package br.com.matera.restmatera;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/beer")
public class BeerController {
	
	@Autowired
	private BeerRepository beerRepository;
	
	@ResponseBody
	@RequestMapping(value= "/nova/{nome}",  method = RequestMethod.GET)
	public ResponseEntity<Beer> add(@PathVariable String nome){
		Beer beer = new Beer(nome);
		return ResponseEntity.ok(beerRepository.save(beer));
	}
	
	@ResponseBody
	@RequestMapping(value= "/{id}",  method = RequestMethod.GET)
	public ResponseEntity<Beer> get(@PathVariable Long id){
		return ResponseEntity.ok(beerRepository.findOne(id));
	}
	
	@ResponseBody
	@RequestMapping(value= "/all", method = RequestMethod.GET)
	public ResponseEntity<List<Beer>> getAll(){
		return  ResponseEntity.ok( (List<Beer>) beerRepository.findAll());
	}
	
	@ResponseBody
	@RequestMapping(value= "/remove/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<String> delete(@PathVariable Long id){
		beerRepository.delete(id);
		return ResponseEntity.ok("Deletado com sucesso");
	}
	
}
