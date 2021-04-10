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
        System.out.println("===051===Fruit create==== " );
        return fruitRepository.saveAndFlush(fruit);
    }

    @RequestMapping(value="{id}",method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id){
        //Also need to check for children records before deleting.
        System.out.println("===051===FruitController.java===Fruit DELETE==== " +id.toString() );
        fruitRepository.deleteById(id);
    }


    @RequestMapping(value="{id}", method = RequestMethod.PUT)
    public Fruit update(@PathVariable Long id, @RequestBody Fruit session) {
        //because this is a PUT, we expect all attributes to be passed in, A Patch would only need what
        //TODO: Add validation that all attributes are passed in, otherwisae return a 400 bad payload
        System.out.println("===051===FruitController.java===update====id= " +id.toString() );

        Fruit existingSession = fruitRepository.getOne(id);
        BeanUtils.copyProperties(session, existingSession, "fruit_id");
        return fruitRepository.saveAndFlush(existingSession);
    }


}
