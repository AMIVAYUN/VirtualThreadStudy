package com.virtualthread.virtualmethod.Controller;


import com.virtualthread.virtualmethod.Domain.Vthr;
import com.virtualthread.virtualmethod.Repository.VirtualThreadRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequiredArgsConstructor
public class VirtualThreadController {

    private final VirtualThreadRepository repository;


    @GetMapping("/non-block")
    public ResponseEntity<Map< String, String >> NonBlockTestMethod(){
        Map result = new HashMap();
        result.put("VTHR", "TEST");

        return ResponseEntity.ok( result );
    }

    @GetMapping("/block")
    public ResponseEntity<Map< String, String >> BlockTestMethod(){
        Map result = new HashMap();
        try{
            Thread.sleep( 1000 );
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        result.put("VTHR", "TEST");

        return ResponseEntity.ok( result );
    }

    @GetMapping("/jpablock")
    public ResponseEntity< String > JpaBlockTest(){
        List<Vthr> result = repository.findOneBlock();
        return ResponseEntity.ok( "1" );
    }



    @GetMapping("/jpanonblock")
    public ResponseEntity< String > JpaNonBlockTest(){

        List<Vthr> result = repository.findOne();

        return ResponseEntity.ok( result.toString() );
    }
}
