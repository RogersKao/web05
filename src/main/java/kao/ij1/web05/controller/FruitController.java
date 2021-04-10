package kao.ij1.web05.controller;

import kao.ij1.web05.models.Fruit;
import kao.ij1.web05.repositories.FruitRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/fruits")
public class FruitController {
    @Autowired
    private FruitRepository fruitRepository;

    @GetMapping
    public List<Fruit> list(){
        System.out.println("===051===fruitController.java===List<Fruit> list()==== " );
        return fruitRepository.findAll();
    }

    // @ReponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Fruit create(@RequestBody final Fruit fruit){
        System.out.println("===051===fruitController.java===Fruit create==== " );
        return fruitRepository.saveAndFlush(fruit);
    }

    //@RequestMapping(value="{fruit_id}",method = RequestMethod.DELETE)
    @DeleteMapping
    public void delete( Long fruit_id){
        //Also need to check for children records before deleting.
        System.out.println("===051===FruitController.java===Fruit DELETE==== " +fruit_id.toString() );
        fruitRepository.deleteById(fruit_id);
    }
    /*
    public Fruit update( Long id) {

        System.out.println("===051===FruitController.java===update==1==fruit_id= "  );
        Fruit existingSession = fruitRepository.getOne(id);
        System.out.println("===051===FruitController.java===update==2==fruit_id= "  );
        BeanUtils.copyProperties(fruit, existingSession, "fruit_id");
        System.out.println("===051===FruitController.java===update==3==fruit_id= "  );
        return fruitRepository.saveAndFlush(existingSession);
    }
    */

    //@RequestMapping(value="{fruit_id}", method = RequestMethod.PUT)
    //   public Fruit update(@PathVariable Long fruit_id, @RequestBody Fruit session) {
    // @PutMapping

    @PutMapping
    public Fruit update(@RequestBody Fruit fruit) {
        //because this is a PUT, we expect all attributes to be passed in, A Patch would only need what
        //TODO: Add validation that all attributes are passed in, otherwisae return a 400 bad payload
        System.out.println("===051===FruitController.java===update==1==fruit_id= "  );
        //System.out.println("===051===FruitController.java===update==2==fruit_id= " +id.toString() );

        //Long id;
        //id = fruit.getFruit_id();
        //Fruit existingSession = fruitRepository.getOne(id);
        Fruit existingSession = fruitRepository.getOne(fruit.getFruit_id());
        System.out.println("===051===FruitController.java===update==5==fruit_id= "  );
        BeanUtils.copyProperties(fruit, existingSession, "fruit_id");
        System.out.println("===051===FruitController.java===update==6==fruit_id= "  );
        return fruitRepository.saveAndFlush(existingSession);
    }

    /*
    @PutMapping(path="/alien",consumes= {"application/json"})
    public Alien saveOrUpdateAlien(@RequestBody Alien alien) {
        repo.save(alien);
        return alien;
    }
    */

}
