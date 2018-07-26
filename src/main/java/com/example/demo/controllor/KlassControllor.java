package com.example.demo.controllor;

import com.example.demo.entity.Klass;
import com.example.demo.repository.KlassRepository;
import com.example.demo.repository.LeaderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
public class KlassControllor {
    private KlassRepository klassRepository;
    private LeaderRepository leaderRepository;

    @Autowired
    public KlassControllor(KlassRepository klassRepository,LeaderRepository leaderRepository){
        this.klassRepository=klassRepository;
        this.leaderRepository=leaderRepository;
    }

    @Transactional
    @PostMapping("/klass")
    public Klass addKlass(@RequestBody Klass klass){
        if(klass.getLeader()!=null)
            leaderRepository.save(klass.getLeader());
        return  klassRepository.save(klass);
    }

   @GetMapping("/klass")
   public List<Klass> getKlass(){
         return    klassRepository.findAll();
    }

    @PutMapping("/klass")
    public Klass updateKlass(@RequestBody Klass klass){
        if(klass.getLeader()!=null)
            leaderRepository.save(klass.getLeader());
      return   klassRepository.save(klass);
    }

    @DeleteMapping("/klass/{id}")
    public boolean deleteKlass(@PathVariable Long id){
        if(klassRepository.findById(id)==null){
            return false;
        }
        klassRepository.delete(klassRepository.findById(id).get());
        return  true;
    }
}
